package com.morning.star.retail.facade.dto;

import java.io.Serializable;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.annotations.ApiParam;

import javax.validation.constraints.NotNull;

/**
 * 品牌
 *
 * @author obama
 */
@ApiModel
public class BrandUpdateDTO implements Serializable {
	private static final long serialVersionUID = 6348392991146109707L;

	
	@ApiModelProperty(required=true,value = "品牌ID")
	private Long id;

	@ApiModelProperty(value = "品牌名称")
	private String brandName;
	@ApiModelProperty(value = "图片")
	private String url;

	@ApiModelProperty(required=true,value = "部门ID")
	private Long categoryId;

	@ApiModelProperty(required=true,value = "部门ID")
	private String categoryIds;


	public String getCategoryIds() {
		return categoryIds;
	}

	public void setCategoryIds(String categoryIds) {
		this.categoryIds = categoryIds;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public Long getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(Long categoryId) {
		this.categoryId = categoryId;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getBrandName() {
		return brandName;
	}

	public void setBrandName(String brandName) {
		this.brandName = brandName;
	}
}
