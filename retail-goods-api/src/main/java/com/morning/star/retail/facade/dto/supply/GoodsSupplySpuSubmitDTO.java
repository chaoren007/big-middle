package com.morning.star.retail.facade.dto.supply;


import com.morning.star.retail.facade.dto.ProductSpecDTO;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

/**
 * 多规格商品信息
 */
@ApiModel
@Data
public class GoodsSupplySpuSubmitDTO implements Serializable {
	private static final long serialVersionUID = 735382006815547012L;

	@ApiModelProperty(value = "货品规格")
	private List<ProductSpecDTO> productSpecInfo;

	@ApiModelProperty(value = "单品编码")
	private String productCode;

//	@NotNull(message = "条形码不能为空,多个逗号隔开")
//	@ApiModelProperty(value = "条形码")
//	private String upcCode;

	@ApiModelProperty(value = "库存", hidden = true)
	private BigDecimal stockNum = new BigDecimal(9999);

	@ApiModelProperty(value = "库存预警值", hidden = true)
	private BigDecimal stockWarningNum = new BigDecimal(9999);

	@ApiModelProperty("供货区域设置详情")
	private List<GoodsSupplySetSubmitDTO> areaDetail;
}
