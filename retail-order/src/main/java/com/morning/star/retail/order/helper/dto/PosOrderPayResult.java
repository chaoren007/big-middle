package com.morning.star.retail.order.helper.dto;

import java.math.BigDecimal;

import org.springframework.beans.BeanUtils;

import com.morning.star.retail.pay.bean.ScanPayTradeResult;
import com.morning.star.retail.pay.enums.PayChannel;
import com.morning.star.retail.pay.enums.ScanPayStatus;

public class PosOrderPayResult {

    private String code;        //  返回码
    private String msg;         //  返回码描述
    private String trade_no;    //  第三方交易号
    private String out_trade_no;    //  商户订单号
    private BigDecimal total_amount;//  交易金额，单位：分
    private PayChannel payChannel;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public String getTrade_no() {
        return trade_no;
    }

    public void setTrade_no(String trade_no) {
        this.trade_no = trade_no;
    }

    public String getOut_trade_no() {
        return out_trade_no;
    }

    public void setOut_trade_no(String out_trade_no) {
        this.out_trade_no = out_trade_no;
    }

    public BigDecimal getTotal_amount() {
        return total_amount;
    }

    public void setTotal_amount(BigDecimal total_amount) {
        this.total_amount = total_amount;
    }

    public PayChannel getPayChannel() {
        return payChannel;
    }

    public void setPayChannel(PayChannel payChannel) {
        this.payChannel = payChannel;
    }

    public static PosOrderPayResult from(ScanPayTradeResult result) {
        PosOrderPayResult r = new PosOrderPayResult();
        BeanUtils.copyProperties(result, r);
        return r;
    }

    public boolean isSucc() {
        return ScanPayStatus.SUCC.equals(code);
    }

    public boolean isFail() {
        return ScanPayStatus.FAIL.equals(code);
    }
}
