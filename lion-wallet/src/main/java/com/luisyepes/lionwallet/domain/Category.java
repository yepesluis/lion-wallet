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
	
	@Column(nullable = false)
	private String name;
	
	@OneToMany(
			mappedBy = "category", 
			cascade = CascadeType.ALL,
			orphanRemoval = true)
	private Set<Income> incomes;
	
	@OneToMany(
			mappedBy = "category",
			cascade = CascadeType.ALL,
			orphanRemoval = true)
	private Set<Outflow> outflows;
	
	public void addIncome(Income income) {
		this.incomes.add(income);
		income.setCategory(this);
	}
	
	public void removeIncome(Income income) {
		this.incomes.remove(income);
		income.setCategory(null);
	}
	
	public void addOutflow(Outflow outflow) {
		this.outflows.add(outflow);
		outflow.setCategory(this);
	}
	
	public void removeOutflow(Outflow outflow) {
		this.outflows.remove(outflow);
		outflow.setCategory(null);
	}
	
}
