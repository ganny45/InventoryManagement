package com.accenture.lkm.business.bean;

public class MaterialCategoryBean {
	private String categoryId;
	private String categoryName;

	public MaterialCategoryBean(String categoryId, String categoryName) {
		this.categoryId = categoryId;
		this.categoryName = categoryName;
	}

	public MaterialCategoryBean() {
	}

	public String getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(String categoryId) {
		this.categoryId = categoryId;
	}

	public String getCategoryName() {
		return categoryName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}

	@Override
	public String toString() {
		return "MaterialCategoryBean [categoryId=" + categoryId + ", categoryName=" + categoryName + "]";
	}

}
