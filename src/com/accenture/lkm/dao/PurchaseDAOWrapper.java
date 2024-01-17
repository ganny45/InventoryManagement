package com.accenture.lkm.dao;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.accenture.lkm.business.bean.PurchaseBean;
import com.accenture.lkm.entity.PurchaseEntity;

@Repository
public class PurchaseDAOWrapper {

	@Autowired
	private PurchaseDAO dao;

	public PurchaseDAOWrapper() {

	}

	public PurchaseBean savePurchaseDetails(PurchaseBean bean) {
		PurchaseEntity entity=new PurchaseEntity();
		BeanUtils.copyProperties(bean, entity);
		entity=dao.save(entity);
		BeanUtils.copyProperties(entity, bean);
		return bean;
	}

}
