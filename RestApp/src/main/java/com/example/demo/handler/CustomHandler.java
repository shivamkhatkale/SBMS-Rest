package com.example.demo.handler;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.example.demo.entity.ErrorE;
import com.example.demo.exception.ProductNotFoundException;

@RestControllerAdvice
public class CustomHandler {

	@ExceptionHandler(ProductNotFoundException.class)
	public ResponseEntity<ErrorE> customException() {

		return new ResponseEntity<>(new ErrorE("System Error", "Product Not Found "), HttpStatus.BAD_REQUEST);

	}

}
