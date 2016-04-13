package com.intuiture.qm.json;

import java.util.List;

/**
 * 
 * This class is to find-out the overall purchase of a customer for a particular
 * date and find out is there any discount applied
 *
 */
public class TotalOrdersJson {
	private Integer totalOrderId;
	private String totalOrderGenId;
	private Integer customerId;
	// private Double totalPurchase;
	private Integer couponCodeId;
	private Double subTotal;
	private Double totalAmount;
	private Double deliveryCharges;
	private Double discountAmount;
	private Boolean isDeleted;
	private String comments;
	private String transactionId;
	private Boolean isDelivered;
	private Boolean isItemInvoiced;
	private String deliveryAddress;
	private String imageName;
	private Long phoneNumber;
	private Boolean isTotalOrderSelected;
	private CustomerJson customerJson;
	private List<AddToCartJson> orderList;
	private String strOrderDate;

	public Integer getTotalOrderId() {
		return totalOrderId;
	}

	public void setTotalOrderId(Integer totalOrderId) {
		this.totalOrderId = totalOrderId;
	}

	public String getTotalOrderGenId() {
		return totalOrderGenId;
	}

	public void setTotalOrderGenId(String totalOrderGenId) {
		this.totalOrderGenId = totalOrderGenId;
	}

	public Integer getCustomerId() {
		return customerId;
	}

	public void setCustomerId(Integer customerId) {
		this.customerId = customerId;
	}

	// public Double getTotalPurchase() {
	// return totalPurchase;
	// }
	//
	// public void setTotalPurchase(Double totalPurchase) {
	// this.totalPurchase = totalPurchase;
	// }

	public Integer getCouponCodeId() {
		return couponCodeId;
	}

	public void setCouponCodeId(Integer couponCodeId) {
		this.couponCodeId = couponCodeId;
	}

	public Double getSubTotal() {
		return subTotal;
	}

	public void setSubTotal(Double subTotal) {
		this.subTotal = subTotal;
	}

	public Double getTotalAmount() {
		return totalAmount;
	}

	public void setTotalAmount(Double totalAmount) {
		this.totalAmount = totalAmount;
	}

	public Double getDeliveryCharges() {
		return deliveryCharges;
	}

	public void setDeliveryCharges(Double deliveryCharges) {
		this.deliveryCharges = deliveryCharges;
	}

	public Double getDiscountAmount() {
		return discountAmount;
	}

	public void setDiscountAmount(Double discountAmount) {
		this.discountAmount = discountAmount;
	}

	public Boolean getIsDeleted() {
		return isDeleted;
	}

	public void setIsDeleted(Boolean isDeleted) {
		this.isDeleted = isDeleted;
	}

	public String getComments() {
		return comments;
	}

	public void setComments(String comments) {
		this.comments = comments;
	}

	public String getTransactionId() {
		return transactionId;
	}

	public void setTransactionId(String transactionId) {
		this.transactionId = transactionId;
	}

	public Boolean getIsDelivered() {
		return isDelivered;
	}

	public void setIsDelivered(Boolean isDelivered) {
		this.isDelivered = isDelivered;
	}

	public Boolean getIsItemInvoiced() {
		return isItemInvoiced;
	}

	public void setIsItemInvoiced(Boolean isItemInvoiced) {
		this.isItemInvoiced = isItemInvoiced;
	}

	public String getDeliveryAddress() {
		return deliveryAddress;
	}

	public void setDeliveryAddress(String deliveryAddress) {
		this.deliveryAddress = deliveryAddress;
	}

	public String getImageName() {
		return imageName;
	}

	public void setImageName(String imageName) {
		this.imageName = imageName;
	}

	public Long getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(Long phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public CustomerJson getCustomerJson() {
		return customerJson;
	}

	public void setCustomerJson(CustomerJson customerJson) {
		this.customerJson = customerJson;
	}

	public List<AddToCartJson> getOrderList() {
		return orderList;
	}

	public void setOrderList(List<AddToCartJson> orderList) {
		this.orderList = orderList;
	}

	public Boolean getIsTotalOrderSelected() {
		return isTotalOrderSelected;
	}

	public void setIsTotalOrderSelected(Boolean isTotalOrderSelected) {
		this.isTotalOrderSelected = isTotalOrderSelected;
	}

	public String getStrOrderDate() {
		return strOrderDate;
	}

	public void setStrOrderDate(String strOrderDate) {
		this.strOrderDate = strOrderDate;
	}

}
