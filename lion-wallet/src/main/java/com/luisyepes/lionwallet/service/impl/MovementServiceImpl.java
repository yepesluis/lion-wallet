package com.luisyepes.lionwallet.service.impl;

import java.math.BigInteger;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.luisyepes.lionwallet.dao.MovementDao;
import com.luisyepes.lionwallet.domain.Category;
import com.luisyepes.lionwallet.domain.Movement;
import com.luisyepes.lionwallet.domain.enums.Month;
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
	public BigInteger getTotalIncomesMonth(Month month) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public BigInteger getTotalOutflowsMonth(Month month) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public BigInteger getTotalAmountOutflowsMonthByCategory(Category category, Month month) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Map<Category, BigInteger> getTotalAmountOutflowsMonthByCategories(Month month) {
		// TODO Auto-generated method stub
		return null;
	}


}
