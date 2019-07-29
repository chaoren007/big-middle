package com.morning.star.retail.admin.group.stock.controller.command;

import java.io.Serializable;

import com.morning.star.retail.base.poi.ExcelColumn;

public class ReceiptImportCommand implements Serializable {
	private static final long serialVersionUID = 1990467488083690464L;

	@ExcelColumn(name = "入库组号(同组同个入库单)", column = "0")
	private String groupNum;

	@ExcelColumn(name = "供应商（调拨门店）编码", column = "1")
	private String supplierCode;

	@ExcelColumn(name = "供应商（调拨门店）名称", column = "2")
	private String supplierName;

	@ExcelColumn(name = "总金额", column = "3")
	private String amount;

	@ExcelColumn(name = "入库类型（采购、调拨、其他）", column = "4")
	private String receiptType;

	@ExcelColumn(name = "商品编码", column = "5")
	private String goodsCode;

	@ExcelColumn(name = "商品名称", column = "6")
	private String productName;

	@ExcelColumn(name = "入库价", column = "7")
	private String price;

	@ExcelColumn(name = "入库数量", column = "8")
	private String qty;

	@ExcelColumn(name = "入库类型编号（采购调拨单号等）", column = "9")
	private String receiptTypeCode;

	@ExcelColumn(name = "门店编码", column = "10")
	private String storeCode;

	@ExcelColumn(name = "门店名称", column = "11")
	private String storeName;

	@ExcelColumn(name = "称重单位(克、千克、吨、两、斤、公斤)", column = "12")
	private String ReceiptUnits;

	@ExcelColumn(name = "备注", column = "13")
	private String remark;

	public String getGroupNum() {
		return groupNum;
	}

	public void setGroupNum(String groupNum) {
		this.groupNum = groupNum;
	}

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

	public String getAmount() {
		return amount;
	}

	public void setAmount(String amount) {
		this.amount = amount;
	}

	public String getReceiptType() {
		return receiptType;
	}

	public void setReceiptType(String receiptType) {
		this.receiptType = receiptType;
	}

	public String getGoodsCode() {
		return goodsCode;
	}

	public void setGoodsCode(String goodsCode) {
		this.goodsCode = goodsCode;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	public String getQty() {
		return qty;
	}

	public void setQty(String qty) {
		this.qty = qty;
	}

	public String getReceiptTypeCode() {
		return receiptTypeCode;
	}

	public void setReceiptTypeCode(String receiptTypeCode) {
		this.receiptTypeCode = receiptTypeCode;
	}

	public String getStoreCode() {
		return storeCode;
	}

	public void setStoreCode(String storeCode) {
		this.storeCode = storeCode;
	}

	public String getStoreName() {
		return storeName;
	}

	public void setStoreName(String storeName) {
		this.storeName = storeName;
	}

	public String getReceiptUnits() {
		return ReceiptUnits;
	}

	public void setReceiptUnits(String receiptUnits) {
		ReceiptUnits = receiptUnits;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}
}
