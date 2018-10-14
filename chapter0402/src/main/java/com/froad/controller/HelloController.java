/**
 * @author ZHUZIHUI
 * @date 2018年9月27日
 */
package com.froad.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author ZHUZIHUI
 * @date 2018年9月27日
 */
@RestController
public class HelloController {

	@RequestMapping("/index")
	public String index() {
		return "Hello Spring Boot!";
	}
}
