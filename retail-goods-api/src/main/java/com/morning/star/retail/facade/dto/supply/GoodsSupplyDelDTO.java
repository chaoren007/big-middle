package com.morning.star.retail.facade.dto.supply;


import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.Set;

@ApiModel
@Data
public class GoodsSupplyDelDTO implements Serializable {
	private static final long serialVersionUID = 735382006815547012L;

	@ApiModelProperty(value = "供货商品编码")
	private String goodsSupplyCode;

	@ApiModelProperty(value = "批量供货商品编码")
	private Set<String> goodsSupplyCodeSet;
}
