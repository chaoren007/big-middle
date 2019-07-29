package com.morning.star.retail.facade.dto;

import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

public class CategoryAddDTO implements Serializable {
	private static final long serialVersionUID = 6107323523250786926L;
	@ApiModelProperty(required=true,value = "为父id,如果是一级分类,1-6，如果添加部门父分类ID为0")
	private Long parentId;
	/**
	 * 分类名称
	 */
	@ApiModelProperty(required=true,value = "分类名称")
	private String categoryName;

	@ApiModelProperty(required=true,value = "最大分佣比例")
	private BigDecimal maxCommission;

	@ApiModelProperty(required=true,value = "最小分佣比例")
	private BigDecimal minCommission;

	@ApiModelProperty(value = "分类属性")
	private List<CategoryPropertyDTO> propertyList;


	public List<CategoryPropertyDTO> getPropertyList() {
		return propertyList;
	}

	public void setPropertyList(List<CategoryPropertyDTO> propertyList) {
		this.propertyList = propertyList;
	}

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

	public Long getParentId() {
		return parentId;
	}
	public void setParentId(Long parentId) {
		this.parentId = parentId;
	}
	public String getCategoryName() {
		return categoryName;
	}
	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}
}
