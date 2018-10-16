package com.froad.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author ZHUZIHUI
 * @date 2018年10月15日
 */
@RequestMapping("/user")
@RestController
public class UserController {

	@GetMapping("/hi")
	public String hi() {
		return "Hi! I'm zhuzihui.";
	}

}
