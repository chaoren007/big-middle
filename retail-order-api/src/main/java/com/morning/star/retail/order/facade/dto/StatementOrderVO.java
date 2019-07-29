package com.morning.star.retail.order.facade.dto;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class StatementOrderVO implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	  private String orderCode;
	  private String refundCode;
	  //账期类型：“入账” “出账”
	  private String type;
	  private Date payTime;
	  private String goodsName;
	  private String goodsCode;
	  private String upc;
	  private String category;
	  /**
		 * 货品规格
		 */
	 private String goodsSpecInfo;
	 private Integer num;
	 private BigDecimal originalPrice = BigDecimal.ZERO;    	//商品原售单价
	 private BigDecimal salePrice = BigDecimal.ZERO;			//商品销售单价
	 private BigDecimal amount = BigDecimal.ZERO;    		//优惠前金额
	 private BigDecimal realAmount = BigDecimal.ZERO;    		//支付金额（优惠后金额）
	 private BigDecimal discountAmount = BigDecimal.ZERO;	//优惠金额		
	 private String unit;
	 private String storeCode;
	 private String storeName;
	 private String companyCode;
	 private String companyName;
	 private String categoryName1;
	 private String categoryName2;
	 private String categoryName3;
	 //规格1
	 private String specValue1;
	//规格2
	 private String specValue2;
	//规格3
	 private String specValue3;
	 //品牌
	 private String brandName;
	//支付方式
	private Integer payChannel;
	private String payChannelDesc;
	//配送费
	private BigDecimal deliveryFee;
	//供应商
	private String supplierCode;
	private String supplierName;

	public String getOrderCode() {
		return orderCode;
	}
	public void setOrderCode(String orderCode) {
		this.orderCode = orderCode;
	}
	public String getRefundCode() {
		return refundCode;
	}
	public void setRefundCode(String refundCode) {
		this.refundCode = refundCode;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public Date getPayTime() {
		return payTime;
	}
	public void setPayTime(Date payTime) {
		this.payTime = payTime;
	}
	public String getGoodsName() {
		return goodsName;
	}
	public void setGoodsName(String goodsName) {
		this.goodsName = goodsName;
	}
	public String getGoodsCode() {
		return goodsCode;
	}
	public void setGoodsCode(String goodsCode) {
		this.goodsCode = goodsCode;
	}
	public String getUpc() {
		return upc;
	}
	public void setUpc(String upc) {
		this.upc = upc;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public String getGoodsSpecInfo() {
		return goodsSpecInfo;
	}
	public void setGoodsSpecInfo(String goodsSpecInfo) {
		this.goodsSpecInfo = goodsSpecInfo;
	}
	public Integer getNum() {
		return num;
	}
	public void setNum(Integer num) {
		this.num = num;
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
	public BigDecimal getRealAmount() {
		return realAmount;
	}
	public void setRealAmount(BigDecimal realAmount) {
		this.realAmount = realAmount;
	}
	public BigDecimal getDiscountAmount() {
		return discountAmount;
	}
	public void setDiscountAmount(BigDecimal discountAmount) {
		this.discountAmount = discountAmount;
	}
	public String getUnit() {
		return unit;
	}
	public void setUnit(String unit) {
		this.unit = unit;
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
	public String getCompanyCode() {
		return companyCode;
	}
	public void setCompanyCode(String companyCode) {
		this.companyCode = companyCode;
	}
	public String getCompanyName() {
		return companyName;
	}
	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}
	public BigDecimal getAmount() {
		return amount;
	}
	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}
	public String getCategoryName1() {
		return categoryName1;
	}
	public void setCategoryName1(String categoryName1) {
		this.categoryName1 = categoryName1;
	}
	public String getCategoryName2() {
		return categoryName2;
	}
	public void setCategoryName2(String categoryName2) {
		this.categoryName2 = categoryName2;
	}
	public String getCategoryName3() {
		return categoryName3;
	}
	public void setCategoryName3(String categoryName3) {
		this.categoryName3 = categoryName3;
	}
	public String getSpecValue1() {
		return specValue1;
	}
	public void setSpecValue1(String specValue1) {
		this.specValue1 = specValue1;
	}
	public String getSpecValue2() {
		return specValue2;
	}
	public void setSpecValue2(String specValue2) {
		this.specValue2 = specValue2;
	}
	public String getSpecValue3() {
		return specValue3;
	}
	public void setSpecValue3(String specValue3) {
		this.specValue3 = specValue3;
	}
	public String getBrandName() {
		return brandName;
	}
	public void setBrandName(String brandName) {
		this.brandName = brandName;
	}
	public Integer getPayChannel() {
		return payChannel;
	}
	public void setPayChannel(Integer payChannel) {
		this.payChannel = payChannel;
	}
	public String getPayChannelDesc() {
		return payChannelDesc;
	}
	public void setPayChannelDesc(String payChannelDesc) {
		this.payChannelDesc = payChannelDesc;
	}
	public BigDecimal getDeliveryFee() {
		return deliveryFee;
	}
	public void setDeliveryFee(BigDecimal deliveryFee) {
		this.deliveryFee = deliveryFee;
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
}
