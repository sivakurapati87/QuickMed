package com.intuiture.qm.controller;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.intuiture.qm.json.LookUpDetailJson;
import com.intuiture.qm.service.LookUpService;

@Controller
@RequestMapping("/LookUpController")
public class LookUpController {
	@Autowired
	private LookUpService lookUpService;

	@RequestMapping(value = "/getAllLookupDetailsByTypeList", method = RequestMethod.POST)
	public @ResponseBody Map<String, List<LookUpDetailJson>> getAllLookupDetailsByTypeList(HttpServletRequest request, @RequestBody List<String> typesList,
			HttpServletResponse response) {
		Map<String, List<LookUpDetailJson>> jsonMap = lookUpService.getAllLookupDetailsByTypeList(typesList);
		return jsonMap;
	}

	@RequestMapping(value = "/searchState/{stateName}", method = RequestMethod.GET)
	public @ResponseBody List<LookUpDetailJson> searchState(@PathVariable("stateName") String stateName) {
		return lookUpService.searchState(stateName);
	}
}
