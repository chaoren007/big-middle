package com.morning.star.retail.stock.dto;

import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.List;

public class ModifyReceiptDiffDTO implements Serializable {
    private static final long serialVersionUID = 1L;

	@ApiModelProperty(value = "入库差异单号")
	private String receiptDiffCode;

	@ApiModelProperty(value = "细表")
	private List<ModifyReceiptDiffItemDTO> item;

	public String getReceiptDiffCode() {
		return receiptDiffCode;
	}

	public void setReceiptDiffCode(String receiptDiffCode) {
		this.receiptDiffCode = receiptDiffCode;
	}

	public List<ModifyReceiptDiffItemDTO> getItem() {
		return item;
	}

	public void setItem(List<ModifyReceiptDiffItemDTO> item) {
		this.item = item;
	}
}
