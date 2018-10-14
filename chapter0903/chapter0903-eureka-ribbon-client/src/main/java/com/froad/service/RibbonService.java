package com.froad.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

/**
 * @author ZHUZIHUI
 * @date 2018年9月30日
 */
@Service
public class RibbonService {

	@Autowired
	RestTemplate restTemplate;

	@HystrixCommand(fallbackMethod = "hiError")
	public String hi(String name) {
		return restTemplate.getForObject("http://eureka-client/hi?name=" + name, String.class);
	}

	public String hiError(String name) {
		return "Hi, " + name + ", sorry, error!";
	}
}
