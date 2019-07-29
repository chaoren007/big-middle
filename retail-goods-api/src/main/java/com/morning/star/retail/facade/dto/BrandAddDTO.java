package com.morning.star.retail.facade.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

/**
 * 品牌
 *
 * @author obama
 */
@ApiModel
public class BrandAddDTO implements Serializable {
	private static final long serialVersionUID = 6348392991146109707L;

	@ApiModelProperty(required=true,value = "品牌名称")
	private String brandName;

	@ApiModelProperty(value = "英文名称")
	private String enName;

	@ApiModelProperty(value = "图片")
	private String url;

	@ApiModelProperty(value = "部门ID")
	private Long categoryId;

	@ApiModelProperty(value = "部门ID")
	private String categoryIds;


	public String getCategoryIds() {
		return categoryIds;
	}

	public void setCategoryIds(String categoryIds) {
		this.categoryIds = categoryIds;
	}

	public Long getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(Long categoryId) {
		this.categoryId = categoryId;
	}

	public String getEnName() {
		return enName;
	}

	public void setEnName(String enName) {
		this.enName = enName;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getBrandName() {
		return brandName;
	}

	public void setBrandName(String brandName) {
		this.brandName = brandName;
	}
}
