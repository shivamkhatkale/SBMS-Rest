package com.example.demo.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Employee;

@RestController
@RequestMapping("/employee")
public class EmployeeControlerr {

	@GetMapping("/code/{id}")
	public ResponseEntity<Employee> getMessage(@PathVariable("id") Integer id) {
		System.out.println("Hit or not");

		if (id > 100 && id % 10 == 0) {
			return new ResponseEntity<>(
					new Employee(12, "Aniket", 647675,
					"Employee found " + id), HttpStatus.OK);
		} else {
			throw new EmployeeNotFoundException("Employee not found " + id);
		}

	}

}
