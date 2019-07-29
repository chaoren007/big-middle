package com.morning.star.retail.order.listener;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

import com.morning.star.retail.order.domain.entity.SalesOrderEntity;
import com.morning.star.retail.order.event.SalesOrderCreateEvent;
import com.morning.star.retail.order.helper.StorkReduceHelper;

@Component
public class SalesOrderCreateListener implements ApplicationListener<SalesOrderCreateEvent> {

    @Autowired private StorkReduceHelper storkReduceHelper;
    
    @Async
    @Override
    public void onApplicationEvent(SalesOrderCreateEvent event) {
        SalesOrderEntity order = (SalesOrderEntity)event.getSource();
        storkReduceHelper.offlineOutStock(order);
    }
    
}
