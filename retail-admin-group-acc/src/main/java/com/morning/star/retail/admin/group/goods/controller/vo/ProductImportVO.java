package com.morning.star.retail.admin.group.goods.controller.vo;


import java.io.Serializable;

import com.morning.star.retail.base.poi.ExcelColumn;

/**
 * Created by ethan on 2018/5/3.
 */
public class ProductImportVO implements Serializable {

	private static final long serialVersionUID = 5899067468623906496L;
	/**
	 * 商品名称
	 */
	@ExcelColumn(name = "SAP货品编码", column = "0")
	private String sapProductCode;

	public String getSapProductCode() {
		return sapProductCode;
	}

	public void setSapProductCode(String sapProductCode) {
		this.sapProductCode = sapProductCode;
	}
}
