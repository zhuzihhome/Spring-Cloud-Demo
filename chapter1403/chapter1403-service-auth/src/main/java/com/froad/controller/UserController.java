package com.froad.controller;

import java.security.Principal;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author ZHUZIHUI
 * @date 2018年10月27日
 */
@RequestMapping("/users")
@RestController
public class UserController {

	@GetMapping("/current")
	public Principal getUser(Principal principal) {
		return principal;
	}

}
