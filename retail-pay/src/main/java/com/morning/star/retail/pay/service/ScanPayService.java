package com.morning.star.retail.pay.service;

import java.math.BigDecimal;

import com.morning.star.retail.pay.bean.ScanPay;
import com.morning.star.retail.pay.bean.ScanPayRefundResult;
import com.morning.star.retail.pay.bean.ScanPayTradeResult;

public interface ScanPayService {
	/**
	 * 聚合支付扫码支付
	 * @param scanPay
	 * @return
	 */
	public ScanPayTradeResult offlineScanPay(ScanPay scanPay);
	
	/**
	 * 查询聚合支付的结果
	 * @param merchantCode,
	 * @param payBillCode
	 * @return
	 */
	public ScanPayTradeResult getOfflineScanPayResult(String merchantCode,String payBillCode);
	
	/**
	 * 聚合支付退款接口
	 * @param payBillCode		原支付单号   retail_order表的payment_code字段
	 * @param refundCode		退款单号（如退款失败，继续复用这个code）
	 * @param refundAmount		退款金额   （支持部分退款  单位：元）
	 * @return
	 */
	public ScanPayRefundResult offlineRefundScanPayBill(String payBillCode, String refundCode,
			BigDecimal refundAmount);


}
