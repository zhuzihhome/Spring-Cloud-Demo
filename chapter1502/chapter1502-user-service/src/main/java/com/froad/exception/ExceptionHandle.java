package com.froad.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * @author ZHUZIHUI
 * @date 2018年11月7日
 */
@RestControllerAdvice
public class ExceptionHandle {

	@ExceptionHandler(UserLoginException.class)
	public ResponseEntity<?> handleException(Exception ex) {
		return new ResponseEntity(ex.getMessage(), HttpStatus.OK);
	}

}
