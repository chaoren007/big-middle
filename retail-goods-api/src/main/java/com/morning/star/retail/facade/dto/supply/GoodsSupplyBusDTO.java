package com.morning.star.retail.facade.dto.supply;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

@ApiModel
@Data
public class GoodsSupplyBusDTO implements Serializable {
	private static final long serialVersionUID = 735382006815547012L;

	@ApiModelProperty(value = "供货商品编码")
	private String goodsSupplyCode;

	@ApiModelProperty(value = "货品编码")
	private String productCode;

	@ApiModelProperty(value = "货品名称")
	private String productName;

	@ApiModelProperty(value = "规格编码")
	private String spuCode;

	@ApiModelProperty(value = "规格详情")
	private String spuInfo;

	@ApiModelProperty(value = "UPC编码")
	private String upcCode;

	@ApiModelProperty(value = "供应商品状态")
	private Integer supplyStatus;

	@ApiModelProperty(value = "供应商编码")
	private String supplierCode;

	@ApiModelProperty(value = "供应商名称")
	private String supplierName;

	@ApiModelProperty(value = "货品图标")
	private String iconPath;

	@ApiModelProperty("库存")
	private BigDecimal stockNum;

	@ApiModelProperty("库存预警值")
	private BigDecimal stockWarningNum;

	@ApiModelProperty("累积销量")
	private BigDecimal salesNum;

	@ApiModelProperty("单价最大值")
	private BigDecimal priceMax;

	@ApiModelProperty("单价最小值")
	private BigDecimal priceMin;

	@ApiModelProperty("城市单价")
	private BigDecimal cityPrice = BigDecimal.ZERO;

	@ApiModelProperty("城市库存")
	private BigDecimal cityStockNum = BigDecimal.ZERO;

	@ApiModelProperty(value = "一级类目ID")
	private Long categoryId1;

	@ApiModelProperty(value = "一级类目")
	private String categoryName1;

	@ApiModelProperty(value = "二级类目ID")
	private Long categoryId2;

	@ApiModelProperty(value = "二级类目")
	private String categoryName2;

	@ApiModelProperty(value = "三级类目ID")
	private Long categoryId3;

	@ApiModelProperty(value = "三级类目")
	private String categoryName3;

	@ApiModelProperty(value = "计量单位ID")
	private Long unitsId;

	@ApiModelProperty(value = "计量单位名称")
	private String unitsName;

	@ApiModelProperty(value = "税率")
	private Integer taxRate;

	@ApiModelProperty("创建时间")
	private Date createTime;

	@ApiModelProperty("供货区域城市ID，逗号分隔")
	private String supplyCityIds;

	@ApiModelProperty("供货区域是否多区域")
	private String supplyCityType;

	private List<GoodsSupplyBusDTO> detail;


}
