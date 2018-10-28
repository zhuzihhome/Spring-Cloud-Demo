package com.froad.controller;

import java.security.Principal;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author ZHUZIHUI
 * @date 2018年10月28日
 */
@RestController
public class HiController {

	Logger logger = LoggerFactory.getLogger(HiController.class);

	@Value("${server.port}")
	private String port;

	@GetMapping("/hi")
	public String home() {
		return "Hi, I am from port:" + port;
	}

	@PreAuthorize("hasAuthority('ROLE_ADMIN')")
	@GetMapping("/hello")
	public String hello() {
		return "hello!";
	}

	public OAuth2Authentication getPrinciple(OAuth2Authentication oAuth2Authentication, Principal principal,
			Authentication authentication) {

		logger.info(oAuth2Authentication.getUserAuthentication().getAuthorities().toString());
		logger.info(oAuth2Authentication.toString());
		logger.info("principal.toString()" + principal.toString());
		logger.info("principal.getName()" + principal.getName());
		logger.info("authentication:" + authentication.getAuthorities().toString());

		return oAuth2Authentication;
	}

}
