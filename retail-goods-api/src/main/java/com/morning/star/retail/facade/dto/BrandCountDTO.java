package com.morning.star.retail.facade.dto;

import java.io.Serializable;

import io.swagger.annotations.ApiModelProperty;

public class BrandCountDTO implements Serializable {
	private static final long serialVersionUID = 6107323523250786926L;
	
	@ApiModelProperty(value = "品牌名称")
	private String brandName;
	@ApiModelProperty(value = "品牌编码")
	private Long brandId;
	private String groupCode;
	private String storeCode;
	@ApiModelProperty(required = true, value = "分页数据")
	private Integer pageNo;
	@ApiModelProperty(required = true, value = "分页数据")
	private Integer pageSize;
	public String getBrandName() {
		return brandName;
	}
	public void setBrandName(String brandName) {
		this.brandName = brandName;
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

	public Long getBrandId() {
		return brandId;
	}

	public void setBrandId(Long brandId) {
		this.brandId = brandId;
	}

	public String getGroupCode() {
		return groupCode;
	}

	public void setGroupCode(String groupCode) {
		this.groupCode = groupCode;
	}

	public String getStoreCode() {
		return storeCode;
	}

	public void setStoreCode(String storeCode) {
		this.storeCode = storeCode;
	}
}
