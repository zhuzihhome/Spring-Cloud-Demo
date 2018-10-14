package com.froad.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.froad.service.HiService;

/**
 * @author ZHUZIHUI
 * @date 2018年9月30日
 */
@RestController
public class HiController {

	@Autowired
	private HiService hiService;

	@GetMapping("/hi")
	public String sayHi(@RequestParam(required = false, defaultValue = "zhuzihui") String name) {
		return hiService.sayHi(name);
	}

}
