package com.intuiture.qm.bean;

import java.util.List;

import com.intuiture.qm.json.LookUpDetailJson;
import com.intuiture.qm.json.AdminJson;

public class AddEmployeeBean {
	private String email;
	private String password;
	private String reEnteredPwd;
	private String fullName;
	// private String profession;
	// private Integer selectedState;
	// private Integer selectedCity;
	// private String landMark;
	// private String area;
	private String mobileNo;
	private String message;
	private String userName;
	private List<LookUpDetailJson> empTypeComboList;
	private Integer selectedEmpType;
	private AdminJson userJson;
	private List<AdminJson> employeeList;

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

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public String getMobileNo() {
		return mobileNo;
	}

	public void setMobileNo(String mobileNo) {
		this.mobileNo = mobileNo;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public AdminJson getUserJson() {
		return userJson;
	}

	public void setUserJson(AdminJson userJson) {
		this.userJson = userJson;
	}

	public List<AdminJson> getEmployeeList() {
		return employeeList;
	}

	public void setEmployeeList(List<AdminJson> employeeList) {
		this.employeeList = employeeList;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getReEnteredPwd() {
		return reEnteredPwd;
	}

	public void setReEnteredPwd(String reEnteredPwd) {
		this.reEnteredPwd = reEnteredPwd;
	}

}
