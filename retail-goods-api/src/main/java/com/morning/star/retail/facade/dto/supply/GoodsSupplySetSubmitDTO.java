package com.morning.star.retail.facade.dto.supply;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

/**
 * 供货区域设置提交详情
 */
@Data
@ApiModel
public class GoodsSupplySetSubmitDTO implements Serializable {
	private static final long serialVersionUID = 735382006815547012L;

	@ApiModelProperty("单价")
	private BigDecimal price;

	@ApiModelProperty(value = "数量", hidden = true)
	private BigDecimal totalNum = new BigDecimal(9999);

	@ApiModelProperty("城市ID")
	private List<String> cityIds;

	@ApiModelProperty("城市名称")
	private List<String> cityNames;
}
