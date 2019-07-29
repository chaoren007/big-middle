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
import com.morning.star.retail.utils.page.PageBean;

/**
 * 订单自动完成
 */
@Service
public class SalesOrderAutoDoneTask implements Runnable {
    private static final Logger logger = LoggerFactory.getLogger(SalesOrderAutoDoneTask.class);
    
    @Autowired private OrderServiceFacadeForInner orderServiceFacadeForInner;
    
    
    @Override
    public void run() {
        logger.info("------- SalesOrderAutoDoneTask start -------");
        PageIterator<SalesOrderDTO> ite = new PageIterator<>(new Page(1, 1000), new PageLoader<SalesOrderDTO>() {
            @Override
            public List<SalesOrderDTO> load(Page page) {
                // 获取1天前已收货的订单
                OrderListReqParams search = new OrderListReqParams();
                //search.setStatus(SalesOrderStatus.RECEIVED.getCode());
                //search.setEndModifyTime(Date.from(LocalDateTime.now().minusDays(1).atZone(ZoneId.systemDefault()).toInstant()));
                search.setPageNo(page.getPageNo());
                search.setPageSize(page.getPageSize());
                
                PageBean<SalesOrderDTO> dataPage = orderServiceFacadeForInner.querySalesOrder(search);
                return dataPage.getRecord();
            }
        });
        
        ite.forEachRemaining(e -> handleAutoDone(e));
        logger.info("------- SalesOrderAutoDoneTask end -------");
    }
    
    /**
     * 自动完成
     * @param order
     */
    public void handleAutoDone(SalesOrderDTO order) {
        try {
        	orderServiceFacadeForInner.done(order.getOrderCode(), "系统自动完成");
        } catch (Exception e) {
            logger.error("time out error", e);
        }
    }
}
