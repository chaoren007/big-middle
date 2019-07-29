package com.morning.star.retail.order.facade.order.resp;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

@Data
public class Model2Vo implements Serializable {

    @ApiModelProperty("销售订单笔数")
    private Integer salesOrderNum;

    @ApiModelProperty("销售金额")
    private BigDecimal salesAmount;

    @ApiModelProperty("收入明细")
    private List<Map<String, String>> payList;
}
