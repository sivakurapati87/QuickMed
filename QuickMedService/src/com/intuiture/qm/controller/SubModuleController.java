package com.intuiture.qm.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.intuiture.qm.json.SubModuleJson;
import com.intuiture.qm.service.SubModuleService;

@RestController
@RequestMapping("/SubModuleController")
public class SubModuleController {
	@Autowired
	private SubModuleService subModuleService;

	@RequestMapping(value = "/getAllSubModulesWithModuleNameMap", method = RequestMethod.GET)
	public Map<String, List<SubModuleJson>> getAllSubModulesWithModuleNameMap() {
		return subModuleService.getAllSubModulesWithModuleNameMap();
	}
	
}
