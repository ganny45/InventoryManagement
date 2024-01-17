package com.accenture.lkm.dao;

import org.springframework.data.repository.RepositoryDefinition;
import org.springframework.transaction.annotation.Transactional;

import com.accenture.lkm.entity.PurchaseEntity;

@RepositoryDefinition(idClass = Integer.class, domainClass = PurchaseEntity.class)
@Transactional(value = "txManager")
public interface PurchaseDAO {
	
	PurchaseEntity save(PurchaseEntity entity);
}
