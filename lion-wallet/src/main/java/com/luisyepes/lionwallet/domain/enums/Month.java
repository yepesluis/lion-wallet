package com.luisyepes.lionwallet.domain.enums;

public enum Month {
	
	JANUARY("january", 1),
	FEBRUARY("february", 2),
	MARCH("march", 3),
	APRIL("april", 4),
	MAY("may", 5),
	JUNE("june", 6),
	JULY("july", 7),
	AUGUST("august", 8),
	SEPTEMBER("septemer", 9),
	OCTOBER("october", 10),
	NOVEMBER("november", 11),
	DECEMBER("december", 12);
	
	private String name;
	private int number;
	
	Month(String monthName, int monthNumber){
		this.name = monthName;
		this.number = monthNumber;
	}
	
	public String getMonthName() {
		return this.name;
	}
	
	public int getMonthNumber() {
		return this.number;
	}
	
	public Month getByMonthName(String monthName) {
		for (Month month : values()) {
			if(month.getMonthName().equalsIgnoreCase(monthName)) {
				return month;
			}
		}
		return null;
	}
	
	public Month getByMonthNumber(int monthNumber) {
		for (Month month : values()) {
			if(month.getMonthNumber() == monthNumber) {
				return month;
			}
		}
		return null;
	}

}
