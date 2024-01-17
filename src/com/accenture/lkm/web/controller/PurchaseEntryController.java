package com.accenture.lkm.web.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.accenture.lkm.business.bean.MaterialCategoryBean;
import com.accenture.lkm.business.bean.MaterialTypeBean;
import com.accenture.lkm.business.bean.PurchaseBean;
import com.accenture.lkm.business.bean.UnitBean;
import com.accenture.lkm.business.bean.VendorBean;
import com.accenture.lkm.services.PurchaseService;
import com.accenture.lkm.web.client.MaterialCategoryConsumer;
import com.accenture.lkm.web.client.MaterialTypeConsumer;
import com.accenture.lkm.web.client.UnitServiceConsumer;
import com.accenture.lkm.web.client.VendorServiceConsumer;

@Controller
@SessionAttributes({"materialType","unitType"})
public class PurchaseEntryController {

	@Autowired
	private PurchaseService purchaseService;
	@Autowired
	private VendorServiceConsumer  vendorServiceConsumer;
	@Autowired
	private MaterialCategoryConsumer materialCategoryConsumer;
	@Autowired
	private UnitServiceConsumer unitServiceConsumer;
	@Autowired
	private MaterialTypeConsumer materialTypeConsumer;
	
	@RequestMapping(value = "/loginPurchase")
	public ModelAndView purchaseEntry() {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("purchaseEntry");
		modelAndView.addObject("purchaseEntryObj",new PurchaseBean());
		return modelAndView;
		
	}
	
	@ModelAttribute(value="vendorList")
	public List<VendorBean> generateVendorList() {
		List<VendorBean> listvendor=vendorServiceConsumer.getVendorBeanList();
		return listvendor;
		
	}
	@ModelAttribute(value="materialCategory")
    public List<MaterialCategoryBean> generateCategoryList() {
		List<MaterialCategoryBean> listMaterial= materialCategoryConsumer.getMaterialCategoryBeanList();
		return listMaterial;
	}

	@RequestMapping(value="/getUnitAndTypeList",method = RequestMethod.GET)
	public ModelAndView generateUnitAndTypeList(@ModelAttribute("purchaseEntryObj")PurchaseBean purchaseBean) {
		List<UnitBean> unitBeans=unitServiceConsumer.hitGetUnitsByCategoryId(purchaseBean.getMaterialCategoryId());
		List<MaterialTypeBean> materialTypeBeans=materialTypeConsumer.hitGetTypesBasedOnCategoryId(purchaseBean.getMaterialCategoryId());
		ModelAndView modelAndView=new ModelAndView();
		modelAndView.setViewName("purchaseEntry");
		modelAndView.addObject("materialType", materialTypeBeans);
		modelAndView.addObject("unitType", unitBeans);
		return modelAndView;
	}
	
	@RequestMapping(value = "/savedetails" ,method = RequestMethod.POST)
    public ModelAndView addPurchaseDetail( @Valid @ModelAttribute("purchaseEntryObj")PurchaseBean purchaseBean,BindingResult bindingResult) {
		ModelAndView modelAndView = new ModelAndView();
		if(bindingResult.hasErrors()) {
			modelAndView.setViewName("purchaseEntry");
		}
		else {
    	PurchaseBean bean=purchaseService.savePurchaseDetails(purchaseBean);
		modelAndView.setViewName("purchaseEntry");
		modelAndView.addObject("message","Registered success with id:"+bean.getPurchaseId());
		}
		return modelAndView;
    }
    
		
		
	}
