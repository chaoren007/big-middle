package com.morning.star.retail.order.domain.entity;


import javax.persistence.Column;
import javax.persistence.Comment;
import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.morning.star.retail.order.enums.SalesOrderStatus;

@Entity
@Table(name = "order_water_info")
public class SalesOrderOperationEntity extends WaterEntity{


    @Column(length = 2, nullable = false)
    @Convert(converter = SalesOrderStatus.Convert.class)
    @Comment("订单状态： 100-待支付 110-已支付  115-待确认  116-待拣货  120-待配送  121-待自提  130-配送中  140-已收货  150-已完成  160-超时取消  170-交易关闭 ")
    private SalesOrderStatus orderStatus;

    public SalesOrderStatus getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(SalesOrderStatus orderStatus) {
        this.orderStatus = orderStatus;
    }

}
