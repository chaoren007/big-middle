package com.morning.star.retail.facade.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

@ApiModel
public class ProductPackQueryDTO implements Serializable {
	private static final long serialVersionUID = 1990467488083690464L;

	@ApiModelProperty(value = "集团编码", hidden = true)
	private String groupCode;

	@ApiModelProperty(value = "大包装货品编码")
	private String productCode;

	@ApiModelProperty(value = "大包装货品唯一编码")
	private String sapProductCode;

	@ApiModelProperty(value = "大包装货品名称")
	private String productName;

	@ApiModelProperty(value = "大包装UPC编码")
	private String upcCode;

	@ApiModelProperty(value = "小包装货品编码")
	private String packProductCode;

	@ApiModelProperty(value = "小包装货品唯一编码")
	private String packSapProductCode;

	@ApiModelProperty(value = "小包装货品名称")
	private String packProductName;

	@ApiModelProperty(value = "小包装UPC编码")
	private String packUpcCode;

	@ApiModelProperty(value = "状态")
	private Integer status;

	@ApiModelProperty(value = "页码")
	private Integer pageNo;

	@ApiModelProperty(value = "每页数")
	private Integer pageSize;

	public String getGroupCode() {
		return groupCode;
	}

	public void setGroupCode(String groupCode) {
		this.groupCode = groupCode;
	}

	public String getProductCode() {
		return productCode;
	}

	public void setProductCode(String productCode) {
		this.productCode = productCode;
	}

	public String getSapProductCode() {
		return sapProductCode;
	}

	public void setSapProductCode(String sapProductCode) {
		this.sapProductCode = sapProductCode;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getUpcCode() {
		return upcCode;
	}

	public void setUpcCode(String upcCode) {
		this.upcCode = upcCode;
	}

	public String getPackProductCode() {
		return packProductCode;
	}

	public void setPackProductCode(String packProductCode) {
		this.packProductCode = packProductCode;
	}

	public String getPackSapProductCode() {
		return packSapProductCode;
	}

	public void setPackSapProductCode(String packSapProductCode) {
		this.packSapProductCode = packSapProductCode;
	}

	public String getPackProductName() {
		return packProductName;
	}

	public void setPackProductName(String packProductName) {
		this.packProductName = packProductName;
	}

	public String getPackUpcCode() {
		return packUpcCode;
	}

	public void setPackUpcCode(String packUpcCode) {
		this.packUpcCode = packUpcCode;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
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
}
