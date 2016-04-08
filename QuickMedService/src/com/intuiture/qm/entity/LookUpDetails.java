package com.intuiture.qm.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "lookupdetails")
public class LookUpDetails {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer lookupDetailId;
	private String description;
	private Integer parent;
	private Integer lookupMasterId;
	private Integer indexOfTheMonth;
	private Integer daysOfTheMonth;
	@ManyToOne
	@JoinColumn(name = "lookupMasterId", insertable = false, updatable = false)
	private LookUpMaster lookUpMaster;

	public Integer getIndexOfTheMonth() {
		return indexOfTheMonth;
	}

	public void setIndexOfTheMonth(Integer indexOfTheMonth) {
		this.indexOfTheMonth = indexOfTheMonth;
	}

	public Integer getDaysOfTheMonth() {
		return daysOfTheMonth;
	}

	public void setDaysOfTheMonth(Integer daysOfTheMonth) {
		this.daysOfTheMonth = daysOfTheMonth;
	}

	public Integer getLookupMasterId() {
		return lookupMasterId;
	}

	public void setLookupMasterId(Integer lookupMasterId) {
		this.lookupMasterId = lookupMasterId;
	}

	public Integer getLookupDetailId() {
		return lookupDetailId;
	}

	public void setLookupDetailId(Integer lookupDetailId) {
		this.lookupDetailId = lookupDetailId;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public LookUpMaster getLookUpMaster() {
		return lookUpMaster;
	}

	public void setLookUpMaster(LookUpMaster lookUpMaster) {
		this.lookUpMaster = lookUpMaster;
	}

	public Integer getParent() {
		return parent;
	}

	public void setParent(Integer parent) {
		this.parent = parent;
	}

}
