package com.morning.star.retail.facade.dto;

import java.io.Serializable;

import io.swagger.annotations.ApiModelProperty;

/**
 * 品牌
 *
 * @author obama
 */
public class BrandQueryDTO implements Serializable {
	private static final long serialVersionUID = 6348392991146109707L;
	@ApiModelProperty(value = "品牌名称")
	private String brandName;
	private Integer id;
	@ApiModelProperty(required = true ,value = "页数 从1开始")
	private Integer pageNo;
	@ApiModelProperty(required = true ,value = "每页数量")
	private Integer pageSize;

	@ApiModelProperty(required = true ,value = "分类ID")
	private String categoryId;

	public String getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(String categoryId) {
		this.categoryId = categoryId;
	}

	public Integer getPageNo() {
		return pageNo;
	}

	public void setPageNo(Integer pageNo) {
		this.pageNo = pageNo;
	}

	public Integer getPageSize() {
		return pageSize;
	}

	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}

	public String getBrandName() {
		return brandName;
	}

	public void setBrandName(String brandName) {
		this.brandName = brandName;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}
}
