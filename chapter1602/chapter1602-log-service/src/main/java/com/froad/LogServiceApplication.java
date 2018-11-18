package com.froad;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @author ZHUZIHUI
 * @date 2018年11月18日
 */
@EnableEurekaClient
@SpringBootApplication
public class LogServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(LogServiceApplication.class, args);
	}

}
