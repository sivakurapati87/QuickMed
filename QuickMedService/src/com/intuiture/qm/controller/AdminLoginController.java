package com.intuiture.qm.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.intuiture.qm.json.AdminJson;
import com.intuiture.qm.json.CustomerJson;
import com.intuiture.qm.service.AdminLoginService;

@RestController
@RequestMapping("/AdminLoginController")
public class AdminLoginController {
	@Autowired
	private AdminLoginService adminLoginService;

	@RequestMapping(value = "/registrationAction", method = RequestMethod.POST)
	public Boolean registrationAction(@RequestBody AdminJson adminJson) {
		return adminLoginService.registrationAction(adminJson);
	}

	@RequestMapping(value = "/loginAction", method = RequestMethod.POST)
	public AdminJson loginAction(@RequestBody CustomerJson customerJson) {
		return adminLoginService.loginAction(customerJson.getUserName(), customerJson.getPassword());
	}

	@RequestMapping(value = "/checkUserNameExists", method = RequestMethod.GET)
	public AdminJson checkUserNameExists(HttpServletRequest request, HttpServletResponse response, @RequestParam("userName") String userName) {
		return adminLoginService.checkUserNameExists(userName);
	}

	@RequestMapping(value = "/getAllAdmins", method = RequestMethod.GET)
	public List<AdminJson> getAllAdmins() {
		return adminLoginService.getAllAdmins();
	}

	@RequestMapping(value = "/deleteAdmin/{adminId}", method = RequestMethod.GET)
	public Boolean deleteAdmin(HttpServletRequest request, HttpServletResponse response, @PathVariable("adminId") Integer adminId) {
		return adminLoginService.deleteAdmin(adminId);
	}
}
