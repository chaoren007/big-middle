package com.morning.star.retail.vo;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * 货品定价
 * 
 * @author jiangyf
 * @date 2017年5月31日 下午8:30:40
 */
public class PriceVO implements Serializable {
	private static final long serialVersionUID = 2240080861393264871L;

	/**
	 * 原销售价
	 */
	private BigDecimal originalPrice;

	/**
	 * 现销售价
	 */
	private BigDecimal salePrice;

	/**
	 * 状态（0：待审核，1：审核成功，2：审核失败)
	 */
	private Integer status;

	/**
	 * 创建时间
	 */
	private Date createTime;

	/**
	 * 创建人名称
	 */
	private String creatorName;

	/**
	 * 修改时间
	 */
	private Date modifyTime;

	/**
	 * 操作人名称
	 */
	private String operatorName;

	public BigDecimal getOriginalPrice() {
		return originalPrice;
	}

	public void setOriginalPrice(BigDecimal originalPrice) {
		this.originalPrice = originalPrice;
	}

	public BigDecimal getSalePrice() {
		return salePrice;
	}

	public void setSalePrice(BigDecimal salePrice) {
		this.salePrice = salePrice;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public String getCreatorName() {
		return creatorName;
	}

	public void setCreatorName(String creatorName) {
		this.creatorName = creatorName;
	}

	public Date getModifyTime() {
		return modifyTime;
	}

	public void setModifyTime(Date modifyTime) {
		this.modifyTime = modifyTime;
	}

	public String getOperatorName() {
		return operatorName;
	}

	public void setOperatorName(String operatorName) {
		this.operatorName = operatorName;
	}

}
