package com.morning.star.retail.order.event;

import org.springframework.context.ApplicationEvent;

import com.morning.star.retail.order.domain.entity.SalesOrderEntity;

/**
 * 订单创建事件
 * @author Tim
 *
 */
public class SalesOrderCreateEvent extends ApplicationEvent {
    
    private static final long serialVersionUID = 1L;

    private String topCode;
    
    public SalesOrderCreateEvent(SalesOrderEntity order) {
        super(order);
    }
    
    public SalesOrderCreateEvent(String topCode, SalesOrderEntity order) {
        super(order);
        this.topCode = topCode;
    }

    public String getTopCode() {
        return topCode;
    }

}
