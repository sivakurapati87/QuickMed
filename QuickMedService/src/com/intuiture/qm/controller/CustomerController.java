package com.intuiture.qm.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.intuiture.qm.json.CustomerJson;
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

}
