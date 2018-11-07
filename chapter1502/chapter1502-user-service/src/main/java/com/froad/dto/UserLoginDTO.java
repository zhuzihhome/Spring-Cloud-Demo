package com.froad.dto;

import com.froad.entity.JsonWebToken;
import com.froad.entity.User;

/**
 * @author ZHUZIHUI
 * @date 2018年11月7日
 */
public class UserLoginDTO {

	private JsonWebToken jwt;

	private User user;

	public UserLoginDTO() {
		super();
	}

	public UserLoginDTO(JsonWebToken jwt, User user) {
		super();
		this.jwt = jwt;
		this.user = user;
	}

	public JsonWebToken getJwt() {
		return jwt;
	}

	public void setJwt(JsonWebToken jwt) {
		this.jwt = jwt;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

}
