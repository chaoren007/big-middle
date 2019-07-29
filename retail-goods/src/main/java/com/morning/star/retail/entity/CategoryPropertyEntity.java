package com.morning.star.retail.entity;

import org.hibernate.annotations.Where;

import javax.persistence.*;

@Entity
@Table(name = "retail_category_property")
@Where(clause = "delete_flag <> 1")
public class CategoryPropertyEntity extends BaseEntity {
	private static final long serialVersionUID = 3176858011720865431L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@Column
	private Long categoryId;

	@Column(length=64)
	private String categoryName;

	@Column(length=64)
	private String propertyKey;

	@Column(length=64)
	private String propertyVal;



	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(Long categoryId) {
		this.categoryId = categoryId;
	}

	public String getCategoryName() {
		return categoryName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}

	public String getPropertyKey() {
		return propertyKey;
	}

	public void setPropertyKey(String propertyKey) {
		this.propertyKey = propertyKey;
	}

	public String getPropertyVal() {
		return propertyVal;
	}

	public void setPropertyVal(String propertyVal) {
		this.propertyVal = propertyVal;
	}
}
