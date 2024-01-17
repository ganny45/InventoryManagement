package com.accenture.lkm.services;

import com.accenture.lkm.business.bean.LoginBean;

public interface LoginService {
	
	public LoginBean findLoginDetails(LoginBean loginBean)throws Exception;

}
