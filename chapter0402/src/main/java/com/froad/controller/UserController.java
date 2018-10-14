/**
 * @author ZHUZIHUI
 * @date 2018年9月27日
 */
package com.froad.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.froad.vo.User;

/**
 * @author ZHUZIHUI
 * @date 2018年9月27日
 */
@RestController
@EnableConfigurationProperties({User.class})
public class UserController {

	@Autowired
	User user;
	
	@GetMapping("/user")
	public String user() {
		return user.toString();
	}

}
