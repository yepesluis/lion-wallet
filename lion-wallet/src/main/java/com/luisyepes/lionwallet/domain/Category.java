package com.luisyepes.lionwallet.domain;

import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "category")
@Getter
@Setter
public class Category extends AbstractEntity {
	
	private static final long serialVersionUID = 1L;

	@Column(nullable = false, unique = true)
	private String name;
	
	@OneToMany(
			mappedBy = "category", 
			cascade = CascadeType.ALL,
			orphanRemoval = true)
	private Set<Movement> movements;
	
	public void addMovement(Movement movement) {
		this.movements.add(movement);
		movement.setCategory(this);
	}
	
	public void removeMovement(Movement movement) {
		this.movements.remove(movement);
		movement.setCategory(null);
	}

}
