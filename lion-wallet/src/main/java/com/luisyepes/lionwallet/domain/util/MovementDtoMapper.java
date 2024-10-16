package com.luisyepes.lionwallet.domain.util;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.luisyepes.lionwallet.domain.Movement;
import com.luisyepes.lionwallet.domain.dto.MovementDto;

@Component
public class MovementDtoMapper {
	
	@Autowired
	ModelMapper modelMapper;
		
	@Autowired
	CategoryDtoMapper categoryDtoMapper;
	
	public MovementDto movementToDto(Movement movement) {
		MovementDto dto = modelMapper.map(movement, MovementDto.class);
		return dto;
	}
	
	public Movement dtoToMovement(MovementDto dto) {
		Movement movement = modelMapper.map(dto, Movement.class);
		movement.setCategory(categoryDtoMapper.extractCategoryFromMovementDto(dto));
		return movement;	
	}
		
}
