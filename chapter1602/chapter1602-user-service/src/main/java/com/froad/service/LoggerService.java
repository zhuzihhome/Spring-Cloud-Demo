package com.froad.service;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSON;
import com.froad.config.RabbitConfig;
import com.froad.entity.SysLog;

/**
 * @author ZHUZIHUI
 * @date 2018年11月13日
 */
@Service
public class LoggerService {

	@Autowired
	private AmqpTemplate rabbitTemplate;

	public void log(SysLog sysLog) {
		rabbitTemplate.convertAndSend(RabbitConfig.QUEUE_NAME, JSON.toJSONString(sysLog));
	}

}
