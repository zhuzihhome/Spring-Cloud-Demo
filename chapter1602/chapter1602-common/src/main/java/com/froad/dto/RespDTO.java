package com.froad.dto;

import java.io.Serializable;

/**
 * @author ZHUZIHUI
 * @date 2018年11月11日
 */
public class RespDTO<T> implements Serializable {

	public int code = 0;
	public String msg = "ok";
	public T data;

	public static RespDTO onSuc(Object data) {
		RespDTO resp = new RespDTO();
		resp.data = data;
		return resp;
	}

	@Override
	public String toString() {
		return "RespDTO{" +
                "code=" + code +
                ", msg='" + msg + '\'' +
                ", data=" + data +
                '}';
	}

}
