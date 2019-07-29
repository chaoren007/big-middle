package com.morning.star.retail.order.logicservice;

import com.morning.star.retail.order.facade.dto.OfflineOrderPayFormDTO;
import com.morning.star.retail.order.facade.dto.OfflineOrderPayResultDTO;
import com.morning.star.retail.order.facade.dto.PosOrderPayResultDTO;

public interface OrderPayLogicService {


    /**
     * 线下订单扫码支付    （商户扫支付宝微信支付码）
     * @param dto
     * @return
     */
    OfflineOrderPayResultDTO offlinePayForOrder(OfflineOrderPayFormDTO dto);

    /**
     * 查询线下订单扫码支付结果
     * @param orderCode
     * @return
     */
    PosOrderPayResultDTO getOfflineScanPayResult(String  orderCode);

}
