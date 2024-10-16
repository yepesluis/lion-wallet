package com.luisyepes.lionwallet.domain.enums;

public enum MovementType {
	
	INCOME("income"),
	OUTFLOW("outflow");
	
	private String name;
	
	MovementType(String typeName) {
		this.name = typeName;
	}
	
	public String getTypeName() {
		return this.name;
	}
	
	public static MovementType getByName(String name) {
		for (MovementType movementType: values()) {
			if (movementType.getTypeName().equals(name)) {
				return movementType;
			}
		}
		return null;
	}

}
