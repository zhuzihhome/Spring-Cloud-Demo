package com.froad.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author ZHUZIHUI
 * @date 2018年9月29日
 */
@RestController
public class HiController {

	@Value("${server.port}")
	private String port;

	@GetMapping("/hi")
	public String index(@RequestParam String name) {
		return "Hi " + name + ", I am from port: " + port;
	}
}
