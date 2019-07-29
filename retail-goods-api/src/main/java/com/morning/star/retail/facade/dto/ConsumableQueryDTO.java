package com.morning.star.retail.facade.dto;


import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

/**
 * 耗材
 */
@ApiModel
public class ConsumableQueryDTO implements Serializable {

	private static final long serialVersionUID = 5309186858474685886L;

	@ApiModelProperty(value = "集团编码", hidden = true)
	private String groupCode;

	@ApiModelProperty(value = "门店编码", hidden = true)
	private String storeCode;

	@ApiModelProperty(value = "耗材编码")
	private String consumableCode;

	@ApiModelProperty(value = "耗材名称")
	private String consumableName;

	@ApiModelProperty(value = "当前页码")
	private Integer pageNo;

	@ApiModelProperty(value = "当前数量")
	private Integer pageSize;

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

	public String getConsumableCode() {
		return consumableCode;
	}

	public void setConsumableCode(String consumableCode) {
		this.consumableCode = consumableCode;
	}

	public String getConsumableName() {
		return consumableName;
	}

	public void setConsumableName(String consumableName) {
		this.consumableName = consumableName;
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
