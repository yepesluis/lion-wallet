package com.luisyepes.lionwallet.validation.util;

public class ErrorMessages {
	
	public static final String EMPTY_MOVEMENT_DTO = "|Movement request empty| \n";
	public static final String DATE_MOVEMENT_MISSING = "|Movement date missing| \n";
	public static final String EMPTY_MOVEMENT_TYPE = "|Movement type (income/outflow) missing| \n";
	public static final String VALUE_MOVEMENT_MISSING = "|Mandatory money value missing| \n";
	public static final String CATEGORY_MOVEMENT_MISSING = "|Movement Category missing| \n";
	public static final String INVALID_MOVEMENT_TYPE = "|Movement type not valid, possible values: income or outflow| \n";
	
	public static final String CATEGORY_NOT_FOUND = "Category Not Found, ID: ";
	public static final String CATEGORY_WITH_DIFFERENT_NAME = "Category already exists with different name: ";

}
