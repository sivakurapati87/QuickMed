//package com.intuiture.qm.managedbean;
//
//import java.text.SimpleDateFormat;
//import java.util.ArrayList;
//import java.util.List;
//
//import javax.faces.bean.ManagedBean;
//import javax.faces.bean.SessionScoped;
//
//import org.apache.log4j.Logger;
//
//import com.intuiture.storetodoorgrocer.bean.CustomerBean;
//import com.intuiture.storetodoorgrocer.json.GridInfoJson;
//import com.intuiture.storetodoorgrocer.json.SearchComboJson;
//import com.intuiture.storetodoorgrocer.json.SearchJson;
//import com.intuiture.storetodoorgrocer.util.CommonUtil;
//import com.intuiture.storetodoorgrocer.util.Constants;
//import com.intuiture.storetodoorgrocer.util.SerConstants;
//
//@ManagedBean(name = "CustomerBean")
//@SessionScoped
//public class CustomerManagedBean extends CustomerBean {
//	private static final Logger LOG = Logger.getLogger(CustomerManagedBean.class);
//	private static SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
//
//	public void init() {
//		setGridInfoJson(new GridInfoJson());
//		getGridInfoJson().setFirstResults(0);
//		getGridInfoJson().setRecordsPerPage(Constants.RECORDSPERPAGE);
//		getGridInfoJson().setSearchJsonList(new ArrayList<SearchJson>());
//		getGridInfoJson().getSearchJsonList().add(getsearchComboAction(SerConstants.STRING.toString()));
//		getAllCustomers();
//	}
//
//	public void getAllCustomers() {
//		getGridInfoJson().setNoOfRecordSize(CommonUtil.getNoOfItemsList(Constants.Customer.GET_NO_CUSTOMERS, getGridInfoJson()));
//		setCustomerList(CommonUtil.getAllCustomerList(getGridInfoJson()));
//		getCurrentPage();
//	}
//
//	public String searchGoAction() {
//		try {
//			if (getGridInfoJson().getSearchJsonList() != null && getGridInfoJson().getSearchJsonList().size() > 0) {
//				for (SearchJson json : getGridInfoJson().getSearchJsonList()) {
//					if (json.getSearchValue() != null || json.getDateSearchValue() != null) {
//						if (json.getSelectedDataType().equalsIgnoreCase(SerConstants.DATE.toString())) {
//							if (json.getDateSearchValue() != null) {
//								json.setSearchValue(sdf.format(json.getDateSearchValue()));
//								break;
//							}
//						}
//					}
//				}
//			}
//			getAllCustomers();
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//		return "";
//	}
//
//	public SearchJson getsearchComboAction(String typeOfField) {
//
//		SearchJson searchJson = new SearchJson();
//		try {
//			String[] searchFieldLabels = { "First Name", "Last Name", "Address", "Email", "Phone Number", "Monthly Purchase", "Yearly Purchase", "Created On" };
//			String[] searchFieldValues = { "firstName", "lastName", "address", "email", "phoneNo", "monthlyPurchase", "yearlyPurchase", "createdOn" };
//			SerConstants[] searchFieldType = { SerConstants.STRING, SerConstants.STRING, SerConstants.STRING, SerConstants.STRING, SerConstants.NUMBER, SerConstants.NUMBER, SerConstants.NUMBER, SerConstants.DATE };
//			List<SearchComboJson> searchFieldComboJsonList = new ArrayList<SearchComboJson>();
//			for (int i = 0; i < searchFieldLabels.length; i++) {
//				SearchComboJson searchComboJson = new SearchComboJson();
//				searchComboJson.setLabel(searchFieldLabels[i]);
//				searchComboJson.setValue(searchFieldValues[i]);
//				searchComboJson.setType(searchFieldType[i].toString());
//				searchFieldComboJsonList.add(searchComboJson);
//			}
//			searchJson.setIsAddIconVisible(Boolean.TRUE);
//			searchJson.setSearchFieldList(searchFieldComboJsonList);
//			searchJson.setSelectedDataType(SerConstants.STRING.toString());
//			searchJson.setOperatorsList(CommonUtil.getSearchOperators(typeOfField));
//			searchJson.setSearchValue(null);
//		} catch (Exception e) {
//			e.printStackTrace();
//			LOG.error("Error at getsearchComboAction():" + e.getMessage());
//		}
//		return searchJson;
//
//	}
//
//	public void onChangeSearchFieldNameAction() {
//		try {
//			String typeOfField = null;
//			// if (fieldName != null && fieldName.trim().length() > 0) {
//			if (getGridInfoJson().getSearchJsonList() != null && getGridInfoJson().getSearchJsonList().size() > 0) {
//				for (SearchJson json : getGridInfoJson().getSearchJsonList()) {
//					// if
//					// (fieldName.equalsIgnoreCase(json.getSelectedSearchFieldName()))
//					// {
//					if (json.getSearchFieldList() != null && json.getSearchFieldList().size() > 0) {
//						for (SearchComboJson comboJson : json.getSearchFieldList()) {
//							if (comboJson.getValue().equalsIgnoreCase(json.getSelectedSearchFieldName())) {
//								typeOfField = comboJson.getType();
//								break;
//							}
//						}
//						json.setOperatorsList(CommonUtil.getSearchOperators(typeOfField));
//						json.setSelectedDataType(typeOfField);
//					}
//				}
//			}
//		} catch (Exception e) {
//			e.printStackTrace();
//			LOG.error("Error at getsearchComboAction():" + e.getMessage());
//		}
//	}
//
//	public String navigationAction() {
//
//		Integer offSetValue = 0;
//		if (getNavigationTagId().startsWith("f")) {
//			offSetValue = 0;
//		} else if (getNavigationTagId().startsWith("p")) {
//			if ((getGridInfoJson().getFirstResults() - getGridInfoJson().getRecordsPerPage()) < 0) {
//				offSetValue = 0;
//			} else {
//				offSetValue = (getGridInfoJson().getFirstResults() - getGridInfoJson().getRecordsPerPage());
//			}
//		} else if (getNavigationTagId().startsWith("n")) {
//			if ((getGridInfoJson().getFirstResults() + getGridInfoJson().getRecordsPerPage()) >= getGridInfoJson().getNoOfRecordSize()) {
//				offSetValue = getGridInfoJson().getFirstResults();
//			} else {
//				offSetValue = (getGridInfoJson().getFirstResults() + getGridInfoJson().getRecordsPerPage());
//			}
//		} else {
//			offSetValue = getGridInfoJson().getNoOfRecordSize().equals(0) ? 0 : (getGridInfoJson().getNoOfRecordSize() % getGridInfoJson().getRecordsPerPage()) == 0 ? (getGridInfoJson().getNoOfRecordSize() - getGridInfoJson().getRecordsPerPage())
//					: (getGridInfoJson().getNoOfRecordSize() - (getGridInfoJson().getNoOfRecordSize() % getGridInfoJson().getRecordsPerPage()));
//		}
//
//		getGridInfoJson().setFirstResults(offSetValue);
//		getAllCustomers();
//		return "";
//	}
//
//	public void getCurrentPage() {
//		Integer count = getGridInfoJson().getRecordsPerPage();
//		Integer listSize = getGridInfoJson().getNoOfRecordSize();
//		Integer offSetValue = getGridInfoJson().getFirstResults();
//		String currentRecordPage = listSize == 0 ? "" : "Page " + ((offSetValue / count) + 1) + " Of " + (listSize.equals(0) ? 1 : (listSize % count == 0) ? (listSize / count) : (listSize / count) + 1);
//		getGridInfoJson().setCurrentPage(currentRecordPage);
//	}
//
//}
