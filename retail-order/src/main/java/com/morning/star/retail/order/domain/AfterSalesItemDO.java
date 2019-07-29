package com.morning.star.retail.order.domain;

import java.math.BigDecimal;
import java.util.Date;

/**
 * 售后退货货品
 * Created by liangguobin on 2017/5/19.
 */
public class AfterSalesItemDO {
    private long id;
    private Integer buyNum;

    private Integer refundNum;  				// 退回数量
    private String code;   					// 货品code
    private String image;
    private String name;
    private String afterSalesOrderCode; 	// 售后订单code
    private String orderCode;   			// 订单code
    private BigDecimal originalPrice;	
    private BigDecimal unitPrice;
    private BigDecimal realPrice;
    private String unit;

    private Date createTime;
    private Date modifyTime;

    private Integer brandId;		//品牌ID
    private String brandName;		//品牌名字
	private Long categoryId1;		//一级分类ID
	private String categoryName1;	//一级分类名字
	private Long categoryId2;		//二级分类ID
	private String categoryName2;	//二级分类名字
	private Long categoryId3;		//三级分类ID
	private String categoryName3;	//三级分类名字
	private String upcCode;			//商品UPC编码
	private String spuCode;			//商品规格编码
	private String specValue1;		//商品品规格1
	private String specValue2;		//商品品规格2
	private String specValue3;		//商品品规格3
    
	private BigDecimal discountAmount;	//所退款商品占订单项优惠金额的优惠份额

    private String supplierName;        //供应商名字
    private String supplierCode;        //供应商编码

	private BigDecimal refundAmount = BigDecimal.ZERO;
	private BigDecimal prepayCardAmount = BigDecimal.ZERO;	//退款单项的预付卡金额
	private BigDecimal normalRefundAmount;      // 正常情况下退款金额    系统计算
	private BigDecimal normalPrepayAmount;		// 正常情况下退的预付卡    系统计算

    public String getSupplierName() {
        return supplierName;
    }

    public void setSupplierName(String supplierName) {
        this.supplierName = supplierName;
    }

    public String getSupplierCode() {
        return supplierCode;
    }

    public void setSupplierCode(String supplierCode) {
        this.supplierCode = supplierCode;
    }

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

	public String getUpcCode() {
		return upcCode;
	}

	public void setUpcCode(String upcCode) {
		this.upcCode = upcCode;
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

    public Integer getBuyNum() {
        return buyNum;
    }

    public void setBuyNum(Integer buyNum) {
        this.buyNum = buyNum;
    }

    public Integer getRefundNum() {
        return refundNum;
    }

    public void setRefundNum(Integer refundNum) {
        this.refundNum = refundNum;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public String getOrderCode() {
        return orderCode;
    }

    public void setOrderCode(String orderCode) {
        this.orderCode = orderCode;
    }

    public BigDecimal getRefundAmount() {
        return refundAmount;
    }

    public void setRefundAmount(BigDecimal refundAmount) {
        this.refundAmount = refundAmount;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

	public BigDecimal getNormalRefundAmount() {
		return normalRefundAmount;
	}

	public void setNormalRefundAmount(BigDecimal normalRefundAmount) {
		this.normalRefundAmount = normalRefundAmount;
	}

	public BigDecimal getNormalPrepayAmount() {
		return normalPrepayAmount;
	}

	public void setNormalPrepayAmount(BigDecimal normalPrepayAmount) {
		this.normalPrepayAmount = normalPrepayAmount;
	}
}
