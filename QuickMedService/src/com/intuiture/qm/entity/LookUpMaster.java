package com.intuiture.qm.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "lookupmaster")
public class LookUpMaster {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer lookupmasterId;
	private String description;
	private String lookupType;

	public Integer getLookupmasterId() {
		return lookupmasterId;
	}

	public void setLookupmasterId(Integer lookupmasterId) {
		this.lookupmasterId = lookupmasterId;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getLookupType() {
		return lookupType;
	}

	public void setLookupType(String lookupType) {
		this.lookupType = lookupType;
	}

}
