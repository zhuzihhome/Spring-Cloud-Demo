package com.froad.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.froad.dto.UserLoginDTO;
import com.froad.entity.User;
import com.froad.service.security.UserDetailsServiceImpl;

/**
 * @author ZHUZIHUI
 * @date 2018年10月29日
 */
@RequestMapping("/user")
@RestController
public class UserController {

	@Autowired
	private UserDetailsServiceImpl userDetailsService;

	@PostMapping("/register")
	public User register(@RequestBody User user) {
		// 参数判断，省略
		return userDetailsService.insertUser(user);
	}

	@PostMapping("/login")
	public UserLoginDTO login(@RequestParam("username") String username, @RequestParam("password") String password) {
		// 参数判断，省略
		return userDetailsService.login(username, password);
	}

}
