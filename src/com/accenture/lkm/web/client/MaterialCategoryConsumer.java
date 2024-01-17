package com.accenture.lkm.web.client;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.accenture.lkm.business.bean.MaterialCategoryBean;


@Service
public class MaterialCategoryConsumer {
	
	@Value("${MaterialServiceConsumer.serviceURL}")
	private String serviceURL;
	@Value("${MaterialCategoryConsumer.apiURL}")
	private String apiURL;
	@Value("${MaterialCategoryConsumer.apiURLForById}")
	private String apiURLForById;
	private List<MaterialCategoryBean> materialCategoryBeanList;
	private RestTemplate restTemplate;
	private Map<String,String> categoryMap;
	
	public MaterialCategoryConsumer() {
		restTemplate=new RestTemplate();
		
	}
	public List<MaterialCategoryBean> getMaterialCategoryBeanList() {
		hitGetCategories();
		return materialCategoryBeanList;
	}
	public Map<String, String> getCategoryMap() {
		hitGetCategories();
		categoryMap=new HashMap<String, String>();
		for(MaterialCategoryBean bean:materialCategoryBeanList) {
		categoryMap.put( bean.getCategoryId(),bean.getCategoryName());
		}
		return categoryMap;
	}
	
	private void hitGetCategories() {
		ResponseEntity<MaterialCategoryBean[]> responseEntity = restTemplate.getForEntity(serviceURL + apiURL, MaterialCategoryBean[].class); 
		materialCategoryBeanList=Arrays.asList(responseEntity.getBody());
		
	}
	public List<MaterialCategoryBean>hitGetCategoriesById(String id){
		ResponseEntity<MaterialCategoryBean[]> responseEntity = restTemplate.getForEntity(serviceURL + apiURL+id, MaterialCategoryBean[].class); 
		materialCategoryBeanList=Arrays.asList((responseEntity.getBody()));
		return materialCategoryBeanList;
		
	}

}
