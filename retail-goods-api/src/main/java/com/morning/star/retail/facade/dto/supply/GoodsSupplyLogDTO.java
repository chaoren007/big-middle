package com.morning.star.retail.facade.dto.supply;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@ApiModel
@Data
public class GoodsSupplyLogDTO implements Serializable {
	private static final long serialVersionUID = 735382006815547012L;

	@ApiModelProperty(value = "供货商品编码")
	private String goodsSupplyCode;

	@ApiModelProperty(value = "商品名称")
	private String goodsName;

	@ApiModelProperty(value = "门店名称")
	private String storeName;

	@ApiModelProperty(value = "货品编码")
	private String productCode;

	@ApiModelProperty(value = "货品名称")
	private String productName;

	@ApiModelProperty(value = "操作人ID")
	private Long operatorId;

	@ApiModelProperty(value = "操作人名称")
	private String operatorName;

	@ApiModelProperty(value = "操作记录")
	private String operatorRemark;

	@ApiModelProperty(value = "操作时间")
	private Date operateTime;

}
