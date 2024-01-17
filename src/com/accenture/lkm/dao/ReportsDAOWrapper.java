package com.accenture.lkm.dao;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.accenture.lkm.business.bean.PurchaseBean;
import com.accenture.lkm.entity.PurchaseEntity;

@Repository
public class ReportsDAOWrapper {

	@Autowired
	private ReportsDAO dao;

	public ReportsDAOWrapper() {

	}

	public List<PurchaseBean> getPurchaseRecordsByDate(Date fromDate, Date endDate){
		List<PurchaseBean> bean = new ArrayList<>();

		List<PurchaseEntity> entity = dao.getPurchaseRecordsByDate(fromDate, endDate);
		for (PurchaseEntity entities : entity) {
			PurchaseBean beans = new PurchaseBean();
			BeanUtils.copyProperties(entities, beans);
			bean.add(beans);
		}

		return bean;
	}

	public List<PurchaseBean> getPurchaseRecordsByVendorName(String vendorName){
		List<PurchaseBean> bean = new ArrayList<>();
		List<PurchaseEntity> entity = dao.getPurchaseRecordsByVendorName(vendorName);
		for (PurchaseEntity entities : entity) {
			PurchaseBean beans = new PurchaseBean();
			BeanUtils.copyProperties(entities, beans);
			bean.add(beans);
		}

		return bean;
	}

}
