package com.morning.star.retail.facade.dto;

import java.io.Serializable;

import io.swagger.annotations.ApiModelProperty;

public class CategoryDeleteDTO implements Serializable {
	private static final long serialVersionUID = 6107323523250786926L;
	@ApiModelProperty(required=true,value = "分类id")
	private Long id;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	
	

}
