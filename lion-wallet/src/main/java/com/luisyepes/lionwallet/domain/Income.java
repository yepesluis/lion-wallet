package com.luisyepes.lionwallet.domain;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "income")
@Getter
@Setter
public class Income extends Movement {

	@ManyToOne(fetch = FetchType.LAZY)
	private Category category;
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj) return true;
		if (!(obj instanceof Income)) return false;
		final var otherIncome = (Income) obj;
		return new EqualsBuilder()
				.append(this.getId(), otherIncome.getId())
				.append(date, otherIncome.getDate())
				.append(title, otherIncome.getTitle())
				.append(value, otherIncome.getValue())
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
