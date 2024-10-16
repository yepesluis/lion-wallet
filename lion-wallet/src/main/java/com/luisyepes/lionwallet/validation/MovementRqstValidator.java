package com.luisyepes.lionwallet.validation;

import org.springframework.stereotype.Component;

import com.luisyepes.lionwallet.controller.exception.IncorrectMovementRqstException;
import com.luisyepes.lionwallet.domain.dto.CategoryDto;
import com.luisyepes.lionwallet.domain.dto.MovementDto;
import com.luisyepes.lionwallet.domain.enums.MovementType;
import com.luisyepes.lionwallet.validation.util.ErrorMessages;

@Component
public class MovementRqstValidator {
	
	public void validate(MovementDto movementDto) {
		
		StringBuilder errors = new StringBuilder();
		
		if(movementDto == null) {
			errors.append(ErrorMessages.EMPTY_MOVEMENT_DTO);
			throw new IncorrectMovementRqstException(errors.toString());
		} 
		
		String movementType = movementDto.getMovementType();
		if (movementType == null || movementType.isBlank()) {
			errors.append(ErrorMessages.EMPTY_MOVEMENT_TYPE);
		}
		
		if (movementDto.getDate() == null) {
			errors.append(ErrorMessages.DATE_MOVEMENT_MISSING);
		}
		
		if (movementDto.getValue() == null) {
			errors.append(ErrorMessages.VALUE_MOVEMENT_MISSING);
		}
		
		CategoryDto categoryDto = movementDto.getCategory();
		if (categoryDto == null 
				|| categoryDto.getName() == null 
				|| categoryDto.getName().isBlank()) {
			errors.append(ErrorMessages.CATEGORY_MOVEMENT_MISSING);
		}
		
		if (movementType != null && MovementType.getByName(movementType.toLowerCase()) == null) {
			errors.append(ErrorMessages.INVALID_MOVEMENT_TYPE);
		}
		
		if (!errors.toString().isEmpty()) {
			throw new IncorrectMovementRqstException(errors.toString());
		}
		
	}

}
