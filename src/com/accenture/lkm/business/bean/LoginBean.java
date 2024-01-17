package com.accenture.lkm.business.bean;

import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotBlank;

public class LoginBean {
	
	@NotBlank
	private String username;
	
	@NotBlank
	@Size(max=12,min=8)
	private String password;

	
	public LoginBean() {
	}


	public String getUsername() {
		return username;
	}


	public void setUsername(String username) {
		this.username = username;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	@Override
	public String toString() {
		return "LoginBean [username=" + username + ", password=" + password + "]";
	}


}
