package com.example.demo.controller;

public class EmployeeNotFoundException extends RuntimeException{

	public EmployeeNotFoundException() {
		super();
	}

	public EmployeeNotFoundException(String message) {
		super(message);
	}

}
