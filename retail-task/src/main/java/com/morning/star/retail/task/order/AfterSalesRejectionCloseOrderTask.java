package com.morning.star.retail.task.order;

import java.util.Date;

import org.apache.commons.lang3.time.DateUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.morning.star.retail.order.enums.AfterSalesOrderStatus;
import com.morning.star.retail.order.enums.AfterSalesRefundType;
import com.morning.star.retail.order.enums.SalesOrderStatus;
import com.morning.star.retail.order.facade.AfterSalesServiceFacade;
import com.morning.star.retail.order.facade.OrderServiceFacadeForInner;
import com.morning.star.retail.order.facade.dto.AfterSalesOrderDTO;
import com.morning.star.retail.order.facade.dto.SalesOrderDTO;
import com.morning.star.retail.order.qo.AfterSalesRecentlyOrderQO;
import com.morning.star.retail.task.utils.PageIterator;

/**
 * 售后拒收后要关闭主订单
 * 该task检查拒收但主订单没关闭的情况，进行补偿
 * Created by liangguobin on 2017/5/31.
 */
@Service
public class AfterSalesRejectionCloseOrderTask {
    private Logger logger = LoggerFactory.getLogger(AfterSalesRejectionCloseOrderTask.class);

    @Autowired
    private AfterSalesServiceFacade afterService;


    @Autowired
    private OrderServiceFacadeForInner orderServiceFacadeForInner;

    public void execute() {
        logger.info("------- AfterSalesRejectionCloseOrderTask start -------");


        new PageIterator<AfterSalesOrderDTO>(pageNo -> {
            AfterSalesRecentlyOrderQO qo = new AfterSalesRecentlyOrderQO();

            qo.setRefundType(AfterSalesRefundType.REJECTION.getCode());
            qo.setStatus(AfterSalesOrderStatus.WAIT_REFUND.getCode());
            qo.setIncludeTrack(AfterSalesRecentlyOrderQO.LATEST_TRACK);
            qo.setStartTime(DateUtils.addMinutes(new Date(), -30));
            qo.setEndTime(DateUtils.addMinutes(new Date(), -5));

            return afterService.listRecentlyOrder(qo);

        }).forEachRemaining(afterOrder -> {

            SalesOrderDTO orderDTO = orderServiceFacadeForInner.getSalesOrder(afterOrder.getOrderCode());

            if(orderDTO.getOrderStatus() != SalesOrderStatus.CLOSE.getCode()) {   // 订单未关闭
                // 关闭订单 TODO
//                orderServiceFacadeForInner.closeSalesOrder(afterOrder.getCompanyCode(), afterOrder.getOrderCode(), "");
            }

        });

        logger.info("------- AfterSalesRejectionCloseOrderTask end -------");
    }

}
