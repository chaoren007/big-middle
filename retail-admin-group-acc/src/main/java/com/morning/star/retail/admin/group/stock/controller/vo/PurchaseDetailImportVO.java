package com.morning.star.retail.admin.group.stock.controller.vo;


import java.io.Serializable;
import java.math.BigDecimal;

import com.morning.star.retail.base.poi.ExcelColumn;

/**
 * Created by ethan on 2018/5/3.
 */
public class PurchaseDetailImportVO implements Serializable {

	private static final long serialVersionUID = 5899067468623906496L;

	@ExcelColumn(name = "货品编码", isExport = true, column = "0")
	private String productCode;

	@ExcelColumn(name = "采购数量", isExport = true, column = "1")
	private BigDecimal qty;

	@ExcelColumn(name = "门店编码", isExport = true, column = "2")
	private String storeCode;

	@ExcelColumn(name = "采购价格", isExport = true, column = "3")
	private BigDecimal price;

	@ExcelColumn(name = "税率", isExport = true, column = "4")
	private Integer taxRate;

	public String getProductCode() {
		return productCode;
	}

	public void setProductCode(String productCode) {
		this.productCode = productCode;
	}

	public BigDecimal getQty() {
		return qty;
	}

	public void setQty(BigDecimal qty) {
		this.qty = qty;
	}

	public String getStoreCode() {
		return storeCode;
	}

	public void setStoreCode(String storeCode) {
		this.storeCode = storeCode;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}
}
