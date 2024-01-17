package com.accenture.lkm.web.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.accenture.lkm.business.bean.DateWisePurchaseReportBean;
import com.accenture.lkm.business.bean.PurchaseBean;
import com.accenture.lkm.business.bean.VendorBean;
import com.accenture.lkm.services.ReportsService;
import com.accenture.lkm.web.client.MaterialCategoryConsumer;
import com.accenture.lkm.web.client.MaterialTypeConsumer;
import com.accenture.lkm.web.client.UnitServiceConsumer;
import com.accenture.lkm.web.client.VendorServiceConsumer;

@Controller

public class ReportsController {

	@Autowired
	private ReportsService reportsService;
	@Autowired
	private MaterialCategoryConsumer materialCategoryConsumer;
	@Autowired
	private UnitServiceConsumer unitServiceConsumer;
	@Autowired
	private MaterialTypeConsumer materialTypeConsumer;
	@Autowired
	private VendorServiceConsumer vendorServiceConsumer;

	@RequestMapping(value = "/purchaseDateWise", method = RequestMethod.GET)
	public ModelAndView showDateWisePurchaseDetailPage() {

		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("purchaseReportDateWise");
		modelAndView.addObject("dateObj", new DateWisePurchaseReportBean());
		return modelAndView;
	}

	@RequestMapping(value = "/ReportDateWise", method = RequestMethod.POST)
	public ModelAndView getDateWisePurchaseDetails(
			@ModelAttribute("dateObj") DateWisePurchaseReportBean dateWisePurchaseReportBean) {
		ModelAndView modelAndView = new ModelAndView();
		String message = "";
		try {
			List<PurchaseBean> listBean = reportsService.getPurchaseRecordsByDate(
					dateWisePurchaseReportBean.getFromDate(), dateWisePurchaseReportBean.getToDate());

			Map<String, String> mapCategory = materialCategoryConsumer.getCategoryMap();
			Map<String, String> mapType = materialTypeConsumer.getCategoryTypeMap();
			Map<String, String> mapUnit = unitServiceConsumer.getUnitMap();

			for (PurchaseBean purchaseBean : listBean) {

				System.out.println("**" + purchaseBean.getMaterialCategoryId());
				System.out.println("*******" + mapCategory.get(purchaseBean.getMaterialCategoryId()));

				purchaseBean.setMaterialCategoryName(mapCategory.get(purchaseBean.getMaterialCategoryId()));
				System.out.println(mapCategory.get(purchaseBean.getMaterialCategoryId()));
				purchaseBean.setMaterialTypeName(mapType.get(purchaseBean.getMaterialTypeId()));
				System.out.println(mapType.get(purchaseBean.getMaterialTypeId()));
				purchaseBean.setUnitName(mapUnit.get(purchaseBean.getUnitId()));
				System.out.println(mapUnit.get(purchaseBean.getUnitId()));
				// purchaseBean.setVendorName(purchaseBean.getVendorName());
			}
			modelAndView.setViewName("purchaseReportDateWise");
			modelAndView.addObject("List", listBean);
		} catch (Exception e) {
			message = "No Records Found!";
			modelAndView.addObject("message", message);
			modelAndView.setViewName("purchaseReportDateWise");
		}
		return modelAndView;
	}

	@ModelAttribute(value = "listVendor")
	public List<VendorBean> generateVendorList() {
		List<VendorBean> listvendor = vendorServiceConsumer.getVendorBeanList();
		return listvendor;

	}

	@RequestMapping(value = "/loadPurchaseReport")
	public ModelAndView showVendorWisePurchaseReportPage() {

		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("vendorPurchasedItemReport");
		modelAndView.addObject("beanObj", new VendorBean());
		return modelAndView;

	}

	@RequestMapping(value = "/FetchRecordsWithVendorName", method = RequestMethod.POST)
	public ModelAndView getVendorWisePurchaseDetail(@ModelAttribute("beanObj") VendorBean vendorBean) {

		ModelAndView modelAndView = new ModelAndView();
		String message = "";
		try {
			List<PurchaseBean> listbean = reportsService.getPurchaseRecordsByVendorName(vendorBean.getVendorName());
			Map<String, String> mapCategory = materialCategoryConsumer.getCategoryMap();
			Map<String, String> mapType = materialTypeConsumer.getCategoryTypeMap();
			Map<String, String> mapUnit = unitServiceConsumer.getUnitMap();

			for (PurchaseBean purchaseBean : listbean) {
				purchaseBean.setMaterialCategoryName(mapCategory.get(purchaseBean.getMaterialCategoryId()));
				purchaseBean.setMaterialTypeName(mapType.get(purchaseBean.getMaterialTypeId()));
				purchaseBean.setUnitName(mapUnit.get(purchaseBean.getUnitId()));
			}
			modelAndView.setViewName("vendorPurchasedItemReport");
			modelAndView.addObject("listALL", listbean);
		} catch (Exception e) {
			message = "No Records Found!";
			modelAndView.addObject("message", message);
			modelAndView.setViewName("vendorPurchasedItemReport");
		}

		return modelAndView;

	}

}
