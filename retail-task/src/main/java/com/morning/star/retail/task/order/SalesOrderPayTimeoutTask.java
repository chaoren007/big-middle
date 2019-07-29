package com.morning.star.retail.task.order;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
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
import com.morning.star.retail.task.helper.CheckOrderHelper;

/**
 * 订单支付超时
 */
@Service
public class SalesOrderPayTimeoutTask implements Runnable {
    private static final Logger logger = LoggerFactory.getLogger(SalesOrderPayTimeoutTask.class);
    
    @Autowired private OrderServiceFacadeForInner orderServiceFacadeForInner;
    @Autowired private CheckOrderHelper checkOrderHelper;
    
    
    @Override
    public void run() {
        logger.info("------- SalesOrderPayTimeoutTask start -------");
        PageIterator<SalesOrderDTO> ite = new PageIterator<>(new Page(1, 1000), new PageLoader<SalesOrderDTO>() {
            @Override
            public List<SalesOrderDTO> load(Page page) {
                
            	// 创建时间30分钟以内的非预付卡的线上订单列表
            	List<SalesOrderDTO> onlineOrderlList = getOnlineWaitPayOrderWithNoPrepayCard(page);
                //创建时间8分钟以内的预付卡订单列表
            	List<SalesOrderDTO> prepayCardList = getOnlineWaitPayOrderWithPrepayCard(page);
                //线下订单创建时间60分钟才超时
            	List<SalesOrderDTO> offlineOrderlList = getOfflineWaitPayOrder(page);
                
                List<SalesOrderDTO> list = new ArrayList<>();
                list.addAll(onlineOrderlList); 		//线上不含预付卡订单
                list.addAll(prepayCardList);		//线上含预付卡订单
                list.addAll(offlineOrderlList);		//线下订单
                
                return list;
            }
            
        });
        
        ite.forEachRemaining(e -> handleTimeout(e));
        logger.info("------- SalesOrderPayTimeoutTask end -------");
    }
    
    /**
     * 处理支付超时
     * @param order
     */
    public void handleTimeout(SalesOrderDTO order) {
        try {
        	if(!checkOrderHelper.checkCanCancelPay(order)) {
        		return;
        	}
        	
        	String remark = order.getOrderType().intValue() == SalesOrderType.OFFLINE_ORDER.getCode() ?  "线下订单超时自动关闭" 
        			: "支付超时自动关闭(不含预付卡支付)";
        	orderServiceFacadeForInner.timeout(order.getOrderCode(), remark);
        } catch (Exception e) {
            logger.error("time out error", e);
        }
    }
    
    /**
     * 获取线上非预付卡支付的待支付订单
     * @return
     */
    private List<SalesOrderDTO> getOnlineWaitPayOrderWithNoPrepayCard(Page page){
    	
        OrderListReqParams onlineOrderSearch = new OrderListReqParams();
        //onlineOrderSearch.setStatus(SalesOrderStatus.WAIT_PAY.getCode());
        onlineOrderSearch.setEndTime(Date.from(LocalDateTime.now().minusMinutes(30).atZone(ZoneId.systemDefault()).toInstant()));
        onlineOrderSearch.setPageNo(page.getPageNo());
        onlineOrderSearch.setPageSize(page.getPageSize());
        return orderServiceFacadeForInner.querySalesOrder(onlineOrderSearch).getRecord()
        										.stream()
        										.filter(e->e.getOrderType().intValue() == SalesOrderType.ONLINE_ORDER.getCode())
        										.collect(Collectors.toList());
    }
    
    
    /**
     * 获取线上非预付卡支付的待支付订单
     * @return
     */
    private List<SalesOrderDTO> getOnlineWaitPayOrderWithPrepayCard(Page page){
    	OrderListReqParams prepayCardOrderSearch = new OrderListReqParams();
        //prepayCardOrderSearch.setStatus(SalesOrderStatus.WAIT_PAY.getCode());
        prepayCardOrderSearch.setEndTime(Date.from(LocalDateTime.now().minusMinutes(8).atZone(ZoneId.systemDefault()).toInstant()));
        prepayCardOrderSearch.setPageNo(page.getPageNo());
        prepayCardOrderSearch.setPageSize(page.getPageSize());
        return orderServiceFacadeForInner.querySalesOrder(prepayCardOrderSearch).getRecord()
        							.stream()
        							.filter(e->e.getOrderType().intValue() == SalesOrderType.ONLINE_ORDER.getCode())
        							.collect(Collectors.toList());
    }
    
    
    /**
     * 获取线上非预付卡支付的待支付订单
     * @return
     */
    private List<SalesOrderDTO> getOfflineWaitPayOrder(Page page){
    	OrderListReqParams offlineOrderSearch = new OrderListReqParams();
        //offlineOrderSearch.setStatus(SalesOrderStatus.WAIT_PAY.getCode());
        offlineOrderSearch.setEndTime(Date.from(LocalDateTime.now().minusMinutes(60).atZone(ZoneId.systemDefault()).toInstant()));
        offlineOrderSearch.setPageNo(page.getPageNo());
        offlineOrderSearch.setPageSize(page.getPageSize());
        return orderServiceFacadeForInner.querySalesOrder(offlineOrderSearch).getRecord()
        										.stream()
        										.filter(e->e.getOrderType().intValue() == SalesOrderType.OFFLINE_ORDER.getCode())
        										.collect(Collectors.toList());
    }
    
    
    
}
