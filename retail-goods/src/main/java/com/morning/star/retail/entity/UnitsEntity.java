package com.morning.star.retail.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.Where;

/**
 * 单位
 */
@Entity
@Table(name = "retail_units")
@Where(clause = "delete_flag <> 1")
public class UnitsEntity extends BaseEntity {
	private static final long serialVersionUID = -6317728108971810835L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	private String unitsName;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}


	public String getUnitsName() {
		return unitsName;
	}

	public void setUnitsName(String unitsName) {
		this.unitsName = unitsName;
	}
}
