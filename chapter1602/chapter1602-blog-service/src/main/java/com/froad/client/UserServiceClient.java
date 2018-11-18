package com.froad.client;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;

import com.froad.client.hystrix.UserServiceHystrix;
import com.froad.dto.RespDTO;
import com.froad.entity.User;

/**
 * @author ZHUZIHUI
 * @date 2018年11月7日
 */
@FeignClient(value = "user-service", fallback = UserServiceHystrix.class)
public interface UserServiceClient {

	@PostMapping("/user/{username}")
	RespDTO<User> getUser(@RequestHeader("Authorization") String authorization,
			@RequestParam("username") String username);

}
