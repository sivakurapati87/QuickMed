package com.intuiture.qm.bean;

import java.util.List;

import com.intuiture.qm.json.AdminJson;

public class AddEmployeeBean {
	private String password;
	private String reEnteredPwd;
	private String fullName;
	private String message;
	private String userName;
	private AdminJson adminJson;
	private List<AdminJson> employeeList;

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

	public List<AdminJson> getEmployeeList() {
		return employeeList;
	}

	public void setEmployeeList(List<AdminJson> employeeList) {
		this.employeeList = employeeList;
	}

	public String getReEnteredPwd() {
		return reEnteredPwd;
	}

	public void setReEnteredPwd(String reEnteredPwd) {
		this.reEnteredPwd = reEnteredPwd;
	}

	public AdminJson getAdminJson() {
		return adminJson;
	}

	public void setAdminJson(AdminJson adminJson) {
		this.adminJson = adminJson;
	}

}
