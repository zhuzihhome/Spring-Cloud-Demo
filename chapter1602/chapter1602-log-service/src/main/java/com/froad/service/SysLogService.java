package com.froad.service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.froad.dao.SysLogDao;
import com.froad.entity.SysLog;

/**
 * @author ZHUZIHUI
 * @date 2018年11月18日
 */
@Service
public class SysLogService {

	@Autowired
	private SysLogDao sysLogDao;

	public void saveLog(SysLog sysLog) {
		sysLogDao.save(sysLog);
	}

}
