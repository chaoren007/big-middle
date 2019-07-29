package com.morning.star.retail.admin.group.stock.controller.vo;

import java.io.Serializable;
import java.math.BigDecimal;

import com.morning.star.retail.base.poi.ExcelColumn;

/**
 * Created by lenovo on 2017/11/14.
 */
public class PurchaseDetailExportVO implements Serializable {

	private static final long serialVersionUID = 8120882177810323117L;

	@ExcelColumn(name = "商品编码")
	private String goodsCode;
	@ExcelColumn(name = "货品编码")
	private String productCode;
	@ExcelColumn(name = "货品名称")
	private String productName;
	@ExcelColumn(name = "UPC")
	private String upcCode;
	@ExcelColumn(name = "采购单价")
	private BigDecimal price;
	@ExcelColumn(name = "采购数量")
	private BigDecimal qty;
	@ExcelColumn(name = "单位")
	private String unitsName;
	@ExcelColumn(name = "门店名称")
	private String storeName;
	@ExcelColumn(name = "门店编码")
	private String storeCode;
	@ExcelColumn(name = "入库单号")
	private String receiptCode;
	@ExcelColumn(name = "采购金额")
	private BigDecimal amount;
	@ExcelColumn(name = "税率")
	private Integer taxRate;

	public String getGoodsCode() {
		return goodsCode;
	}

	public void setGoodsCode(String goodsCode) {
		this.goodsCode = goodsCode;
	}

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

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	public BigDecimal getQty() {
		return qty;
	}

	public void setQty(BigDecimal qty) {
		this.qty = qty;
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

	public String getReceiptCode() {
		return receiptCode;
	}

	public void setReceiptCode(String receiptCode) {
		this.receiptCode = receiptCode;
	}

	public BigDecimal getAmount() {
		return amount;
	}

	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}

	public Integer getTaxRate() {
		return taxRate;
	}

	public void setTaxRate(Integer taxRate) {
		this.taxRate = taxRate;
	}
}
