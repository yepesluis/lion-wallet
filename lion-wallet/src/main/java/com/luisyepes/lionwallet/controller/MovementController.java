package com.luisyepes.lionwallet.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
public class MovementController {
	
	@GetMapping("/prueba")
	public String prueba() {
		log.info("ejecutando controlador log");
		return "hola desde el controlador movement";
	}
	

}
