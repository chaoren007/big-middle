package com.morning.star.retail.admin.goods.vo;


import java.io.Serializable;

import com.morning.star.retail.base.poi.ExcelColumn;

/**
 * Created by ethan on 2018/5/3.
 */
public class GoodsImportVO implements Serializable {

	private static final long serialVersionUID = 5899067468623906496L;
	/**
	 * 商品名称
	 */
	@ExcelColumn(name = "货品编码", column = "0")
	private String productCode;

	@ExcelColumn(name = "柜组编码", column = "1")
	private String containerCode;

	public String getProductCode() {
		return productCode;
	}

	public void setProductCode(String productCode) {
		this.productCode = productCode;
	}

	public String getContainerCode() {
		return containerCode;
	}

	public void setContainerCode(String containerCode) {
		this.containerCode = containerCode;
	}
}
