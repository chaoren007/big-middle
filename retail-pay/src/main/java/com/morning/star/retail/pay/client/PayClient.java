package com.morning.star.retail.pay.client;

import com.morning.star.retail.pay.bean.ScanPay;
import com.morning.star.retail.pay.bean.ScanPayRefundResult;
import com.morning.star.retail.pay.bean.ScanPayTradeResult;

public interface PayClient {

    ScanPayTradeResult scanPay(ScanPay payOrder);

    ScanPayTradeResult queryPayResult(String out_trade_no);

    ScanPayRefundResult cancelPay(String out_trade_no);

}
