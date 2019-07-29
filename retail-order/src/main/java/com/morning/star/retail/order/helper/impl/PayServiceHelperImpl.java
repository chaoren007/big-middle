package com.morning.star.retail.order.helper.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.morning.star.retail.order.helper.PayServiceHelper;
import com.morning.star.retail.order.helper.dto.PosOrderPayResult;
import com.morning.star.retail.pay.bean.ScanPay;
import com.morning.star.retail.pay.bean.ScanPayTradeResult;
import com.morning.star.retail.pay.service.ScanPayRemoteService;


@Service
public class PayServiceHelperImpl implements PayServiceHelper {
    @Autowired
    private ScanPayRemoteService scanPayService;


    /**
     * 聚合支付  扫码支付
     */
    @Override
    public PosOrderPayResult offlineScanPay(ScanPay scanPay) {
        ScanPayTradeResult result = scanPayService.offlineScanPay(scanPay);
        return PosOrderPayResult.from(result);
    }

}