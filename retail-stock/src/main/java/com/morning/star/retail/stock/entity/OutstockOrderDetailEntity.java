package com.morning.star.retail.stock.entity;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Comment;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.Where;

/**
 * 出库单明细
 *
 */
@Table(name = "retail_outstock_item")
@Where(clause = "delete_flag <> 1")
@Entity
public class OutstockOrderDetailEntity {

	private static final long serialVersionUID = 1L;
	/**
	 * 主键
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(length = 19)
	@Comment(value = "主键id")
	private Long id;
	/**
	 * 出库单号
	 */
	@Column(length = 64)
	@Comment(value = "出库单号")
	private String outstockCode;
	/**
	 * 集团编码
	 */
	@Column(length = 64)
	@Comment(value = "集团编码")
	private String groupCode;
	/**
	 * 商品编码
	 */
	@Column(length = 64)
	@Comment(value = "商品编码")
	private String productCode;
	/**
	 * 商品名称
	 */
	@Column(length = 64)
	@Comment(value = "商品名称")
	private String productName;
	/**
	 * 货品名称
	 */
	@Column(length = 128)
	@Comment(value = "商品名称")
	private String goodsName;
	/**
	 * upc
	 */
	@Column(length = 64)
	@Comment(value = "upc编码")
	private String upcCode;
	
	/**
	 * 单位
	 */
	@Column(length = 19,scale=3)
	@Comment(value = "单位")
	private String units;
	
	@Column(precision = 19,scale=2)
	@Comment(value = "采购价")
	private BigDecimal purchasePrice;
	
	@Column(length = 10)
	@Comment(value = "删除标记 1删除")
	private Integer deleteFlag;
	/**
	 * 需求出库数量
	 */
	@Column(precision = 19,scale=3)
	@Comment(value = "需求出库数量")
	private BigDecimal initialNum;
	/**
	 * 实际出库数量
	 */
	@Column(precision = 19,scale=3)
	@Comment(value = "实际出库数量")
	private BigDecimal realNum;
	
	/**
	 * 可退数量
	 */
	@Column(precision = 19,scale=3)
	@Comment(value = "可退数量")
	private BigDecimal returnableQty;
	/**
	 * 退货数量
	 */
	@Column(precision = 19,scale=3)
	@Comment(value = "退货数量")
	private BigDecimal refundNum;

	/**
	 * 实际入库数量
	 */
	@Column(precision = 19,scale=3)
	@Comment(value = "实际入库数量")
	private BigDecimal realQty;
	

	
	
	
	
	
	public Integer getDeleteFlag() {
		return deleteFlag;
	}

	public void setDeleteFlag(Integer deleteFlag) {
		this.deleteFlag = deleteFlag;
	}
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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

	public String getProductCode() {
		return productCode;
	}

	public BigDecimal getPurchasePrice() {
		return purchasePrice;
	}

	public void setPurchasePrice(BigDecimal purchasePrice) {
		this.purchasePrice = purchasePrice;
	}

	public void setProductCode(String productCode) {
		this.productCode = productCode;
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

	public BigDecimal getInitialNum() {
		return initialNum;
	}

	public void setInitialNum(BigDecimal initialNum) {
		this.initialNum = initialNum;
	}

	public BigDecimal getRealNum() {
		return realNum;
	}

	public void setRealNum(BigDecimal realNum) {
		this.realNum = realNum;
	}

	public String getUnits() {
		return units;
	}

	public void setUnits(String units) {
		this.units = units;
	}

	public BigDecimal getReturnableQty() {
		return returnableQty;
	}

	public void setReturnableQty(BigDecimal returnableQty) {
		this.returnableQty = returnableQty;
	}

	public BigDecimal getRefundNum() {
		return refundNum;
	}

	public void setRefundNum(BigDecimal refundNum) {
		this.refundNum = refundNum;
	}

	public BigDecimal getRealQty() {
		return realQty;
	}

	public void setRealQty(BigDecimal realQty) {
		this.realQty = realQty;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}
}
