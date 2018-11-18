package com.froad.util;

import java.util.List;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;

/**
 * @author ZHUZIHUI
 * @date 2018年11月13日
 */
public class UserUtil {

	private static final String AUTHORIZATION = "authorization";

	/**
	 * 获取当前请求的token
	 */
	public static String getCurrentToken() {
		return HttpUtil.getHeaders(HttpUtil.getHttpServletRequest()).get(AUTHORIZATION);
	}

	/**
	 * 获取当前请求Authentication
	 */
	public static Authentication getCurrentAuthentication() {
		return SecurityContextHolder.getContext().getAuthentication();
	}

	/**
	 * 获取当前请求的权限信息
	 */
	public static List<SimpleGrantedAuthority> getCurrentAuthorities() {
		return (List<SimpleGrantedAuthority>) getCurrentAuthentication().getAuthorities();
	}

	/**
	 * 获取当前请求的用户ID
	 */
	public static String getCurrentPrinciple() {
		return (String) getCurrentAuthentication().getPrincipal();
	}

	/**
	 * 判断当前token用户是否为接口所需的参数username
	 */
	public static boolean isMyself(String username) {
		return username.equals(getCurrentPrinciple());
	}

	/**
	 * 判断是否有该角色
	 */
	public static boolean hasRole(String role) {
		if (!role.startsWith("ROLE_")) {
			role = "ROLE_" + role;
		}
		boolean hasRole = false;
		List<SimpleGrantedAuthority> list = getCurrentAuthorities();
		for (SimpleGrantedAuthority s : list) {
			if (role.equals(s.getAuthority())) {
				hasRole = true;
				break;
			}
		}
		return hasRole;
	}
}
