package com.morning.star.retail.entity.enums;

import com.morning.star.retail.utils.entity.HasCode;

/**
 * 出库类型
 */
public enum OutStockTypeEnum implements HasCode {
	OTHER(1, "其它出库"),
	SALE(2, "销售出库"),
	TRANSFER(3, "调拨出库"),
	REFUND_SUPPLIER(3, "退供应商出库"),
	MATERIEL(5, "物料领用出库");

	private final Integer code;

	private final String desc;

	OutStockTypeEnum(Integer code, String desc) {
		this.code = code;
		this.desc = desc;
	}

	@Override
	public Integer getCode() {
		return code;
	}

	public String getDesc() {
		return desc;
	}
}
