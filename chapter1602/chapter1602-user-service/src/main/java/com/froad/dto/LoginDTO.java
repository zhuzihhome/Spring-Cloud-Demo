package com.froad.dto;

import com.froad.entity.User;

/**
 * @author ZHUZIHUI
 * @date 2018年11月7日
 */
public class LoginDTO {

	private User user;
	private String token;

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

}
