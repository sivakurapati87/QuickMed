package com.intuiture.qm.managedbean;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import org.apache.log4j.Logger;

import com.intuiture.qm.bean.OrdersBean;
import com.intuiture.qm.json.GridInfoJson;
import com.intuiture.qm.json.SearchComboJson;
import com.intuiture.qm.json.SearchJson;
import com.intuiture.qm.json.TotalOrdersJson;
import com.intuiture.qm.util.CommonUtil;
import com.intuiture.qm.util.Constants;
import com.intuiture.qm.util.SerConstants;

@ManagedBean(name = "OrdersBean")
@SessionScoped
public class OrdersManagedBean extends OrdersBean {
	private static Logger LOG = Logger.getLogger(OrdersManagedBean.class);

	public void init() {
		setGridInfoJson(new GridInfoJson());
		getGridInfoJson().setFirstResults(0);
		getGridInfoJson().setRecordsPerPage(Constants.ITEMS_RECORDSPERPAGE);
		// setOrdersList(null);
		getGridInfoJson().setSearchJsonList(new ArrayList<SearchJson>());
		getGridInfoJson().getSearchJsonList().add(getsearchComboAction(SerConstants.STRING.toString()));
		allTotalOrders();
		setTotalOrdersJson(new TotalOrdersJson());
		setIsTotalOrderSelected(Boolean.FALSE);
	}

	public void onClickAllCheckboxAction() {
		if (getIsTotalOrderSelected()) {
			if (getTotalOrdersList() != null && getTotalOrdersList().size() > 0) {
				for (TotalOrdersJson json : getTotalOrdersList()) {
					json.setIsTotalOrderSelected(Boolean.TRUE);
				}
			}
		} else {
			if (getTotalOrdersList() != null && getTotalOrdersList().size() > 0) {
				for (TotalOrdersJson json : getTotalOrdersList()) {
					json.setIsTotalOrderSelected(Boolean.FALSE);
				}
			}
		}
	}

	public SearchJson getsearchComboAction(String typeOfField) {

		SearchJson searchJson = new SearchJson();
		try {
			String[] searchFieldLabels = { "OrderId", "Phone Number", "Customer First Name" };
			String[] searchFieldValues = { "totalOrderGenId", "customerDeliveryAddress.phoneNumber", "customer.firstName" };
			SerConstants[] searchFieldType = { SerConstants.STRING, SerConstants.NUMBER, SerConstants.STRING };
			List<SearchComboJson> searchFieldComboJsonList = new ArrayList<SearchComboJson>();
			for (int i = 0; i < searchFieldLabels.length; i++) {
				SearchComboJson searchComboJson = new SearchComboJson();
				searchComboJson.setLabel(searchFieldLabels[i]);
				searchComboJson.setValue(searchFieldValues[i]);
				searchComboJson.setType(searchFieldType[i].toString());
				searchFieldComboJsonList.add(searchComboJson);
			}
			searchJson.setIsAddIconVisible(Boolean.TRUE);
			searchJson.setSearchFieldList(searchFieldComboJsonList);
			searchJson.setOperatorsList(CommonUtil.getSearchOperators(typeOfField));
			searchJson.setSearchValue(null);
		} catch (Exception e) {
			e.printStackTrace();
			LOG.error("Error at getsearchComboAction():" + e.getMessage());
		}
		return searchJson;

	}

	public void onChangeSearchFieldNameAction() {
		String typeOfField = null;
		// if (fieldName != null && fieldName.trim().length() > 0) {
		if (getGridInfoJson().getSearchJsonList() != null && getGridInfoJson().getSearchJsonList().size() > 0) {
			for (SearchJson json : getGridInfoJson().getSearchJsonList()) {
				// if
				// (fieldName.equalsIgnoreCase(json.getSelectedSearchFieldName()))
				// {
				if (json.getSearchFieldList() != null && json.getSearchFieldList().size() > 0) {
					for (SearchComboJson comboJson : json.getSearchFieldList()) {
						if (comboJson.getValue().equalsIgnoreCase(json.getSelectedSearchFieldName())) {
							typeOfField = comboJson.getType();
							break;
						}
					}
					json.setOperatorsList(CommonUtil.getSearchOperators(typeOfField));
				}
			}
		}
	}

	public String searchGoAction() {
		allTotalOrders();
		return "";
	}

	public void allTotalOrders() {
		try {
			setTotalOrdersList(CommonUtil.getAllTotalOrdersJsonList(Constants.TotalOrdersController.GETTOTALORDERS, getGridInfoJson()));
		} catch (Exception e) {
			LOG.error("error at allAddItemsList() in AddItemManagedBean" + e.getMessage());
		}
	}

