package com.morning.star.retail.stock.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.math.BigDecimal;

@ApiModel(value = "盘点调整")
public class InventoryAdjustDTO implements Serializable {
    private static final long serialVersionUID = -8141872529794177353L;

    @ApiModelProperty("盘点编码")
    @NotNull(message = "盘点编码不能为空")
    private String inventoryCode;

    @ApiModelProperty("商品编码")
    @NotNull(message = "商品编码不能为空")
    private String goodsCode;

    @ApiModelProperty("调整数量")
    @NotNull(message = "调整数量不能为空")
    private BigDecimal adjustNum;

    @ApiModelProperty("备注（调整原因）")
    @NotNull(message = "调整原因不能为空")
    private String remark;

    private Long operatorId;

    private String operatorName;

    public String getInventoryCode() {
        return inventoryCode;
    }

    public void setInventoryCode(String inventoryCode) {
        this.inventoryCode = inventoryCode;
    }

    public String getGoodsCode() {
        return goodsCode;
    }

    public void setGoodsCode(String goodsCode) {
        this.goodsCode = goodsCode;
    }

    public BigDecimal getAdjustNum() {
        return adjustNum;
    }

    public void setAdjustNum(BigDecimal adjustNum) {
        this.adjustNum = adjustNum;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public Long getOperatorId() {
        return operatorId;
    }

    public void setOperatorId(Long operatorId) {
        this.operatorId = operatorId;
    }

    public String getOperatorName() {
        return operatorName;
    }

    public void setOperatorName(String operatorName) {
        this.operatorName = operatorName;
    }
}

