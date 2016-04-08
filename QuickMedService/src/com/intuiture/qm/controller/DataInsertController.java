package com.intuiture.qm.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.intuiture.qm.service.DataInsertService;

@Controller
@RequestMapping("/DataInsertController")
public class DataInsertController {
	@Autowired
	private DataInsertService dataInsertService;

	@RequestMapping(value = "/insertModule", method = RequestMethod.GET)
	public @ResponseBody Boolean insertModule(HttpServletRequest request, HttpServletResponse response) {
		return dataInsertService.insertModule();
	}

	@RequestMapping(value = "/insertSubModule", method = RequestMethod.GET)
	public @ResponseBody Boolean insertSubModule(HttpServletRequest request, HttpServletResponse response) {
		return dataInsertService.insertSubModule();
	}

	@RequestMapping(value = "/insertCategory", method = RequestMethod.GET)
	public @ResponseBody Boolean insertCategory(HttpServletRequest request, HttpServletResponse response) {
		return dataInsertService.insertCategory();
	}

	@RequestMapping(value = "/insertItem", method = RequestMethod.GET)
	public @ResponseBody Boolean insertItem(HttpServletRequest request, HttpServletResponse response) {
		return dataInsertService.insertItem();
	}

	@RequestMapping(value = "/updateModule", method = RequestMethod.GET)
	public @ResponseBody Boolean updateModule(HttpServletRequest request, HttpServletResponse response) {
		return dataInsertService.updateModule();
	}

	@RequestMapping(value = "/updateSubModule", method = RequestMethod.GET)
	public @ResponseBody Boolean updateSubModule(HttpServletRequest request, HttpServletResponse response) {
		return dataInsertService.updateSubModule();
	}

	@RequestMapping(value = "/updateCategory", method = RequestMethod.GET)
	public @ResponseBody Boolean updateCategory(HttpServletRequest request, HttpServletResponse response) {
		return dataInsertService.updateCategory();
	}

	@RequestMapping(value = "/updateItem", method = RequestMethod.GET)
	public @ResponseBody Boolean updateItem(HttpServletRequest request, HttpServletResponse response) {
		return dataInsertService.updateItem();
	}

}
