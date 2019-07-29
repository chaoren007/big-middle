package com.morning.star.retail.facade.dto.purchase;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * Created by lenovo on 2018/5/2.
 */
public class PurchaseOrderRptDTO implements Serializable {
	private static final long serialVersionUID = -3399228668193285546L;

	private String purchaseCode;

	private Date purchaseTime;

	private String statusName;

	private String goodsCode;
	private String productCode;
	private String productName;
	private String upcCode;
	private String unitsName;
	/**
	 * 规格
	 */
	private String spuInfo;

	private String supplierCode;

	private String supplierName;

	private BigDecimal price = BigDecimal.ZERO;

	private BigDecimal qty = BigDecimal.ZERO;
	/**
	 * 采购金额
	 */
	private BigDecimal amount = BigDecimal.ZERO;
	//入库单号
	private String receiptCode;
	//入库时间
	private Date receiptTime;
	/**
	 * 入库门店
	 */
	private String storeCode;
	/**
	 * 入库门店名称
	 */
	private String storeName;

	/**
	 * 入库数量
	 */
	private BigDecimal receiptQty;

	/**
	 * 入库金额
	 */
	private BigDecimal receiptAmount;

	/**
	 * 未入库数量
	 */
	private BigDecimal noReceiptQty;
	/**
	 * 未入库金额
	 */
	private BigDecimal noReceiptAmount;

	private String memo;

	public String getPurchaseCode() {
		return purchaseCode;
	}

	public void setPurchaseCode(String purchaseCode) {
		this.purchaseCode = purchaseCode;
	}

	public Date getPurchaseTime() {
		return purchaseTime;
	}

	public void setPurchaseTime(Date purchaseTime) {
		this.purchaseTime = purchaseTime;
	}

	public String getStatusName() {
		return statusName;
	}

	public void setStatusName(String statusName) {
		this.statusName = statusName;
	}

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

	public String getUnitsName() {
		return unitsName;
	}

	public void setUnitsName(String unitsName) {
		this.unitsName = unitsName;
	}

	public String getSpuInfo() {
		return spuInfo;
	}

	public void setSpuInfo(String spuInfo) {
		this.spuInfo = spuInfo;
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

	public BigDecimal getAmount() {
		return amount;
	}

	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}

	public String getReceiptCode() {
		return receiptCode;
	}

	public void setReceiptCode(String receiptCode) {
		this.receiptCode = receiptCode;
	}

	public Date getReceiptTime() {
		return receiptTime;
	}

	public void setReceiptTime(Date receiptTime) {
		this.receiptTime = receiptTime;
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

	public BigDecimal getReceiptQty() {
		return receiptQty;
	}

	public void setReceiptQty(BigDecimal receiptQty) {
		this.receiptQty = receiptQty;
	}

	public BigDecimal getReceiptAmount() {
		return receiptAmount;
	}

	public void setReceiptAmount(BigDecimal receiptAmount) {
		this.receiptAmount = receiptAmount;
	}

	public BigDecimal getNoReceiptQty() {
		return noReceiptQty;
	}

	public void setNoReceiptQty(BigDecimal noReceiptQty) {
		this.noReceiptQty = noReceiptQty;
	}

	public BigDecimal getNoReceiptAmount() {
		return noReceiptAmount;
	}

	public void setNoReceiptAmount(BigDecimal noReceiptAmount) {
		this.noReceiptAmount = noReceiptAmount;
	}

	public String getMemo() {
		return memo;
	}

	public void setMemo(String memo) {
		this.memo = memo;
	}
}
