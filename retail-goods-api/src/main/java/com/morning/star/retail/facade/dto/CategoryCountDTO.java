package com.morning.star.retail.facade.dto;

import java.io.Serializable;

import io.swagger.annotations.ApiModelProperty;

public class CategoryCountDTO implements Serializable {
	private static final long serialVersionUID = 6107323523250786926L;
	@ApiModelProperty(required = true, value = "分类id级别（1-3级）")
	private Integer clevel;
	private String groupCode;
	private String storeCode;
	@ApiModelProperty(value = "分类ID")
	private Long categoryId;
	@ApiModelProperty(value = "分类名称")
	private String categoryName;
	@ApiModelProperty(required = true, value = "分页数据")
	private Integer pageNo;
	@ApiModelProperty(required = true, value = "分页数据")
	private Integer pageSize;

	public String getGroupCode() {
		return groupCode;
	}

	public void setGroupCode(String groupCode) {
		this.groupCode = groupCode;
	}

	public Integer getClevel() {
		return clevel;
	}

	public void setClevel(Integer clevel) {
		this.clevel = clevel;
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

	public String getStoreCode() {
		return storeCode;
	}

	public void setStoreCode(String storeCode) {
		this.storeCode = storeCode;
	}
}
