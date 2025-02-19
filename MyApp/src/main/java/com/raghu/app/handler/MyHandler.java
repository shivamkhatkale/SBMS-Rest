package com.raghu.app.handler;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.raghu.app.exception.ProductNotFoundException;

@ControllerAdvice
public class MyHandler {

	@ExceptionHandler(ProductNotFoundException.class)
	public ResponseEntity<String> productNotFound(ProductNotFoundException pnfe) {

		return new ResponseEntity<>("Product Not Found ", HttpStatus.BAD_REQUEST);

	}

}
