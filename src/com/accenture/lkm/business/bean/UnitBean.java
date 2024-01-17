package com.accenture.lkm.business.bean;

public class UnitBean {
	private String unitId;
	private String unitName;

	public UnitBean(String unitId, String unitName) {

		this.unitId = unitId;
		this.unitName = unitName;
	}

	public UnitBean() {
	}

	public String getUnitId() {
		return unitId;
	}

	public void setUnitId(String unitId) {
		this.unitId = unitId;
	}

	public String getUnitName() {
		return unitName;
	}

	public void setUnitName(String unitName) {
		this.unitName = unitName;
	}

	@Override
	public String toString() {
		return "UnitBean [unitId=" + unitId + ", unitName=" + unitName + "]";
	}

}
