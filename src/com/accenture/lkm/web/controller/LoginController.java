package com.accenture.lkm.web.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.accenture.lkm.business.bean.LoginBean;
import com.accenture.lkm.services.LoginService;

@Controller
public class LoginController {
	
	@Autowired
	private LoginService loginService;
	
	
	@RequestMapping(value = "/login")
	public ModelAndView login() {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("Login");
		modelAndView.addObject("loginObj",new LoginBean());
		return modelAndView;
	}
	
	@RequestMapping(value = "/save", method = RequestMethod.POST)
	 public ModelAndView findLoginDetails( @Valid @ModelAttribute("loginObj") LoginBean loginBean, 
			 BindingResult bindingResult ){
		
		 ModelAndView modelAndView = new ModelAndView();
		 LoginBean bean=null;
			if(bindingResult.hasErrors())
			{
			   modelAndView.setViewName("Login");
			   
			}else { 
				String message=" ";
				try {
				bean= loginService.findLoginDetails(loginBean);
				modelAndView.setViewName("Welcome");
				}catch(Exception e) {
					message="Either Username or Password not matching!";
					modelAndView.setViewName("Login");
					modelAndView.addObject("message",message);
				}
			
	 }return modelAndView;
}
	
}	


