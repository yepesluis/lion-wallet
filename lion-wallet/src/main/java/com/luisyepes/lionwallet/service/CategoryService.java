package com.luisyepes.lionwallet.service;

import java.util.List;
import java.util.Set;

import com.luisyepes.lionwallet.domain.Category;

public interface CategoryService {
	
	Category createCategory(Category category);
	Category findCategoryById(Long id);
	List<Category> findCategoryByName(String name);
	Category validateAndGetCategory(Category categoryFromDto);
	Set<Category> findAllcategories();

}
