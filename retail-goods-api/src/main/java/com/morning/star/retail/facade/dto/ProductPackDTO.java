package com.morning.star.retail.facade.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.Date;

@ApiModel
public class ProductPackDTO implements Serializable {
	private static final long serialVersionUID = 1990467488083690464L;

	@ApiModelProperty(value = "集团编码")
	private String groupCode;

	@ApiModelProperty(value = "大包装货品编码")
	private String productCode;

	@ApiModelProperty(value = "大包装货品唯一编码")
	private String sapProductCode;

	@ApiModelProperty(value = "大包装货品名称")
	private String productName;

	@ApiModelProperty(value = "大包装UPC编码")
	private String upcCode;

	@ApiModelProperty(value = "大包装计量单位ID")
	private Long unitsId;

	@ApiModelProperty(value = "大包装计量单位名称")
	private String unitsName;

	@ApiModelProperty(value = "小包装货品编码")
	private String packProductCode;

	@ApiModelProperty(value = "小包装货品唯一编码")
	private String packSapProductCode;

	@ApiModelProperty(value = "小包装货品名称")
	private String packProductName;

	@ApiModelProperty(value = "小包装UPC编码")
	private String packUpcCode;

	@ApiModelProperty(value = "小包装计量单位ID")
	private Long packUnitsId;

	@ApiModelProperty(value = "小包装计量单位名称")
	private String packUnitsName;

	@ApiModelProperty(value = "包装容量")
	private Integer packNum;

	@ApiModelProperty(value = "状态")
	private Integer status;

	@ApiModelProperty(value = "创建时间")
	private Date createTime;

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

	public Long getUnitsId() {
		return unitsId;
	}

	public void setUnitsId(Long unitsId) {
		this.unitsId = unitsId;
	}

	public String getUnitsName() {
		return unitsName;
	}

	public void setUnitsName(String unitsName) {
		this.unitsName = unitsName;
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

	public Long getPackUnitsId() {
		return packUnitsId;
	}

	public void setPackUnitsId(Long packUnitsId) {
		this.packUnitsId = packUnitsId;
	}

	public String getPackUnitsName() {
		return packUnitsName;
	}

	public void setPackUnitsName(String packUnitsName) {
		this.packUnitsName = packUnitsName;
	}

	public Integer getPackNum() {
		return packNum;
	}

	public void setPackNum(Integer packNum) {
		this.packNum = packNum;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
}
