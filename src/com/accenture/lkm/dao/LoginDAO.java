package com.accenture.lkm.dao;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.RepositoryDefinition;
import org.springframework.transaction.annotation.Transactional;

import com.accenture.lkm.entity.LoginEntity;

@RepositoryDefinition(idClass = String.class,domainClass = LoginEntity.class)
@Transactional(value="txManager")
public interface LoginDAO {

	@Query(name="Login.findEntity")
	LoginEntity findOne(String s);
}
