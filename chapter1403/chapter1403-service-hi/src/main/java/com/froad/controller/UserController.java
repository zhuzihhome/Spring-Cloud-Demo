package com.froad.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.froad.entity.User;
import com.froad.service.UserService;

/**
 * @author ZHUZIHUI
 * @date 2018年10月28日
 */
@RequestMapping("/user")
@RestController
public class UserController {

	@Autowired
	private UserService userService;

	@PostMapping("/registry")
	public User createUser(@RequestBody User user) {
		return userService.create(user);
	}

}
