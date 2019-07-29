package com.morning.star.retail.admin.stock.controller.command;

import java.io.Serializable;

import com.morning.star.retail.base.poi.ExcelColumn;

public class ExportReceiptDiffCommand implements Serializable {
	private static final long serialVersionUID = 4641390325344723431L;

	@ExcelColumn(name = "入库差异单编码", column = "0")
	private String receiptDifferenceCode;

	@ExcelColumn(name = "货品编码", column = "1")
	private String goodsCode;

	@ExcelColumn(name = "商品名称", column = "2")
	private String productName;

	@ExcelColumn(name = "保质期(天)", column = "3")
	private String shelfLife;

	@ExcelColumn(name = "生产日期", column = "4")
	private String productionDate;

	@ExcelColumn(name = "差异数量", column = "5")
	private String differenceQty;

	@ExcelColumn(name = "差异原因", column = "6")
	private String diffReason;

	public String getReceiptDifferenceCode() {
		return receiptDifferenceCode;
	}

	public void setReceiptDifferenceCode(String receiptDifferenceCode) {
		this.receiptDifferenceCode = receiptDifferenceCode;
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

	public String getProductionDate() {
		return productionDate;
	}

	public void setProductionDate(String productionDate) {
		this.productionDate = productionDate;
	}

	public String getDiffReason() {
		return diffReason;
	}

	public void setDiffReason(String diffReason) {
		this.diffReason = diffReason;
	}

	public String getShelfLife() {
		return shelfLife;
	}

	public void setShelfLife(String shelfLife) {
		this.shelfLife = shelfLife;
	}

	public String getDifferenceQty() {
		return differenceQty;
	}

	public void setDifferenceQty(String differenceQty) {
		this.differenceQty = differenceQty;
	}
}
