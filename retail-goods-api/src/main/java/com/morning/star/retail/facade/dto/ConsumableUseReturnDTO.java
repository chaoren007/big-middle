package com.morning.star.retail.facade.dto;


import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 * 耗材
 */
@ApiModel
public class ConsumableUseReturnDTO implements Serializable {

	private static final long serialVersionUID = 5309186858474685886L;

	@ApiModelProperty(value = "耗材编码")
	@NotNull(message = "耗材编码不能为空")
	private String consumableCode;

	@ApiModelProperty(value = "耗材借用数量")
	@NotNull(message = "耗材借用数量不能为空")
	@Min(value = 1, message = "耗材借用和归还数量最小为1")
	private Integer consumableNum;

	public String getConsumableCode() {
		return consumableCode;
	}

	public void setConsumableCode(String consumableCode) {
		this.consumableCode = consumableCode;
	}

	public Integer getConsumableNum() {
		return consumableNum;
	}

	public void setConsumableNum(Integer consumableNum) {
		this.consumableNum = consumableNum;
	}
}
