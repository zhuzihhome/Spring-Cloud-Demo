/**
 * @author ZHUZIHUI
 * @date 2018年9月27日
 */
package com.froad;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author ZHUZIHUI
 * @date 2018年9月27日
 */
@SpringBootApplication
@RestController
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	@GetMapping("/hi")
	public String hi() {
		return "hi,I'm spring boot";
	}
}
