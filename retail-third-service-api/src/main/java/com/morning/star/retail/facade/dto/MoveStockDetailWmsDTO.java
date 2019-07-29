package com.morning.star.retail.facade.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * 外部服务移库细表dto（推送类型：3-其他入库单接口，2-移库单接口）
 */
@ApiModel
public class MoveStockDetailWmsDTO implements Serializable {
    private static final long serialVersionUID = 735382006815547012L;

    @ApiModelProperty(required = true, value = "单据单号")
    private String pushCode;

    @ApiModelProperty(required = true, value = "货品编码")
    private String productCode;

    @ApiModelProperty(required = true, value = "货品名称")
    private String productName;

    @ApiModelProperty(required = true, value = "最小配送单位")
    private String units;

    @ApiModelProperty(required = true, value = "采购数量")
    private BigDecimal qty;

    @ApiModelProperty(required = true, value = "分公司编码")
    private String storeCode;

    public String getPushCode() {
        return pushCode;
    }

    public void setPushCode(String pushCode) {
        this.pushCode = pushCode;
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

    public String getUnits() {
        return units;
    }

    public void setUnits(String units) {
        this.units = units;
    }

    public BigDecimal getQty() {
        return qty;
    }

    public void setQty(BigDecimal qty) {
        this.qty = qty;
    }

    public String getStoreCode() {
        return storeCode;
    }

    public void setStoreCode(String storeCode) {
        this.storeCode = storeCode;
    }
}
