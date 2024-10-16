package com.luisyepes.lionwallet.service.impl;

import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.luisyepes.lionwallet.dao.CategoryDao;
import com.luisyepes.lionwallet.domain.Category;
import com.luisyepes.lionwallet.domain.exception.CategoryAlreadyExistsException;
import com.luisyepes.lionwallet.domain.exception.CategoryNotFoundException;
import com.luisyepes.lionwallet.service.CategoryService;
import com.luisyepes.lionwallet.validation.util.ErrorMessages;

@Service
public class CategoryServiceImpl implements CategoryService {

	@Autowired
	CategoryDao categoryDao;
	
	@Override
	@Transactional
	public Category createCategory(Category category) {
		return categoryDao.save(category);
	}

	@Override
	public Category findCategoryById(Long id) {
		Optional<Category> categoryOpt = categoryDao.findById(id);
		if(categoryOpt.isPresent()) {
			return categoryOpt.get();
		} else {
			throw new CategoryNotFoundException(ErrorMessages.CATEGORY_NOT_FOUND + id);
		}	
	}

	@Override
	public Set<Category> findAllcategories() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Category getReferenceById(Long Id) {
		return categoryDao.getReferenceById(Id);
	}

	@Override
	public Category validateAndGetCategory(Category categoryFromDto) {
		//it is assumed category was already validated as not null
		Long categoryIdInDto = categoryFromDto.getId();
		String categoryNameInDto = categoryFromDto.getName();
		Category category;
		if(categoryIdInDto != null) {
			category = findCategoryById(categoryIdInDto);
			if (!category.getName().equals(categoryNameInDto)) {
				throw new CategoryAlreadyExistsException(ErrorMessages.CATEGORY_WITH_DIFFERENT_NAME + category.getName());
			}
		} else {
			category = createCategory(categoryFromDto);
		}
		return category;
	}

}
