package com.intuiture.qm.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "couponcode")
public class CouponCode {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer couponCodeId;
	private String couponCode;
	private Float discountPercentage;
	private Date expiryDate;
	private Date createdOn;
	private Date updatedOn;
	private Boolean isDeleted;
	private Integer userId;

	public Date getCreatedOn() {
		return createdOn;
	}

	public void setCreatedOn(Date createdOn) {
		this.createdOn = createdOn;
	}

	public Date getUpdatedOn() {
		return updatedOn;
	}

	public void setUpdatedOn(Date updatedOn) {
		this.updatedOn = updatedOn;
	}

	public Integer getCouponCodeId() {
		return couponCodeId;
	}

	public void setCouponCodeId(Integer couponCodeId) {
		this.couponCodeId = couponCodeId;
	}

	public String getCouponCode() {
		return couponCode;
	}

	public void setCouponCode(String couponCode) {
		this.couponCode = couponCode;
	}

	public Float getDiscountPercentage() {
		return discountPercentage;
	}

	public void setDiscountPercentage(Float discountPercentage) {
		this.discountPercentage = discountPercentage;
	}

	public Date getExpiryDate() {
		return expiryDate;
	}

	public void setExpiryDate(Date expiryDate) {
		this.expiryDate = expiryDate;
	}

	public Boolean getIsDeleted() {
		return isDeleted;
	}

	public void setIsDeleted(Boolean isDeleted) {
		this.isDeleted = isDeleted;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

}
