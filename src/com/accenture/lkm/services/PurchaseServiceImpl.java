package com.accenture.lkm.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.accenture.lkm.business.bean.PurchaseBean;
import com.accenture.lkm.dao.PurchaseDAOWrapper;

@Service
public class PurchaseServiceImpl implements PurchaseService {
	
	@Autowired
	private PurchaseDAOWrapper daoWrapper;

	@Override
	public PurchaseBean savePurchaseDetails(PurchaseBean purchaseBean) {
		return daoWrapper.savePurchaseDetails(purchaseBean);
	}

}
