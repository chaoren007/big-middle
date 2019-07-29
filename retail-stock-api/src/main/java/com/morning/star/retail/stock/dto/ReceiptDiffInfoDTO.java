package com.morning.star.retail.stock.dto;

import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

public class ReceiptDiffInfoDTO implements Serializable {
    private static final long serialVersionUID = 1L;

	@ApiModelProperty(value = "入库差异单号")
	private String receiptDiffCode;

	@ApiModelProperty(value = "入库单号")
	private String receiptCode;

	@ApiModelProperty(value = "入库类型单号")
	private String receiptTypeCode;

	@ApiModelProperty(value = "供应商编码")
	private String supplierCode;

	@ApiModelProperty(value = "供应商名称")
	private String supplierName;

	@ApiModelProperty(value = "入库类型(0、采购入库 10、门店调拨 30.其他)")
	private Integer receiptType;

	@ApiModelProperty(value = "入库状态(0、待配送 10、配送中20、已到货 30.已入库)")
	private Integer transStatus;

	@ApiModelProperty(value = "总金额")
	private BigDecimal amount;

	@ApiModelProperty(value = "备注说明")
	private String remark;

	@ApiModelProperty(value = "入库时间")
	private Date receiptTime;

	@ApiModelProperty(value = "预计入库时间")
	private Date expectedReceiptTime;

	@ApiModelProperty(value = "出库单号")
	private String outstockCode;

	@ApiModelProperty(value = "差异单状态(0、待填写差异单 10、待审核、20.待提供处理方案 30.待退货 40.已定责)")
	private Integer diffStatus;

	@ApiModelProperty(value = "处理方案(0、物流公司上架 10、物流公司全责 20、物流公司门店各50% 30.门店全责)")
	private Integer processStatus;

	@ApiModelProperty(value = "集团编码")
	private String groupCode;

	@ApiModelProperty(value = "集团名称")
	private String groupName;

	@ApiModelProperty(value = "门店编码")
	private String storeCode;

	@ApiModelProperty(value = "门店名称")
	private String storeName;

	@ApiModelProperty(value = "细表")
	private List<ReceiptDiffItemInfoDTO> item;

	public String getReceiptDiffCode() {
		return receiptDiffCode;
	}

	public void setReceiptDiffCode(String receiptDiffCode) {
		this.receiptDiffCode = receiptDiffCode;
	}

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

	public String getGroupCode() {
		return groupCode;
	}

	public void setGroupCode(String groupCode) {
		this.groupCode = groupCode;
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

	public Integer getTransStatus() {
		return transStatus;
	}

	public void setTransStatus(Integer transStatus) {
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

	public Integer getDiffStatus() {
		return diffStatus;
	}

	public void setDiffStatus(Integer diffStatus) {
		this.diffStatus = diffStatus;
	}

	public Integer getProcessStatus() {
		return processStatus;
	}

	public void setProcessStatus(Integer processStatus) {
		this.processStatus = processStatus;
	}

	public List<ReceiptDiffItemInfoDTO> getItem() {
		return item;
	}

	public void setItem(List<ReceiptDiffItemInfoDTO> item) {
		this.item = item;
	}

	public String getGroupName() {
		return groupName;
	}

	public void setGroupName(String groupName) {
		this.groupName = groupName;
	}
}
