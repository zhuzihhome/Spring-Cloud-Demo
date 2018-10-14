/**
 * @author ZHUZIHUI
 * @date 2018年9月27日
 */
package com.froad.controller;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;

import java.net.URL;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.embedded.LocalServerPort;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author ZHUZIHUI
 * @date 2018年9月27日
 */
@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class HelloControllerTest {

	@LocalServerPort
	private int port;

	private URL url;

	@Autowired
	private TestRestTemplate template;

	@Before
	public void setUp() throws Exception {
		this.url = new URL("http://localhost:" + port + "/index");
	}

	@Test
	public void indexTest() throws Exception {
		ResponseEntity<String> response = template.getForEntity(url.toString(), String.class);
		assertThat(response.getBody(), equalTo("Hello Spring Boot!"));
	}

}
