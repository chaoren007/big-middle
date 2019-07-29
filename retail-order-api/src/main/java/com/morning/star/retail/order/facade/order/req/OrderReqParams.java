package com.morning.star.retail.order.facade.order.req;

import com.morning.star.retail.order.enums.SalesOrderStatus;
import com.morning.star.retail.order.enums.SalesOrderType;
import com.morning.star.retail.order.facade.order.dto.BuyerDTO;
import com.morning.star.retail.order.facade.order.dto.OrderGoodsItemDTO;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.hibernate.validator.constraints.NotBlank;

import javax.persistence.*;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;


@Data
public class OrderReqParams implements Serializable {

    private static final long serialVersionUID = -5268811672162282752L;

    @NotBlank (message = "订单号入参为空")
    @ApiModelProperty(value = "订单号", required = true)
    private String orderCode;

    @NotNull (message = "订单下单时间")
    @ApiModelProperty(value = "下单时间", required = true)
    private Date orderTime;

    @NotNull(message = "订单金额入参为空")
    @ApiModelProperty(value = "订单商品总实际金额", required = true)
    private BigDecimal totalAmount;

    @NotNull(message = "优惠金额入参为空")
    @ApiModelProperty(value = "优惠金额", required = true)
    private BigDecimal discountAmount;

    @ApiModelProperty(value = "购买备注")
    private String buyRemark;

    @ApiModelProperty(value = "特殊优惠金额")
    private BigDecimal discountSpecial = BigDecimal.ZERO;

    @ApiModelProperty(value = "登陆信息", hidden = true)
    private LoginParams loginParams = new LoginParams();

    @ApiModelProperty(value = "购买人")
    private BuyerDTO buyer;

    @Valid
    @NotNull(message = "商品列表为空")
    @ApiModelProperty(value = "商品列表", required = true)
    private List<OrderGoodsItemDTO> goodsItems;
}



