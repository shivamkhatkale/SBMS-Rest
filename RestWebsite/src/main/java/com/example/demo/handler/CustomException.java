package com.example.demo.handler;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.example.demo.exception.ProductNotFoundException;

@RestControllerAdvice
public class CustomException {

	@ExceptionHandler(ProductNotFoundException.class)
	public ResponseEntity<String> takeException(ProductNotFoundException pnfe) {
		return new ResponseEntity<>("ProductEntity Not Found ", HttpStatus.BAD_REQUEST);
	}

}
