package com.intuiture.qm.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.intuiture.qm.dao.CommonRepository;
import com.intuiture.qm.dao.ItemRepository;
import com.intuiture.qm.entity.Item;
import com.intuiture.qm.json.ItemJson;
import com.intuiture.qm.util.MethodUtil;
import com.intuiture.qm.util.TransformDomainToJson;

@Service
@Transactional
public class ItemService {
	private final static Logger LOG = Logger.getLogger(ItemService.class);
	@Autowired
	private CommonRepository commonRepository;
	@Autowired
	private ItemRepository itemRepository;

	public Map<String, List<ItemJson>> getAllCategoriesWithItemsBySubModuleCode(String subModuleCode) {
		Map<String, List<ItemJson>> itemWithCategoryMap = null;
		try {
			List<Item> itemList = itemRepository.getAllCategoriesWithItemsBySubModuleCode(subModuleCode);
			itemWithCategoryMap = MethodUtil.getACategoryWithItemsMap(itemList, itemWithCategoryMap);

		} catch (Exception e) {
			e.printStackTrace();
			LOG.error(e.getMessage(), e);
		}
		return itemWithCategoryMap;
	}

	public List<ItemJson> getAllManufacturers() {
		List<ItemJson> manufacturerJsonList = null;
		try {
			List<String> manufacturersList = itemRepository.getAllManufacturers();
			if (manufacturersList != null && manufacturersList.size() > 0) {
				manufacturerJsonList = new ArrayList<ItemJson>();
				for (String manufacturer : manufacturersList) {
					ItemJson json = new ItemJson();
					json.setManufacturerName(manufacturer);
					manufacturerJsonList.add(json);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			LOG.error(e.getMessage(), e);
		}
		return manufacturerJsonList;
	}

	public Map<String, List<ItemJson>> getACategoryWithItemsByManufacturerName(String manufacturer) {
		Map<String, List<ItemJson>> itemWithCategoryMap = null;
		try {
			List<Item> itemList = itemRepository.getAllProductsByManufacturerName(manufacturer);
			itemWithCategoryMap = MethodUtil.getACategoryWithItemsMap(itemList, itemWithCategoryMap);

		} catch (Exception e) {
			e.printStackTrace();
			LOG.error(e.getMessage(), e);
		}
		return itemWithCategoryMap;
	}

	public List<ItemJson> searchProduct(String productName) {
		List<ItemJson> productList = null;
		try {
			List<Item> itemList = itemRepository.searchProduct(productName);
			if (itemList != null && itemList.size() > 0) {
				productList = new ArrayList<ItemJson>();
				for (Item item : itemList) {
					ItemJson json = new ItemJson();
					if (item.getItemName().toLowerCase().contains(productName.toLowerCase())) {
						json.setItemName(item.getItemName());
						json.setSearchItemName(item.getItemName() + " -- Rs." + MethodUtil.round(MethodUtil.findOfferPrice(item.getPrice(), item.getOffer()), 2));
					} else if (item.getCategory() != null) {
						if (item.getCategory().getCategoryName().toLowerCase().contains(productName.toLowerCase())) {
							json.setItemName(item.getCategoryCode());
							json.setSearchItemName(item.getCategory().getCategoryName());
						} else if (item.getCategory().getSubModule() != null) {
							if (item.getCategory().getSubModule().getSubModuleName().toLowerCase().contains(productName.toLowerCase())) {
								json.setItemName(item.getCategory().getSubModuleCode());
								json.setSearchItemName(item.getCategory().getSubModule().getSubModuleName());
							}
						}
					}
					if (productList != null && productList.size() > 0) {
						Boolean isValueExists = false;
						for (ItemJson product : productList) {
							if (product.getItemName().equalsIgnoreCase(json.getItemName())) {
								isValueExists = true;
								break;
							}
						}
						if (!isValueExists) {
							productList.add(json);
						}
					} else {
						productList.add(json);
					}

				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			LOG.error(e.getMessage(), e);
		}
		return productList;
	}

	public List<ItemJson> getRequiredsearchProducts(String productName, Integer pageNo) {
		List<ItemJson> productList = null;
		try {
			List<Item> itemList = itemRepository.getRequiredsearchProducts(productName, pageNo);
			if (itemList != null && itemList.size() > 0) {
				productList = new ArrayList<ItemJson>();
				for (Item item : itemList) {
					productList.add(TransformDomainToJson.getItemJson(item));
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
			LOG.error(e.getMessage(), e);
		}
		return productList;
	}

	public Integer getNoOfRequiredsearchProducts(String productName) {
		Integer noOfRecords = null;
		try {
			Long recordsCount = itemRepository.getNoOfRequiredsearchProducts(productName);
			if (recordsCount != null) {
				noOfRecords = recordsCount.intValue();
			}
		} catch (Exception e) {
			e.printStackTrace();
			LOG.error(e.getMessage(), e);
		}
		return noOfRecords;
	}
}
