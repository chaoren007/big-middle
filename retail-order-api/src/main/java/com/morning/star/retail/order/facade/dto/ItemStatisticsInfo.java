package com.morning.star.retail.order.facade.dto;

import java.io.Serializable;

/**
 * Created by lenovo on 2018/1/30.
 */
public class ItemStatisticsInfo implements Serializable {
    private static final long serialVersionUID = -8804696304095776552L;

    /**
     *
     销售商品数
     */
    private Integer saleNum;

    /**
     *
     退货商品数
     */
    private Integer refundNum;

    public Integer getSaleNum() {
        return saleNum;
    }

    public void setSaleNum(Integer saleNum) {
        this.saleNum = saleNum;
    }

    public Integer getRefundNum() {
        return refundNum;
    }

    public void setRefundNum(Integer refundNum) {
        this.refundNum = refundNum;
    }
}
