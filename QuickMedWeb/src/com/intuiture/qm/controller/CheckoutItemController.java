package com.intuiture.qm.controller;

import java.util.List;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.intuiture.qm.bean.CheckoutItemsBean;
import com.intuiture.qm.json.AddToCartJson;

@RestController
@RequestMapping("/CheckoutItemController")
public class CheckoutItemController {
	CheckoutItemsBean checkoutItemsBean = new CheckoutItemsBean();

	@RequestMapping(value = "/saveCheckOutItems", method = RequestMethod.POST)
	public void saveCheckOutItems(@RequestBody List<AddToCartJson> addToCartJsonList) {
		checkoutItemsBean.setAddToCartJsonList(addToCartJsonList);
	}

	@RequestMapping(value = "/getcheckOutItems", method = RequestMethod.GET)
	public List<AddToCartJson> getcheckOutItems() {
		return checkoutItemsBean.getAddToCartJsonList();
	}
}
