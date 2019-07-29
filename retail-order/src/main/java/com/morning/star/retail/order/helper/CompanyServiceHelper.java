package com.morning.star.retail.order.helper;

public interface CompanyServiceHelper {

    /**
     * 获取支付的商户号
     * @param groupCode
     * @return
     */
    String getPayMerchantCode(String groupCode);

}
