package com.morning.star.retail.facade.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * 品牌
 *
 * @author obama
 */
@ApiModel
public class ImeiAddDTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5938698022164199549L;
   /*
    *串码 
    */
   @ApiModelProperty(value = "串码")
	private String imeiCode;

	@ApiModelProperty(value = "名称")
	private String imeiName;

	@ApiModelProperty(value = "入库单号")
	private String instockCode;

	@ApiModelProperty(value = "入库时间")
	private Date instockTime;

	@ApiModelProperty(value = "进价")
	private BigDecimal inPrice;

	@ApiModelProperty(value = "出库单号")
	private String outstockCode;

	@ApiModelProperty(value = "出库时间")
	private Date outstockTime;

	@ApiModelProperty(value = "出库价格")
	private BigDecimal outPrice;

	@ApiModelProperty(value = "集团编码")
	private String groupCode;

	@ApiModelProperty(value = "门店编码")
	private String storeCode;

	@ApiModelProperty(value = "sap编码")
	private String sapCode;

	@ApiModelProperty(value = "备注")
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

	public Date getInstockTime() {
		return instockTime;
	}

	public void setInstockTime(Date instockTime) {
		this.instockTime = instockTime;
	}

	public void setOutstockTime(Date outstockTime) {
		this.outstockTime = outstockTime;
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

	public Date getOutstockTime() {
		return outstockTime;
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
