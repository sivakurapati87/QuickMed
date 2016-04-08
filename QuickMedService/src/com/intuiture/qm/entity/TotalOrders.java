package com.intuiture.qm.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Where;

/**
 * 
 * This class is to find-out the overall purchase of a customer for a particular
 * date and find out is there any discount applied
 *
 */
@Entity
@Table(name = "totalOrders")
public class TotalOrders {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer totalOrderId;
	private String totalOrderGenId;
	private Integer customerId;
//	private Double totalPurchase;
	private Integer couponCodeId;
	private Double subTotal;
	private Double totalAmount;
	private Double deliveryCharges;
	private Date orderDate;
	@ManyToOne
	@JoinColumn(name = "couponCodeId", insertable = false, updatable = false)
	private CouponCode couponCode;
	private Double discountAmount;
	private String typeOfOrder;
	// private Integer typeOfOrderId;
	// @ManyToOne
	// @JoinColumn(name = "typeOfOrderId", insertable = false, updatable =
	// false)
	// private LookUpDetails lookUpDetails;
	// private Integer locationId;
	// @ManyToOne
	// @JoinColumn(name = "locationId", insertable = false, updatable = false)
	// private LookUpDetails locationDetails;
	private Boolean isDeleted;
	private String comments;
	private String transactionId;
	@ManyToOne
	@JoinColumn(name = "customerId", insertable = false, updatable = false)
	private Customer customer;
	private Boolean isDelivered;
	private Date updateOn;
	private Boolean isItemInvoiced;
	@OneToOne(mappedBy = "totalOrders")
	@Where(clause = "isDeleted='false'")
	private CustomerDeliveryAddress customerDeliveryAddress;

	public CustomerDeliveryAddress getCustomerDeliveryAddress() {
		return customerDeliveryAddress;
	}

	public void setCustomerDeliveryAddress(CustomerDeliveryAddress customerDeliveryAddress) {
		this.customerDeliveryAddress = customerDeliveryAddress;
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

	public Integer getCouponCodeId() {
		return couponCodeId;
	}

	public void setCouponCodeId(Integer couponCodeId) {
		this.couponCodeId = couponCodeId;
	}

	public CouponCode getCouponCode() {
		return couponCode;
	}

	public void setCouponCode(CouponCode couponCode) {
		this.couponCode = couponCode;
	}

	public Integer getTotalOrderId() {
		return totalOrderId;
	}

	public void setTotalOrderId(Integer totalOrderId) {
		this.totalOrderId = totalOrderId;
	}

	public Integer getCustomerId() {
		return customerId;
	}

	public void setCustomerId(Integer customerId) {
		this.customerId = customerId;
	}

//	public Double getTotalPurchase() {
//		return totalPurchase;
//	}
//
//	public void setTotalPurchase(Double totalPurchase) {
//		this.totalPurchase = totalPurchase;
//	}

	public Date getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(Date orderDate) {
		this.orderDate = orderDate;
	}

	public Double getSubTotal() {
		return subTotal;
	}

	public void setSubTotal(Double subTotal) {
		this.subTotal = subTotal;
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

	public String getTransactionId() {
		return transactionId;
	}

	public void setTransactionId(String transactionId) {
		this.transactionId = transactionId;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public String getTotalOrderGenId() {
		return totalOrderGenId;
	}

	public void setTotalOrderGenId(String totalOrderGenId) {
		this.totalOrderGenId = totalOrderGenId;
	}

	public Boolean getIsDelivered() {
		return isDelivered;
	}

	public void setIsDelivered(Boolean isDelivered) {
		this.isDelivered = isDelivered;
	}

	public Date getUpdateOn() {
		return updateOn;
	}

	public void setUpdateOn(Date updateOn) {
		this.updateOn = updateOn;
	}

	public Boolean getIsItemInvoiced() {
		return isItemInvoiced;
	}

	public void setIsItemInvoiced(Boolean isItemInvoiced) {
		this.isItemInvoiced = isItemInvoiced;
	}

	public Double getTotalAmount() {
		return totalAmount;
	}

	public void setTotalAmount(Double totalAmount) {
		this.totalAmount = totalAmount;
	}

	public String getTypeOfOrder() {
		return typeOfOrder;
	}

	public void setTypeOfOrder(String typeOfOrder) {
		this.typeOfOrder = typeOfOrder;
	}

}
