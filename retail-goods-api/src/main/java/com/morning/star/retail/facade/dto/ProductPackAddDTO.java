package com.morning.star.retail.facade.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

@ApiModel
public class ProductPackAddDTO implements Serializable {
	private static final long serialVersionUID = 1990467488083690464L;

	@ApiModelProperty(value = "集团编码")
	private String groupCode;

	@NotNull(message = "大包装主数据编码不能为空")
	@ApiModelProperty(value = "大包装主数据编码")
	private String sapProductCode;

	@NotNull(message = "小包装主数据编码不能为空")
	@ApiModelProperty(value = "小包装主数据编码")
	private String packSapProductCode;

	@NotNull(message = "包装容量不能为空")
	@Min(value = 1, message = "包装容量最小为1")
	@Max(value = Integer.MAX_VALUE, message = "包装容量过大")
	@ApiModelProperty(value = "包装容量")
	private Integer packNum;

	@ApiModelProperty(value = "权重")
	private Integer priority = 1;

	public String getGroupCode() {
		return groupCode;
	}

	public void setGroupCode(String groupCode) {
		this.groupCode = groupCode;
	}

	public String getSapProductCode() {
		return sapProductCode;
	}

	public void setSapProductCode(String sapProductCode) {
		this.sapProductCode = sapProductCode;
	}

	public String getPackSapProductCode() {
		return packSapProductCode;
	}

	public void setPackSapProductCode(String packSapProductCode) {
		this.packSapProductCode = packSapProductCode;
	}

	public Integer getPackNum() {
		return packNum;
	}

	public void setPackNum(Integer packNum) {
		this.packNum = packNum;
	}

	public Integer getPriority() {
		return priority;
	}

	public void setPriority(Integer priority) {
		this.priority = priority;
	}
}
