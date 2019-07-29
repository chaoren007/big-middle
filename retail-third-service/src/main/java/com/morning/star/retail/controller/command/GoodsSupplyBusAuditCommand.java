package com.morning.star.retail.controller.command;


import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.Set;

/**
 * 运营端审核
 */
@ApiModel
@Data
public class GoodsSupplyBusAuditCommand implements Serializable {
	private static final long serialVersionUID = 735382006815547012L;

	@ApiModelProperty(value = "供货商品编码")
	private String goodsSupplyCode;

	@ApiModelProperty(value = "批量供货商品编码")
	private Set<String> goodsSupplyCodeSet;
}
