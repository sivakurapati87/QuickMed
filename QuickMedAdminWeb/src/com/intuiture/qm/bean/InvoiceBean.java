package com.intuiture.qm.bean;

import java.util.List;

import com.intuiture.qm.json.AddToCartJson;
import com.intuiture.qm.json.TotalOrdersJson;

public class InvoiceBean {
	private List<TotalOrdersJson> totalOrderComboList;
	private Integer selectedTotalOrder;
	private List<AddToCartJson> orderItemsList;
	private TotalOrdersJson totalOrdersJson;
	private Integer ordersSize;

	public List<TotalOrdersJson> getTotalOrderComboList() {
		return totalOrderComboList;
	}

	public void setTotalOrderComboList(List<TotalOrdersJson> totalOrderComboList) {
		this.totalOrderComboList = totalOrderComboList;
	}

	public Integer getSelectedTotalOrder() {
		return selectedTotalOrder;
	}

	public void setSelectedTotalOrder(Integer selectedTotalOrder) {
		this.selectedTotalOrder = selectedTotalOrder;
	}

	public List<AddToCartJson> getOrderItemsList() {
		return orderItemsList;
	}

	public void setOrderItemsList(List<AddToCartJson> orderItemsList) {
		this.orderItemsList = orderItemsList;
	}

	public TotalOrdersJson getTotalOrdersJson() {
		return totalOrdersJson;
	}

	public void setTotalOrdersJson(TotalOrdersJson totalOrdersJson) {
		this.totalOrdersJson = totalOrdersJson;
	}

	public Integer getOrdersSize() {
		return ordersSize;
	}

	public void setOrdersSize(Integer ordersSize) {
		this.ordersSize = ordersSize;
	}

}
