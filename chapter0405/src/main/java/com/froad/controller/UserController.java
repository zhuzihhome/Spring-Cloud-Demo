/**
 * @author ZHUZIHUI
 * @date 2018年9月28日
 */
package com.froad.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.froad.entity.User;
import com.froad.service.UserService;

/**
 * @author ZHUZIHUI
 * @date 2018年9月28日
 */
@RequestMapping("/user")
@RestController
public class UserController {

	@Autowired
	UserService userService;
	
	@GetMapping("/{username}")
	public User getUser(@PathVariable("username") String username) {
		return userService.findByUsername(username);
	}
}
