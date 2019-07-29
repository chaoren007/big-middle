package com.morning.star.retail.vo;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * 货品定价
 * 
 * @author jiangyf
 * @date 2017年5月31日 下午5:20:47
 */
public class GoodsPriceVO implements Serializable {
	private static final long serialVersionUID = -8005503692905278411L;

	/**
	 * 货品编码
	 */
	private String goodsCode;

	/**
	 * 货品名称
	 */
	private String goodsNme;

	/**
	 * upc
	 */
	private String upcCode;

	/**
	 * 货品类型
	 */
	private String goodsType;

	/**
	 * 销售指导价
	 * 
	 */
	private BigDecimal guidePrice;

	/**
	 * 销售价
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

	public String getGoodsCode() {
		return goodsCode;
	}

	public void setGoodsCode(String goodsCode) {
		this.goodsCode = goodsCode;
	}

	public String getGoodsNme() {
		return goodsNme;
	}

	public void setGoodsNme(String goodsNme) {
		this.goodsNme = goodsNme;
	}

	public String getUpcCode() {
		return upcCode;
	}

	public void setUpcCode(String upcCode) {
		this.upcCode = upcCode;
	}

	public String getGoodsType() {
		return goodsType;
	}

	public void setGoodsType(String goodsType) {
		this.goodsType = goodsType;
	}

	public BigDecimal getGuidePrice() {
		return guidePrice;
	}

	public void setGuidePrice(BigDecimal guidePrice) {
		this.guidePrice = guidePrice;
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

}