	public void onClickCheckboxAction() {
		Boolean isAllItemsSelected = Boolean.TRUE;
		if (getTotalOrdersList() != null && getTotalOrdersList().size() > 0) {
			for (TotalOrdersJson json : getTotalOrdersList()) {
				if (!json.getIsTotalOrderSelected()) {
					isAllItemsSelected = Boolean.FALSE;
					break;
				}
			}
			if (isAllItemsSelected) {
				setIsTotalOrderSelected(Boolean.TRUE);
			} else {
				setIsTotalOrderSelected(Boolean.FALSE);
			}
		}
	}

	public String subGridAction() {
		setTotalOrdersJson(new TotalOrdersJson());
		try {
			String key = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("key");
			Integer totalOrderId = null;
			if (key != null) {
				totalOrderId = Integer.parseInt(key);
				for (TotalOrdersJson json : getTotalOrdersList()) {
					if (json.getTotalOrderId().equals(totalOrderId)) {
						if (json.getImageName().equalsIgnoreCase(Constants.PLUS)) {
							json.setImageName(Constants.MINUS);
							setTotalOrdersJson(json);
							// if (json.getOrdersList() == null)
							// json.setOrdersList(CommonUtil.getAllOrderedItemsCustomerId(json.getCustomerId(),
							// totalOrderId));
						} else {
							json.setImageName(Constants.PLUS);
						}
					} else {
						json.setImageName(Constants.PLUS);
					}
				}
			}
		} catch (Exception e) {
			LOG.error("error at subGridAction() in SubCategoryManagedBean" + e.getMessage());
		}

		return "";
	}

	// public void onChangeQntyComboChange(Integer keyValue) {
	public void onChangeQntyComboChange() {
		try {
//			Double subTotal = 0d;
//			for (AddToCartJson json : getTotalOrdersJson().getOrderList()) {
//				json.setSubTotal(json.getPrice() * json.getQuantity());
//				subTotal += json.getSubTotal();
//			}
//			for (TotalOrdersJson json : getTotalOrdersList()) {
//				if (json.getTotalOrderId().equals(getTotalOrdersJson().getTotalOrderId())) {
//					json.setSubTotal(subTotal);
//					if (subTotal < Constants.AMOUNTEXCEEDSLIMIT) {
//						json.setDeliveryCharges(Constants.DELIVERYCHARGES);
//					} else {
//						json.setDeliveryCharges(0d);
//					}
//					json.setTotalPurchase(json.getSubTotal() + json.getDeliveryCharges());
//
//				}
//			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void onChangeInputSpinner() {
		onChangeQntyComboChange();
	}

	public String deleteOrder() {
//		String key = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("key");
//		Integer cartId = null;
//		if (key != null) {
//			cartId = Integer.parseInt(key);
//			CommonUtil.removeItemFromCart(Constants.AddToCartController.REMOVECART, cartId);
//			getTotalOrdersJson().setOrdersList(CommonUtil.getAllOrderedItemsCustomerId(getTotalOrdersJson().getCustomerId(), getTotalOrdersJson().getTotalOrderId()));
//			if (getTotalOrdersJson().getOrdersList() == null) {
//				CommonUtil.removeTotalOrder(Constants.TotalOrdersController.REMOVETOTALORDER, getTotalOrdersJson().getTotalOrderId());
//				init();
//			} else {
//				onChangeQntyComboChange();
//			}
//		}
		return "";
	}

	public String updateOrders() {
//		if (getTotalOrdersList() != null && getTotalOrdersList().size() > 0) {
//			for (TotalOrdersJson totalOrdersJson : getTotalOrdersList()) {
//				if (totalOrdersJson.getIsTotalOrderSelected()) {
//					totalOrdersJson.setIsDeleted(Boolean.TRUE);
//					totalOrdersJson.setIsDelivered(Boolean.TRUE);
//					CommonUtil.saveTotalOrders(totalOrdersJson);
//					// List<AddToCartJson> orderList =
//					// CommonUtil.getAllOrderedItemsCustomerId(totalOrdersJson.getCustomerId(),
//					// totalOrdersJson.getTotalOrderId());
//					if (totalOrdersJson.getOrdersList() != null && totalOrdersJson.getOrdersList().size() > 0) {
//						for (AddToCartJson item : totalOrdersJson.getOrdersList()) {
//							CommonUtil.makeAnItemToDelivered(item);
//						}
//					}
//				}
//			}
//		}
//		init();
		return "";
	}
}
