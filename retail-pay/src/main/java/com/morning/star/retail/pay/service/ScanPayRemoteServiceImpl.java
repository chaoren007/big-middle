package com.morning.star.retail.pay.service;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.morning.star.retail.pay.bean.ScanPay;
import com.morning.star.retail.pay.bean.ScanPayRefundResult;
import com.morning.star.retail.pay.bean.ScanPayTradeResult;

@Service
public class ScanPayRemoteServiceImpl implements ScanPayRemoteService {
	
	@Autowired
	private ScanPayService scanPayService;

    /**
     * 聚合支付  扫码支付
     */
	@Override
	public ScanPayTradeResult offlineScanPay(ScanPay scanPay) {
		return scanPayService.offlineScanPay(scanPay);
	}

	/**
	 * 查询聚合支付的结果
	 */
	@Override
	public ScanPayTradeResult getOfflineScanPayResult(String merchantCode,String payBillCode) {
		return scanPayService.getOfflineScanPayResult(merchantCode, payBillCode);
	}
	/**
	 * 聚合支付退款
	 */
	@Override
	public ScanPayRefundResult offlineRefundScanPayBill(String payBillCode, String refundCode,
			BigDecimal refundAmount) {
		return scanPayService.offlineRefundScanPayBill(payBillCode,refundCode,refundAmount);
	}



}
