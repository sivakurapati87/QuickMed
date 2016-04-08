package com.intuiture.qm.bean;

import java.util.List;

import com.intuiture.qm.json.LookUpDetailJson;
import com.intuiture.qm.json.AdminJson;

public class LoginBean {
	private String userName;
	private String password;
	private AdminJson userJson;
	private Boolean isUserLoggedIn = Boolean.FALSE;
	private String message;
	private String logOutString;
	private List<LookUpDetailJson> empTypeComboList;
	private Integer selectedEmpType;
	private List<LookUpDetailJson> locationsList;
	private Integer selectedLocation;
	private Boolean isLocationComboBoxDisplayed;

	public List<LookUpDetailJson> getLocationsList() {
		return locationsList;
	}

	public void setLocationsList(List<LookUpDetailJson> locationsList) {
		this.locationsList = locationsList;
	}

	public Integer getSelectedLocation() {
		return selectedLocation;
	}

	public void setSelectedLocation(Integer selectedLocation) {
		this.selectedLocation = selectedLocation;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public AdminJson getUserJson() {
		return userJson;
	}

	public void setUserJson(AdminJson userJson) {
		this.userJson = userJson;
	}

	public Boolean getIsUserLoggedIn() {
		return isUserLoggedIn;
	}

	public void setIsUserLoggedIn(Boolean isUserLoggedIn) {
		this.isUserLoggedIn = isUserLoggedIn;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getLogOutString() {
		return logOutString;
	}

	public void setLogOutString(String logOutString) {
		this.logOutString = logOutString;
	}

	public List<LookUpDetailJson> getEmpTypeComboList() {
		return empTypeComboList;
	}

	public void setEmpTypeComboList(List<LookUpDetailJson> empTypeComboList) {
		this.empTypeComboList = empTypeComboList;
	}

	public Integer getSelectedEmpType() {
		return selectedEmpType;
	}

	public void setSelectedEmpType(Integer selectedEmpType) {
		this.selectedEmpType = selectedEmpType;
	}

	public Boolean getIsLocationComboBoxDisplayed() {
		return isLocationComboBoxDisplayed;
	}

	public void setIsLocationComboBoxDisplayed(Boolean isLocationComboBoxDisplayed) {
		this.isLocationComboBoxDisplayed = isLocationComboBoxDisplayed;
	}

}
