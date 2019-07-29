package com.morning.star.retail.task.order;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.morning.star.retail.order.facade.OrderServiceFacadeForInner;
import com.morning.star.retail.order.facade.dto.SalesOrderDTO;
import com.morning.star.retail.order.facade.order.req.OrderListReqParams;
import com.morning.star.retail.order.util.Page;
import com.morning.star.retail.order.util.PageIterator;
import com.morning.star.retail.order.util.PageIterator.PageLoader;
import com.morning.star.retail.task.helper.StockServiceHelper;
import com.morning.star.retail.utils.page.PageBean;

/**
 * 配送补偿
 */
@Service
public class SalesOrderDeliveryFixTask implements Runnable {
    private static final Logger logger = LoggerFactory.getLogger(SalesOrderDeliveryFixTask.class);
    
    @Autowired private OrderServiceFacadeForInner orderServiceFacadeForInner;
    @Autowired private StockServiceHelper stockServiceHelper;
    
    @Override
    public void run() {
        logger.info("------- SalesOrderDeliveryFixTask start -------");
        PageIterator<SalesOrderDTO> ite = new PageIterator<>(new Page(1, 1000), new PageLoader<SalesOrderDTO>() {
            @Override
            public List<SalesOrderDTO> load(Page page) {
                // 获取所有交易关闭的订单
                OrderListReqParams search = new OrderListReqParams();
                /*search.setStatus(SalesOrderStatus.DELIVERED.getCode());
                search.setStartModifyTime(Date.from(
                        LocalDateTime.now().minusMinutes(30).atZone(ZoneId.systemDefault()).toInstant()));
                search.setEndModifyTime(Date.from(
                        LocalDateTime.now().minusMinutes(5).atZone(ZoneId.systemDefault()).toInstant()));*/
                search.setPageNo(page.getPageNo());
                search.setPageSize(page.getPageSize());
                
                PageBean<SalesOrderDTO> dataPage = orderServiceFacadeForInner.querySalesOrder(search);
                return dataPage.getRecord();
            }
        });
        
        ite.forEachRemaining(e -> fixDelivery(e));
        logger.info("------- SalesOrderDeliveryFixTask end -------");
    }
    
    /**
     * 补尝
     * @param order
     */
    public void fixDelivery(SalesOrderDTO order) {
        try {
            // 释放库存
            stockServiceHelper.consumeStock(order);
        } catch (Exception e) {
            logger.error("confirm stock error", e);
        }
        
    }
    
}
