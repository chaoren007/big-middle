package com.morning.star.retail.facade.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * 外部服务采购细表dto
 */
@ApiModel
public class PurchaseDetailSubmitWmsDTO implements Serializable {
    private static final long serialVersionUID = 735382006815547012L;

    @ApiModelProperty(required = true, value = "货品编码")
    private String productCode;

    @ApiModelProperty(required = true, value = "货品名称")
    private String productName;

    @ApiModelProperty(required = true, value = "单位名称")
    private String unitsName;

    @ApiModelProperty(required = true, value = "采购数量")
    private BigDecimal qty;

    @ApiModelProperty(required = true, value = "采购单价（含税）")
    private BigDecimal ratePrice;

    @ApiModelProperty(required = true, value = "采购总价（含税）")
    private BigDecimal rateAmount;

    @ApiModelProperty(required = true, value = "规格信息")
    private String spuInfo;

    @ApiModelProperty(value = "是否允许过期收货（0：不允许，1：允许）")
    private Integer expiredAllow = 0;

    public PurchaseDetailSubmitWmsDTO() {
    }

    public PurchaseDetailSubmitWmsDTO(String productCode, String productName, String unitsName, BigDecimal qty, BigDecimal ratePrice, BigDecimal rateAmount, String spuInfo, Integer expiredAllow) {
        this.productCode = productCode;
        this.productName = productName;
        this.unitsName = unitsName;
        this.qty = qty;
        this.ratePrice = ratePrice;
        this.rateAmount = rateAmount;
        this.spuInfo = spuInfo;
        this.expiredAllow = expiredAllow;
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

    public String getUnitsName() {
        return unitsName;
    }

    public void setUnitsName(String unitsName) {
        this.unitsName = unitsName;
    }

    public BigDecimal getQty() {
        return qty;
    }

    public void setQty(BigDecimal qty) {
        this.qty = qty;
    }

    public BigDecimal getRatePrice() {
        return ratePrice;
    }

    public void setRatePrice(BigDecimal ratePrice) {
        this.ratePrice = ratePrice;
    }

    public BigDecimal getRateAmount() {
        return rateAmount;
    }

    public void setRateAmount(BigDecimal rateAmount) {
        this.rateAmount = rateAmount;
    }

    public String getSpuInfo() {
        return spuInfo;
    }

    public void setSpuInfo(String spuInfo) {
        this.spuInfo = spuInfo;
    }

    public Integer getExpiredAllow() {
        return expiredAllow;
    }

    public void setExpiredAllow(Integer expiredAllow) {
        this.expiredAllow = expiredAllow;
    }
}
