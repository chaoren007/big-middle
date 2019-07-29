package com.morning.star.retail.stock.dto;

import java.io.Serializable;
import java.math.BigDecimal;

import io.swagger.annotations.ApiModelProperty;

/**
 * 出库单明细
 *
 * @author jiangyf
 * @date 2018/3/13
 */
public class OutstockOrderDetailDTO implements Serializable {
	private static final long serialVersionUID = 6177930044594156802L;
	/**
	 * 商品编码
	 */
	@ApiModelProperty(required = true, value = "商品编码")
	private String productCode;
	/**
	 * 商品名称
	 */
	@ApiModelProperty(required = true, value = "商品名称")
	private String goodsName;
	/**
	 * upc
	 */
	@ApiModelProperty(required = true, value = "upc")
	String upcCode;
	/**
	 * 需求出库数量
	 */
	@ApiModelProperty(value = "需求出库数量")
	private BigDecimal initialNum = BigDecimal.ZERO;
	/**
	 * 实际出库数量
	 */
	@ApiModelProperty(value = "实际出库数量")
	private BigDecimal realNum = BigDecimal.ZERO;
	/**
	 * 单位
	 */
	@ApiModelProperty(required=true,value = "单位")
	private String units;

	
	
	
	/**
	 * 实际入库数量
	 */
	@ApiModelProperty(value = "退货出库申请传:实际入库数量")
	private BigDecimal realQty=BigDecimal.ZERO;
	/**
	 * 可退数量
	 */
	@ApiModelProperty(value = "退货出库申请传:可退数量")
	private BigDecimal returnableQty=BigDecimal.ZERO;
	/**
	 * 退货数量
	 */
	@ApiModelProperty(value = "退货出库申请传:退货数量")
	private BigDecimal refundNum=BigDecimal.ZERO;

	/**
	 * 采购价
	 */
	@ApiModelProperty(required=true,value = "采购价")
	private BigDecimal purchasePrice;

	public String getProductCode() {
		return productCode;
	}

	public void setProductCode(String productCode) {
		this.productCode = productCode;
	}

	public String getGoodsName() {
		return goodsName;
	}

	public void setGoodsName(String goodsName) {
		this.goodsName = goodsName;
	}

	public String getUpcCode() {
		return upcCode;
	}

	public void setUpcCode(String upcCode) {
		this.upcCode = upcCode;
	}

	public BigDecimal getInitialNum() {
		return initialNum;
	}

	public void setInitialNum(BigDecimal initialNum) {
		this.initialNum = initialNum;
	}

	public BigDecimal getRealNum() {
		return realNum;
	}

	public void setRealNum(BigDecimal realNum) {
		this.realNum = realNum;
	}

	public String getUnits() {
		return units;
	}

	public void setUnits(String units) {
		this.units = units;
	}

	public BigDecimal getReturnableQty() {
		return returnableQty;
	}

	public void setReturnableQty(BigDecimal returnableQty) {
		this.returnableQty = returnableQty;
	}

	public BigDecimal getRefundNum() {
		return refundNum;
	}

	public void setRefundNum(BigDecimal refundNum) {
		this.refundNum = refundNum;
	}

	public BigDecimal getRealQty() {
		return realQty;
	}

	public void setRealQty(BigDecimal realQty) {
		this.realQty = realQty;
	}

	public BigDecimal getPurchasePrice() {
		return purchasePrice;
	}

	public void setPurchasePrice(BigDecimal purchasePrice) {
		this.purchasePrice = purchasePrice;
	}
}
