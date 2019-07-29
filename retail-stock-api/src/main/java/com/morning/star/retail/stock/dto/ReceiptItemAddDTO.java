package com.morning.star.retail.stock.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

@ApiModel(value = "入库明细")
public class ReceiptItemAddDTO implements Serializable {
    private static final long serialVersionUID = 4641390325344723431L;

    @ApiModelProperty(value = "商品编码")
    private String productCode;

    @ApiModelProperty(value = "入库数量")
    private BigDecimal num;

    @ApiModelProperty(value = "生产日期")
    private Date productionDate;

    public String getProductCode() {
        return productCode;
    }

    public void setProductCode(String productCode) {
        this.productCode = productCode;
    }

    public BigDecimal getNum() {
        return num;
    }

    public void setNum(BigDecimal num) {
        this.num = num;
    }

    public Date getProductionDate() {
        return productionDate;
    }

    public void setProductionDate(Date productionDate) {
        this.productionDate = productionDate;
    }
}
