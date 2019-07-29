package com.morning.star.retail.facade.dto.supply;


import com.morning.star.retail.facade.SubmitSystem;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

@ApiModel
@Data
public class GoodsSupplyAuditGroupDTO implements Serializable {
	private static final long serialVersionUID = 735382006815547012L;

	@ApiModelProperty(value = "商品编码")
	private String productCode;

	@ApiModelProperty(value = "城市ID")
	private String cityId;

	@ApiModelProperty(value = "提交方", hidden = true)
	private SubmitSystem submitSystem = SubmitSystem.DEFAULT;

}
