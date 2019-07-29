package com.morning.star.retail.facade.dto.purchase;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 * 采购单删除
 */
@ApiModel
public class PurchaseDeleteDTO implements Serializable {

	private static final long serialVersionUID = -8137520453003973871L;

	@NotNull(message = "采购单号不能为空")
	@ApiModelProperty(value = "采购单号")
	private String purchaseCode;

	public String getPurchaseCode() {
		return purchaseCode;
	}

	public void setPurchaseCode(String purchaseCode) {
		this.purchaseCode = purchaseCode;
	}


}
