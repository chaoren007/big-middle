package com.morning.star.retail.msg.dto;

/**
 * 订单撤销返回的数据
 * @author Administrator
 *
 */
public class OffineRevokeReturn {
	
	private String transaction_id;		//平台的订单ID
	private String nonce_str;		//随机字符串
	private String retry_flag;	//重试标志
	private String out_trade_no;	//商户支付单号
	private String action;			//当前操作
	private String trade_type;		//支付渠道
	private String status;		//返回状态码	0表示成功非0表示失败此字段是通信标识，非交易标识，交易是否成功需要查看 result_code 来判断
	private String result_code;	//业务结果		0表示成功，非0表示失败；0表示关单成功
	private String message;		//返回信息		
	private String mch_id;		//商户号
	private String err_code;	//错误代码
	private String err_msg;		//错误代码描述
	private String sign;		//签名
	
	
	public String getTransaction_id() {
		return transaction_id;
	}
	public void setTransaction_id(String transaction_id) {
		this.transaction_id = transaction_id;
	}
	public String getNonce_str() {
		return nonce_str;
	}
	public void setNonce_str(String nonce_str) {
		this.nonce_str = nonce_str;
	}
	public String getRetry_flag() {
		return retry_flag;
	}
	public void setRetry_flag(String retry_flag) {
		this.retry_flag = retry_flag;
	}
	public String getOut_trade_no() {
		return out_trade_no;
	}
	public void setOut_trade_no(String out_trade_no) {
		this.out_trade_no = out_trade_no;
	}
	public String getAction() {
		return action;
	}
	public void setAction(String action) {
		this.action = action;
	}
	public String getTrade_type() {
		return trade_type;
	}
	public void setTrade_type(String trade_type) {
		this.trade_type = trade_type;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getResult_code() {
		return result_code;
	}
	public void setResult_code(String result_code) {
		this.result_code = result_code;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public String getMch_id() {
		return mch_id;
	}
	public void setMch_id(String mch_id) {
		this.mch_id = mch_id;
	}
	public String getErr_code() {
		return err_code;
	}
	public void setErr_code(String err_code) {
		this.err_code = err_code;
	}
	public String getErr_msg() {
		return err_msg;
	}
	public void setErr_msg(String err_msg) {
		this.err_msg = err_msg;
	}
	public String getSign() {
		return sign;
	}
	public void setSign(String sign) {
		this.sign = sign;
	}
	
	
	
	

}
