package com.froad.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

/**
 * @author ZHUZIHUI
 * @date 2018年10月19日
 */
@RestController
public class HiController {

	@Value("${server.port}")
	String port;

	@GetMapping("/hi")
	@HystrixCommand(fallbackMethod = "hiError")
	public String hi(@RequestParam String name) {
		return "Hi " + name + ", I am lucy and from port:" + port;
	}

	public String hiError(String name) {
		return "Hi " + name + ", sorry, error!";
	}
}
