package com.yepes.lionwallet.domain.testdatabuilder;

import java.time.LocalDate;

import com.luisyepes.lionwallet.domain.enums.MovementType;

public class MovementTestDataBuilder {
	
	public static final String MOVEMENT_TYPE_OUTFLOW = MovementType.OUTFLOW.getTypeName();
	public static final LocalDate DATE_2024_10_10 = LocalDate.of(2024, 10, 10);
	public static final String MOVEMENT_TITLE = "movement title";
	public static final Double MOVEMENT_VALUE_50K = 50000d; 

}
