package com.morning.star.retail.facade.dto.replenish;

import java.io.Serializable;
import java.math.BigDecimal;

public class ReplenishItemSimpleDTO implements Serializable {
	private static final long serialVersionUID = -3143613675177016599L;

	private String goodsCode;
	private String productCode;
	private String productName;
	private String upcCode;
	private BigDecimal replenishNum;
	private String unitsName;
	private String productType;
	private Integer packSpecNum;
	private String packSpecUnits;
	private Integer boxAmount;
	private Integer deliveryAmount;
	private Integer receiveAmount;

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

	public String getUpcCode() {
		return upcCode;
	}

	public void setUpcCode(String upcCode) {
		this.upcCode = upcCode;
	}

	public BigDecimal getReplenishNum() {
		return replenishNum;
	}

	public void setReplenishNum(BigDecimal replenishNum) {
		this.replenishNum = replenishNum;
	}

	public String getUnitsName() {
		return unitsName;
	}

	public void setUnitsName(String unitsName) {
		this.unitsName = unitsName;
	}

	public String getProductType() {
		return productType;
	}

	public void setProductType(String productType) {
		this.productType = productType;
	}

	public Integer getPackSpecNum() {
		return packSpecNum;
	}

	public void setPackSpecNum(Integer packSpecNum) {
		this.packSpecNum = packSpecNum;
	}

	public String getPackSpecUnits() {
		return packSpecUnits;
	}

	public void setPackSpecUnits(String packSpecUnits) {
		this.packSpecUnits = packSpecUnits;
	}

	public Integer getBoxAmount() {
		return boxAmount;
	}

	public void setBoxAmount(Integer boxAmount) {
		this.boxAmount = boxAmount;
	}

	public Integer getDeliveryAmount() {
		return deliveryAmount;
	}

	public void setDeliveryAmount(Integer deliveryAmount) {
		this.deliveryAmount = deliveryAmount;
	}

	public Integer getReceiveAmount() {
		return receiveAmount;
	}

	public void setReceiveAmount(Integer receiveAmount) {
		this.receiveAmount = receiveAmount;
	}
}
