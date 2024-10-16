package com.luisyepes.lionwallet.service;

import java.math.BigInteger;
import java.util.Map;

import com.luisyepes.lionwallet.domain.Category;
import com.luisyepes.lionwallet.domain.Movement;
import com.luisyepes.lionwallet.domain.enums.Month;

public interface MovementService {
	
	Movement recordMovement(Movement movement);
	BigInteger getTotalIncomesMonth(Month month);
	BigInteger getTotalOutflowsMonth(Month month);
	BigInteger getTotalAmountOutflowsMonthByCategory(Category category, Month month);
	Map<Category, BigInteger> getTotalAmountOutflowsMonthByCategories(Month month);

}
