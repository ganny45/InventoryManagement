package com.accenture.lkm.dao;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.accenture.lkm.business.bean.LoginBean;
import com.accenture.lkm.entity.LoginEntity;

@Repository
@Transactional(value="txManager")
public class LoginDAOWrapper{

	@Autowired
	private LoginDAO dao;

	public LoginDAOWrapper() {
		
	}
	
	public LoginBean findLoginDetails(LoginBean bean)
	{
		LoginEntity login=dao.findOne(bean.getUsername());
		LoginBean beans=new LoginBean();
		BeanUtils.copyProperties(login, beans);
		return beans;
		
		
	}

	
}
