package com.intuiture.qm.util;

import java.util.Date;

import org.apache.log4j.Logger;

import com.intuiture.qm.entity.AddToCart;
import com.intuiture.qm.entity.Customer;
import com.intuiture.qm.entity.TotalOrders;
import com.intuiture.qm.json.AddToCartJson;
import com.intuiture.qm.json.CustomerJson;
import com.intuiture.qm.json.TotalOrdersJson;

public class TransformJsonToDomain {
	private static Logger LOG = Logger.getLogger(TransformJsonToDomain.class);

	public static void getCustomer(CustomerJson customerJson, Customer customer) {
		try {
			if (customerJson.getCustomerId() != null) {
				customer.setUpdatedOn(new Date());
			} else {
				customer.setCreatedOn(new Date());
			}
			customer.setEmailId(customerJson.getEmailId());
			customer.setFirstName(customerJson.getFirstName());
			customer.setLastName(customerJson.getLastName());
			if (customerJson.getPassword() != null) {
				customer.setPassword(MethodUtil.passwordEncryption(customerJson.getPassword()));
			}
			customer.setPhoneNumber(customerJson.getPhoneNumber());
			customer.setUserName(MethodUtil.getUserNameFromEmail(customerJson.getEmailId()));
			customer.setGender(customerJson.getGender());
			customer.setDateOfBirth(customerJson.getDateOfBirth());
		} catch (Exception e) {
			e.printStackTrace();
			LOG.error(e.getMessage(), e);
		}
	}

	public static TotalOrders getTotalOrderFromJson(TotalOrders totalOrders, TotalOrdersJson totalOrdersJson) {
		try {
			totalOrders.setCouponCodeId(totalOrdersJson.getCouponCodeId());
			totalOrders.setCustomerId(totalOrdersJson.getCustomerId());
			totalOrders.setDeliveryCharges(totalOrdersJson.getDeliveryCharges());
			totalOrders.setOrderDate(new Date());
			totalOrders.setTotalOrderGenId(totalOrdersJson.getTotalOrderGenId());
			totalOrders.setSubTotal(totalOrdersJson.getSubTotal());
			totalOrders.setIsDelivered(totalOrdersJson.getIsDelivered());
			// totalOrders.setTotalPurchase(totalOrdersJson.getTotalPurchase());
			totalOrders.setDiscountAmount(totalOrders.getDiscountAmount());
			totalOrders.setComments(totalOrdersJson.getComments());
			totalOrders.setIsDeleted(totalOrdersJson.getIsDeleted());
			// totalOrders.setTypeOfOrderId(totalOrdersJson.getTypeOfOrderId());
			// totalOrders.setIsItemInvoiced(totalOrdersJson.getIsItemInvoiced());
			// if
			// (totalOrdersJson.getTypeOfOrderId().equals(EnumUtils.NETBANKING.getState()))
			// {
			// totalOrders.setTransactionId(totalOrdersJson.getTxnId());
			// }
		} catch (Exception e) {
			e.printStackTrace();
			LOG.error("Error at getTotalOrderFromJson() in TransformJsonToDomain:" + e.getMessage(), e);
		}
		return totalOrders;
	}

	public static AddToCart getAddToCart(AddToCart addToCart, AddToCartJson addToCartJson) {
		try {
			addToCart.setCustomerId(addToCartJson.getCustomerId());
			addToCart.setIsItemRemovedFromCart(Boolean.FALSE);
			addToCart.setIsItemDelivered(Boolean.FALSE);
			addToCart.setIsItemOrdered(Boolean.TRUE);
			addToCart.setItemId(addToCartJson.getItemId());
			addToCart.setOrderDate(new Date());
			addToCart.setPrice(addToCartJson.getPrice());
			addToCart.setDiscount(addToCartJson.getDiscount());
			// addToCart.setSavings(addToCartJson.getSavings());
			// addToCart.setMinSavings(addToCartJson.getMinSavings());
			addToCart.setSubTotal(addToCartJson.getSubTotal());
			addToCart.setQuantity(addToCartJson.getQuantity());
			addToCart.setIsItemDelivered(addToCartJson.getIsItemDelivered());
		} catch (Exception e) {
			e.printStackTrace();
			LOG.error("Error at getAddToCartFromJson() in TransformJsonToDomain:" + e.getMessage(), e);
		}
		return addToCart;
	}
}
