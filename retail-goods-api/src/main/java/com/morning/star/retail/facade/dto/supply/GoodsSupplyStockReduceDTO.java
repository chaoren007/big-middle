package com.morning.star.retail.facade.dto.supply;


import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.math.BigDecimal;

@ApiModel
@Data
public class GoodsSupplyStockReduceDTO implements Serializable {
	private static final long serialVersionUID = 735382006815547012L;

	@ApiModelProperty(value = "单品编码")
	@NotNull(message = "单品编码不能为空")
	private String productCode;

	@ApiModelProperty(value = "供货城市")
	@NotNull(message = "供货城市不能为空")
	private Long cityId;

	@ApiModelProperty(value = "扣减数量")
	@NotNull(message = "扣减数量不能为空")
	@DecimalMin(value = "0.01", message = "扣减数量最低为0.01")
	private BigDecimal num;

}
