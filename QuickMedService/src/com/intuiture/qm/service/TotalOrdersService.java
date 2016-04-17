package com.intuiture.qm.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.intuiture.qm.dao.AddToCartRepository;
import com.intuiture.qm.dao.CommonRepository;
import com.intuiture.qm.dao.CustomerRepository;
import com.intuiture.qm.dao.TotalOrdersRepository;
import com.intuiture.qm.entity.AddToCart;
import com.intuiture.qm.entity.CustomerDeliveryAddress;
import com.intuiture.qm.entity.TotalOrders;
import com.intuiture.qm.json.AddToCartJson;
import com.intuiture.qm.json.GridInfoJson;
import com.intuiture.qm.json.TotalOrdersJson;
import com.intuiture.qm.util.EnumUtils;
import com.intuiture.qm.util.TransformDomainToJson;
import com.intuiture.qm.util.TransformJsonToDomain;

@Service
@Transactional
public class TotalOrdersService {
	private static Logger LOG = Logger.getLogger(TotalOrdersService.class);
	@Autowired
	private CommonRepository commonRepository;
	@Autowired
	private AddToCartRepository addToCartRepository;
	@Autowired
	private TotalOrdersRepository totalOrdersRepository;
	@Autowired
	private CustomerRepository customerRepository;

	public Integer sendTheOrderForDelivery(TotalOrdersJson totalOrdersJson) {
		Integer totalOrderId = null;
		try {
			TotalOrders totalOrders = null;
			if (totalOrdersJson.getTotalOrderId() != null) {
				totalOrders = (TotalOrders) commonRepository.findById(totalOrdersJson.getTotalOrderId(), TotalOrders.class);
				TransformJsonToDomain.getTotalOrderFromJson(totalOrders, totalOrdersJson);
				totalOrders.setUpdateOn(new Date());
				commonRepository.update(totalOrders);
			}
		} catch (Exception e) {
			e.printStackTrace();
			LOG.error("Error at saveTotalOrders() in TotalOrdersService:" + e.getMessage(), e);
		}
		return totalOrderId;
	}

	public Integer placeCashOnDeliveryTotalOrder(TotalOrdersJson totalOrdersJson) {
		Integer totalOrderId = null;
		try {
			TotalOrders totalOrders = null;
			if (totalOrdersJson.getTotalOrderId() != null) {
				totalOrders = (TotalOrders) commonRepository.findById(totalOrdersJson.getTotalOrderId(), TotalOrders.class);
			} else {
				totalOrders = new TotalOrders();
			}
			TransformJsonToDomain.getTotalOrderFromJson(totalOrders, totalOrdersJson);
			totalOrders.setTypeOfOrder(EnumUtils.CASHONDELIVERY.getState());
			if (totalOrdersJson.getTotalOrderId() != null) {
				commonRepository.update(totalOrders);
			} else {
				commonRepository.persist(totalOrders);
			}
			totalOrderId = totalOrders.getTotalOrderId();
		} catch (Exception e) {
			e.printStackTrace();
			LOG.error("Error at placeCashOnDeliveryTotalOrder() in TotalOrdersService:" + e.getMessage(), e);
		}
		return totalOrderId;
	}

