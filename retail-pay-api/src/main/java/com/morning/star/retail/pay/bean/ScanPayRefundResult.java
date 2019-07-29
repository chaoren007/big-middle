package com.morning.star.retail.pay.bean;

import java.io.Serializable;

public class ScanPayRefundResult implements Serializable {
    /**
     * 
     */
    private static final long serialVersionUID = 1L;
    
    private String code;        //  返回码			SUCC、FAIL、REFUNDING
    private String msg;         //  返回码描述
	private String transactionId;	//平台退款编号
    
    public ScanPayRefundResult() {
    }
    public ScanPayRefundResult(String code, String msg) {
        this.code = code;
        this.msg = msg;
    }
    public String getCode() {
        return code;
    }
    public String getMsg() {
        return msg;
    }
    
    
    public String getTransactionId() {
		return transactionId;
	}
	public void setTransactionId(String transactionId) {
		this.transactionId = transactionId;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	public static ScanPayRefundResult succ() {
        return new ScanPayRefundResult("SUCC", "退款成功");
    }
    public static ScanPayRefundResult fail() {
        return new ScanPayRefundResult("FAIL", "退款失败");
    }
    
    public static ScanPayRefundResult refunding() {
        return new ScanPayRefundResult("REFUNDING", "退款中");
    }
    
    public static ScanPayRefundResult error() {
        return new ScanPayRefundResult("ERROR", "退款异常");
    }
    public static ScanPayRefundResult error(String desc) {
        return new ScanPayRefundResult("ERROR", desc);
    }
    public static ScanPayRefundResult fail(String desc) {
        return new ScanPayRefundResult("FAIL", desc);
    }

}
