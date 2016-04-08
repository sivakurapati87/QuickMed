package com.intuiture.qm.json;

import java.util.Date;
import java.util.List;

public class SearchJson {
	private List<SearchComboJson> operatorsList;
	private String selectedOperator;
	private List<SearchComboJson> searchFieldList;
	private String selectedSearchFieldName;
	private String searchValue;
	private String selectedDataType;
	private Date dateSearchValue;
	private Boolean isAddIconVisible;
	private List<Integer> ids;

	public String getSearchValue() {
		return searchValue;
	}

	public void setSearchValue(String searchValue) {
		this.searchValue = searchValue;
	}

	public List<Integer> getIds() {
		return ids;
	}

	public void setIds(List<Integer> ids) {
		this.ids = ids;
	}

	public String getSelectedOperator() {
		return selectedOperator;
	}

	public void setSelectedOperator(String selectedOperator) {
		this.selectedOperator = selectedOperator;
	}

	public String getSelectedSearchFieldName() {
		return selectedSearchFieldName;
	}

	public void setSelectedSearchFieldName(String selectedSearchFieldName) {
		this.selectedSearchFieldName = selectedSearchFieldName;
	}

	public List<SearchComboJson> getOperatorsList() {
		return operatorsList;
	}

	public void setOperatorsList(List<SearchComboJson> operatorsList) {
		this.operatorsList = operatorsList;
	}

	public List<SearchComboJson> getSearchFieldList() {
		return searchFieldList;
	}

	public void setSearchFieldList(List<SearchComboJson> searchFieldList) {
		this.searchFieldList = searchFieldList;
	}

	public Boolean getIsAddIconVisible() {
		return isAddIconVisible;
	}

	public void setIsAddIconVisible(Boolean isAddIconVisible) {
		this.isAddIconVisible = isAddIconVisible;
	}

	public String getSelectedDataType() {
		return selectedDataType;
	}

	public void setSelectedDataType(String selectedDataType) {
		this.selectedDataType = selectedDataType;
	}

	public Date getDateSearchValue() {
		return dateSearchValue;
	}

	public void setDateSearchValue(Date dateSearchValue) {
		this.dateSearchValue = dateSearchValue;
	}

}
