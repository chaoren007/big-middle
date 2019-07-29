package com.morning.star.retail.controller.command;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * 门店货品
 */
@ApiModel
@Data
public class GoodsSupplyQueryCommand implements Serializable {
	private static final long serialVersionUID = 4720371191153018716L;

	@ApiModelProperty(value = "城市ID")
	private String cityId;

//	@ApiModelProperty(value = "供应商品状态")
//	private Set<Integer> supplyStatus;

//	@ApiModelProperty(value = "一级类目ID")
//	private Long categoryId1;

//	@ApiModelProperty(value = "二级类目ID")
//	private Long categoryId2;

//	@ApiModelProperty(value = "三级类目ID")
//	private Long categoryId3;

//	@ApiModelProperty(value = "品牌ID")
//	private Long brandId;

	@ApiModelProperty(value = "当前页码")
	private Integer pageNo;

	@ApiModelProperty(value = "每页数量")
	private Integer pageSize;

//	@ApiModelProperty(value = "商品类型，0,普通商品;1,生鲜商品；2,服饰")
//	private Integer commodityType;

	@ApiModelProperty(value = "货品名称")
	private String productName;

	@ApiModelProperty(value = "货品编码")
	private String productCode;

	@ApiModelProperty(value = "货品UPC条码")
	private String upcCode;

	@ApiModelProperty(value = "供应商编码")
	private String supplierCode;

	@ApiModelProperty(value = "供应商名称")
	private String supplierName;

	@ApiModelProperty(value = "系列：PP,单品：SP")
	private String productType;

//	@ApiModelProperty(value = "对规格主数据", hidden = true)
//	private String mainSpu = "0";

}