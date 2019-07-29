package com.morning.star.retail.order.facade.dto;

import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * Created by liangguobin on 2017/5/19.
 */
public class AfterSalesItemDTO implements Serializable {
	private static final long serialVersionUID = 1213829454950205914L;

	@ApiModelProperty(value = "主键id")
	private long id;
	@ApiModelProperty(value = "购买数量")
    private BigDecimal buyNum;
	@ApiModelProperty(value = "回退数量")
    private BigDecimal refundNum;
	@ApiModelProperty(value = "货品编码")
    private String goodsCode;
	@ApiModelProperty(value = "图片地址")
    private String image;
	@ApiModelProperty(value = "名称")
    private String goodsName;
	@ApiModelProperty(value = "售后单编码")
    private String afterSalesOrderCode;
	@ApiModelProperty(value = "原价")
    private BigDecimal originalPrice;
	@ApiModelProperty(value = "单价")
    private BigDecimal unitPrice;
	@ApiModelProperty(value = "真实价格")
    private BigDecimal realPrice;
	@ApiModelProperty(value = "单位")
    private String unit;
	@ApiModelProperty(value = "创建时间")
    private Date createTime;
	@ApiModelProperty(value = "更新时间")
    private Date modifyTime;
	@ApiModelProperty(value = "品牌id")
    private Integer brandId;
	@ApiModelProperty(value = "品牌名称")
    private String brandName;
	@ApiModelProperty(value = "一级分类id")
	private Long categoryId1;
	@ApiModelProperty(value = "一级分类名称")
	private String categoryName1;
	@ApiModelProperty(value = "二级分类id")
	private Long categoryId2;
	@ApiModelProperty(value = "二级分类名称")
	private String categoryName2;
	@ApiModelProperty(value = "三级分类id")
	private Long categoryId3;
	@ApiModelProperty(value = "三级分类名称")
	private String categoryName3;
	@ApiModelProperty(value = "upc编码")
	private String upcCode;
	@ApiModelProperty(value = "商品规格编码")
	private String spuCode;
	@ApiModelProperty(value = "商品规格1")
	private String specValue1;
	@ApiModelProperty(value = "商品规格2")
	private String specValue2;
	@ApiModelProperty(value = "商品规格3")
	private String specValue3;
	@ApiModelProperty(value = "所退款商品占订单项优惠金额的优惠份额")
	private BigDecimal discountAmount;
	@ApiModelProperty(value = "正常情况下第三方退款金额")
	private BigDecimal normalRefundAmount = BigDecimal.ZERO;
	@ApiModelProperty(value = "正常情况下退的预付卡")
	private BigDecimal normalPrepayAmount = BigDecimal.ZERO;
	@ApiModelProperty(value = "正常情况下退款总金额")
	private BigDecimal totalNormalRefundAmount;
	@ApiModelProperty(value = "退款总金额")
	private BigDecimal totalRefundAmount;
	@ApiModelProperty(value = "退款金额")
	private BigDecimal refundAmount = BigDecimal.ZERO;
	@ApiModelProperty(value = "售后退款的订单项预付卡金额")
	private BigDecimal prepayCardAmount = BigDecimal.ZERO;
	@ApiModelProperty(value = "订单中该商品所占总金额")
	private BigDecimal orderAmount;
	@ApiModelProperty(value = "订单优惠后该商品所占总金额")
	private BigDecimal orderAmountAfterDiscount;
	@ApiModelProperty(value = "订单优惠金额中该商品所占总金额")
	private BigDecimal orderDiscountAmount;
	@ApiModelProperty(value = "供应商编码")
	private String supplierCode;
	@ApiModelProperty(value = "供应商名称")
	private String supplierName;
	@ApiModelProperty(value = "门店名称")
	private String storeName;
	@ApiModelProperty(value = "门店编码")
	private String storeCode;
	@ApiModelProperty(value = "集团编码")
	private String groupCode;
	@ApiModelProperty(value = "集团名称")
	private String groupName;

	
    public BigDecimal getOriginalPrice() {
		return originalPrice;
	}

	public void setOriginalPrice(BigDecimal originalPrice) {
		this.originalPrice = originalPrice;
	}

	public BigDecimal getDiscountAmount() {
		return discountAmount;
	}

	public void setDiscountAmount(BigDecimal discountAmount) {
		this.discountAmount = discountAmount;
	}

	public String getUpcCode() {
		return upcCode;
	}

	public void setUpcCode(String upcCode) {
		this.upcCode = upcCode;
	}

	public Integer getBrandId() {
		return brandId;
	}

	public void setBrandId(Integer brandId) {
		this.brandId = brandId;
	}

	public String getBrandName() {
		return brandName;
	}

