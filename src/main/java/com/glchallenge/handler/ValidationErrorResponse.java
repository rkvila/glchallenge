package com.glchallenge.handler;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter @Setter
public class ValidationErrorResponse {
	private LocalDateTime timestamp;
	private int codigo;
	private String detail;
	
}
