package com.accenture.lkm.services;

import java.util.Date;
import java.util.List;

import com.accenture.lkm.business.bean.PurchaseBean;

public interface ReportsService {
	
	public List<PurchaseBean> getPurchaseRecordsByDate(Date fromDate,Date toDate)throws Exception;
	public List<PurchaseBean> getPurchaseRecordsByVendorName(String vendorName)throws Exception;

}
