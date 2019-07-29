package com.morning.star.retail.admin.order.qo;

import java.util.List;

import com.morning.star.retail.order.facade.dto.AfterSalesItemDTO;

/**
 * 售后请求参数
 * Created by liangguobin on 2017/6/2.
 */
public class ApplyAfterSalesQO {
    /**
     * 订单code
     */
    private String orderCode;

    /**
     * 售后原因
     */
    private String reason;
    /**
     * 退货商品
     */
    private List<AfterSalesItemDTO> refundItems;


    public String getOrderCode() {
        return orderCode;
    }

    public void setOrderCode(String orderCode) {
        this.orderCode = orderCode;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public List<AfterSalesItemDTO> getRefundItems() {
        return refundItems;
    }

    public void setRefundItems(List<AfterSalesItemDTO> refundItems) {
        this.refundItems = refundItems;
    }
}