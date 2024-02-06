package com.app.dto;

import java.time.LocalDateTime;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class ApiResponseDTO {
	
	private LocalDateTime dateTime;
	private String message;
	public ApiResponseDTO(String message) {
		super();
		this.dateTime = LocalDateTime.now();
		this.message = message;
	}
}
