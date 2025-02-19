package com.example.demo.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import com.example.demo.entity.Employee;

@RestControllerAdvice
public class CustomException {

	@ExceptionHandler(EmployeeNotFoundException.class)
	public ResponseEntity<Employee> getmessage(EmployeeNotFoundException enfe) {

		return new ResponseEntity<>(new Employee(101, "Shivam", 93939, enfe.getMessage()),
				HttpStatus.METHOD_NOT_ALLOWED);
	}

}
