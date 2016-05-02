package com.intuiture.qm.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.intuiture.qm.json.ItemJson;
import com.intuiture.qm.service.ItemService;

@RestController
@RequestMapping("/ItemController")
public class ItemController {
	@Autowired
	private ItemService itemService;

	@RequestMapping(value = "/getAllCategoriesWithItemsBySubModuleCode/{subModuleCode}", method = RequestMethod.GET)
	public Map<String, List<ItemJson>> getAllCategoriesWithItemsBySubModuleCode(@PathVariable("subModuleCode") String subModuleCode) {
		return itemService.getAllCategoriesWithItemsBySubModuleCode(subModuleCode);
	}

	@RequestMapping(value = "/getAllManufacturers", method = RequestMethod.GET)
	public List<ItemJson> getAllManufacturers() {
		return itemService.getAllManufacturers();
	}

	@RequestMapping(value = "/searchProduct/{productName}", method = RequestMethod.GET)
	public List<ItemJson> searchProduct(@PathVariable("productName") String productName) {
		return itemService.searchProduct(productName);
	}

	@RequestMapping(value = "/getACategoryWithItemsByManufacturerName/{manufacturer}", method = RequestMethod.GET)
	public Map<String, List<ItemJson>> getACategoryWithItemsByManufacturerName(@PathVariable("manufacturer") String manufacturer) {
		return itemService.getACategoryWithItemsByManufacturerName(manufacturer);
	}

	@RequestMapping(value = "/getRequiredsearchProducts", method = RequestMethod.GET)
	public List<ItemJson> getRequiredsearchProducts(@RequestParam("productName") String productName, @RequestParam("pageNo") Integer pageNo) {
		return itemService.getRequiredsearchProducts(productName, pageNo);
	}

	@RequestMapping(value = "/getNoOfRequiredsearchProducts/{productName}", method = RequestMethod.GET)
	public Integer getNoOfRequiredsearchProducts(@PathVariable("productName") String productName) {
		return itemService.getNoOfRequiredsearchProducts(productName);
	}
	
	@RequestMapping(value = "/getAllSimilarItems/{chemicalIngradient}", method = RequestMethod.GET)
	public List<ItemJson> getAllSimilarItems(@PathVariable("chemicalIngradient")String chemicalIngradient) {
		return itemService.getAllSimilarItems(chemicalIngradient);
	}
}