	public List<TotalOrdersJson> getTotalOrders(GridInfoJson gridInfoJson) {
		List<TotalOrdersJson> totalOrdersJsonList = new ArrayList<TotalOrdersJson>();
		try {
			List<TotalOrders> list = totalOrdersRepository.getAllTotalOrders(gridInfoJson);
			if (list != null && list.size() > 0) {
				List<Integer> totalOrderIds = new ArrayList<Integer>();
				for (TotalOrders totalOrders : list) {
					totalOrderIds.add(totalOrders.getTotalOrderId());
				}
				List<AddToCart> addToCartList = addToCartRepository.getAllOrderedItemsTotalOrderIds(totalOrderIds);
				Map<Integer, List<AddToCartJson>> totalOrderId_Map = new HashMap<Integer, List<AddToCartJson>>();
				if (addToCartList != null && addToCartList.size() > 0) {
					for (AddToCart cart : addToCartList) {
						AddToCartJson json = TransformDomainToJson.getAddToCartJson(cart);
						if (totalOrderId_Map.get(cart.getTotalOrderId()) != null) {
							totalOrderId_Map.get(cart.getTotalOrderId()).add(json);
						} else {
							List<AddToCartJson> addTocartJsonList = new ArrayList<AddToCartJson>();
							addTocartJsonList.add(json);
							totalOrderId_Map.put(cart.getTotalOrderId(), addTocartJsonList);
						}
					}
				}
				for (TotalOrders totalOrders : list) {
					TotalOrdersJson json = TransformDomainToJson.getTotalOrdersJson(totalOrders);
					json.setOrderList(totalOrderId_Map.get(json.getTotalOrderId()));
					totalOrdersJsonList.add(json);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			LOG.error("Error at getTotalOrders() in TotalOrdersService:" + e.getMessage(), e);
		}
		return totalOrdersJsonList;
	}

	//
	// public List<TotalOrdersJson> getTotalOrdersByCustomerId(Integer
	// customerId) {
	// List<TotalOrdersJson> totalOrdersJsonList = new
	// ArrayList<TotalOrdersJson>();
	// try {
	// List<TotalOrders> list =
	// totalOrdersRepository.getAllTotalOrdersByCustomerId(customerId);
	// if (list != null && list.size() > 0) {
	// List<Integer> totalOrderIds = new ArrayList<Integer>();
	// for (TotalOrders totalOrders : list) {
	// totalOrderIds.add(totalOrders.getTotalOrderId());
	// }
	// List<AddToCart> addToCartList =
	// addToCartRepository.getAllOrderedItemsTotalOrderIds(totalOrderIds);
	// Map<Integer, List<AddToCartJson>> totalOrderId_Map = new HashMap<Integer,
	// List<AddToCartJson>>();
	// if (addToCartList != null && addToCartList.size() > 0) {
	// for (AddToCart cart : addToCartList) {
	// AddToCartJson json =
	// TransformDomainToJson.getAddToCartJsonFromAddToCart(cart);
	// if (totalOrderId_Map.get(cart.getTotalOrderId()) != null) {
	// totalOrderId_Map.get(cart.getTotalOrderId()).add(json);
	// } else {
	// List<AddToCartJson> addTocartJsonList = new ArrayList<AddToCartJson>();
	// addTocartJsonList.add(json);
	// totalOrderId_Map.put(cart.getTotalOrderId(), addTocartJsonList);
	// }
	// }
	// }
	//
	// for (TotalOrders totalOrders : list) {
	// TotalOrdersJson json =
	// TransformDomainToJson.getTotalOrdersJsonFromTotalOrders(totalOrders);
	// json.setOrdersList(totalOrderId_Map.get(json.getTotalOrderId()));
	// json.setItemsSize(json.getOrdersList().size());
	// totalOrdersJsonList.add(json);
	// }
	// }
	// } catch (Exception e) {
	// e.printStackTrace();
	// LOG.error("Error at getTotalOrdersByCustomerId() in TotalOrdersService:"
	// + e.getMessage(), e);
	// }
	// return totalOrdersJsonList;
	// }
	//
	public Boolean removeTotalOrder(Integer totalOrderId) {
		Boolean isOrderRemoved = false;
		try {
			TotalOrders totalOrders = (TotalOrders) commonRepository.findById(totalOrderId, TotalOrders.class);
			totalOrders.setIsDeleted(Boolean.TRUE);
			commonRepository.update(totalOrders);
			CustomerDeliveryAddress customerDeliveryAddress = customerRepository.findAddressByTotalOrderId(totalOrderId);
			customerDeliveryAddress.setIsDeleted(Boolean.TRUE);
			commonRepository.update(customerDeliveryAddress);
			isOrderRemoved = true;
		} catch (Exception e) {
			e.printStackTrace();
			LOG.error("Error at removeTotalOrder() in TotalOrdersService:" + e.getMessage(), e);
		}
		return isOrderRemoved;
	}

	public Boolean removeItemFromInvoice(Integer totalOrderId) {
		Boolean isOrderInvoiced = false;
		try {
			TotalOrders totalOrders = (TotalOrders) commonRepository.findById(totalOrderId, TotalOrders.class);
			totalOrders.setIsItemInvoiced(Boolean.TRUE);
			commonRepository.update(totalOrders);
			CustomerDeliveryAddress customerDeliveryAddress = customerRepository.findAddressByTotalOrderId(totalOrderId);
			customerDeliveryAddress.setIsDeleted(Boolean.TRUE);
			commonRepository.update(customerDeliveryAddress);
			isOrderInvoiced = true;
		} catch (Exception e) {
			e.printStackTrace();
			LOG.error("Error at removeItemFromInvoice() in TotalOrdersService:" + e.getMessage(), e);
		}
		return isOrderInvoiced;
	}

	public List<TotalOrdersJson> getDeliveredTotalOrders() {
		List<TotalOrdersJson> totalOrdersJsonList = new ArrayList<TotalOrdersJson>();
		try {
			List<TotalOrders> list = totalOrdersRepository.getDeliveredTotalOrders();
			if (list != null && list.size() > 0) {
				for (TotalOrders totalOrders : list) {
					totalOrdersJsonList.add(TransformDomainToJson.getTotalOrdersJson(totalOrders));
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			LOG.error("Error at getDeliveredTotalOrders() in TotalOrdersService:" + e.getMessage(), e);
		}
		return totalOrdersJsonList;
	}
}
