package com.froad.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.froad.annotation.SysLogger;
import com.froad.dto.RespDTO;
import com.froad.entity.User;
import com.froad.service.UserService;
import com.froad.util.BCryptEncoderUtil;

import io.swagger.annotations.ApiOperation;

/**
 * @author ZHUZIHUI
 * @date 2018年10月29日
 */
@RequestMapping("/user")
@RestController
public class UserController {

	@Autowired
	private UserService userService;

	@ApiOperation(value = "用户注册", notes = "username and password is required")
	@PostMapping("/register")
	@SysLogger("register")
	public User register(@RequestBody User user) {
		// 参数判断，省略
		// 判断用户名是否存在，省略
		user.setPassword(BCryptEncoderUtil.BCryptPassword(user.getPassword()));
		return userService.createUser(user);
	}

	@ApiOperation(value = "用户登录", notes = "username and password is required")
	@PostMapping("/login")
	@SysLogger("login")
	public RespDTO login(@RequestParam("username") String username, @RequestParam("password") String password) {
		// 参数判断，省略
		return userService.login(username, password);
	}

	@ApiOperation(value = "根据用户名获取用户信息", notes = "根据用户名获取用户信息")
	@PostMapping("/{username}")
	@PreAuthorize("hasRole('USER')")
	@SysLogger("getUserInfo")
	public RespDTO getUserInfo(@PathVariable("username") String username) {
		UserDetails user = userService.getUserInfo(username);
		return RespDTO.onSuc(user);
	}
	
}
