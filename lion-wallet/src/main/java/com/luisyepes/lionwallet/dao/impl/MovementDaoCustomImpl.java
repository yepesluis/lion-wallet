package com.luisyepes.lionwallet.dao.impl;

import org.springframework.stereotype.Repository;

import com.luisyepes.lionwallet.dao.MovementDaoCustom;
import com.luisyepes.lionwallet.domain.Movement;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;

@Repository
public class MovementDaoCustomImpl implements MovementDaoCustom {

	@PersistenceContext
	EntityManager entityManager;
	
	private final String MONTH_SQL_FUNCTION = "month";
	private final String YEAR_SQL_FUNCTION = "year";
	private final String DATE_COLUMN = "date";
	private final String VALUE_COLUMN = "value";
	private final Double TOTAL_ZERO = 0.0d;

	@Override
	public Double getTotalOutflowsMonth(int month, int year) {
		
		CriteriaBuilder cb = entityManager.getCriteriaBuilder();
		CriteriaQuery<Double> cq = cb.createQuery(Double.class);
		
		Root<Movement> movement = cq.from(Movement.class);
		
		//filter date by month and year
		Predicate monthPredicate = cb.equal(
				cb.function(MONTH_SQL_FUNCTION, Integer.class, movement.get(DATE_COLUMN)), month);
		Predicate yearPredicate = cb.equal(
				cb.function(YEAR_SQL_FUNCTION, Integer.class, movement.get(DATE_COLUMN)), year);
		
		//sum the outflow's values
		cq.select(cb.sum(movement.get(VALUE_COLUMN)));
		
		//apply predicates (conditions)
		cq.where(cb.and(monthPredicate, yearPredicate));
		
		Double result = entityManager.createQuery(cq).getSingleResult();
		
		return result != null ? result : TOTAL_ZERO;

	}

}
