package com.morning.star.retail.stock.entity;

import javax.persistence.Column;
import javax.persistence.Comment;
import javax.persistence.Entity;
import javax.persistence.Table;

import org.hibernate.annotations.Where;


@Table(name = "retail_receipt_diff_water")
@Where(clause = "delete_flag <> 1")
@Entity
public class ReceiptDiffWaterEntity extends WaterEntity {
    private static final long serialVersionUID = 1L;

	@Column(length = 64)
	@Comment(value = "差异单编号")
	private String receiptDifferenceCode;

	@Column(length = 64)
	@Comment(value = "入库单编号")
	private String receiptCode;

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

	public String getReceiptDifferenceCode() {
		return receiptDifferenceCode;
	}

	public void setReceiptDifferenceCode(String receiptDifferenceCode) {
		this.receiptDifferenceCode = receiptDifferenceCode;
	}

	public String getReceiptCode() {
		return receiptCode;
	}

	public void setReceiptCode(String receiptCode) {
		this.receiptCode = receiptCode;
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
