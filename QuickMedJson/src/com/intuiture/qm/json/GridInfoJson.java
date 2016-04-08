package com.intuiture.qm.json;

import java.util.List;

public class GridInfoJson {
	private Integer firstResults;
	private Integer maxResults;
	private String currentPage;
	private Integer userId;
	private Integer locationId;
	private Integer noOfRecordSize;
	private List<SearchJson> searchJsonList;
	private Integer recordsPerPage;

	public Integer getFirstResults() {
		return firstResults;
	}

	public void setFirstResults(Integer firstResults) {
		this.firstResults = firstResults;
	}

	public Integer getMaxResults() {
		return maxResults;
	}

	public void setMaxResults(Integer maxResults) {
		this.maxResults = maxResults;
	}

	public String getCurrentPage() {
		return currentPage;
	}

	public void setCurrentPage(String currentPage) {
		this.currentPage = currentPage;
	}

	public List<SearchJson> getSearchJsonList() {
		return searchJsonList;
	}

	public void setSearchJsonList(List<SearchJson> searchJsonList) {
		this.searchJsonList = searchJsonList;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public Integer getNoOfRecordSize() {
		return noOfRecordSize;
	}

	public void setNoOfRecordSize(Integer noOfRecordSize) {
		this.noOfRecordSize = noOfRecordSize;
	}

	public Integer getRecordsPerPage() {
		return recordsPerPage;
	}

	public void setRecordsPerPage(Integer recordsPerPage) {
		this.recordsPerPage = recordsPerPage;
	}

	public Integer getLocationId() {
		return locationId;
	}

	public void setLocationId(Integer locationId) {
		this.locationId = locationId;
	}

}
