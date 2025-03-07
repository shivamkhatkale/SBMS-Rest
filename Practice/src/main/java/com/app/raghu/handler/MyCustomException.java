package com.app.raghu.handler;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.app.raghu.exception.ProductNotFoundException;

@ControllerAdvice
public class MyCustomException {

	@ExceptionHandler
	public ResponseEntity<String> myCustomException(ProductNotFoundException pnfe) {

		return new ResponseEntity<>("ProductEntity Not Found ", HttpStatus.BAD_GATEWAY);

	}

}
