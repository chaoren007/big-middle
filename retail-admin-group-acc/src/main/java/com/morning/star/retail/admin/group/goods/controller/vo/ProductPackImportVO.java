package com.morning.star.retail.admin.group.goods.controller.vo;

import java.io.Serializable;

import com.morning.star.retail.base.poi.ExcelColumn;

public class ProductPackImportVO implements Serializable {
	private static final long serialVersionUID = 1990467488083690464L;

	@ExcelColumn(name = "大包装货品编码", column = "0")
	private String productCode;

	@ExcelColumn(name = "小包装货品编码", column = "1")
	private String packProductCode;

	@ExcelColumn(name = "包装容量", column = "2")
	private Integer packNum;

	@ExcelColumn(name = "权重", column = "3")
	private Integer priority = 1;

	public String getProductCode() {
		return productCode;
	}

	public void setProductCode(String productCode) {
		this.productCode = productCode;
	}

	public String getPackProductCode() {
		return packProductCode;
	}

	public void setPackProductCode(String packProductCode) {
		this.packProductCode = packProductCode;
	}

	public Integer getPackNum() {
		return packNum;
	}

	public void setPackNum(Integer packNum) {
		this.packNum = packNum;
	}

	public Integer getPriority() {
		return priority;
	}

	public void setPriority(Integer priority) {
		this.priority = priority;
	}
}
