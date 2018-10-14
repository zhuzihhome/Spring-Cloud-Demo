/**
 * @author ZHUZIHUI
 * @date 2018年9月28日
 */
package com.froad.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.froad.entity.User;
import com.froad.service.UserService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import springfox.documentation.annotations.ApiIgnore;

/**
 * @author ZHUZIHUI
 * @date 2018年9月28日
 */
@Api(description="用户管理")
@RequestMapping("/user")
@RestController
public class UserController {

	@Autowired
	UserService userService;

	@ApiOperation(value = "创建用户", notes = "创建用户")
	@RequestMapping(value = "", method = RequestMethod.POST)
	public User postUser(@RequestBody User user) {
		return userService.save(user);
	}

	@ApiOperation(value = "删除用户", notes = "根据url的id删除用户")
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public String deleteUser(@PathVariable Long id) {
		userService.delete(id);
		return "success";
	}

	@ApiOperation(value = "更新用户", notes = "根据url的id更新用户")
	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	public User putUser(@PathVariable Long id, @RequestBody User user) {
		user.setId(id);
		return userService.update(user);
	}

	@ApiOperation(value = "用户列表", notes = "用户列表")
	@RequestMapping(value = "", method = RequestMethod.GET)
	public List<User> getUsers() {
		return userService.findAll();
	}

	@ApiOperation(value = "获取用户信息", notes = "根据url的id获取用户信息")
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public User getUser(@PathVariable Long id) {
		return userService.findById(id);
	}

	@ApiIgnore
	@GetMapping("/{username}")
	public User getUser(@PathVariable("username") String username) {
		return userService.findByUsername(username);
	}

}
