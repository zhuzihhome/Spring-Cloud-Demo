package com.froad;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.turbine.EnableTurbine;

/**
 * @author ZHUZIHUI
 * @date 2018年11月10日
 */
@EnableTurbine
@EnableEurekaClient
@SpringBootApplication
public class MonitorServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(MonitorServiceApplication.class, args);
	}

}
