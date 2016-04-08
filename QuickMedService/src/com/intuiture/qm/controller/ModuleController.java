package com.intuiture.qm.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.intuiture.qm.json.ModuleJson;
import com.intuiture.qm.service.ModuleService;

@RestController
@RequestMapping("/ModuleController")
public class ModuleController {
	@Autowired
	private ModuleService moduleService;

	@RequestMapping(value = "/getAllModules", method = RequestMethod.GET)
	public List<ModuleJson> getAllModules() {
		return moduleService.getAllModules();
	}
}
