package com.luisyepes.lionwallet.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.luisyepes.lionwallet.domain.dto.MovementDto;
import com.luisyepes.lionwallet.domain.util.MovementDtoMapper;
import com.luisyepes.lionwallet.service.MovementService;
import com.luisyepes.lionwallet.validation.MovementRqstValidator;

import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
public class MovementController {
	
	@Autowired
	MovementRqstValidator movementRqstValidator;
	
	@Autowired
	MovementService movementService;
	
	@Autowired
	MovementDtoMapper movementDtoMapper;
	
	@GetMapping("/")
	public ResponseEntity<?> welcome(){
		return new ResponseEntity<String>("Bienvenido a Lion Wallet", HttpStatus.OK);
	}
	
	@PostMapping("/record-movement")
	public ResponseEntity<?> recordMovement(@RequestBody MovementDto movementDto) {
		log.info("entrando en controlador");
		movementRqstValidator.validate(movementDto);
		return new ResponseEntity<>(
				movementDtoMapper.movementToDto(
						movementService.recordMovement(
								movementDtoMapper.dtoToMovement(movementDto))),
				HttpStatus.CREATED);
	}
	
	@PostMapping("/testing-post") 
	public  ResponseEntity<?> postest() {
		return new ResponseEntity<String>("Bienvenido a Lion Wallet desde post", HttpStatus.OK);
	}

}
