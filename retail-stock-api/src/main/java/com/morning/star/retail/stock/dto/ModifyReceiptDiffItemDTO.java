package com.morning.star.retail.stock.dto;

import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * Created by kimhuhg.
 */
public class ModifyReceiptDiffItemDTO implements Serializable {
    private static final long serialVersionUID = 4641390325344723431L;

    @NotNull(message = "货品编码不能为空")
    @ApiModelProperty(value = "货品编码")
    private String goodsCode;

    @NotNull(message = "差异数量不能为空")
    @ApiModelProperty(value = "差异数量")
    private BigDecimal differenceQty;

    @NotNull(message = "差异原因不能为空")
    @ApiModelProperty(value = "差异原因")
    private String diffReason;

    public String getGoodsCode() {
        return goodsCode;
    }

    public void setGoodsCode(String goodsCode) {
        this.goodsCode = goodsCode;
    }

    public BigDecimal getDifferenceQty() {
        return differenceQty;
    }

    public void setDifferenceQty(BigDecimal differenceQty) {
        this.differenceQty = differenceQty;
    }

    public String getDiffReason() {
        return diffReason;
    }

    public void setDiffReason(String diffReason) {
        this.diffReason = diffReason;
    }
}
