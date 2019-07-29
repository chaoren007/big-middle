package com.morning.star.retail.export.dto;

import com.morning.star.retail.base.poi.ExcelColumn;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * Created by kimhuhg.
 */
public class ReceiptInfoDTO implements Serializable {
	private static final long serialVersionUID = 6366465855733174380L;

	@ExcelColumn(name = "入库单号")
	private String receiptCode;

	@ExcelColumn(name = "入库类型单号")
	private String receiptTypeCode;

	@ExcelColumn(name = "供应商编码(调拨门店编码)")
	private String supplierCode;

	@ExcelColumn(name = "供应商名称(调拨门店名称)")
	private String supplierName;

	@ExcelColumn(name = "入库类型(0、采购入库 10、门店调拨 30.其他)")
	private Integer receiptType;

	@ExcelColumn(name = "入库类型说明(0、采购入库 10、门店调拨 30.其他)")
	private String receiptTypeStr;

	@ExcelColumn(name = "入库状态(0、待配送 10、配送中20、已到货 30.已入库)")
	private Integer transStatus;

	@ExcelColumn(name = "入库状态说明(0、待配送 10、配送中20、已到货 30.已入库)")
	private String transStatusStr;

	@ExcelColumn(name = "总金额")
	private BigDecimal amount;

	@ExcelColumn(name = "备注说明")
	private String remark;

	@ExcelColumn(name = "入库时间")
	private Date receiptTime;

	@ExcelColumn(name = "预计入库时间")
	private Date expectedReceiptTime;

	@ExcelColumn(name = "出库单号")
	private String outstockCode;

	@ExcelColumn(name = "集团编码")
	private String groupCode;

	@ExcelColumn(name = "集团名称")
	private String groupName;

	@ExcelColumn(name = "门店编码")
	private String storeCode;

	@ExcelColumn(name = "门店名称")
	private String storeName;

	@ExcelColumn(name = "创建时间")
	private Date createTime;

	public String getReceiptCode() {
		return receiptCode;
	}

	public void setReceiptCode(String receiptCode) {
		this.receiptCode = receiptCode;
	}

	public String getReceiptTypeCode() {
		return receiptTypeCode;
	}

	public void setReceiptTypeCode(String receiptTypeCode) {
		this.receiptTypeCode = receiptTypeCode;
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

	public Integer getReceiptType() {
		return receiptType;
	}

	public void setReceiptType(Integer receiptType) {
		this.receiptType = receiptType;
	}

	public String getReceiptTypeStr() {
		return receiptTypeStr;
	}

	public void setReceiptTypeStr(String receiptTypeStr) {
		this.receiptTypeStr = receiptTypeStr;
	}

	public Integer getTransStatus() {
		return transStatus;
	}

	public void setTransStatus(Integer transStatus) {
		this.transStatus = transStatus;
	}

	public String getTransStatusStr() {
		return transStatusStr;
	}

	public void setTransStatusStr(String transStatusStr) {
		this.transStatusStr = transStatusStr;
	}

	public BigDecimal getAmount() {
		return amount;
	}

	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public Date getReceiptTime() {
		return receiptTime;
	}

	public void setReceiptTime(Date receiptTime) {
		this.receiptTime = receiptTime;
	}

	public Date getExpectedReceiptTime() {
		return expectedReceiptTime;
	}

	public void setExpectedReceiptTime(Date expectedReceiptTime) {
		this.expectedReceiptTime = expectedReceiptTime;
	}

	public String getOutstockCode() {
		return outstockCode;
	}

	public void setOutstockCode(String outstockCode) {
		this.outstockCode = outstockCode;
	}

	public String getGroupCode() {
		return groupCode;
	}

	public void setGroupCode(String groupCode) {
		this.groupCode = groupCode;
	}

	public String getGroupName() {
		return groupName;
	}

	public void setGroupName(String groupName) {
		this.groupName = groupName;
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

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
}
