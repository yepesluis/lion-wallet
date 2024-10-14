package com.luisyepes.lionwallet.service;

import java.math.BigInteger;
import java.util.Map;

import com.luisyepes.lionwallet.domain.Category;
import com.luisyepes.lionwallet.domain.Income;
import com.luisyepes.lionwallet.domain.Outflow;
import com.luisyepes.lionwallet.domain.enums.Month;

public interface MovementService {
	
	Income recordIncome(Income income);
	Outflow recordOutflow(Outflow outflow);
	BigInteger getTotalIncomesMonth(Month month);
	BigInteger getTotalOutflowsMonth(Month month);
	BigInteger getTotalOutflowsMonthByCategory(Category category, Month month);
	Map<Category, BigInteger> getTotalOutflowsMonthByCategories(Month month);

}
