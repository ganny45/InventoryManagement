package com.accenture.lkm.web.client;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.accenture.lkm.business.bean.UnitBean;

@Service
public class UnitServiceConsumer {
	@Value("${MaterialServiceConsumer.serviceURL}")
	private String serviceURL;
	@Value("${UnitServiceConsumer.apiURL}")
	private String apiURL;
	@Value("${UnitServiceConsumer.apiURLByCategoryId}")
	private String apiURLByCategoryId;
	private RestTemplate restTemplate;
	private List<UnitBean> unitBeanList;
	private Map<String, String> unitMap;

	public UnitServiceConsumer() {
		restTemplate = new RestTemplate();
	}

	public List<UnitBean> getUnitBeanList() {
		hitGetUnitDetails();
		return unitBeanList;
	}

	public Map<String, String> getUnitMap() {
		hitGetUnitDetails();
		unitMap = new HashMap<String, String>();
		for (UnitBean unitBean : unitBeanList) {
			unitMap.put(unitBean.getUnitId(), unitBean.getUnitName());
		}
		return unitMap;
	}

	private void hitGetUnitDetails() {
		ResponseEntity<UnitBean[]> responseEntity = restTemplate.getForEntity(serviceURL + apiURL, UnitBean[].class);
		unitBeanList = Arrays.asList((responseEntity.getBody()));
	}

	public List<UnitBean> hitGetUnitsByCategoryId(String categoryId) {
		ResponseEntity<UnitBean[]> responseEntity = restTemplate
				.getForEntity(serviceURL + apiURLByCategoryId + categoryId, UnitBean[].class);
		unitBeanList = Arrays.asList((responseEntity.getBody()));
		return unitBeanList;
	}

}
