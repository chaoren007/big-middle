package com.morning.star.retail.facade.dto.purchasein;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 * 采购单申请提交数据
 */
@ApiModel
public class PurchaseInAuditDTO implements Serializable {
	private static final long serialVersionUID = 6156993290436174199L;

	@NotNull(message = "采购入库单号不能为空")
	@ApiModelProperty(value = "采购入库单号")
	private String purchaseInCode;

	@ApiModelProperty(value = "审核备注")
	private String remark;

	public String getPurchaseInCode() {
		return purchaseInCode;
	}

	public void setPurchaseInCode(String purchaseInCode) {
		this.purchaseInCode = purchaseInCode;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}
}
