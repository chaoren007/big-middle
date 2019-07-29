package com.morning.star.retail.order.facade.order.req;

import com.morning.star.retail.order.enums.RefundType;
import com.morning.star.retail.order.facade.order.dto.BuyerDTO;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;


@Data
public class ApplyRefundReqParams implements Serializable {


    @ApiModelProperty(value = "订单Code", required = true)
    @NotNull(message = "订单编号不能为空")
    private String orderCode;

    @ApiModelProperty(value = "售后Code", required = true)
    @NotNull(message = "售后编号不能为空")
    private String afterSalesCode;

    @ApiModelProperty(value = "退款金额", required = true)
    @NotNull(message = "退款金额不能为空")
    private BigDecimal refundAmount;

    @ApiModelProperty(value = "退款类型", required = true)
    @NotNull(message = "退款类型不能为空")
    private RefundType refundType;

    @ApiModelProperty(value = "退款备注")
    private String refundReason;

    @ApiModelProperty(value = "申请人")
    private BuyerDTO buyer;

    @ApiModelProperty(value = "申请提交工作人员登陆信息")
    private LoginParams loginParams;

    @ApiModelProperty(value = "申请时间")
    private Date applyTime;

    @ApiModelProperty(value = "订单金额")
    private BigDecimal orderAmount;

    @Valid
    @NotNull(message = "退款商品不能为空")
    @ApiModelProperty(value = "商品列表", required = true)
    private List<ApplyRefundGoodsReqParams> refundGoods;

}
