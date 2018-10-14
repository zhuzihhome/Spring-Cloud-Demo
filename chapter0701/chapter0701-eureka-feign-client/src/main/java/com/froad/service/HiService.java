package com.froad.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.froad.client.EurekaClientFeign;

/**
 * @author ZHUZIHUI
 * @date 2018年9月30日
 */
@Service
public class HiService {

	@Autowired
	private EurekaClientFeign eurekaClientFeign;

	public String sayHi(String name) {
		return eurekaClientFeign.sayHiFromClientEureka(name);
	}

}
