package com.intuiture.qm.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.intuiture.qm.json.GridInfoJson;
import com.intuiture.qm.json.TotalOrdersJson;
import com.intuiture.qm.service.TotalOrdersService;

@Controller
@RequestMapping("/TotalOrdersController")
public class TotalOrdersController {
	@Autowired
	private TotalOrdersService totalOrdersService;

//	@RequestMapping(value = "/saveTotalOrders", method = RequestMethod.POST)
//	public @ResponseBody Integer saveTotalOrders(HttpServletRequest request, HttpServletResponse response, @RequestBody TotalOrdersJson totalOrdersJson) {
//		Integer totalOrderId = totalOrdersService.saveTotalOrders(totalOrdersJson);
//		return totalOrderId;
//	}

	@RequestMapping(value = "/placeCashOnDeliveryTotalOrder", method = RequestMethod.POST)
	public @ResponseBody Integer placeCashOnDeliveryTotalOrder(HttpServletRequest request, HttpServletResponse response, @RequestBody TotalOrdersJson totalOrdersJson) {
		Integer totalOrderId = totalOrdersService.placeCashOnDeliveryTotalOrder(totalOrdersJson);
		return totalOrderId;
	}

	@RequestMapping(value = "/getTotalOrders", method = RequestMethod.POST)
	public @ResponseBody List<TotalOrdersJson> getTotalOrders(HttpServletRequest request, HttpServletResponse response, @RequestBody GridInfoJson gridInfoJson) {
		List<TotalOrdersJson> list = totalOrdersService.getTotalOrders(gridInfoJson);
		return list;
	}
//
//	@RequestMapping(value = "/getTotalOrdersByCustomerId/{customerId}", method = RequestMethod.GET)
//	public @ResponseBody List<TotalOrdersJson> getTotalOrdersByCustomerId(HttpServletRequest request, HttpServletResponse response, @PathVariable("customerId") Integer customerId) {
//		List<TotalOrdersJson> list = totalOrdersService.getTotalOrdersByCustomerId(customerId);
//		return list;
//	}
//
//	@RequestMapping(value = "/removeTotalOrder/{totalOrderId}", method = RequestMethod.GET)
//	public @ResponseBody Boolean removeTotalOrder(HttpServletRequest request, HttpServletResponse response, @PathVariable("totalOrderId") Integer totalOrderId) {
//		return totalOrdersService.removeTotalOrder(totalOrderId);
//	}
//
//	@RequestMapping(value = "/removeItemFromInvoice/{totalOrderId}", method = RequestMethod.GET)
//	public @ResponseBody Boolean removeItemFromInvoice(HttpServletRequest request, HttpServletResponse response, @PathVariable("totalOrderId") Integer totalOrderId) {
//		return totalOrdersService.removeItemFromInvoice(totalOrderId);
//	}
//
//	@RequestMapping(value = "/getDeliveredTotalOrders/{locationId}", method = RequestMethod.GET)
//	public @ResponseBody List<TotalOrdersJson> getDeliveredTotalOrders(HttpServletRequest request, HttpServletResponse response, @PathVariable("locationId") Integer locationId) {
//		List<TotalOrdersJson> list = totalOrdersService.getDeliveredTotalOrders(locationId);
//		return list;
//	}
}
