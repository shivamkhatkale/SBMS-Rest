package com.example.demp.customExceptionm;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.example.demo.exception.ProductNotFoundException;

@ControllerAdvice
public class CustomException {

	@ExceptionHandler(ProductNotFoundException.class)
	public ResponseEntity<String> exception(ProductNotFoundException pnfe) {

		return new ResponseEntity<>("Product Not Found", HttpStatus.BAD_REQUEST);

	}

}
