package com.intuiture.qm.bean;

import java.util.List;

import com.intuiture.qm.json.CustomerJson;
import com.intuiture.qm.json.GridInfoJson;

public class CustomerBean {
	private List<CustomerJson> customerList;
	private GridInfoJson gridInfoJson;
	private String navigationTagId;

	public List<CustomerJson> getCustomerList() {
		return customerList;
	}

	public void setCustomerList(List<CustomerJson> customerList) {
		this.customerList = customerList;
	}

	public GridInfoJson getGridInfoJson() {
		return gridInfoJson;
	}

	public void setGridInfoJson(GridInfoJson gridInfoJson) {
		this.gridInfoJson = gridInfoJson;
	}

	public String getNavigationTagId() {
		return navigationTagId;
	}

	public void setNavigationTagId(String navigationTagId) {
		this.navigationTagId = navigationTagId;
	}

}
