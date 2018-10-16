package com.froad.filter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.netflix.zuul.filters.support.FilterConstants;
import org.springframework.cloud.sleuth.Tracer;
import org.springframework.stereotype.Component;

import com.netflix.zuul.ZuulFilter;

/**
 * @author ZHUZIHUI
 * @date 2018年10月15日
 */
@Component
public class LoggerFilter extends ZuulFilter {

	@Autowired
	Tracer tracer;

	@Override
	public Object run() {
		tracer.addTag("operator", "zhuzihui");
		System.out.println("***tranceId:" + tracer.getCurrentSpan().traceIdString());
		return null;
	}

	@Override
	public boolean shouldFilter() {
		return true;
	}

	@Override
	public int filterOrder() {
		return 900;
	}

	@Override
	public String filterType() {
		return FilterConstants.POST_TYPE;
	}

}
