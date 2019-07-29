package com.morning.star.retail.task.order;

import java.util.List;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.morning.star.retail.order.enums.SalesOrderType;
import com.morning.star.retail.order.facade.OrderServiceFacadeForInner;
import com.morning.star.retail.order.facade.dto.SalesOrderDTO;
import com.morning.star.retail.order.facade.order.req.OrderListReqParams;
import com.morning.star.retail.order.util.Page;
import com.morning.star.retail.order.util.PageIterator;
import com.morning.star.retail.order.util.PageIterator.PageLoader;

/**
 * 支付结果补偿
 */
@Service
public class SalesOrderPayResultTask implements Runnable {
    
    private static final Logger logger = LoggerFactory.getLogger(SalesOrderAutoDoneTask.class);
    @Autowired private OrderServiceFacadeForInner orderServiceFacadeForInner;
    
    
    @Override
    public void run() {
        logger.info("------- SalesOrderPayResultTask start -------");
        PageIterator<SalesOrderDTO> ite = new PageIterator<>(new Page(1, 1000), new PageLoader<SalesOrderDTO>() {
            @Override
            public List<SalesOrderDTO> load(Page page) {
                // 获取所有交易关闭的订单
                OrderListReqParams search = new OrderListReqParams();
                /*search.setStatus(SalesOrderStatus.WAIT_PAY.getCode());
                search.setPayStatus(PaymentStatus.PAY_ING.getCode());*/
                search.setPageNo(page.getPageNo());
                search.setPageSize(page.getPageSize());
                
                List<SalesOrderDTO> record = orderServiceFacadeForInner.querySalesOrder(search)
                		.getRecord()
                		.stream()
                		.collect(Collectors.toList());
                return record;
            }
        });
        
        ite.forEachRemaining(e -> handlePayResult(e));
        logger.info("------- SalesOrderPayResultTask end -------");
    }
    
    /**
     * 补尝
     * @param order
     */
    public void handlePayResult(SalesOrderDTO order) {
    	if(order.getOrderType().intValue() == SalesOrderType.ONLINE_ORDER.getCode()){
    		orderServiceFacadeForInner.updatePayResult(order.getOrderCode());
    	} else if(order.getOrderType().intValue() == SalesOrderType.OFFLINE_ORDER.getCode()){
    		orderServiceFacadeForInner.getOfflineScanPayResult(order.getOrderCode());
    	}
    	
    }
    
}
