package com.intuiture.qm.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.intuiture.qm.dao.AddToCartRepository;
import com.intuiture.qm.dao.CommonRepository;
import com.intuiture.qm.entity.AddToCart;
import com.intuiture.qm.entity.TotalOrders;
import com.intuiture.qm.json.AddToCartJson;
import com.intuiture.qm.util.Constants;
import com.intuiture.qm.util.EnumUtils;
import com.intuiture.qm.util.MethodUtil;
import com.intuiture.qm.util.TransformDomainToJson;
import com.intuiture.qm.util.TransformJsonToDomain;

@Service
@Transactional
public class AddToCartService {
	private static final Logger LOG = Logger.getLogger(AddToCartService.class);
	@Autowired
	private CommonRepository commonRepository;
	@Autowired
	private AddToCartRepository addToCartRepository;

	public Integer placeCashOnDeliveryOrders(List<AddToCartJson> addToCartJsonList) {
		Integer totalOrderId = null;
		try {

			if (addToCartJsonList != null && addToCartJsonList.size() > 0) {
				TotalOrders totalOrders = new TotalOrders();
				Double totalPrice = 0d, totalSubTotal = 0d, totalDiscount = 0d;
				for (AddToCartJson addToCartJson : addToCartJsonList) {
					totalPrice += addToCartJson.getPrice();
					totalSubTotal += addToCartJson.getSubTotal();
					totalDiscount += addToCartJson.getDiscount();
				}

				// totalOrders.setComments(addToCartJsonList.get(0).getco);
				// totalOrders.setCouponCode(couponCode);
				// totalOrders.setCouponCodeId(couponCodeId);
				totalOrders.setCustomerId(addToCartJsonList.get(0).getCustomerId());
				if (totalSubTotal < Constants.MIN_AMOUT_TO_NO_CASHONDELIVERY) {
					totalOrders.setDeliveryCharges(Constants.MIN_DELIVERY_CHARGE);
				}
				totalOrders.setDiscountAmount(totalDiscount);
				totalOrders.setIsDeleted(Boolean.FALSE);
				totalOrders.setIsDelivered(Boolean.FALSE);
				totalOrders.setIsItemInvoiced(Boolean.FALSE);
				totalOrders.setOrderDate(MethodUtil.convertStringToDate(MethodUtil.convertDateToString(new Date())));
				totalOrders.setSubTotal(totalSubTotal);
				totalOrders.setTotalAmount(totalPrice);
				totalOrders.setTotalOrderGenId(Constants.PREFIX_GEN_ID + MethodUtil.randomString());
				totalOrders.setTypeOfOrder(EnumUtils.CASHONDELIVERY.getState());
				commonRepository.persist(totalOrders);
				totalOrderId = totalOrders.getTotalOrderId();
				for (AddToCartJson addToCartJson : addToCartJsonList) {
					AddToCart addToCart = new AddToCart();
					TransformJsonToDomain.getAddToCart(addToCart, addToCartJson);
					addToCart.setTotalOrderId(totalOrderId);
					commonRepository.persist(addToCart);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			LOG.error("Error at placeCashOnDeliveryTotalOrder() in TotalOrdersService:" + e.getMessage(), e);
		}
		return totalOrderId;
	}

	public List<AddToCartJson> getAllOrderedItemsCustomerIdAndTotalId(Integer customerId, Integer totalOrderId) {
		List<AddToCartJson> addToCartJsonList = null;
		try {
			List<AddToCart> addToCartList = addToCartRepository.getAllOrderedItemsCustomerIdAndTotalOrderId(customerId, totalOrderId);
			if (addToCartList != null && addToCartList.size() > 0) {
				addToCartJsonList = new ArrayList<AddToCartJson>();
				for (AddToCart addToCart : addToCartList) {
					AddToCartJson addToCartJson = TransformDomainToJson.getAddToCartJson(addToCart);
					addToCartJsonList.add(addToCartJson);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			LOG.error("Error at getAllOrderedItemsCustomerIdAndTotalId() in AddToCartService:" + e.getMessage(), e);
		}
		return addToCartJsonList;
	}
}
