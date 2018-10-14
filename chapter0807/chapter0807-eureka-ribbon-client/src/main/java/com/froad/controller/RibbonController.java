package com.froad.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.froad.service.RibbonService;

/**
 * @author ZHUZIHUI
 * @date 2018年9月30日
 */
@RestController
public class RibbonController {

	@Autowired
	private RibbonService ribbonService;

	@GetMapping("/hi")
	public String hi(@RequestParam(required = false, defaultValue = "zhuzihui") String name) {
		return ribbonService.hi(name);
	}

}
