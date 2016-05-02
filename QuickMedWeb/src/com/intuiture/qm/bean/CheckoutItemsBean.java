package com.intuiture.qm.bean;

import java.util.List;

import com.intuiture.qm.json.AddToCartJson;

public class CheckoutItemsBean {
	private List<AddToCartJson> addToCartJsonList;

	public List<AddToCartJson> getAddToCartJsonList() {
		return addToCartJsonList;
	}

	public void setAddToCartJsonList(List<AddToCartJson> addToCartJsonList) {
		this.addToCartJsonList = addToCartJsonList;
	}
}
