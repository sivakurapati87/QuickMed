package com.intuiture.qm.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "addtocart")
public class AddToCart {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer addToCartId;
	private Integer customerId;
	private Date orderDate;
	private Integer itemId;
	private Integer quantity;
	private Double price;
	private Double subTotal;
	private Double discount;
	private Integer totalOrderId;
	@ManyToOne
	@JoinColumn(name = "itemId", insertable = false, updatable = false)
	private Item item;
	private Boolean isItemRemovedFromCart;
	private Boolean isItemDelivered;
	private Boolean isItemOrdered;
	@ManyToOne
	@JoinColumn(name = "totalOrderId", insertable = false, updatable = false)
	private TotalOrders totalOrders;

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

	public Item getItem() {
		return item;
	}

	public void setItem(Item item) {
		this.item = item;
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

	public TotalOrders getTotalOrders() {
		return totalOrders;
	}

	public void setTotalOrders(TotalOrders totalOrders) {
		this.totalOrders = totalOrders;
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
}
