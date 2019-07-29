package com.morning.star.retail.facade.dto.purchasein;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

@ApiModel
public class PurchaseInUpdateDTO implements Serializable {
	private static final long serialVersionUID = -8137520453003973871L;

	@ApiModelProperty(value = "集团编码", hidden = true)
	private String groupCode;

	@ApiModelProperty(value = "门店编码", hidden = true)
	private String storeCode;

	@NotNull(message = "采购入库单号不能为空")
	@ApiModelProperty(value = "采购入库单号")
	private String purchaseInCode;

	@ApiModelProperty(value = "预计入库时间")
	private Date preReceiptTime;

	private List<PurchaseInDetailUpdateDTO> detailList;

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

	public String getPurchaseInCode() {
		return purchaseInCode;
	}

	public void setPurchaseInCode(String purchaseInCode) {
		this.purchaseInCode = purchaseInCode;
	}

	public Date getPreReceiptTime() {
		return preReceiptTime;
	}

	public void setPreReceiptTime(Date preReceiptTime) {
		this.preReceiptTime = preReceiptTime;
	}

	public List<PurchaseInDetailUpdateDTO> getDetailList() {
		return detailList;
	}

	public void setDetailList(List<PurchaseInDetailUpdateDTO> detailList) {
		this.detailList = detailList;
	}
}
