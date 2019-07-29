package com.morning.star.retail.order.facade.order.resp;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

@Data
public class Model1Vo implements Serializable {

    @ApiModelProperty("实际收入")
    private BigDecimal realIncome;

    @ApiModelProperty("收入明细")
    private List<Map<String, String>> payList;

}
