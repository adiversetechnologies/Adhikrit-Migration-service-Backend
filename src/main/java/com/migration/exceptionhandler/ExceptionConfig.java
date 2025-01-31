package com.migration.exceptionhandler;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import lombok.extern.slf4j.Slf4j;

@RestControllerAdvice
@Slf4j
public class ExceptionConfig {

	@ExceptionHandler(IllegalArgumentException.class)
	public ResponseEntity<Object> handelingIllegalArgumentException(IllegalArgumentException e) {
		return new ResponseEntity<Object>(e.getMessage(), HttpStatus.BAD_REQUEST);
	}

	@ExceptionHandler(ResponseExceptionObject.class)
	public ResponseEntity<Object> responseExceptionObject(ResponseExceptionObject e) {
		return new ResponseEntity<Object>(e.getError(), e.getStatus());
	}
}
