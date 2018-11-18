package com.froad.entity;

import java.util.Date;

/**
 * @author ZHUZIHUI
 * @date 2018年11月11日
 */
public class SysLog {

	private String id;
	/** 用户名 */
	private String username;
	/** 用户操作 */
	private String operation;
	/** 请求方法 */
	private String method;
	/** 请求参数 */
	private String params;
	/** IP地址 */
	private String ip;
	/** 创建时间 */
	private Date createDate;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getOperation() {
		return operation;
	}

	public void setOperation(String operation) {
		this.operation = operation;
	}

	public String getMethod() {
		return method;
	}

	public void setMethod(String method) {
		this.method = method;
	}

	public String getParams() {
		return params;
	}

	public void setParams(String params) {
		this.params = params;
	}

	public String getIp() {
		return ip;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

}
