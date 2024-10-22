package com.luisyepes.lionwallet.service;

import java.util.Map;

import com.luisyepes.lionwallet.domain.Category;
import com.luisyepes.lionwallet.domain.Movement;

public interface MovementService {
	
	Movement recordMovement(Movement movement);
	Double getTotalIncomesMonth(int month, int year);
	Double getTotalOutflowsMonth(int month, int year);
	Double getTotalAmountOutflowsMonthByCategory(Category category, int month, int year);
	Map<Category, Double> getTotalAmountOutflowsMonthByCategories(int month, int year);

}
