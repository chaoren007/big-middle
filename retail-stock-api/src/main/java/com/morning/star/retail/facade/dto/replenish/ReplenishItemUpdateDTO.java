package com.morning.star.retail.facade.dto.replenish;


import com.morning.star.retail.validate.SaveGroup;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.math.BigDecimal;

@ApiModel
public class ReplenishItemUpdateDTO implements Serializable {
	private static final long serialVersionUID = 700733871275750587L;

	@NotNull(message = "货品编码不能为空")
	@ApiModelProperty(value = "货品编码")
	private String goodsCode;

	@NotNull(groups = {SaveGroup.class}, message = "补货数量不能为空")
	@Min(groups = {SaveGroup.class}, value = 1, message = "补货数量不能小于1")
	@ApiModelProperty(value = "补货数量")
	private BigDecimal replenishNum;

	@NotNull(message = "补货单号不能为空")
	@ApiModelProperty(value = "补货单号")
	private String replenishCode;

	public String getReplenishCode() {
		return replenishCode;
	}

	public void setReplenishCode(String replenishCode) {
		this.replenishCode = replenishCode;
	}

	public String getGoodsCode() {
		return goodsCode;
	}

	public void setGoodsCode(String goodsCode) {
		this.goodsCode = goodsCode;
	}

	public BigDecimal getReplenishNum() {
		return replenishNum;
	}

	public void setReplenishNum(BigDecimal replenishNum) {
		this.replenishNum = replenishNum;
	}
}
