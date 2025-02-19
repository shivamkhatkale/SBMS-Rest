package com.app.raghu.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class MyCustomExceptionHandler {

	@ExceptionHandler(ProductNotFoundException.class)
	public ResponseEntity<MyErrorResponse> showErrorMsg(ProductNotFoundException pnfe) {

		return new ResponseEntity<MyErrorResponse>(
				new MyErrorResponse("11-11-2001", "EXCEPTION IN PROCESS", 500, pnfe.getMessage()),
				HttpStatus.INTERNAL_SERVER_ERROR);
	}

}
