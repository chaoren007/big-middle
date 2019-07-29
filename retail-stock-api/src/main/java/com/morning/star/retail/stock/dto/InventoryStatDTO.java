package com.morning.star.retail.stock.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.math.BigDecimal;

@ApiModel(value = "盘点数量统计")
public class InventoryStatDTO implements Serializable {
    private static final long serialVersionUID = -8141872529794177353L;

    @ApiModelProperty(value = "货架数量")
    private BigDecimal shelfNum;

    @ApiModelProperty(value = "仓库数量")
    private BigDecimal warehouseNum;

    @ApiModelProperty(value = "调整数量")
    private BigDecimal adjustNum;

    @ApiModelProperty(value = "合计数量（货架数量+仓库数量+调整数量）")
    private BigDecimal totalNum;

    public BigDecimal getShelfNum() {
        return shelfNum;
    }

    public void setShelfNum(BigDecimal shelfNum) {
        this.shelfNum = shelfNum;
    }

    public BigDecimal getWarehouseNum() {
        return warehouseNum;
    }

    public void setWarehouseNum(BigDecimal warehouseNum) {
        this.warehouseNum = warehouseNum;
    }

    public BigDecimal getAdjustNum() {
        return adjustNum;
    }

    public void setAdjustNum(BigDecimal adjustNum) {
        this.adjustNum = adjustNum;
    }

    public BigDecimal getTotalNum() {
        return totalNum;
    }

    public void setTotalNum(BigDecimal totalNum) {
        this.totalNum = totalNum;
    }
}

