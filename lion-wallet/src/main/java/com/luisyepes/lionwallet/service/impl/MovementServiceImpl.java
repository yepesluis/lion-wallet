package com.luisyepes.lionwallet.service.impl;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.luisyepes.lionwallet.dao.MovementDao;
import com.luisyepes.lionwallet.domain.Category;
import com.luisyepes.lionwallet.domain.Movement;
import com.luisyepes.lionwallet.service.CategoryService;
import com.luisyepes.lionwallet.service.MovementService;

@Service
public class MovementServiceImpl implements MovementService {

	@Autowired
	MovementDao movementDao;
	
	@Autowired
	CategoryService categoryService;
	
	@Override
	@Transactional
	public Movement recordMovement(Movement movement) {
			
		movement.setCategory(
				categoryService.validateAndGetCategory(
						movement.getCategory()));
		
		return movementDao.save(movement);
	}

	@Override
	public Double getTotalIncomesMonth(int month, int year) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Double getTotalOutflowsMonth(int month, int year) {
		return movementDao.getTotalOutflowsMonth(month, year);
	}

	@Override
	public Double getTotalAmountOutflowsMonthByCategory(Category category, int month, int year) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Map<Category, Double> getTotalAmountOutflowsMonthByCategories(int month, int year) {
		// TODO Auto-generated method stub
		return null;
	}


}
