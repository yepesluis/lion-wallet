package com.luisyepes.lionwallet.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.luisyepes.lionwallet.domain.dto.MovementDto;
import com.luisyepes.lionwallet.domain.util.MovementDtoMapper;
import com.luisyepes.lionwallet.service.MovementService;
import com.luisyepes.lionwallet.validation.MovementRqstValidator;

@RestController
@RequestMapping("/movements")
public class MovementController {
	
	@Autowired
	MovementRqstValidator movementRqstValidator;
	
	@Autowired
	MovementService movementService;
	
	@Autowired
	MovementDtoMapper movementDtoMapper;
	
	@GetMapping("/health-check")
	public ResponseEntity<?> welcome(){
		return new ResponseEntity<String>("Bienvenido a Lion Wallet, server is up and ready!", HttpStatus.OK);
	}
	
	@PostMapping("/record-movement")
	public ResponseEntity<?> recordMovement(@RequestBody MovementDto movementDto) {
		movementRqstValidator.validate(movementDto);
		return new ResponseEntity<>(
				movementDtoMapper.movementToDto(
						movementService.recordMovement(
								movementDtoMapper.dtoToMovement(movementDto))),
				HttpStatus.CREATED);
	}
	
	@GetMapping("/total-outflows")
	public ResponseEntity<?> getTotalOutflowsMonth(@RequestParam int month, @RequestParam int year) {
		return new ResponseEntity<>(
				movementService.getTotalOutflowsMonth(month, year), HttpStatus.OK);
	}
	
}
