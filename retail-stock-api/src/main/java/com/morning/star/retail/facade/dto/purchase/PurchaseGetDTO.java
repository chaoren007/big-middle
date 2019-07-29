package com.morning.star.retail.facade.dto.purchase;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotNull;
import java.io.Serializable;

@ApiModel
public class PurchaseGetDTO implements Serializable {
	private static final long serialVersionUID = -8137520453003973871L;

	@ApiModelProperty(value = "集团编码", hidden = true)
	private String groupCode;

	@ApiModelProperty(value = "门店编码")
	private String storeCode;

	@NotNull(message = "采购单号不能为空")
	@ApiModelProperty(value = "采购单号")
	private String purchaseCode;

	public PurchaseGetDTO() {
	}

	public PurchaseGetDTO(String groupCode, String purchaseCode) {
		this.groupCode = groupCode;
		this.purchaseCode = purchaseCode;
	}

	public String getGroupCode() {
		return groupCode;
	}

	public void setGroupCode(String groupCode) {
		this.groupCode = groupCode;
	}

	public String getStoreCode() {
		return storeCode;
	}

	public void setStoreCode(String storeCode) {
		this.storeCode = storeCode;
	}

	public String getPurchaseCode() {
		return purchaseCode;
	}

	public void setPurchaseCode(String purchaseCode) {
		this.purchaseCode = purchaseCode;
	}
}
