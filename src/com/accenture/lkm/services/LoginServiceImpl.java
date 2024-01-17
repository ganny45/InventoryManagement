package com.accenture.lkm.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.accenture.lkm.business.bean.LoginBean;
import com.accenture.lkm.dao.LoginDAOWrapper;

@Service
public class LoginServiceImpl implements LoginService {
	
	@Autowired
	private LoginDAOWrapper daoWrapper;


	@Override
	public LoginBean findLoginDetails(LoginBean loginBean)throws Exception {
		// TODO Auto-generated method stub
		
		LoginBean bean=daoWrapper.findLoginDetails(loginBean);
		
		if(loginBean.getUsername().equals(bean.getUsername()) && loginBean.getPassword().equals(bean.getPassword())) {
			return bean;
		}
		else{
			throw new Exception("Either Username or Password not matching!");
		}
	}

}
