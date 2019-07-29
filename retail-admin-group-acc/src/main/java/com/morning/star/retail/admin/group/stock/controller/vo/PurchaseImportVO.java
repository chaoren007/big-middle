package com.morning.star.retail.admin.group.stock.controller.vo;


import java.io.Serializable;
import java.math.BigDecimal;

import com.morning.star.retail.base.poi.ExcelColumn;

/**
 * Created by ethan on 2018/5/3.
 */
public class PurchaseImportVO implements Serializable {

	private static final long serialVersionUID = 5899067468623906496L;

	@ExcelColumn(name = "供应商编码", column = "0")
	private String supplierCode;

	@ExcelColumn(name = "供应商名称", column = "1")
	private String supplierName;

	@ExcelColumn(name = "货品编码", column = "2")
	private String productCode;

	@ExcelColumn(name = "采购数量", column = "3")
	private BigDecimal qty;

	@ExcelColumn(name = "门店编码", column = "4")
	private String storeCode;

	@ExcelColumn(name = "采购价格", column = "5")
	private BigDecimal price;

	@ExcelColumn(name = "税率", column = "6")
	private Integer taxRate;

	public String getSupplierCode() {
		return supplierCode;
	}

	public void setSupplierCode(String supplierCode) {
		this.supplierCode = supplierCode;
	}

	public String getSupplierName() {
		return supplierName;
	}

	public void setSupplierName(String supplierName) {
		this.supplierName = supplierName;
	}

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

	public Integer getTaxRate() {
		return taxRate;
	}

	public void setTaxRate(Integer taxRate) {
		this.taxRate = taxRate;
	}
}
