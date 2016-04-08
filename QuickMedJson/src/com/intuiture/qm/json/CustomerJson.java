package com.intuiture.qm.json;

import java.util.Date;

public class CustomerJson {
	private Integer customerId;
	private String firstName;
	private String lastName;
	private String emailId;
	private String userName;
	private String password;
	private String confirmPassword;
	private Long phoneNumber;
	private String gender;
	private String strDateOfBirth;
	private Date dateOfBirth;
	private Long pincode;
	private String address;
	private String city;
	private String state;
	private CustomerDeliveryAddressJson customerDeliveryAddressJson;

	public Long getPincode() {
		return pincode;
	}

	public void setPincode(Long pincode) {
		this.pincode = pincode;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getStrDateOfBirth() {
		return strDateOfBirth;
	}

	public void setStrDateOfBirth(String strDateOfBirth) {
		this.strDateOfBirth = strDateOfBirth;
	}

	public Integer getCustomerId() {
		return customerId;
	}

	public void setCustomerId(Integer customerId) {
		this.customerId = customerId;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
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

	public Long getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(Long phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getConfirmPassword() {
		return confirmPassword;
	}

	public void setConfirmPassword(String confirmPassword) {
		this.confirmPassword = confirmPassword;
	}

	public CustomerDeliveryAddressJson getCustomerDeliveryAddressJson() {
		return customerDeliveryAddressJson;
	}

	public void setCustomerDeliveryAddressJson(CustomerDeliveryAddressJson customerDeliveryAddressJson) {
		this.customerDeliveryAddressJson = customerDeliveryAddressJson;
	}

	public Date getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}
}
