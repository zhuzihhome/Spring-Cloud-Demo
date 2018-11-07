package com.froad.hystrix;

import org.springframework.stereotype.Component;

import com.froad.client.AuthServiceClient;
import com.froad.entity.JsonWebToken;

/**
 * @author ZHUZIHUI
 * @date 2018年11月7日
 */
@Component
public class AuthServiceHystrix implements AuthServiceClient {

	@Override
	public JsonWebToken getToken(String authorization, String type, String username, String password) {
		return null;
	}

}
