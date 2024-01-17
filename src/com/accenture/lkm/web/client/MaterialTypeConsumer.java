package com.accenture.lkm.web.client;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;


import com.accenture.lkm.business.bean.MaterialTypeBean;

@Service
public class MaterialTypeConsumer {
	@Value("${MaterialServiceConsumer.serviceURL}")
	private String serviceURL;
	@Value("${MaterialTypeConsumer.apiURL}")
	private String apiURL;
	@Value("${MaterialTypeConsumer.apiURLByCategoryId}")
	private String apiURLByCategoryId;
	private RestTemplate restTemplate;
	private List<MaterialTypeBean> materialTypeBeanList;
	private Map<String, String> categoryTypeMap;

	public MaterialTypeConsumer() {
		restTemplate=new RestTemplate();
	}

	public List<MaterialTypeBean> getMaterialTypeBeanList() {
		hitGetMaterialType();
		return materialTypeBeanList;
	}

	public Map<String, String> getCategoryTypeMap() {
		hitGetMaterialType();
		categoryTypeMap=new HashMap<String, String>();
		for(MaterialTypeBean bean:materialTypeBeanList)
		{
		categoryTypeMap.put(bean.getTypeId(),bean.getTypeName());
		}
		return categoryTypeMap;
	}

	private void hitGetMaterialType() {
		ResponseEntity<MaterialTypeBean[]> responseEntity = restTemplate.getForEntity(serviceURL + apiURL,
				MaterialTypeBean[].class);
		materialTypeBeanList = Arrays.asList((responseEntity.getBody()));
	}

	public List<MaterialTypeBean> hitGetTypesBasedOnCategoryId(String categoryId) {
		ResponseEntity<MaterialTypeBean[]> responseEntity = restTemplate
				.getForEntity(serviceURL + apiURLByCategoryId + categoryId, MaterialTypeBean[].class);
		materialTypeBeanList = Arrays.asList((responseEntity.getBody()));
		return materialTypeBeanList;
	}

}
