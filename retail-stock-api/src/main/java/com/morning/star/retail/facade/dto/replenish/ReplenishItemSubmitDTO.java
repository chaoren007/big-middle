package com.morning.star.retail.facade.dto.replenish;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.math.BigDecimal;

@ApiModel(value = "补货明细")
public class ReplenishItemSubmitDTO implements Serializable {
    private static final long serialVersionUID = -7647192255319381108L;

    @NotNull(message = "货品编码不能为空")
    @ApiModelProperty(value = "货品编码")
    private String goodsCode;

    @NotNull(message = "补货数量不能为空")
    @DecimalMin(value = "0.01", message = "补货数量不能小于0.01")
    @ApiModelProperty(value = "补货数量")
    private BigDecimal replenishNum;

    @ApiModelProperty(value = "仓库编码")
    private String warehouseCode;

    public String getGoodsCode() {
        return goodsCode;
    }

    public void setGoodsCode(String goodsCode) {
        this.goodsCode = goodsCode;
    }

    public BigDecimal getReplenishNum() {
        return replenishNum;
    }

    public void setReplenishNum(BigDecimal replenishNum) {
        this.replenishNum = replenishNum;
    }

    public String getWarehouseCode() {
        return warehouseCode;
    }

    public void setWarehouseCode(String warehouseCode) {
        this.warehouseCode = warehouseCode;
    }
}
