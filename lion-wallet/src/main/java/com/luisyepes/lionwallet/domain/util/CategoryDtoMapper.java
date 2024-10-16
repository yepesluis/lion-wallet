package com.luisyepes.lionwallet.domain.util;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.luisyepes.lionwallet.domain.Category;
import com.luisyepes.lionwallet.domain.dto.MovementDto;

@Component
public class CategoryDtoMapper {
	
	@Autowired
	ModelMapper modelMapper;
	
	public Category extractCategoryFromMovementDto(MovementDto movementDto) {
		if(movementDto == null) { return null; }
		Category category = modelMapper.map(movementDto.getCategory(), Category.class);
		return category;
	}

}
