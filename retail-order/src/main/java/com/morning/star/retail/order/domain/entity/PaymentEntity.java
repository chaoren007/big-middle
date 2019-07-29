package com.morning.star.retail.order.domain.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Comment;
import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.springframework.data.annotation.CreatedDate;

import com.morning.star.retail.order.enums.PaymentStatus;
import com.morning.star.retail.pay.enums.PayChannel;

import lombok.Data;

/**
 * 支付信息
 *
 * @author Tim
 */
@Entity
@Table(name = "order_payment_info")
@Data
public class PaymentEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "pay_code")
    @SequenceGenerator(name = "pay_code", sequenceName = "pay_code", allocationSize = 1)
    @Comment("支付编号")
    private String payCode;

    @Column(precision = 19, scale = 3, nullable = false)
    @Comment("支付金额")
    private BigDecimal payAmount;

    @Column(length = 2, nullable = true)
    @Convert(converter = PayChannel.Convert.class)
    @Comment("支付方式： CASH(0,现金支付),ALI(1,支付宝支付),WX(2,微信支付),YZF(3,翼支付),UNION(4,银联支付),PERPAY(5,预付卡),HBPAY(6,和包支付),JDPAY(7,京东支付),QQPAY(8,QQ钱包支付),OTHERPAY(101,其他支付) ")
    private PayChannel payChannel;

    @Column(length = 2, nullable = false)
    @Convert(converter = PaymentStatus.Convert.class)
    @Comment("支付状态： PAY_WAIT(0 等待支付) PAY_ING(1 支付中) PAY_SUCC(2 支付成功) PAY_FAIL(3 支付失败) ")
    private PaymentStatus payStatus;

    @CreatedDate
    private Date payTime;

    @Column(length = 50, nullable = true)
    @Comment("支付流水")
    private String payTradeNo;

    private String orderCode;

}
