package com.intuiture.qm.json;

public class LookUpDetailJson {
	private Integer lookupDetailId;
	private String description;
	private Integer parent;
	private Integer lookupMasterId;
	private Integer indexOfTheMonth;
	private Integer daysOfTheMonth;
	private String payDayPeriod;
	private String strPayDayDate;
	private String strPayCycleStartDay;
	private String strPayCycleEndDay;

	public String getStrPayDayDate() {
		return strPayDayDate;
	}

	public void setStrPayDayDate(String strPayDayDate) {
		this.strPayDayDate = strPayDayDate;
	}

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

	public Integer getLookupMasterId() {
		return lookupMasterId;
	}

	public void setLookupMasterId(Integer lookupMasterId) {
		this.lookupMasterId = lookupMasterId;
	}

	public Integer getParent() {
		return parent;
	}

	public void setParent(Integer parent) {
		this.parent = parent;
	}

	public String getPayDayPeriod() {
		return payDayPeriod;
	}

	public void setPayDayPeriod(String payDayPeriod) {
		this.payDayPeriod = payDayPeriod;
	}

	public String getStrPayCycleStartDay() {
		return strPayCycleStartDay;
	}

	public void setStrPayCycleStartDay(String strPayCycleStartDay) {
		this.strPayCycleStartDay = strPayCycleStartDay;
	}

	public String getStrPayCycleEndDay() {
		return strPayCycleEndDay;
	}

	public void setStrPayCycleEndDay(String strPayCycleEndDay) {
		this.strPayCycleEndDay = strPayCycleEndDay;
	}

}