	public void setBrandName(String brandName) {
		this.brandName = brandName;
	}

	public Long getCategoryId1() {
		return categoryId1;
	}

	public void setCategoryId1(Long categoryId1) {
		this.categoryId1 = categoryId1;
	}

	public String getCategoryName1() {
		return categoryName1;
	}

	public void setCategoryName1(String categoryName1) {
		this.categoryName1 = categoryName1;
	}

	public Long getCategoryId2() {
		return categoryId2;
	}

	public void setCategoryId2(Long categoryId2) {
		this.categoryId2 = categoryId2;
	}

	public String getCategoryName2() {
		return categoryName2;
	}

	public void setCategoryName2(String categoryName2) {
		this.categoryName2 = categoryName2;
	}

	public Long getCategoryId3() {
		return categoryId3;
	}

	public void setCategoryId3(Long categoryId3) {
		this.categoryId3 = categoryId3;
	}

	public String getCategoryName3() {
		return categoryName3;
	}

	public void setCategoryName3(String categoryName3) {
		this.categoryName3 = categoryName3;
	}

	public String getSpuCode() {
		return spuCode;
	}

	public void setSpuCode(String spuCode) {
		this.spuCode = spuCode;
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

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public Date getModifyTime() {
		return modifyTime;
	}

	public void setModifyTime(Date modifyTime) {
		this.modifyTime = modifyTime;
	}

	public BigDecimal getPrepayCardAmount() {
		return prepayCardAmount;
	}

	public void setPrepayCardAmount(BigDecimal prepayCardAmount) {
		this.prepayCardAmount = prepayCardAmount;
	}

	public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

	public static long getSerialVersionUID() {
		return serialVersionUID;
	}

	public BigDecimal getBuyNum() {
		return buyNum;
	}

	public void setBuyNum(BigDecimal buyNum) {
		this.buyNum = buyNum;
	}

	public BigDecimal getRefundNum() {
		return refundNum;
	}

	public void setRefundNum(BigDecimal refundNum) {
		this.refundNum = refundNum;
	}

	public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
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

	public String getAfterSalesOrderCode() {
        return afterSalesOrderCode;
    }

    public void setAfterSalesOrderCode(String afterSalesOrderCode) {
        this.afterSalesOrderCode = afterSalesOrderCode;
    }

    public BigDecimal getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(BigDecimal unitPrice) {
        this.unitPrice = unitPrice;
    }

    public BigDecimal getRealPrice() {
        return realPrice;
    }

    public void setRealPrice(BigDecimal realPrice) {
        this.realPrice = realPrice;
    }

    public String getStoreName() {
        return storeName;
    }

    public void setStoreName(String storeName) {
        this.storeName = storeName;
    }

    public String getStoreCode() {
        return storeCode;
    }

    public void setStoreCode(String storeCode) {
        this.storeCode = storeCode;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

	public BigDecimal getRefundAmount() {
		return refundAmount;
	}

	public void setRefundAmount(BigDecimal refundAmount) {
		this.refundAmount = refundAmount;
	}

	public BigDecimal getNormalRefundAmount() {
		return normalRefundAmount;
	}

	public void setNormalRefundAmount(BigDecimal normalRefundAmount) {
		this.normalRefundAmount = normalRefundAmount;
	}

	public BigDecimal getOrderAmount() {
		return orderAmount;
	}

	public void setOrderAmount(BigDecimal orderAmount) {
		this.orderAmount = orderAmount;
	}

	public BigDecimal getOrderAmountAfterDiscount() {
		return orderAmountAfterDiscount;
	}

	public void setOrderAmountAfterDiscount(BigDecimal orderAmountAfterDiscount) {
		this.orderAmountAfterDiscount = orderAmountAfterDiscount;
	}

	public BigDecimal getOrderDiscountAmount() {
		return orderDiscountAmount;
	}

	public void setOrderDiscountAmount(BigDecimal orderDiscountAmount) {
		this.orderDiscountAmount = orderDiscountAmount;
	}

	public BigDecimal getNormalPrepayAmount() {
		return normalPrepayAmount;
	}

	public void setNormalPrepayAmount(BigDecimal normalPrepayAmount) {
		this.normalPrepayAmount = normalPrepayAmount;
	}

	public BigDecimal getTotalNormalRefundAmount() {
		return totalNormalRefundAmount;
	}

	public void setTotalNormalRefundAmount(BigDecimal totalNormalRefundAmount) {
		this.totalNormalRefundAmount = totalNormalRefundAmount;
	}

	public BigDecimal getTotalRefundAmount() {
		return totalRefundAmount;
	}

	public void setTotalRefundAmount(BigDecimal totalRefundAmount) {
		this.totalRefundAmount = totalRefundAmount;
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
}
