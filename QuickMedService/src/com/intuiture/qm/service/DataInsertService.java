package com.intuiture.qm.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.intuiture.qm.dao.CommonRepository;
import com.intuiture.qm.dao.DataInsertRepository;
import com.intuiture.qm.entity.Category;
import com.intuiture.qm.entity.Item;
import com.intuiture.qm.entity.Module;
import com.intuiture.qm.entity.SubModule;
import com.intuiture.qm.util.Constants;
import com.intuiture.qm.util.EnumUtils;
import com.intuiture.qm.util.MethodUtil;

@Service
@Transactional
public class DataInsertService {
	private static final Logger LOG = Logger.getLogger(DataInsertService.class);
	@Autowired
	private CommonRepository commonRepository;
	@Autowired
	private DataInsertRepository dataInsertRepository;

	@SuppressWarnings("unchecked")
	public Boolean insertModule() {
		try {
			List<Module> moduleList = (List<Module>) MethodUtil.readDataFromExcelFile(EnumUtils.MODULE.getValue());

			if (moduleList != null && moduleList.size() > 0) {
				List<String> codesList = new ArrayList<String>();

				for (Module module : moduleList) {
					codesList.add(module.getModuleCode());
				}
				codesList = (List<String>) commonRepository.getCodesByList(codesList, Module.class, Constants.MODULECODE);
				for (Module module : moduleList) {
					if (!codesList.contains(module.getModuleCode())) {
						module.setIsDeleted(Boolean.FALSE);
						module.setCreatedOn(new Date());
						commonRepository.persist(module);
					}
				}
			}
		} catch (Exception e) {
			e.printStackTrace();

			return false;
		}
		return true;
	}

	@SuppressWarnings("unchecked")
	public Boolean insertSubModule() {
		try {
			List<SubModule> subModuleList = (List<SubModule>) MethodUtil.readDataFromExcelFile(EnumUtils.SUBMODULE.getValue());

			if (subModuleList != null && subModuleList.size() > 0) {
				List<String> codesList = new ArrayList<String>();

				for (SubModule subModule : subModuleList) {
					codesList.add(subModule.getSubModuleCode());
				}
				codesList = (List<String>) commonRepository.getCodesByList(codesList, SubModule.class, Constants.SUBMODULECODE);
				for (SubModule subModule : subModuleList) {
					if (!codesList.contains(subModule.getSubModuleCode())) {
						subModule.setIsDeleted(Boolean.FALSE);
						subModule.setCreatedOn(new Date());
						commonRepository.persist(subModule);
					}
				}
			}
		} catch (Exception e) {
			e.printStackTrace();

			return false;
		}
		return true;
	}

	@SuppressWarnings("unchecked")
	public Boolean insertCategory() {
		try {
			List<Category> categoryList = (List<Category>) MethodUtil.readDataFromExcelFile(EnumUtils.CATEGORY.getValue());

			if (categoryList != null && categoryList.size() > 0) {
				List<String> codesList = new ArrayList<String>();

				for (Category category : categoryList) {
					if (category.getCategoryCode() != null && category.getCategoryCode().trim().length() > 0)
						codesList.add(category.getCategoryCode());
				}
				codesList = (List<String>) commonRepository.getCodesByList(codesList, Category.class, Constants.CATEGORYCODE);
				for (Category category : categoryList) {
					if (category.getCategoryCode() != null && category.getCategoryCode().trim().length() > 0) {
						if (!codesList.contains(category.getCategoryCode())) {
							category.setIsDeleted(Boolean.FALSE);
							category.setCreatedOn(new Date());
							commonRepository.persist(category);
						}
					}
				}
			}
		} catch (Exception e) {
			e.printStackTrace();

			return false;
		}
		return true;
	}

