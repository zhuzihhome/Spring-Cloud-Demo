package com.froad.aop;

import java.lang.reflect.Method;
import java.util.Date;

import org.apache.commons.lang.StringUtils;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.alibaba.fastjson.JSON;
import com.froad.annotation.SysLogger;
import com.froad.entity.SysLog;
import com.froad.service.LoggerService;
import com.froad.util.HttpUtil;
import com.froad.util.UserUtil;

/**
 * @author ZHUZIHUI
 * @date 2018年11月13日
 */
@Aspect
@Component
public class SysLoggerAspect {

	@Autowired
	private LoggerService loggerService;

	@Pointcut("@annotation(com.froad.annotation.SysLogger)")
	public void loggerPointCut() {

	}

	@Before("loggerPointCut()")
	public void saveSysLog(JoinPoint joinPoint) {
		MethodSignature signature = (MethodSignature) joinPoint.getSignature();
		Method method = signature.getMethod();

		SysLog sysLog = new SysLog();
		SysLogger sysLogger = method.getAnnotation(SysLogger.class);
		if (null != sysLogger) {
			// 设置操作，及注解上的描述
			sysLog.setOperation(sysLogger.value());
		}
		// 设置请求方法名
		String packageName = joinPoint.getTarget().getClass().getPackage().getName();
		String className = joinPoint.getTarget().getClass().getName();
		String methodName = signature.getName();
		sysLog.setMethod(packageName + "." + className + "." + className + "." + methodName);
		// 设置请求的参数
		Object[] args = joinPoint.getArgs();
		String params = "";
		for (Object obj : args) {
			params += JSON.toJSONString(obj);
		}
		if (StringUtils.isNotEmpty(params)) {
			sysLog.setParams(params);
		}
		// 设置IP地址
		sysLog.setIp(HttpUtil.getIpAddress());
		// 设置用户名
		String username = UserUtil.getCurrentPrinciple();
		if (StringUtils.isNotEmpty(username)) {
			sysLog.setUsername(username);
		}
		// 设置日期
		sysLog.setCreateDate(new Date());
		// 保存系统日志
		loggerService.log(sysLog);
	}

}
