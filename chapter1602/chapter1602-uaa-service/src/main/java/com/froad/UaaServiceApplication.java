package com.froad;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @author ZHUZIHUI
 * @date 2018年11月17日
 */
@EnableEurekaClient
@SpringBootApplication
public class UaaServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(UaaServiceApplication.class, args);
	}

}
