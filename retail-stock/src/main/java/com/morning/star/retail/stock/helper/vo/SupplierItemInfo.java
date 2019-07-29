package com.morning.star.retail.stock.helper.vo;

import java.io.Serializable;
import java.util.Date;

public class SupplierItemInfo implements Serializable{

	/**
	 *
	 */
	private static final long serialVersionUID = -1932115876410624055L;

	private String supplierCode;
	private String goodsCode;
	private String goodsName;
	private String upcCode;
	private String goodsImg;
	private String units;
	private Integer category_id1;
	private Integer category_id2;
	private Integer category_id3;
	private Integer deleteFlag;
	private Date createTime;
	private Date updateTime;
	private Integer operatorId;
	private String operatorName;

	private String groupCode;
	/**
	 * 税率
	 */
	private Integer taxRate;

	public SupplierItemInfo() {
		// TODO Auto-generated constructor stub
	}


	public String getSupplierCode() {
		return supplierCode;
	}


	public void setSupplierCode(String supplierCode) {
		this.supplierCode = supplierCode;
	}


	public String getGoodsCode() {
		return goodsCode;
	}


	public void setGoodsCode(String goodsCode) {
		this.goodsCode = goodsCode;
	}


	public String getGoodsName() {
		return goodsName;
	}


	public void setGoodsName(String goodsName) {
		this.goodsName = goodsName;
	}


	public String getUpcCode() {
		return upcCode;
	}


	public void setUpcCode(String upcCode) {
		this.upcCode = upcCode;
	}


	public String getGoodsImg() {
		return goodsImg;
	}


	public void setGoodsImg(String goodsImg) {
		this.goodsImg = goodsImg;
	}


	public String getUnits() {
		return units;
	}


	public void setUnits(String units) {
		this.units = units;
	}


	public Integer getCategory_id1() {
		return category_id1;
	}


	public void setCategory_id1(Integer category_id1) {
		this.category_id1 = category_id1;
	}


	public Integer getCategory_id2() {
		return category_id2;
	}


	public void setCategory_id2(Integer category_id2) {
		this.category_id2 = category_id2;
	}


	public Integer getCategory_id3() {
		return category_id3;
	}


	public void setCategory_id3(Integer category_id3) {
		this.category_id3 = category_id3;
	}


	public Integer getDeleteFlag() {
		return deleteFlag;
	}


	public void setDeleteFlag(Integer deleteFlag) {
		this.deleteFlag = deleteFlag;
	}


	public Date getCreateTime() {
		return createTime;
	}


	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}


	public Date getUpdateTime() {
		return updateTime;
	}


	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}


	public Integer getOperatorId() {
		return operatorId;
	}


	public void setOperatorId(Integer operatorId) {
		this.operatorId = operatorId;
	}


	public String getOperatorName() {
		return operatorName;
	}


	public void setOperatorName(String operatorName) {
		this.operatorName = operatorName;
	}

	public String getGroupCode() {
		return groupCode;
	}

	public void setGroupCode(String groupCode) {
		this.groupCode = groupCode;
	}

	public Integer getTaxRate() {
		return taxRate;
	}

	public void setTaxRate(Integer taxRate) {
		this.taxRate = taxRate;
	}
}
