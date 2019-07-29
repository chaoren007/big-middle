package com.morning.star.retail.pay.bean;

import java.io.Serializable;
import java.math.BigDecimal;

import com.morning.star.retail.pay.enums.PayChannel;
import com.morning.star.retail.pay.enums.ScanPayStatus;

public class ScanPayTradeResult implements Serializable {
	private static final long serialVersionUID = -42827642085383503L;

	private String code;		//	返回码
	private String msg;			//	返回码描述
	private String trade_no;	//  第三方交易号
	private String out_trade_no;	//	商户订单号
	private BigDecimal total_amount;//	交易金额，单位：分
	private PayChannel payChannel;
	
	public ScanPayTradeResult(){
	}
	
	public ScanPayTradeResult(String code, String msg){
		this.code = code;
		this.msg = msg;
	}
	
	public void setCode(String code) {
		this.code = code;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public String getCode() {
		return code;
	}
	public String getMsg() {
		return msg;
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

    public static ScanPayTradeResult error(String desc) {
        return new ScanPayTradeResult(ScanPayStatus.ERROR, desc);
    }
    public static ScanPayTradeResult fail(String desc) {
        return new ScanPayTradeResult(ScanPayStatus.FAIL, desc);
    }
    public static ScanPayTradeResult waiting(String desc) {
        return new ScanPayTradeResult(ScanPayStatus.WAITING, desc);
    }
	
	public static ScanPayTradeResult error() {
	    return new ScanPayTradeResult(ScanPayStatus.ERROR, "支付异常");
	}
	public static ScanPayTradeResult fail() {
	    return new ScanPayTradeResult(ScanPayStatus.FAIL, "支付失败");
	}
	public static ScanPayTradeResult waiting() {
	    return new ScanPayTradeResult(ScanPayStatus.WAITING, "等待支付");
	}
	public static ScanPayTradeResult succ() {
	    return new ScanPayTradeResult(ScanPayStatus.SUCC, "支付成功");
	}

}
