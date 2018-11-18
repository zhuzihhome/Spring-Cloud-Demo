package com.froad.client.hystrix;

import org.springframework.stereotype.Component;

import com.froad.client.UserServiceClient;
import com.froad.dto.RespDTO;
import com.froad.entity.User;

/**
 * @author ZHUZIHUI
 * @date 2018年11月7日
 */
@Component
public class UserServiceHystrix implements UserServiceClient {

	@Override
	public RespDTO<User> getUser(String authorization, String username) {
		return null;
	}

}
