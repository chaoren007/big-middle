package com.morning.star.retail.task.order;

import java.util.Date;

import org.apache.commons.lang3.time.DateUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.morning.star.retail.order.enums.AfterSalesOrderStatus;
import com.morning.star.retail.order.enums.RefundType;
import com.morning.star.retail.order.facade.AfterSalesServiceFacade;
import com.morning.star.retail.order.facade.RefundServiceFacade;
import com.morning.star.retail.order.facade.dto.AfterSalesOrderDTO;
import com.morning.star.retail.order.facade.dto.ApplyRefundDTO;
import com.morning.star.retail.order.facade.dto.RefundDTO;
import com.morning.star.retail.order.qo.AfterSalesRecentlyOrderQO;
import com.morning.star.retail.task.utils.PageIterator;
import com.morning.star.retail.task.utils.PageLoader;
import com.morning.star.retail.utils.page.PageBean;

/**
 * 验货通过是会生成退款订单
 * 该task检查验货通过没有对于生成退款订的情况(对分布式调用出错的情况补偿)
 * Created by liangguobin on 2017/5/27.
 */
@Service
public class AfterSalesCheckMissedRefundOrderTask {
    private Logger logger = LoggerFactory.getLogger(AfterSalesCheckMissedRefundOrderTask.class);

    @Autowired
    private AfterSalesServiceFacade afterService;


    @Autowired
    private RefundServiceFacade refundService;

    public void execute() {
        logger.info("------- AfterSalesCheckMissedRefundOrderTask start -------");

        new PageIterator<AfterSalesOrderDTO>(pageNo -> {
            AfterSalesRecentlyOrderQO qo = new AfterSalesRecentlyOrderQO();
            qo.setPageNo(pageNo);
            qo.setPageNo(PageLoader.DEFAULT_PAGE_SIZE);
            qo.setStartTime(DateUtils.addMinutes(new Date(), -30));
            qo.setEndTime(DateUtils.addMinutes(new Date(), -5));
            qo.setStatus(AfterSalesOrderStatus.WAIT_REFUND.getCode());

            PageBean<AfterSalesOrderDTO> pageBean = afterService.listRecentlyOrder(qo);    // 查询半小时的
            return pageBean;
        }).forEachRemaining(afterOrder -> {

            RefundDTO refundDTO = refundService.getAfterSalesRefund(afterOrder.getAfterSalesOrderCode());

            if (refundDTO == null) { // 待退款的售后没有退款订单，则生成一个退款订单
                logger.info("after sales order code : {} apply refund", afterOrder.getAfterSalesOrderCode());

                ApplyRefundDTO applyRefundDTO = new ApplyRefundDTO();
                applyRefundDTO.setAfterSalesCode(afterOrder.getAfterSalesOrderCode());
                applyRefundDTO.setAmount(afterOrder.getRefundAmount());
                applyRefundDTO.setGroupCode(afterOrder.getGroupCode());
                applyRefundDTO.setCompanyCode(afterOrder.getStoreCode());
                applyRefundDTO.setOrderCode(afterOrder.getOrderCode());
                applyRefundDTO.setRefundType(RefundType.AFTER_SALES_REFUND.getCode());

                refundService.applyRefund(applyRefundDTO);
            }
        });

        logger.info("------- AfterSalesCheckMissedRefundOrderTask end -------");
    }
}
