package com.luisyepes.lionwallet.controller.exception;

import java.time.LocalDateTime;

import lombok.Data;

@Data
public class ErrorDetails {
	
	LocalDateTime dateTime;
	String error;
	String description;
	
	public ErrorDetails(LocalDateTime dateTime, String error, String description) {
		this.dateTime = dateTime;
		this.error = error;
		this.description = description;
	}

}
