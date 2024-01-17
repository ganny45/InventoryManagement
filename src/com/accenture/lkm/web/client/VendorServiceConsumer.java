package com.accenture.lkm.web.client;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.accenture.lkm.business.bean.VendorBean;

@Service
public class VendorServiceConsumer {
	
	@Value("${VendorServiceConsumer.serviceURL}")
	private String serviceURL;
	@Value("${VendorServiceConsumer.apiURL}")
	private String apiURL;
	private List<VendorBean> vendorBeanList;
	private RestTemplate restTemplate;
	
	public VendorServiceConsumer() {
		restTemplate=new RestTemplate();
	}

	public List<VendorBean> getVendorBeanList() {
		hitGetVendorDetails();
		return vendorBeanList;
	}
	
	private void hitGetVendorDetails() {
		ResponseEntity<VendorBean[]> responseEntity = restTemplate.getForEntity(serviceURL + apiURL, VendorBean[].class); 
		vendorBeanList=Arrays.asList((responseEntity.getBody()));
		
	}
	
	

}
