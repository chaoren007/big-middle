package com.morning.star.retail.admin.group.stock.controller.command;

import java.io.Serializable;
import java.util.List;

import javax.validation.constraints.NotNull;

import com.morning.star.retail.stock.dto.ModifyReceiptDiffItemDTO;

import io.swagger.annotations.ApiModelProperty;

public class ModifyReceiptDiffCommand implements Serializable {
    private static final long serialVersionUID = 1L;

    @NotNull(message = "入库差异单号不能为空")
	@ApiModelProperty(value = "入库差异单号")
	private String receiptDiffCode;

	@NotNull(message = "细表不能为空")
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
