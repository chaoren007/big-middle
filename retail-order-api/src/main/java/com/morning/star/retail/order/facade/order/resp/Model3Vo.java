package com.morning.star.retail.order.facade.order.resp;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;

@Data
public class Model3Vo implements Serializable {

    @ApiModelProperty("退款金额")
    private BigDecimal totalRefundAmount;

    @ApiModelProperty("退货单数")
    private BigDecimal refundNum;

}
