package com.froad.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.froad.dto.RespDTO;

/**
 * @author ZHUZIHUI
 * @date 2018年11月7日
 */
@RestControllerAdvice
public class CommonExceptionHandler {

	@ExceptionHandler(CommonException.class)
	public ResponseEntity<?> handleException(Exception ex) {
		RespDTO resp = new RespDTO();
		CommonException commonException = (CommonException) ex;
		resp.code = commonException.getCode();
		resp.msg = ex.getMessage();
		
		return new ResponseEntity(resp, HttpStatus.OK);
	}

}
