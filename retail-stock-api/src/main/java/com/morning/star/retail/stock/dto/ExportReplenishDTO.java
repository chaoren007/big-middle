package com.morning.star.retail.stock.dto;

import com.morning.star.retail.base.poi.ExcelColumn;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * Created by lenovo on 2017/11/13.
 */
public class ExportReplenishDTO implements Serializable {

	private static final long serialVersionUID = 1875731362242523020L;

	@ExcelColumn(name = "货品编码")
	private String productCode;

	@ExcelColumn(name = "货品名称")
	private String productName;

	@ExcelColumn(name = "UPC")
	private String upcCode;

	@ExcelColumn(name = "采购数量")
	private BigDecimal replenishNum;

	@ExcelColumn(name = "单位")
	private String unitsName;

	@ExcelColumn(name = "门店编码")
	private String storeCode;

	@ExcelColumn(name = "门店名称")
	private String storeName;

	@ExcelColumn(name = "采购单价")
	private BigDecimal price;

	@ExcelColumn(name = "供应商编码")
	private String supplierCode;


	public String getProductCode() {
		return productCode;
	}

	public void setProductCode(String productCode) {
		this.productCode = productCode;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getUpcCode() {
		return upcCode;
	}

	public void setUpcCode(String upcCode) {
		this.upcCode = upcCode;
	}

	public BigDecimal getReplenishNum() {
		return replenishNum;
	}

	public void setReplenishNum(BigDecimal replenishNum) {
		this.replenishNum = replenishNum;
	}

	public String getUnitsName() {
		return unitsName;
	}

	public void setUnitsName(String unitsName) {
		this.unitsName = unitsName;
	}

	public String getStoreName() {
		return storeName;
	}

	public void setStoreName(String storeName) {
		this.storeName = storeName;
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

	public String getSupplierCode() {
		return supplierCode;
	}

	public void setSupplierCode(String supplierCode) {
		this.supplierCode = supplierCode;
	}
}
