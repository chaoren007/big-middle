package com.morning.star.retail.order.facade.order.req;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Comment;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.math.BigDecimal;

@Data
public class ApplyRefundGoodsReqParams implements Serializable{

    @ApiModelProperty(value = "商品Code", required = true)
    @NotNull
    private String goodsCode;

    @ApiModelProperty(value = "退回数量", required = true)
    @NotNull
    private BigDecimal refundNum;

    @ApiModelProperty(value = "原付金额", required = true)
    @NotNull
    private BigDecimal originalPayAmount;

    @ApiModelProperty(value = "应退金额", required = true)
    @NotNull
    private BigDecimal shouldRefundAmount;

    @ApiModelProperty(value = "备注", required = true)
    private BigDecimal remark;
}
