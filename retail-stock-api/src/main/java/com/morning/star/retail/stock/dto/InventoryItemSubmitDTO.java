package com.morning.star.retail.stock.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.math.BigDecimal;

@ApiModel(value = "提交盘点明细")
public class InventoryItemSubmitDTO implements Serializable {
    private static final long serialVersionUID = 4282583588982141892L;

    @ApiModelProperty(required = true, value = "商品编码")
    private String goodsCode;

    @ApiModelProperty(required = true, value = "盘点数量")
    private BigDecimal num;

    @ApiModelProperty(required = true, value = "货架/仓库区域编号")
    private String areaNo;

    public String getGoodsCode() {
        return goodsCode;
    }

    public void setGoodsCode(String goodsCode) {
        this.goodsCode = goodsCode;
    }

    public BigDecimal getNum() {
        return num;
    }

    public void setNum(BigDecimal num) {
        this.num = num;
    }

    public String getAreaNo() {
        return areaNo;
    }

    public void setAreaNo(String areaNo) {
        this.areaNo = areaNo;
    }
}
