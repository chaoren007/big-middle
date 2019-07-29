package com.morning.star.retail.facade.dto.replenish;


import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

@ApiModel
public class ReplenishGetDTO implements Serializable {
	private static final long serialVersionUID = -368324418376031036L;

	@ApiModelProperty(value = "补货单号")
	private String replenishCode;

	@ApiModelProperty(value = "集团编码")
	private String groupCode;

	@ApiModelProperty(value = "门店编码")
	private String storeCode;

	public String getReplenishCode() {
		return replenishCode;
	}

	public void setReplenishCode(String replenishCode) {
		this.replenishCode = replenishCode;
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
