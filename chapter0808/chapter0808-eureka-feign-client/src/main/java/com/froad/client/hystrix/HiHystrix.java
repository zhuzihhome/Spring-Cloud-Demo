package com.froad.client.hystrix;

import org.springframework.stereotype.Component;

import com.froad.client.EurekaClientFeign;

/**
 * @author ZHUZIHUI
 * @date 2018年10月11日
 */
@Component
public class HiHystrix implements EurekaClientFeign {

	@Override
	public String sayHiFromClientEureka(String name) {
		return "hi," + name + ",sorry,error!";
	}

}
