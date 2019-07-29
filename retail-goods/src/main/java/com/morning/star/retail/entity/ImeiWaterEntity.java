package com.morning.star.retail.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import org.hibernate.annotations.Where;

import java.math.BigDecimal;
import java.util.Date;

/**
 * 品牌
 *
 * @author obama
 */
@Table(name = "retail_goods_imei_water")
@Where(clause = "delete_flag <> 1")
@Entity
public class ImeiWaterEntity extends WaterEntity {
	private static final long serialVersionUID = 1111320370190733556L;

	@Column(length = 64)
	private String imeiCode;

	@Column(length = 64)
	private String imeiName;

	@Column(length = 64)
	private String instockCode;

	private Date instockTime;

	@Column(precision = 19, scale = 3)
	private BigDecimal inPrice;

	@Column(length = 64)
	private String outstockCode;

	private Date outstockTime;

	@Column(precision = 19, scale = 3)
	private BigDecimal outPrice;

	@Column(length = 64)
	private String groupCode;

	@Column(length = 64)
	private String storeCode;

	@Column(length = 64)
	private String sapCode;

	@Column(length = 64)
	private String reMark;

	public String getImeiCode() {
		return imeiCode;
	}

	public void setImeiCode(String imeiCode) {
		this.imeiCode = imeiCode;
	}

	public String getImeiName() {
		return imeiName;
	}

	public void setImeiName(String imeiName) {
		this.imeiName = imeiName;
	}

	public String getInstockCode() {
		return instockCode;
	}

	public void setInstockCode(String instockCode) {
		this.instockCode = instockCode;
	}



	public BigDecimal getInPrice() {
		return inPrice;
	}

	public void setInPrice(BigDecimal inPrice) {
		this.inPrice = inPrice;
	}

	public String getOutstockCode() {
		return outstockCode;
	}

	public void setOutstockCode(String outstockCode) {
		this.outstockCode = outstockCode;
	}

	public Date getInstockTime() {
		return instockTime;
	}

	public void setInstockTime(Date instockTime) {
		this.instockTime = instockTime;
	}

	public Date getOutstockTime() {
		return outstockTime;
	}

	public void setOutstockTime(Date outstockTime) {
		this.outstockTime = outstockTime;
	}

	public BigDecimal getOutPrice() {
		return outPrice;
	}

	public void setOutPrice(BigDecimal outPrice) {
		this.outPrice = outPrice;
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

	public String getSapCode() {
		return sapCode;
	}

	public void setSapCode(String sapCode) {
		this.sapCode = sapCode;
	}

	public String getReMark() {
		return reMark;
	}

	public void setReMark(String reMark) {
		this.reMark = reMark;
	}
}
