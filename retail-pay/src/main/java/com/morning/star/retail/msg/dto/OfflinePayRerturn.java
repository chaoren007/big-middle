package com.morning.star.retail.msg.dto;

import org.apache.commons.lang3.StringUtils;

/**
 * 支付后返回的数据
 * @author Administrator
 *
 */
public class OfflinePayRerturn {
	private String nonce_str;
	private String fee_type;
	private String uuid;
	private String total_fee;
	private String time_end;
	private String transaction_id;
	private String bank_type;
	private String pay_result;
	private String out_trade_no;
	private String trade_type;

	private String result_code;
	private String status;
	
	
	private String need_query;
	private String code;
	private String err_code;
	private String err_msg;
	public String getNonce_str() {
		return nonce_str;
	}
	public void setNonce_str(String nonce_str) {
		this.nonce_str = nonce_str;
	}
	public String getFee_type() {
		return fee_type;
	}
	public void setFee_type(String fee_type) {
		this.fee_type = fee_type;
	}
	public String getUuid() {
		return uuid;
	}
	public void setUuid(String uuid) {
		this.uuid = uuid;
	}
	public String getTotal_fee() {
		return total_fee;
	}
	public void setTotal_fee(String total_fee) {
		this.total_fee = total_fee;
	}
	public String getTime_end() {
		return time_end;
	}
	public void setTime_end(String time_end) {
		this.time_end = time_end;
	}
	public String getTransaction_id() {
		return transaction_id;
	}
	public void setTransaction_id(String transaction_id) {
		this.transaction_id = transaction_id;
	}
	public String getBank_type() {
		return bank_type;
	}
	public void setBank_type(String bank_type) {
		this.bank_type = bank_type;
	}
	public String getPay_result() {
		return pay_result;
	}
	public void setPay_result(String pay_result) {
		this.pay_result = pay_result;
	}
	public String getOut_trade_no() {
		return out_trade_no;
	}
	public void setOut_trade_no(String out_trade_no) {
		this.out_trade_no = out_trade_no;
	}
	public String getTrade_type() {
		return trade_type;
	}
	public void setTrade_type(String trade_type) {
		this.trade_type = trade_type;
	}
	public String getResult_code() {
		return result_code;
	}
	public void setResult_code(String result_code) {
		this.result_code = result_code;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getNeed_query() {
		return need_query;
	}
	public void setNeed_query(String need_query) {
		this.need_query = need_query;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
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
	@Override
	public String toString() {
		return "OfflinePayRerturn [nonce_str=" + nonce_str + ", fee_type=" + fee_type + ", uuid=" + uuid
				+ ", total_fee=" + total_fee + ", time_end=" + time_end + ", transaction_id=" + transaction_id
				+ ", bank_type=" + bank_type + ", pay_result=" + pay_result + ", out_trade_no=" + out_trade_no
				+ ", trade_type=" + trade_type + ", result_code=" + result_code + ", status=" + status + ", need_query="
				+ need_query + ", code=" + code + ", err_code=" + err_code + ", err_msg=" + err_msg + "]";
	}
	public boolean checkSucc() {
		return this.getResult_code() != null && this.getResult_code().equals("0") && this.getPay_result() != null
				&& this.getPay_result().equals("0") && this.getNeed_query() == null;
	}
	public boolean checkPaying() {
		if(StringUtils.isNotBlank(this.getNeed_query()) && this.getNeed_query().equals("Y")){
			return true;
		}
		if(StringUtils.isNotBlank(this.getErr_code()) && 			//系统返回支付结果未知，统一成支付中，需查询
					(	this.getErr_code().equals("SYSTEMERROR") ||
						this.getErr_code().equals("Internal error") ||  
						this.getErr_code().equals("BANKERROR") ||  
						this.getErr_code().equals("10003") ||  
						this.getErr_code().equals("USERPAYING") ||  
						this.getErr_code().equals("ACQ.SYSTEM_ERROR") ||  
						this.getErr_code().equals("aop.ACQ.SYSTEM_ERROR")
						)){
			 return true;
		}
		return false;
	}
	
	
	
	
}
