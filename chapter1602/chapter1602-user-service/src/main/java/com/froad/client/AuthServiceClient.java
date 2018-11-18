package com.froad.client;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;

import com.froad.client.hystrix.AuthServiceHystrix;
import com.froad.entity.JsonWebToken;

/**
 * @author ZHUZIHUI
 * @date 2018年11月7日
 */
@FeignClient(value = "uaa-service", fallback = AuthServiceHystrix.class)
public interface AuthServiceClient {

	@PostMapping("/oauth/token")
	JsonWebToken getToken(@RequestHeader("Authorization") String authorization, @RequestParam("grant_type") String type,
			@RequestParam("username") String username, @RequestParam("password") String password);

}
