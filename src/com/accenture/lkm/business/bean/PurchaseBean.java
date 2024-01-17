package com.accenture.lkm.business.bean;

import java.util.Date;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotBlank;
import org.springframework.format.annotation.DateTimeFormat;

public class PurchaseBean {

	private Integer purchaseId;
	@NotBlank
	private String materialCategoryId;
	@NotBlank
	private String materialTypeId;
	@NotBlank
	private String brandName;
	@NotBlank
	private String unitId;
	@NotNull
	private Integer quantity;
	@NotNull
	private Double purchaseAmount;
	private String materialCategoryName;
	private String materialTypeName;
	private String unitName;
	@NotBlank
	private String vendorName;
	@NotNull
	@DateTimeFormat(pattern = "dd-MMM-yyyy")
	private Date purchaseDate;

	public String getMaterialCategoryId() {
		return materialCategoryId;
	}

	public void setMaterialCategoryId(String materialCategoryId) {
		this.materialCategoryId = materialCategoryId;
	}

	public String getVendorName() {
		return vendorName;
	}

	public void setVendorName(String vendorName) {
		this.vendorName = vendorName;
	}

	public Date getPurchaseDate() {
		return purchaseDate;
	}

	public void setPurchaseDate(Date purchaseDate) {
		this.purchaseDate = purchaseDate;
	}

	public PurchaseBean() {
	}

	public Integer getPurchaseId() {
		return purchaseId;
	}

	public void setPurchaseId(Integer purchaseId) {
		this.purchaseId = purchaseId;
	}

	public String getMaterialTypeId() {
		return materialTypeId;
	}

	public void setMaterialTypeId(String materialTypeId) {
		this.materialTypeId = materialTypeId;
	}

	public String getBrandName() {
		return brandName;
	}

	public void setBrandName(String brandName) {
		this.brandName = brandName;
	}

	public String getUnitId() {
		return unitId;
	}

	public void setUnitId(String unitId) {
		this.unitId = unitId;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	public Double getPurchaseAmount() {
		return purchaseAmount;
	}

	public void setPurchaseAmount(Double purchaseAmount) {
		this.purchaseAmount = purchaseAmount;
	}

	public String getMaterialCategoryName() {
		return materialCategoryName;
	}

	public void setMaterialCategoryName(String materialCategoryName) {
		this.materialCategoryName = materialCategoryName;
	}

	public String getMaterialTypeName() {
		return materialTypeName;
	}

	public void setMaterialTypeName(String materialTypeName) {
		this.materialTypeName = materialTypeName;
	}

	public String getUnitName() {
		return unitName;
	}

	public void setUnitName(String unitName) {
		this.unitName = unitName;
	}

	@Override
	public String toString() {
		return "PurchaseBean [purchaseId=" + purchaseId + ", materialTypeId=" + materialTypeId + ", brandName="
				+ brandName + ", unitId=" + unitId + ", quantity=" + quantity + ", purchaseAmount=" + purchaseAmount
				+ ", materialCategoryName=" + materialCategoryName + ", materialTypeName=" + materialTypeName
				+ ", unitName=" + unitName + ", vendorName=" + vendorName + ", purchaseDate=" + purchaseDate + "]";
	}

}
