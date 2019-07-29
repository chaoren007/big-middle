package com.morning.star.retail.order.helper;

import com.morning.star.retail.order.helper.dto.PosOrderPayResult;
import com.morning.star.retail.pay.bean.ScanPay;

public interface PayServiceHelper {

    /**
     * 线下聚合扫码支付
     * @param scanPay
     * @return
     */
    PosOrderPayResult offlineScanPay(ScanPay scanPay);
}
