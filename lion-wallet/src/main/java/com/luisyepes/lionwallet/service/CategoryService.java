package com.luisyepes.lionwallet.service;

import java.util.Set;

import com.luisyepes.lionwallet.domain.Category;

public interface CategoryService {
	
	Category getReferenceById(Long Id);
	Category createCategory(Category category);
	Category findCategoryById(Long id);
	Category validateAndGetCategory(Category categoryFromDto);
	Set<Category> findAllcategories();

}
