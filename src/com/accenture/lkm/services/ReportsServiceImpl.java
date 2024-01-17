package com.accenture.lkm.services;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.accenture.lkm.business.bean.PurchaseBean;

import com.accenture.lkm.dao.ReportsDAOWrapper;

@Service
public class ReportsServiceImpl implements ReportsService {
	
	@Autowired
	private ReportsDAOWrapper daoWrapper;

	@Override
	public List<PurchaseBean> getPurchaseRecordsByDate(Date fromDate, Date endDate) throws Exception {
		
		List<PurchaseBean> listBean=daoWrapper.getPurchaseRecordsByDate(fromDate, endDate);
		if(!listBean.isEmpty()) {
			return listBean;
		}else {
			throw new Exception("");
		}
	}

	@Override
	public List<PurchaseBean> getPurchaseRecordsByVendorName(String vendorName) throws Exception{
		List<PurchaseBean> listBean=daoWrapper.getPurchaseRecordsByVendorName(vendorName);
		if(!listBean.isEmpty()) {
			return listBean;
		}else {
			throw new Exception("");
		}
	}

}
