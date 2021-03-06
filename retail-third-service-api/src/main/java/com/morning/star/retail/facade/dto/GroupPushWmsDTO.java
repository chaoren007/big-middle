package com.morning.star.retail.facade.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * 外部服务出库细表dto
 */
@ApiModel
public class GroupPushWmsDTO implements Serializable {
    private static final long serialVersionUID = 735382006815547012L;

    @ApiModelProperty(required = true, value = "采购入库单号")
    private String outStockCode;

    @ApiModelProperty(required = true, value = "货品编码")
    private String productCode;

    @ApiModelProperty(required = true, value = "采购数量")
    private BigDecimal qty;

    @ApiModelProperty(required = true, value = "分公司编码")
    private String storeCode;

    public String getOutStockCode() {
        return outStockCode;
    }

    public void setOutStockCode(String outStockCode) {
        this.outStockCode = outStockCode;
    }

    public String getProductCode() {
        return productCode;
    }

    public void setProductCode(String productCode) {
        this.productCode = productCode;
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
