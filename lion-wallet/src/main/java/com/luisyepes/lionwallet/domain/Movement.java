package com.luisyepes.lionwallet.domain;

import java.time.LocalDate;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.FetchType;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "movement")
@Getter
@Setter
@EntityListeners(AuditingEntityListener.class)
public class Movement extends AbstractEntity {
	
	private static final long serialVersionUID = 1L;
	
	@Column(nullable = false)
	private String movementType;
	@CreatedDate
	@Column
	private LocalDate date;
	@Column
	private String title;
	@Column(nullable = false)
	private Double value;
	
	@ManyToOne(fetch = FetchType.LAZY)
	private Category category;
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj) return true;
		if (!(obj instanceof Movement)) return false;
		final var otherMovement = (Movement) obj;
		return new EqualsBuilder()
				.append(this.getId(), otherMovement.getId())
				.append(date, otherMovement.getDate())
				.append(title, otherMovement.getTitle())
				.append(value, otherMovement.getValue())
				.isEquals();			
	}
	
	@Override
	public int hashCode() {	
		return new HashCodeBuilder()
				.append(this.getId())
				.append(date)
				.append(title)
				.append(value)
				.toHashCode();				
	}

}
