package com.froad.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

/**
 * @author ZHUZIHUI
 * @date 2018年9月30日
 */
@Service
public class RibbonService {

	@Autowired
	RestTemplate restTemplate;
	
	public String hi(String name) {
		return restTemplate.getForObject("http://eureka-client/hi?name="+name, String.class);
	}
}
