package com.morning.star.retail.facade.dto;


import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.io.Serializable;

/**
 * 耗材
 */
@ApiModel
public class ConsumableAddDTO implements Serializable {

	private static final long serialVersionUID = 5309186858474685886L;

	@ApiModelProperty(value = "集团编码", hidden = true)
	private String groupCode;

	@ApiModelProperty(value = "门店编码", hidden = true)
	private String storeCode;

	@ApiModelProperty(value = "耗材编码")
	@NotNull(message = "耗材编码不能为空")
	@Pattern(regexp = "^[a-zA-Z0-9]+$", message = "耗材编码只能由字母数据组合")
	private String consumableCode;

	@ApiModelProperty(value = "耗材名称")
	@NotNull(message = "耗材名称不能为空")
	private String consumableName;

	@ApiModelProperty(value = "耗材名称")
	@NotNull(message = "耗材名称不能为空")
	@Min(value = 0, message = "耗材数量不能小于0")
	private Integer consumableNum;

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

	public Integer getConsumableNum() {
		return consumableNum;
	}

	public void setConsumableNum(Integer consumableNum) {
		this.consumableNum = consumableNum;
	}
}
