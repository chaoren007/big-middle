package com.morning.star.retail.stock.entity;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Comment;
import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.Table;

import org.hibernate.annotations.Where;

import com.morning.star.retail.stock.enums.ReceiptStatusEnum;
import com.morning.star.retail.stock.enums.ReceiptTypeEnum;


@Table(name = "retail_receipt_water")
@Where(clause = "delete_flag <> 1")
@Entity
public class ReceiptWaterEntity extends WaterEntity {
    private static final long serialVersionUID = 1L;

	@Column(length = 64)
	@Comment(value = "入库单号")
	private String receiptCode;

	@Column(length = 64)
	@Comment(value = "入库类型单号")
	private String receiptTypeCode;

	@Column(length = 64)
	@Comment(value = "供应商编码(调拨门店编码)")
	private String supplierCode;

	@Column(length = 64)
	@Comment(value = "供应商名称(调拨门店名称)")
	private String supplierName;

	@Convert(converter = ReceiptTypeEnum.DBConverter.class)
	@Comment(value = "入库类型(0、采购入库 10、门店调拨 20、盘盈入库 30.其他)")
	private ReceiptTypeEnum receiptType;

	@Convert(converter = ReceiptStatusEnum.DBConverter.class)
	@Comment(value = "入库状态(0、待配送 10、配送中20、已到货 30.已入库)")
	private ReceiptStatusEnum transStatus;

	@Column(precision = 19, scale = 3)
	@Comment(value = "总金额")
	private BigDecimal amount;

	@Comment(value = "备注说明")
	private String remark;

	@Comment(value = "入库时间")
	private Date receiptTime;

	@Comment(value = "预计入库时间")
	private Date expectedReceiptTime;

	@Column(length = 64)
	@Comment(value = "出库单号")
	private String outstockCode;

	@Column(length = 64)
	@Comment(value = "集团编码")
	private String groupCode;

	@Column(length = 64)
	@Comment(value = "集团名称")
	private String groupName;

	@Column(length = 64)
	@Comment(value = "门店编码")
	private String storeCode;

	@Column(length = 64)
	@Comment(value = "门店名称")
	private String storeName;

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

	public ReceiptTypeEnum getReceiptType() {
		return receiptType;
	}

	public void setReceiptType(ReceiptTypeEnum receiptType) {
		this.receiptType = receiptType;
	}

	public ReceiptStatusEnum getTransStatus() {
		return transStatus;
	}

	public void setTransStatus(ReceiptStatusEnum transStatus) {
		this.transStatus = transStatus;
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
}
