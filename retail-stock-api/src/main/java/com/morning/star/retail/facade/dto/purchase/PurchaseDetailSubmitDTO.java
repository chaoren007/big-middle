package com.morning.star.retail.facade.dto.purchase;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.math.BigDecimal;

@ApiModel
@Data
public class PurchaseDetailSubmitDTO implements Serializable {
	private static final long serialVersionUID = 5512269180604741392L;

	@NotNull(message = "明细中门店编码不能为空")
	@ApiModelProperty(value = "门店编码")
	private String storeCode;

	@NotNull(message = "仓库编码不能为空")
	@ApiModelProperty(value = "仓库编码")
	private String warehouseCode;

	@NotNull(message = "明细中货品编号不能为空")
	@ApiModelProperty(value = "货品编号")
	private String productCode;

	@NotNull(message = "明细中UPC编码不能为空")
	@ApiModelProperty(value = "UPC编码")
	private String upcCode;

	@NotNull(message = "明细中采购数量为空")
	@DecimalMin(value = "0.01", message = "采购数量不能小于0.01")
	@ApiModelProperty(value = "采购数量")
	private BigDecimal qty = BigDecimal.ZERO;

	@ApiModelProperty(value = "采购单位")
	private String originalUnits;

	@NotNull(message = "明细中采购价为空")
	@DecimalMin(value = "0.1", message = "采购价不能小于0.1")
	@ApiModelProperty(value = "采购单价（含税）")
	private BigDecimal ratePrice = BigDecimal.ZERO;

	@NotNull(message = "明细中税率为空")
	@Min(value = 1, message = "税率不能小于1")
	@Max(value = 100, message = "税率不能大于100")
	@ApiModelProperty(value = "税率")
	private Integer taxRate;

	@ApiModelProperty(value = "备注")
	private String remark;

	@ApiModelProperty(value = "包装规格")
	private String packSpec;

	@ApiModelProperty(value = "是否允许过期收货（0：不允许，1：允许）")
	private Integer expiredAllow = 0;
}
