package com.example.demo.ErResp;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class MyErrorResponse {

	private LocalDateTime Date;
	private String status;
	private int code;
	private String message;

}
