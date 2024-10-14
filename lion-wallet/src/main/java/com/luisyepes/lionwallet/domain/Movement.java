package com.luisyepes.lionwallet.domain;

import java.math.BigInteger;
import java.time.LocalDate;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import jakarta.persistence.Column;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.MappedSuperclass;
import lombok.Getter;
import lombok.Setter;

@MappedSuperclass
@Getter
@Setter
@EntityListeners(AuditingEntityListener.class)
public abstract class Movement extends AbstractEntity {
	
	@CreatedDate
	@Column
	protected LocalDate date;
	@Column
	protected String title;
	@Column(nullable = false)
	protected BigInteger value;

}
