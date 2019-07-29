package com.morning.star.retail.stock.entity;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Comment;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.Where;

@Table(name = "retail_receipt_diff_item")
@Where(clause = "delete_flag <> 1")
@Entity
public class ReceiptDiffItemEntity extends BaseEntity {
	private static final long serialVersionUID = 6366465855733174380L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

    @Column(length = 64)
	@Comment(value = "差异单编码")
	private String receiptDiffCode;

    @Column(length = 64)
	@Comment(value = "商品编码")
	private String goodsCode;

    @Column(length = 20)
	@Comment(value = "单位id")
	private String unitsId;

	@Column(length = 20)
	@Comment(value = "单位名称")
	private String unitsName;

	@Column(length = 64)
	@Comment(value = "UPC编码")
	private String upcCode;

	@Column(length = 64)
	@Comment(value = "包装数量")
	private Integer packSpecNum;

	@Column(length = 64)
	@Comment(value = "包装单位")
	private String packSpecUnits;

	@Column(length = 64)
	@Comment(value = "货品编码")
	private String productCode;

	@Column(length = 128)
	@Comment(value = "货品名称")
	private String productName;

	@Column(length = 64)
	@Comment(value = "货品类型")
	private String productType;

	@Column(precision = 19,scale = 3)
	@Comment(value = "采购价")
	private BigDecimal price;

	@Comment(value = "备注说明")
	private String remark;

	@Comment(value = "保质期")
	private Integer shelfLife;

	@Comment(value = "生产日期")
	private Date productionDate;

	@Comment(value = "过期时间")
	private Date expirationDate;

	@Comment(value = "差异数量")
	private BigDecimal differenceQty;

	@Column(length = 120)
	@Comment(value = "差异原因")
	private String diffReason;

	@Column(length = 64)
	@Comment(value = "SAP编码")
	private String sapProductCode;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getReceiptDiffCode() {
		return receiptDiffCode;
	}

	public void setReceiptDiffCode(String receiptDiffCode) {
		this.receiptDiffCode = receiptDiffCode;
	}

	public String getGoodsCode() {
		return goodsCode;
	}

	public void setGoodsCode(String goodsCode) {
		this.goodsCode = goodsCode;
	}

	public String getUnitsId() {
		return unitsId;
	}

	public void setUnitsId(String unitsId) {
		this.unitsId = unitsId;
	}

	public String getUnitsName() {
		return unitsName;
	}

	public void setUnitsName(String unitsName) {
		this.unitsName = unitsName;
	}

	public String getUpcCode() {
		return upcCode;
	}

	public void setUpcCode(String upcCode) {
		this.upcCode = upcCode;
	}

	public Integer getPackSpecNum() {
		return packSpecNum;
	}

	public void setPackSpecNum(Integer packSpecNum) {
		this.packSpecNum = packSpecNum;
	}

	public String getPackSpecUnits() {
		return packSpecUnits;
	}

	public void setPackSpecUnits(String packSpecUnits) {
		this.packSpecUnits = packSpecUnits;
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

	public String getProductType() {
		return productType;
	}

	public void setProductType(String productType) {
		this.productType = productType;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public Integer getShelfLife() {
		return shelfLife;
	}

	public void setShelfLife(Integer shelfLife) {
		this.shelfLife = shelfLife;
	}

	public Date getProductionDate() {
		return productionDate;
	}

	public void setProductionDate(Date productionDate) {
		this.productionDate = productionDate;
	}

	public Date getExpirationDate() {
		return expirationDate;
	}

	public void setExpirationDate(Date expirationDate) {
		this.expirationDate = expirationDate;
	}

	public BigDecimal getDifferenceQty() {
		return differenceQty;
	}

	public void setDifferenceQty(BigDecimal differenceQty) {
		this.differenceQty = differenceQty;
	}

	public String getDiffReason() {
		return diffReason;
	}

	public void setDiffReason(String diffReason) {
		this.diffReason = diffReason;
	}

	public String getSapProductCode() {
		return sapProductCode;
	}

	public void setSapProductCode(String sapProductCode) {
		this.sapProductCode = sapProductCode;
	}
}
