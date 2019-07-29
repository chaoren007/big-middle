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
public class GoodsSupplySetDTO implements Serializable {
	private static final long serialVersionUID = 735382006815547012L;

	@ApiModelProperty(value = "单品编码")
	private String productCode;

	@ApiModelProperty("单价")
	private BigDecimal price;

	@ApiModelProperty("数量")
	private BigDecimal totalNum;

	@ApiModelProperty("省ID")
	private String provinceId;

	@ApiModelProperty("省名称")
	private String provinceName;

	@ApiModelProperty("大区编码")
	private String regionCode;

	@ApiModelProperty("大区名称")
	private String regionName;

	@ApiModelProperty("城市ID")
	private String cityId;

	@ApiModelProperty("城市ID列表")
	private List<String> cityIds;

	@ApiModelProperty("城市名称")
	private String cityName;

	@ApiModelProperty("城市名称列表")
	private List<String> cityNames;

	@ApiModelProperty("供应商编码")
	private String supplierCode;

	@ApiModelProperty("供应商名称")
	private String supplierName;

	@ApiModelProperty(value = "供应商品状态")
	private Integer supplyStatus;

	@ApiModelProperty(value = "提交组")
	private Integer submitGroup;

}
