package com.morning.star.retail.facade.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * 外部服务采购细表dto
 */
@ApiModel
public class PurchaseDetailWmsDTO implements Serializable {
    private static final long serialVersionUID = 735382006815547012L;

    @ApiModelProperty(required = true, value = "采购入库单号")
    private String purchaseInCode;

    @ApiModelProperty(required = true, value = "门店编码")
    private String storeCode;

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

    public String getPurchaseInCode() {
        return purchaseInCode;
    }

    public void setPurchaseInCode(String purchaseInCode) {
        this.purchaseInCode = purchaseInCode;
    }

    public String getStoreCode() {
        return storeCode;
    }

    public void setStoreCode(String storeCode) {
        this.storeCode = storeCode;
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
}
