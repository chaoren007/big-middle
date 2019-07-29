package com.morning.star.retail.facade.dto.out;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.math.BigDecimal;


@ApiModel
public class OutStockDetailDTO implements Serializable {
	private static final long serialVersionUID = 6177930044594156802L;
	@ApiModelProperty(value = "主键id")
	private Long id;

	@ApiModelProperty(value = "出库单号")
	private String outStockCode;

	@ApiModelProperty(value = "集团编码")
	private String groupCode;

	@ApiModelProperty(value = "集团名称")
	private String groupName;

	@ApiModelProperty("商品编码")
	private String goodsCode;

	@ApiModelProperty("货品编码")
	private String productCode;

	@ApiModelProperty(value = "商品名称")
	private String productName;

	@ApiModelProperty(value = "商品规格")
	private String spuInfo;

	@ApiModelProperty(value = "upc编码")
	private String upcCode;

	@ApiModelProperty(value = "单位")
	private String units;

	@ApiModelProperty(value = "采购价")
	private BigDecimal purchasePrice;

	@ApiModelProperty(value = "需求出库数量")
	private BigDecimal initialOutNum;

	@ApiModelProperty(value = "实际出库数量")
	private BigDecimal realOutNum;

	@ApiModelProperty(value = "可退数量")
	private BigDecimal returnableNum;

	@ApiModelProperty(value = "退货数量")
	private BigDecimal refundNum;

	@ApiModelProperty(value = "实际入库数量")
	private BigDecimal realInNum;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getOutStockCode() {
		return outStockCode;
	}

	public void setOutStockCode(String outStockCode) {
		this.outStockCode = outStockCode;
	}

	public String getGroupCode() {
		return groupCode;
	}

	public void setGroupCode(String groupCode) {
		this.groupCode = groupCode;
	}

	public String getGroupName() {
		return groupName;
	}

	public void setGroupName(String groupName) {
		this.groupName = groupName;
	}

	public String getGoodsCode() {
		return goodsCode;
	}

	public void setGoodsCode(String goodsCode) {
		this.goodsCode = goodsCode;
	}

	public String getProductCode() {
		return productCode;
	}

	public void setProductCode(String productCode) {
		this.productCode = productCode;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getSpuInfo() {
		return spuInfo;
	}

	public void setSpuInfo(String spuInfo) {
		this.spuInfo = spuInfo;
	}

	public String getUpcCode() {
		return upcCode;
	}

	public void setUpcCode(String upcCode) {
		this.upcCode = upcCode;
	}

	public String getUnits() {
		return units;
	}

	public void setUnits(String units) {
		this.units = units;
	}

	public BigDecimal getPurchasePrice() {
		return purchasePrice;
	}

	public void setPurchasePrice(BigDecimal purchasePrice) {
		this.purchasePrice = purchasePrice;
	}

	public BigDecimal getInitialOutNum() {
		return initialOutNum;
	}

	public void setInitialOutNum(BigDecimal initialOutNum) {
		this.initialOutNum = initialOutNum;
	}

	public BigDecimal getRealOutNum() {
		return realOutNum;
	}

	public void setRealOutNum(BigDecimal realOutNum) {
		this.realOutNum = realOutNum;
	}

	public BigDecimal getReturnableNum() {
		return returnableNum;
	}

	public void setReturnableNum(BigDecimal returnableNum) {
		this.returnableNum = returnableNum;
	}

	public BigDecimal getRefundNum() {
		return refundNum;
	}

	public void setRefundNum(BigDecimal refundNum) {
		this.refundNum = refundNum;
	}

	public BigDecimal getRealInNum() {
		return realInNum;
	}

	public void setRealInNum(BigDecimal realInNum) {
		this.realInNum = realInNum;
	}
}
