package com.morning.star.retail.task.order;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.morning.star.retail.order.enums.PaymentStatus;
import com.morning.star.retail.order.enums.RefundType;
import com.morning.star.retail.order.enums.SalesOrderClosedType;
import com.morning.star.retail.order.facade.OrderServiceFacadeForInner;
import com.morning.star.retail.order.facade.RefundServiceFacade;
import com.morning.star.retail.order.facade.dto.ApplyRefundDTO;
import com.morning.star.retail.order.facade.dto.RefundDTO;
import com.morning.star.retail.order.facade.dto.SalesOrderDTO;
import com.morning.star.retail.order.facade.order.req.OrderListReqParams;
import com.morning.star.retail.order.util.Page;
import com.morning.star.retail.order.util.PageIterator;
import com.morning.star.retail.order.util.PageIterator.PageLoader;
import com.morning.star.retail.task.helper.StockServiceHelper;

/**
 * 取消订单补偿
 */
@Service
public class SalesOrderCancelFixTask implements Runnable {
    private static final Logger logger = LoggerFactory.getLogger(SalesOrderCancelFixTask.class);
    
    @Autowired private OrderServiceFacadeForInner orderServiceFacadeForInner;
    @Autowired private RefundServiceFacade refundService;
    @Autowired private StockServiceHelper stockServiceHelper;
    
    @Override
    public void run() {
        logger.info("------- SalesOrderCancelFixTask start -------");
        PageIterator<SalesOrderDTO> ite = new PageIterator<>(new Page(1, 1000), new PageLoader<SalesOrderDTO>() {
            @Override
            public List<SalesOrderDTO> load(Page page) {
                // 获取所有交易关闭的订单
                OrderListReqParams search = new OrderListReqParams();
                /*search.setStatus(SalesOrderStatus.CLOSE.getCode());
                search.setStartModifyTime(Date.from(
                        LocalDateTime.now().minusMinutes(30).atZone(ZoneId.systemDefault()).toInstant()));
                search.setEndModifyTime(Date.from(
                        LocalDateTime.now().minusMinutes(5).atZone(ZoneId.systemDefault()).toInstant()));*/
                search.setPageNo(page.getPageNo());
                search.setPageSize(page.getPageSize());
                
                //PageBean<SalesOrderVO> dataPage = orderServiceFacadeForInner.querySalesOrder(search);
                return orderServiceFacadeForInner.querySalesOrder(search).getRecord()
                							.stream()
                							.filter(e->!e.getClosedType().equals(SalesOrderClosedType.REJECT_CLOSE.getCode()))
                							.collect(Collectors.toList());
               // return dataPage.getRecord();
            }
        });
        
        ite.forEachRemaining(e -> fixCancel(e));
        logger.info("------- SalesOrderCancelFixTask end -------");
    }
    
    /**
     * 补尝
     * @param order
     */
    public void fixCancel(SalesOrderDTO order) {
        //拒收的订单不释放库存
        if(order.getClosedType() == null || order.getClosedType().intValue() == SalesOrderClosedType.REJECT_CLOSE.getCode()){
            return;
        }
        // 释放库存
        stockServiceHelper.releaseStock(order);
        
        if(		order.getPayAmount().compareTo(BigDecimal.ZERO) > 0) {
            
        	if((	order.getPayAmount().compareTo(BigDecimal.ZERO) == 0 ||
            		order.getPayStatus() == PaymentStatus.PAY_SUCC.getCode())
                    ) {
        		
                createRefund(order);
            }
        }
    }
    
    private void createRefund(SalesOrderDTO order) {
    	RefundDTO refund = refundService.getCancelRefund(order.getOrderCode());
    	// 生成退款单
    	if(refund == null) {
    		refundService.applyRefund(toDTO(order, ""));
    	}
    }
    
    public static ApplyRefundDTO toDTO(SalesOrderDTO order, String remark) {
        ApplyRefundDTO dto = new ApplyRefundDTO();
        dto.setOrderCode(order.getOrderCode());
        dto.setAmount(order.getPayAmount());
        dto.setRefundType(RefundType.CANCEL_REFUND.getCode());
        dto.setRemark(remark);
        return dto;
    }
}
