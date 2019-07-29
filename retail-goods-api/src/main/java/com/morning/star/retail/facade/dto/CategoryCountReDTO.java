package com.morning.star.retail.facade.dto;

import java.io.Serializable;

import io.swagger.annotations.ApiModelProperty;

public class CategoryCountReDTO implements Serializable {
	private static final long serialVersionUID = 6107323523250786926L;
	
	@ApiModelProperty(value="分类id")
	private Long id;
	@ApiModelProperty(value="分类名称")
	private String categoryName;
	@ApiModelProperty(value="商品数")
	private Long count;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getCategoryName() {
		return categoryName;
	}
	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}
	public Long getCount() {
		return count;
	}
	public void setCount(Long count) {
		this.count = count;
	}

}
