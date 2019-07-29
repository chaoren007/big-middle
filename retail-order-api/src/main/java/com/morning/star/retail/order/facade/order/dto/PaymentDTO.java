package com.morning.star.retail.order.facade.order.dto;

import com.morning.star.retail.order.enums.PayChannel;
import com.morning.star.retail.order.enums.PaymentStatus;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.hibernate.validator.constraints.NotEmpty;

import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

@Data
public class PaymentDTO implements Serializable {

    @NotNull(message = "支付金额")
    @ApiModelProperty(value = "支付金额", required = true)
    private BigDecimal payAmount;

    @NotNull(message = "支付方式")
    @ApiModelProperty(value = "支付方式： CASH(0,现金支付),ALI(1,支付宝支付),WX(2,微信支付),YZF(3,翼支付),UNION(4,银联支付),PERPAY(5,预付卡),HBPAY(6,和包支付),JDPAY(7,京东支付),QQPAY(8,QQ钱包支付),OTHERPAY(101,其他支付) ", required = true)
    private PayChannel payChannel;

    @NotNull(message = "支付状态")
    @ApiModelProperty(value = "支付状态： PAY_WAIT(0 等待支付) PAY_ING(1 支付中) PAY_SUCC(2 支付成功) PAY_FAIL(3 支付失败)", required = true)
    private PaymentStatus payStatus;

    @NotNull(message = "支付时间")
    @ApiModelProperty(value = "支付时间", required = true)
    private String payTime;

    @NotEmpty(message = "支付流水号")
    @ApiModelProperty(value = "支付流水号", required = true)
    private String payTradeNo;

    @ApiModelProperty(value = "第三方支付流水号，现金可不传。")
    private String thirdPayTradeNo;
}
