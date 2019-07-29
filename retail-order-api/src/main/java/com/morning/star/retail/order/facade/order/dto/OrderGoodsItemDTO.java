package com.morning.star.retail.order.facade.order.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.hibernate.validator.constraints.NotEmpty;

import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

@Data
public class OrderGoodsItemDTO implements Serializable {

    private static final long serialVersionUID = 1L;

    @NotEmpty(message = "商品code")
    @ApiModelProperty(value = "商品code", required = true)
    private String goodsCode;

    @ApiModelProperty(value = "商品名称")
    private String goodsName;

    @ApiModelProperty(value = "单位")
    private String unit;

    @ApiModelProperty(value = "条形码")
    private String upcCode;

    @ApiModelProperty(value = "商品规格")
    private String specInfo;

    @NotNull(message = "购买数量为空")
    @ApiModelProperty(value = "购买数量", required = true)
    private BigDecimal buyNum;

    @ApiModelProperty(value = "购买时间")
    private String buyTime;

    @ApiModelProperty(value = "商品原售单价")
    private BigDecimal originalPrice;

    @NotNull(message = "商品单价为空")
    @ApiModelProperty(value = "单价", required = true)
    private BigDecimal nowPrice;

    @ApiModelProperty(value = "商品(总)优惠金额")
    private BigDecimal discountAmount = BigDecimal.ZERO;


}
