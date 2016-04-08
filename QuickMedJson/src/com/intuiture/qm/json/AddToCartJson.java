package com.intuiture.qm.json;

import java.util.Date;

public class AddToCartJson {
	private Integer addToCartId;
	private Integer customerId;
	private Date orderDate;
	private Integer itemId;
	private Integer quantity;
	private Double price;
	private Double subTotal;
	private Double discount;
	private Integer totalOrderId;
	private Boolean isItemRemovedFromCart;
	private Boolean isItemDelivered;
	private Boolean isItemOrdered;
	private String itemImageBase64;
	private String itemName;
	private String comment;
	private Integer couponCodeId;

	public Integer getAddToCartId() {
		return addToCartId;
	}

	public void setAddToCartId(Integer addToCartId) {
		this.addToCartId = addToCartId;
	}

	public Integer getCustomerId() {
		return customerId;
	}

	public void setCustomerId(Integer customerId) {
		this.customerId = customerId;
	}

	public Date getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(Date orderDate) {
		this.orderDate = orderDate;
	}

	public Integer getItemId() {
		return itemId;
	}

	public void setItemId(Integer itemId) {
		this.itemId = itemId;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	public Boolean getIsItemRemovedFromCart() {
		return isItemRemovedFromCart;
	}

	public void setIsItemRemovedFromCart(Boolean isItemRemovedFromCart) {
		this.isItemRemovedFromCart = isItemRemovedFromCart;
	}

	public Double getSubTotal() {
		return subTotal;
	}

	public void setSubTotal(Double subTotal) {
		this.subTotal = subTotal;
	}

	public Boolean getIsItemDelivered() {
		return isItemDelivered;
	}

	public void setIsItemDelivered(Boolean isItemDelivered) {
		this.isItemDelivered = isItemDelivered;
	}

	public Boolean getIsItemOrdered() {
		return isItemOrdered;
	}

	public void setIsItemOrdered(Boolean isItemOrdered) {
		this.isItemOrdered = isItemOrdered;
	}

	public Integer getTotalOrderId() {
		return totalOrderId;
	}

	public void setTotalOrderId(Integer totalOrderId) {
		this.totalOrderId = totalOrderId;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public Double getDiscount() {
		return discount;
	}

	public void setDiscount(Double discount) {
		this.discount = discount;
	}

	public String getItemImageBase64() {
		return itemImageBase64;
	}

	public void setItemImageBase64(String itemImageBase64) {
		this.itemImageBase64 = itemImageBase64;
	}

	public String getItemName() {
		return itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public Integer getCouponCodeId() {
		return couponCodeId;
	}

	public void setCouponCodeId(Integer couponCodeId) {
		this.couponCodeId = couponCodeId;
	}
}
