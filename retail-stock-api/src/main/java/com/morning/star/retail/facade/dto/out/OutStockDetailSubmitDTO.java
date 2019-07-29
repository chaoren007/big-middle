package com.morning.star.retail.facade.dto.out;

import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * 出库单明细
 *
 * @author jiangyf
 * @date 2018/3/13
 */
public class OutStockDetailSubmitDTO implements Serializable {
	private static final long serialVersionUID = 6177930044594156802L;

	@ApiModelProperty(required = true, value = "货品编码")
	private String productCode;

	@ApiModelProperty(value = "商品编码", hidden = true)
	private String goodsCode;

	@ApiModelProperty(required = true, value = "upc")
	private String upcCode;

	@ApiModelProperty(value = "需求出库数量")
	private BigDecimal initialOutNum = BigDecimal.ZERO;

	@ApiModelProperty(value = "实际出库数量")
	private BigDecimal realOutNum = BigDecimal.ZERO;

	@ApiModelProperty(required = true, value = "单位")
	private String units;

	public String getProductCode() {
		return productCode;
	}

	public void setProductCode(String productCode) {
		this.productCode = productCode;
	}

	public String getGoodsCode() {
		return goodsCode;
	}

	public void setGoodsCode(String goodsCode) {
		this.goodsCode = goodsCode;
	}

	public String getUpcCode() {
		return upcCode;
	}

	public void setUpcCode(String upcCode) {
		this.upcCode = upcCode;
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

	public String getUnits() {
		return units;
	}

	public void setUnits(String units) {
		this.units = units;
	}
}
