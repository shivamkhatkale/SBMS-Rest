package com.app.raghu.controller;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class MyErrorResponse {

	private String date;
	private String status;
	private int code;
	private String message;

}
