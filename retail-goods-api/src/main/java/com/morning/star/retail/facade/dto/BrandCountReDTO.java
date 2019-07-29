package com.morning.star.retail.facade.dto;

import java.io.Serializable;

import io.swagger.annotations.ApiModelProperty;

public class BrandCountReDTO implements Serializable {
	private static final long serialVersionUID = 6107323523250786926L;
	
	@ApiModelProperty(value = "品牌名称")
	private String brandName;

	@ApiModelProperty(value = "品牌ID")
	private String brandId;
	@ApiModelProperty(value = "商品数")
	private Long count;


	public String getBrandId() {
		return brandId;
	}

	public void setBrandId(String brandId) {
		this.brandId = brandId;
	}

	public Long getCount() {
		return count;
	}
	public void setCount(Long count) {
		this.count = count;
	}
	private Integer pageSize;
	public String getBrandName() {
		return brandName;
	}
	public void setBrandName(String brandName) {
		this.brandName = brandName;
	}
	
	public Integer getPageSize() {
		return pageSize;
	}
	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}

}
