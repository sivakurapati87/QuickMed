package com.intuiture.qm.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class TemplateController {// Serves Templates.

	@RequestMapping(value = "/home")
	public String getMainTemplate() {
		return "template/home";
	}

	@RequestMapping(value = "/header")
	public String header() {
		return "template/header";
	}

	@RequestMapping(value = "/category")
	public String category() {
		return "template/category";
	}

	@RequestMapping(value = "/itemInfo")
	public String itemInfo() {
		return "template/itemInfo";
	}

	@RequestMapping(value = "/searchItems")
	public String searchItems() {
		return "template/searchItems";
	}

	@RequestMapping(value = "/viewAllSubCategoryOrManufacturers")
	public String viewAllSubCategoryOrManufacturers() {
		return "template/viewAllSubCategoryOrManufacturers";
	}

	@RequestMapping(value = "/footer")
	public String footer() {
		return "template/footer";
	}

	@RequestMapping(value = "/account")
	public String account() {
		return "template/account";
	}

	@RequestMapping(value = "/shopping_cart")
	public String shopping_cart() {
		return "template/shopping_cart";
	}

	@RequestMapping(value = "/checkout")
	public String checkout() {
		return "template/checkout";
	}

	@RequestMapping(value = "/checkoutAddress")
	public String checkoutAddress() {
		return "template/checkoutAddress";
	}
}
