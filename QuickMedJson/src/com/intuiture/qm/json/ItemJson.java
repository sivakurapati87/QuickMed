package com.intuiture.qm.json;

import java.util.List;

public class ItemJson {
	private Integer itemId;
	private String categoryCode;
	private Double price;
	private Double offer;
	private String itemImageName;
	private String itemName;
	private String searchItemName;
	private Boolean isAvailable;
	private String manufacturerName;
	private String categoryName;
	private String itemImageBase64;
	private List<ComboJson> comboJsonList;
	private Integer selectedComboJson;
	private Boolean isPrescription;
	private String chemicalIngradient;

	public String getCategoryName() {
		return categoryName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}

	public String getItemImageBase64() {
		return itemImageBase64;
	}

	public void setItemImageBase64(String itemImageBase64) {
		this.itemImageBase64 = itemImageBase64;
	}

	public Integer getItemId() {
		return itemId;
	}

	public void setItemId(Integer itemId) {
		this.itemId = itemId;
	}

	public String getCategoryCode() {
		return categoryCode;
	}

	public void setCategoryCode(String categoryCode) {
		this.categoryCode = categoryCode;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public Double getOffer() {
		return offer;
	}

	public void setOffer(Double offer) {
		this.offer = offer;
	}

	public String getItemImageName() {
		return itemImageName;
	}

	public void setItemImageName(String itemImageName) {
		this.itemImageName = itemImageName;
	}

	public String getItemName() {
		return itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	public Boolean getIsAvailable() {
		return isAvailable;
	}

	public void setIsAvailable(Boolean isAvailable) {
		this.isAvailable = isAvailable;
	}

	public String getManufacturerName() {
		return manufacturerName;
	}

	public void setManufacturerName(String manufacturerName) {
		this.manufacturerName = manufacturerName;
	}

	public List<ComboJson> getComboJsonList() {
		return comboJsonList;
	}

	public void setComboJsonList(List<ComboJson> comboJsonList) {
		this.comboJsonList = comboJsonList;
	}

	public Integer getSelectedComboJson() {
		return selectedComboJson;
	}

	public void setSelectedComboJson(Integer selectedComboJson) {
		this.selectedComboJson = selectedComboJson;
	}

	public Boolean getIsPrescription() {
		return isPrescription;
	}

	public void setIsPrescription(Boolean isPrescription) {
		this.isPrescription = isPrescription;
	}

	public String getSearchItemName() {
		return searchItemName;
	}

	public void setSearchItemName(String searchItemName) {
		this.searchItemName = searchItemName;
	}

	public String getChemicalIngradient() {
		return chemicalIngradient;
	}

	public void setChemicalIngradient(String chemicalIngradient) {
		this.chemicalIngradient = chemicalIngradient;
	}

}
