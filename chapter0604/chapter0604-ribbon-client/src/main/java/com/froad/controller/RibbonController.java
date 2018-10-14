package com.froad.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author ZHUZIHUI
 * @date 2018年9月30日
 */
@RestController
public class RibbonController {

	@Autowired
	private LoadBalancerClient loadBalancerClient;

	@GetMapping("/testRibbon")
	public String testRibbon() {
		ServiceInstance instance = loadBalancerClient.choose("stores");
		return instance.getHost() + ":" + instance.getPort();
	}
}
