package com.froad.controller;

import java.util.UUID;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author ZHUZIHUI
 * @date 2018年11月7日
 */
@RequestMapping("/foo")
@RestController
public class WebController {

	@RequestMapping(method = RequestMethod.GET)
	@PreAuthorize("hasAuthority('ROLE_ADMIN')")
	public String getFoo() {
		return "I'm foo, " + UUID.randomUUID().toString();
	}

}
