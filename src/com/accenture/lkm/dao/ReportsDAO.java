package com.accenture.lkm.dao;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.RepositoryDefinition;
import org.springframework.transaction.annotation.Transactional;

import com.accenture.lkm.entity.PurchaseEntity;


@RepositoryDefinition(idClass = Integer.class, domainClass = PurchaseEntity.class)
@Transactional(value = "txManager")
public interface ReportsDAO {

	@Query(name = "PurchaseEntity.getPurchaseRecordsByDate")
	List<PurchaseEntity> getPurchaseRecordsByDate(Date fromDate, Date endDate);

	@Query(name = "PurchaseEntity.getPurchaseRecordsByVendorName")
	List<PurchaseEntity> getPurchaseRecordsByVendorName(String vendorname);

}
