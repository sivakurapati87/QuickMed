package com.intuiture.qm.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "customerdeliveryaddress")
@NamedQueries({ @NamedQuery(name = "CustomerDeliveryAddress.findByTotalOrderId", query = "select c from CustomerDeliveryAddress c where c.totalOrderId=?1 and c.isDeleted=false "), })
public class CustomerDeliveryAddress {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer deliveryAddressId;
	private Boolean isDeleted;
	private Integer totalOrderId;
	@OneToOne
	@JoinColumn(name = "totalOrderId", insertable = false, updatable = false)
	private TotalOrders totalOrders;
	private Long phoneNumber;
	private Long pincode;
	private String address;
	private String city;
	private String state;

	public Integer getDeliveryAddressId() {
		return deliveryAddressId;
	}

	public void setDeliveryAddressId(Integer deliveryAddressId) {
		this.deliveryAddressId = deliveryAddressId;
	}

	public Boolean getIsDeleted() {
		return isDeleted;
	}

	public void setIsDeleted(Boolean isDeleted) {
		this.isDeleted = isDeleted;
	}

	public Integer getTotalOrderId() {
		return totalOrderId;
	}

	public void setTotalOrderId(Integer totalOrderId) {
		this.totalOrderId = totalOrderId;
	}

	public TotalOrders getTotalOrders() {
		return totalOrders;
	}

	public void setTotalOrders(TotalOrders totalOrders) {
		this.totalOrders = totalOrders;
	}

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

	public Long getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(Long phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

}
