package com.morning.star.retail.facade.dto;

import java.io.Serializable;

public class CategoryQueryDTO implements Serializable {
	private static final long serialVersionUID = 6107323523250786926L;

	/**
	 * 分类id
	 */
	private Long categoryId;
	private String categoryName;
	/**
	 * 父分类id
	 */
	private Long parentId;

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

	public Long getParentId() {
		return parentId;
	}

	public void setParentId(Long parentId) {
		this.parentId = parentId;
	}
}
