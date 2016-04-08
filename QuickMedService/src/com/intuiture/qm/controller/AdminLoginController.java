package com.intuiture.qm.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.intuiture.qm.json.AdminJson;
import com.intuiture.qm.json.CustomerJson;
import com.intuiture.qm.service.AdminLoginService;

@RestController
@RequestMapping("/AdminLoginController")
public class AdminLoginController {
	@Autowired
	private AdminLoginService adminLoginService;

	// @RequestMapping(value = "/registrationAction", method =
	// RequestMethod.POST)
	// public CustomerJson registrationAction(@RequestBody CustomerJson
	// customerJson) {
	// return customerService.registrationAction(customerJson);
	// }

	@RequestMapping(value = "/loginAction", method = RequestMethod.POST)
	public AdminJson loginAction(@RequestBody CustomerJson customerJson) {
		return adminLoginService.loginAction(customerJson.getUserName(), customerJson.getPassword());
	}

}
