package com.morning.star.retail.facade.dto.receipt;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import javax.validation.constraints.NotNull;

import io.swagger.annotations.ApiModelProperty;

/**
 * Created by kimhuhg on 2018/8/4.
 */
public class SureReceiptDTO implements Serializable {
    private static final long serialVersionUID = 700733871275750587L;
    @NotNull(message = "商品编码不能为空")
    @ApiModelProperty(value = "商品编码", required = true)
    private String goodsCode;

    @NotNull(message = "入库数量不能为空")
    @ApiModelProperty(value = "入库数量数量",required = true)
    private BigDecimal qty;

    @ApiModelProperty(value = "生产日期",required = true)
    private Date productionDate;

    @ApiModelProperty(value = "保质期",required = true)
    private Integer shelfLife;

    public String getGoodsCode() {
        return goodsCode;
    }

    public void setGoodsCode(String goodsCode) {
        this.goodsCode = goodsCode;
    }

    public BigDecimal getQty() {
        return qty;
    }

    public void setQty(BigDecimal qty) {
        this.qty = qty;
    }

    public Date getProductionDate() {
        return productionDate;
    }

    public void setProductionDate(Date productionDate) {
        this.productionDate = productionDate;
    }

    public Integer getShelfLife() {
        return shelfLife;
    }

    public void setShelfLife(Integer shelfLife) {
        this.shelfLife = shelfLife;
    }
}
