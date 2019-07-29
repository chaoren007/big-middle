package com.morning.star.retail.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import org.hibernate.annotations.Where;

@Entity
@Table(name = "retail_category_water")
@Where(clause = "delete_flag <> 1")
public class CategoryWaterEntity extends WaterEntity {
	private static final long serialVersionUID = 3176858011720865431L;

	@Column
	private Long categoryId;
	
	@Column
	private Integer clevel;
	
	@Column
	private Long parentId;
	
	@Column(length=64)
	private String categoryName;
	
	@Column
	private Integer weight;
	
	@Column
	private Integer sort;


	public Long getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(Long categoryId) {
		this.categoryId = categoryId;
	}

	public Integer getClevel() {
		return clevel;
	}

	public void setClevel(Integer clevel) {
		this.clevel = clevel;
	}

	public void setParentId(Long parentId) {
		this.parentId = parentId;
	}

	public void setWeight(Integer weight) {
		this.weight = weight;
	}

	public void setSort(Integer sort) {
		this.sort = sort;
	}

	public static long getSerialVersionUID() {
		return serialVersionUID;
	}

	public long getParentId() {
		return parentId;
	}

	public void setParentId(long parentId) {
		this.parentId = parentId;
	}

	public String getCategoryName() {
		return categoryName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}

	public Integer getWeight() {
		return weight;
	}

	public void setWeight(int weight) {
		this.weight = weight;
	}

	public Integer getSort() {
		return sort;
	}

	public void setSort(int sort) {
		this.sort = sort;
	}

}
