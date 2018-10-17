package com.luv2code.springdemo.rest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class StudentRestExceptionHandler {
	
	@ExceptionHandler
	public ResponseEntity<StudentErrorResponse> handleException(StudentNotFoundException exc) {
		StudentErrorResponse errResp = new StudentErrorResponse();
		
		errResp.setStatus(HttpStatus.NOT_FOUND.value());
		errResp.setMessage(exc.getMessage());
		errResp.setTimestamp(System.currentTimeMillis());
		
		return new ResponseEntity<>(errResp, HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler
	public ResponseEntity<StudentErrorResponse> handleException(Exception exc) {
		StudentErrorResponse errResp = new StudentErrorResponse();
		
		errResp.setStatus(HttpStatus.BAD_REQUEST.value());
		errResp.setMessage(exc.getMessage());
		errResp.setTimestamp(System.currentTimeMillis());
		
		return new ResponseEntity<>(errResp, HttpStatus.BAD_REQUEST);
	}

}
