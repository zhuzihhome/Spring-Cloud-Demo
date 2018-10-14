/**
 * @author ZHUZIHUI
 * @date 2018年9月27日
 */
package com.froad.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author ZHUZIHUI
 * @date 2018年9月27日
 */
@RestController
public class MyController {

	@Value("${user.name}")
	private String name;
	@Value("${user.age}")
	private int age;

	@RequestMapping("/my")
	private String my() {
		return name + ":" + age;
	}

}
