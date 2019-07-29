package com.morning.star.retail.bean;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * 货品定价
 * 
 * @author jiangyf
 */
public class GoodsPriceDO implements Serializable {
	private static final long serialVersionUID = 5001043058338126552L;

	/**
	 * 记录ID
	 */
	private Integer id;

	/**
	 * 集团编码
	 */
	private String groupCode;
	/**
	 * 公司编码
	 */
	private String companyCode;

	/**
	 * 门店编码
	 */
	private String storeCode;

	/**
	 * 货品编码
	 */
	private String goodsCode;

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
	 * 创建人ID
	 */
	private String creatorId;

	/**
	 * 创建人名称
	 */
	private String creatorName;

	/**
	 * 修改时间
	 */
	private Date modifyTime;

	/**
	 * 操作人ID
	 */
	private String operatorId;

	/**
	 * 操作人名称
	 */
	private String operatorName;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getGroupCode() {
		return groupCode;
	}

	public void setGroupCode(String groupCode) {
		this.groupCode = groupCode;
	}

	public String getCompanyCode() {
		return companyCode;
	}

	public void setCompanyCode(String companyCode) {
		this.companyCode = companyCode;
	}

	public String getStoreCode() {
		return storeCode;
	}

	public void setStoreCode(String storeCode) {
		this.storeCode = storeCode;
	}

	public String getGoodsCode() {
		return goodsCode;
	}

	public void setGoodsCode(String goodsCode) {
		this.goodsCode = goodsCode;
	}

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

	public Date getModifyTime() {
		return modifyTime;
	}

	public void setModifyTime(Date modifyTime) {
		this.modifyTime = modifyTime;
	}

	public String getOperatorId() {
		return operatorId;
	}

	public void setOperatorId(String operatorId) {
		this.operatorId = operatorId;
	}

	public String getOperatorName() {
		return operatorName;
	}

	public void setOperatorName(String operatorName) {
		this.operatorName = operatorName;
	}

	public GoodsPriceDO() {
	}

	public GoodsPriceDO(String companyCode, String storeCode, String goodsCode, BigDecimal originalPrice,
			BigDecimal salePrice, Integer status, Date createTime, String creatorId, String creatorName,
			Date modifyTime, String operatorId, String operatorName) {
		this.companyCode = companyCode;
		this.storeCode = storeCode;
		this.goodsCode = goodsCode;
		this.originalPrice = originalPrice;
		this.salePrice = salePrice;
		this.status = status;
		this.createTime = createTime;
		this.creatorId = creatorId;
		this.creatorName = creatorName;
		this.modifyTime = modifyTime;
		this.operatorId = operatorId;
		this.operatorName = operatorName;
	}
	public GoodsPriceDO(String groupCode, String companyCode, String storeCode, String goodsCode, BigDecimal originalPrice,
	        BigDecimal salePrice, Integer status, Date createTime, String creatorId, String creatorName,
	        Date modifyTime, String operatorId, String operatorName) {
	    this.groupCode = groupCode;
	    this.companyCode = companyCode;
	    this.storeCode = storeCode;
	    this.goodsCode = goodsCode;
	    this.originalPrice = originalPrice;
	    this.salePrice = salePrice;
	    this.status = status;
	    this.createTime = createTime;
	    this.creatorId = creatorId;
	    this.creatorName = creatorName;
	    this.modifyTime = modifyTime;
	    this.operatorId = operatorId;
	    this.operatorName = operatorName;
	}

	public static GoodsPriceDO getInstance(String companyCode, String storeCode, String goodsCode, BigDecimal salePrice,
			String creatorId, String creatorName) {
		return new GoodsPriceDO(companyCode, storeCode, goodsCode, null, salePrice, null, null, creatorId,
				creatorName, null, null, null);
	}

	public static GoodsPriceDO from(String goodsCode, BigDecimal salePrice, AdminLoginContent content) {
		GoodsPriceDO goodsPriceDO = new GoodsPriceDO();
		goodsPriceDO.setGoodsCode(goodsCode);
		goodsPriceDO.setSalePrice(salePrice);
		goodsPriceDO.setGroupCode(content.getGroupCode());
		goodsPriceDO.setStoreCode(content.getStoreCode());
		goodsPriceDO.setCreatorId(String.valueOf(content.getId()));
		goodsPriceDO.setCreatorName(content.getName());
		return goodsPriceDO;
	}

	public static GoodsPriceDO getInstance(String companyCode, String storeCode, String goodsCode,
			BigDecimal originalPrice, BigDecimal salePrice, Integer status, String creatorId,
			String creatorName, String operatorId, String operatorName) {
		Date nowDate = new Date();
		return new GoodsPriceDO(companyCode, storeCode, goodsCode, originalPrice, salePrice, status, nowDate,
				creatorId, creatorName, nowDate, operatorId, operatorName);
	}

}