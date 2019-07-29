package com.morning.star.retail.facade.dto.supply;


import com.morning.star.retail.facade.dto.ProductSpecDTO;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

/**
 * 多规格商品信息
 */
@ApiModel
@Data
public class GoodsSupplySpuDTO implements Serializable {
	private static final long serialVersionUID = 735382006815547012L;

	@ApiModelProperty(value = "货品编码")
	private String productCode;

	@ApiModelProperty(value = "条形码")
	private String upcCode;

	@ApiModelProperty("单价最大值")
	private BigDecimal priceMax;

	@ApiModelProperty("单价最小值")
	private BigDecimal priceMin;

	@ApiModelProperty("库存")
	private BigDecimal stockNum;

	@ApiModelProperty("库存预警值")
	private BigDecimal stockWarningNum;

	@ApiModelProperty(value = "货品规格")
	private List<ProductSpecDTO> productSpecInfo;

	@ApiModelProperty("供货区域设置详情")
	private List<GoodsSupplySetDTO> areaDetail;
}
