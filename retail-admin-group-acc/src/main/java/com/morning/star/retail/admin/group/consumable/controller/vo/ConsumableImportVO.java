package com.morning.star.retail.admin.group.consumable.controller.vo;

import java.io.Serializable;

import com.morning.star.retail.base.poi.ExcelColumn;

public class ConsumableImportVO implements Serializable {
	private static final long serialVersionUID = 1990467488083690464L;

	@ExcelColumn(name = "耗材编码", column = "0")
	private String consumableCode;

	@ExcelColumn(name = "耗材名称", column = "1")
	private String consumableName;

	@ExcelColumn(name = "耗材数量", column = "2")
	private Integer consumableNum;

	public String getConsumableCode() {
		return consumableCode;
	}

	public void setConsumableCode(String consumableCode) {
		this.consumableCode = consumableCode;
	}

	public String getConsumableName() {
		return consumableName;
	}

	public void setConsumableName(String consumableName) {
		this.consumableName = consumableName;
	}

	public Integer getConsumableNum() {
		return consumableNum;
	}

	public void setConsumableNum(Integer consumableNum) {
		this.consumableNum = consumableNum;
	}
}
