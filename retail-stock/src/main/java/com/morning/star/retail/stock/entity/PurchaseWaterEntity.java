package com.morning.star.retail.stock.entity;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Comment;
import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.morning.star.retail.stock.enums.PurchaseStatusEnum;

@Table(name = "retail_purchase_water")
@Entity
public class PurchaseWaterEntity extends WaterEntity {
	private static final long serialVersionUID = 5208328161187191942L;

	@Column(length = 64, updatable = false)
	private String purchaseCode;

	@Comment("集团编码")
	@Column(length = 64, nullable = false)
	private String groupCode;

	@Comment("集团名称")
	@Column(length = 64)
	private String groupName;

	@Column(length = 64)
	@Comment("门店编码")
	private String storeCode;

	@Column(length = 64)
	@Comment("门店名称")
	private String storeName;

	@Column(length = 64)
	private String supplierCode;

	private String supplierName;

	@Column(length = 2)
	@Convert(converter = PurchaseStatusEnum.DBConverter.class)
	private PurchaseStatusEnum status;

	@Column(length = 2)
	private Integer transStatus;

	@Column(length = 2)
	private Integer payments;

	private BigDecimal amount;

	private String contract;

	private String remark;

	@Column(length = 50)
	private String approveId;

	private String approveName;

	private Date approveDate;

	@Column(length = 64)
	private String creatorId;

	private String creatorName;

	public String getPurchaseCode() {
		return purchaseCode;
	}

	public void setPurchaseCode(String purchaseCode) {
		this.purchaseCode = purchaseCode;
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

	public PurchaseStatusEnum getStatus() {
		return status;
	}

	public void setStatus(PurchaseStatusEnum status) {
		this.status = status;
	}

	public Integer getTransStatus() {
		return transStatus;
	}

	public void setTransStatus(Integer transStatus) {
		this.transStatus = transStatus;
	}

	public Integer getPayments() {
		return payments;
	}

	public void setPayments(Integer payments) {
		this.payments = payments;
	}

	public BigDecimal getAmount() {
		return amount;
	}

	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}

	public String getContract() {
		return contract;
	}

	public void setContract(String contract) {
		this.contract = contract;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public String getApproveId() {
		return approveId;
	}

	public void setApproveId(String approveId) {
		this.approveId = approveId;
	}

	public String getApproveName() {
		return approveName;
	}

	public void setApproveName(String approveName) {
		this.approveName = approveName;
	}

	public Date getApproveDate() {
		return approveDate;
	}

	public void setApproveDate(Date approveDate) {
		this.approveDate = approveDate;
	}

	public String getCreatorId() {
		return creatorId;
	}

	public void setCreatorId(String creatorId) {
		this.creatorId = creatorId;
	}

	public String getCreatorName() {
		return creatorName;
	}

	public void setCreatorName(String creatorName) {
		this.creatorName = creatorName;
	}
}
