package com.froad.client.config;

import static java.util.concurrent.TimeUnit.SECONDS;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import feign.Retryer;

/**
 * @author ZHUZIHUI
 * @date 2018年9月30日
 */
@Configuration
public class FeignConfig {

	@Bean
	public Retryer feignRetryer() {
		// 更改FeignClient的请求失败重试的策略，重试问隔为100ms，最大重试时间为1m，重试次数最多5次
		return new Retryer.Default(100, SECONDS.toMillis(1), 5);
	}
}
