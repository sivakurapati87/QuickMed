package com.intuiture.qm.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.intuiture.qm.json.CustomerJson;
import com.intuiture.qm.json.GridInfoJson;
import com.intuiture.qm.service.CustomerService;
import com.intuiture.qm.util.MethodUtil;

@RestController
@RequestMapping("/CustomerController")
public class CustomerController {
	@Autowired
	private CustomerService customerService;

	@RequestMapping(value = "/registrationAction", method = RequestMethod.POST)
	public CustomerJson registrationAction(@RequestBody CustomerJson customerJson) {
		return customerService.registrationAction(customerJson);
	}

	@RequestMapping(value = "/loginAction", method = RequestMethod.POST)
	public CustomerJson loginAction(@RequestBody CustomerJson customerJson) {
		return customerService.loginAction(customerJson.getUserName(), customerJson.getPassword());
	}

	@RequestMapping(value = "/placeCustomerDeliverAddress", method = RequestMethod.POST)
	public CustomerJson placeCustomerDeliverAddress(@RequestBody CustomerJson customerJson) {
		if (customerJson != null && customerJson.getStrDateOfBirth() != null) {
			customerJson.setDateOfBirth(MethodUtil.convertDiffferentFormatString(customerJson.getStrDateOfBirth()));
		}
		return customerService.placeCustomerDeliverAddress(customerJson);
	}

	@RequestMapping(value = "/getAllCustomer", method = RequestMethod.POST)
	public @ResponseBody List<CustomerJson> getAllCustomer(HttpServletRequest request, HttpServletResponse response, @RequestBody GridInfoJson gridInfoJson) {
		List<CustomerJson> customerJsonList = null;
		try {
			customerJsonList = customerService.getAllCustomer(gridInfoJson);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return customerJsonList;
	}

	@RequestMapping(value = "/getNoOfCustomers", method = RequestMethod.POST)
	public @ResponseBody synchronized Long getNoOfItems(HttpServletRequest request, HttpServletResponse response, @RequestBody GridInfoJson gridInfoJson) {
		Long noOfRecords = customerService.getNoOfItemsList(gridInfoJson);
		return noOfRecords;
	}

	@RequestMapping(value = "/forgetPassword/{email}", method = RequestMethod.GET)
	public CustomerJson forgetPassword(HttpServletRequest request, HttpServletResponse response, @PathVariable("email") String email) {
		return customerService.forgetPassword(email);
	}

}
