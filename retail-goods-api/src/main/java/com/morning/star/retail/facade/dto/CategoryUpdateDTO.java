package com.morning.star.retail.facade.dto;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

import io.swagger.annotations.ApiModelProperty;

public class CategoryUpdateDTO implements Serializable {
	private static final long serialVersionUID = 6107323523250786926L;
	@ApiModelProperty(required=true,value = "分类ID")
	private Long categoryId;
	/**
	 * 分类名称
	 */
	@ApiModelProperty(required=true,value = "分类名称")
	private String categoryName;

	private Integer weight;

	private String url;

	@ApiModelProperty(required=true,value = "最大分佣比例")
	private BigDecimal maxCommission;

	@ApiModelProperty(required=true,value = "最小分佣比例")
	private BigDecimal minCommission;



	@ApiModelProperty(value = "分类属性")
	private List<CategoryPropertyDTO> propertyList;


	public BigDecimal getMaxCommission() {
		return maxCommission;
	}

	public void setMaxCommission(BigDecimal maxCommission) {
		this.maxCommission = maxCommission;
	}

	public BigDecimal getMinCommission() {
		return minCommission;
	}

	public void setMinCommission(BigDecimal minCommission) {
		this.minCommission = minCommission;
	}

	public List<CategoryPropertyDTO> getPropertyList() {
		return propertyList;
	}

	public void setPropertyList(List<CategoryPropertyDTO> propertyList) {
		this.propertyList = propertyList;
	}

	public Integer getWeight() {
		return weight;
	}

	public void setWeight(Integer weight) {
		this.weight = weight;
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

	public String getCategoryName() {
		return categoryName;
	}
	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}
	
	

}
