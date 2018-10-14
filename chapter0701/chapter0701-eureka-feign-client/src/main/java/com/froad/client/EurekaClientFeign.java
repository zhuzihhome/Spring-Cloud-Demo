package com.froad.client;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.froad.client.config.FeignConfig;

/**
 * @author ZHUZIHUI
 * @date 2018年9月30日
 */
@FeignClient(value = "eureka-client", configuration = FeignConfig.class)
public interface EurekaClientFeign {

	@GetMapping("/hi")
	String sayHiFromClientEureka(@RequestParam(value = "name") String name);

}
