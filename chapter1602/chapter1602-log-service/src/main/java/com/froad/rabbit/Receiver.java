package com.froad.rabbit;

import java.util.concurrent.CountDownLatch;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.alibaba.fastjson.JSON;
import com.froad.entity.SysLog;
import com.froad.service.SysLogService;

/**
 * @author ZHUZIHUI
 * @date 2018年11月18日
 */
@Component
public class Receiver {

	private CountDownLatch latch = new CountDownLatch(1);

	@Autowired
	private SysLogService sysLogService;

	public void receiveMessage(String message) {
		System.out.println("Received <" + message + ">");
		SysLog sysLog = JSON.parseObject(message, SysLog.class);
		sysLogService.saveLog(sysLog);
		latch.countDown();
	}

}
