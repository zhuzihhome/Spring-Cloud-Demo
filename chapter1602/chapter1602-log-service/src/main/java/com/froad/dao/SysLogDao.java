package com.froad.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.froad.entity.SysLog;

/**
 * @author ZHUZIHUI
 * @date 2018年11月18日
 */
public interface SysLogDao extends JpaRepository<SysLog, Long> {

}
