package com.intuiture.qm.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.intuiture.qm.json.AddToCartJson;
import com.intuiture.qm.service.AddToCartService;

@RestController
@RequestMapping("/AddToCartController")
public class AddToCartController {
	@Autowired
	private AddToCartService addToCartService;

	@RequestMapping(value = "/placeCashOnDeliveryOrders", method = RequestMethod.POST)
	public @ResponseBody Integer placeCashOnDeliveryOrders(HttpServletRequest request, HttpServletResponse response, @RequestBody List<AddToCartJson> addToCartJsonList) {
		return addToCartService.placeCashOnDeliveryOrders(addToCartJsonList);
	}

	@RequestMapping(value = "/getAllOrderedItemsCustomerIdAndTotalId", method = RequestMethod.GET)
	public @ResponseBody List<AddToCartJson> getAllOrderedItemsCustomerIdAndTotalId(HttpServletRequest request, HttpServletResponse response,
			@RequestParam("totalOrderId") Integer totalOrderId, @RequestParam("customerId") Integer customerId) {
		return addToCartService.getAllOrderedItemsCustomerIdAndTotalId(customerId, totalOrderId);
	}
}