	@SuppressWarnings("unchecked")
	public Boolean insertItem() {
		try {
			List<Item> itemList = (List<Item>) MethodUtil.readDataFromExcelFile(EnumUtils.ITEM.getValue());

			if (itemList != null && itemList.size() > 0) {
				List<String> itemNameList = new ArrayList<String>();

				for (Item item : itemList) {
					itemNameList.add(item.getItemName());
				}
				itemNameList = (List<String>) commonRepository.getCodesByList(itemNameList, Item.class, Constants.ITEMNAME);
				for (Item item : itemList) {
					if (!itemNameList.contains(item.getItemName())) {
						item.setIsDeleted(Boolean.FALSE);
						item.setCreatedOn(new Date());
						commonRepository.persist(item);
					}
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			LOG.error(e.getMessage(), e);

			return false;
		}
		return true;
	}

	@SuppressWarnings("unchecked")
	public Boolean updateModule() {
		try {
			List<Module> moduleList = (List<Module>) MethodUtil.readDataFromExcelFile(EnumUtils.MODULE.getValue());

			if (moduleList != null && moduleList.size() > 0) {
				List<String> codesList = new ArrayList<String>();

				for (Module module : moduleList) {
					codesList.add(module.getModuleCode());
				}
				List<Module> dbModuleList = (List<Module>) commonRepository.getAllRecordsByList(Constants.MODULECODE, codesList, Module.class);
				for (Module module : moduleList) {
					for (Module dbModule : dbModuleList) {
						if (module.getModuleCode().equals(dbModule.getModuleCode())) {
							dbModule.setUpdatedOn(new Date());
							dbModule.setIsDeleted(Boolean.FALSE);
							dbModule.setModuleCode(module.getModuleCode());
							dbModule.setModuleName(module.getModuleName());
							commonRepository.update(dbModule);
						}
					}
				}
			}
		} catch (Exception e) {
			e.printStackTrace();

			return false;
		}
		return true;
	}

	@SuppressWarnings("unchecked")
	public Boolean updateSubModule() {
		try {
			List<SubModule> subModuleList = (List<SubModule>) MethodUtil.readDataFromExcelFile(EnumUtils.SUBMODULE.getValue());

			if (subModuleList != null && subModuleList.size() > 0) {
				List<String> codesList = new ArrayList<String>();

				for (SubModule subModule : subModuleList) {
					codesList.add(subModule.getSubModuleCode());
				}
				List<SubModule> dbSubModuleList = (List<SubModule>) commonRepository.getAllRecordsByList(Constants.SUBMODULECODE, codesList, SubModule.class);
				for (SubModule subModule : subModuleList) {
					for (SubModule dbSubModule : dbSubModuleList) {
						if (subModule.getSubModuleCode().equals(dbSubModule.getSubModuleCode())) {
							dbSubModule.setUpdatedOn(new Date());
							dbSubModule.setIsDeleted(Boolean.FALSE);
							dbSubModule.setModuleCode(subModule.getModuleCode());
							dbSubModule.setSubModuleCode(subModule.getSubModuleCode());
							dbSubModule.setSubModuleName(subModule.getSubModuleName());
							commonRepository.update(dbSubModule);
						}
					}
				}
			}
		} catch (Exception e) {
			e.printStackTrace();

			return false;
		}
		return true;
	}

	@SuppressWarnings("unchecked")
	public Boolean updateCategory() {
		try {
			List<Category> categoryList = (List<Category>) MethodUtil.readDataFromExcelFile(EnumUtils.CATEGORY.getValue());

			if (categoryList != null && categoryList.size() > 0) {
				List<String> codesList = new ArrayList<String>();

				for (Category category : categoryList) {
					codesList.add(category.getCategoryCode());
				}
				List<Category> dbCategoryList = (List<Category>) commonRepository.getAllRecordsByList(Constants.CATEGORYCODE, codesList, Category.class);
				for (Category category : categoryList) {
					for (Category dbCategory : dbCategoryList) {
						if (category.getCategoryCode().equals(dbCategory.getCategoryCode())) {
							dbCategory.setUpdatedOn(new Date());
							dbCategory.setCategoryCode(category.getCategoryCode());
							dbCategory.setCategoryName(category.getCategoryName());
							dbCategory.setSubModuleCode(category.getSubModuleCode());
							commonRepository.update(dbCategory);
						}
					}
				}
			}
		} catch (Exception e) {
			e.printStackTrace();

			return false;
		}
		return true;
	}

	@SuppressWarnings("unchecked")
	public Boolean updateItem() {
		try {
			List<Item> itemList = (List<Item>) MethodUtil.readDataFromExcelFile(EnumUtils.ITEM.getValue());

			if (itemList != null && itemList.size() > 0) {
				List<String> codesList = new ArrayList<String>();

				for (Item item : itemList) {
					codesList.add(item.getCategoryCode());
				}
				List<Item> dbItemList = (List<Item>) commonRepository.getAllRecordsByList(Constants.CATEGORYCODE, codesList, Item.class);
				for (Item item : itemList) {
					for (Item dbItem : dbItemList) {
						if (item.getItemName().equals(dbItem.getItemName())) {
							dbItem.setUpdatedOn(new Date());
							dbItem.setItemImageName(item.getItemImageName());
							dbItem.setManufacturerName(item.getManufacturerName());
							dbItem.setOffer(item.getOffer());
							dbItem.setPrice(item.getPrice());
							dbItem.setItemName(item.getItemName());
							dbItem.setIsAvailable(item.getIsAvailable());
							dbItem.setIsPrescription(item.getIsPrescription());
						}
					}
				}
			}
		} catch (Exception e) {
			e.printStackTrace();

			return false;
		}
		return true;
	}
}
