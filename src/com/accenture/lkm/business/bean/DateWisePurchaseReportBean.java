package com.accenture.lkm.business.bean;

import java.util.Date;

import org.hibernate.validator.constraints.NotBlank;

public class DateWisePurchaseReportBean {
	
	@NotBlank
	private Date fromDate;
	@NotBlank
	private Date toDate;
	public Date getFromDate() {
		return fromDate;
	}
	public void setFromDate(Date fromDate) {
		this.fromDate = fromDate;
	}
	public Date getToDate() {
		return toDate;
	}
	public void setToDate(Date toDate) {
		this.toDate = toDate;
	}

	public DateWisePurchaseReportBean() {
		
	}
}
