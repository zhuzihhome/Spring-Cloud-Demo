package com.froad;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;
import org.springframework.cloud.netflix.turbine.EnableTurbine;

import de.codecentric.boot.admin.config.EnableAdminServer;

/**
 * @author ZHUZIHUI
 * @date 2018年11月18日
 */
@EnableTurbine
@EnableHystrixDashboard
@EnableHystrix
@EnableAdminServer
@EnableEurekaClient
@SpringBootApplication
public class AdminServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(AdminServiceApplication.class, args);
	}

}
