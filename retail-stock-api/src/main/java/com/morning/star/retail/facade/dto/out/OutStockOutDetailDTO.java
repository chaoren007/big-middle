package com.morning.star.retail.facade.dto.out;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.math.BigDecimal;


@ApiModel
public class OutStockOutDetailDTO implements Serializable {
	private static final long serialVersionUID = 6177930044594156802L;

	@NotNull(message = "货品编码不能为空")
	@ApiModelProperty("货品编码")
	private String productCode;

	@NotNull(message = "实际出库数量不能为空")
	@DecimalMin(value = "0.01", message = "实际出库数量不能小于0.01")
	@ApiModelProperty(value = "实际出库数量")
	private BigDecimal realOutNum;

	@ApiModelProperty(value = "可退数量")
	private BigDecimal returnableNum;

	@ApiModelProperty(value = "退货数量")
	private BigDecimal refundNum;

	@ApiModelProperty(value = "实际入库数量")
	private BigDecimal realInNum;

	public String getProductCode() {
		return productCode;
	}

	public void setProductCode(String productCode) {
		this.productCode = productCode;
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
