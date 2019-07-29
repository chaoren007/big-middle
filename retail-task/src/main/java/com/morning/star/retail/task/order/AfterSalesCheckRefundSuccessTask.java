package com.morning.star.retail.task.order;

import java.util.Date;

import org.apache.commons.lang3.time.DateUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.morning.star.retail.order.enums.RefundPayStatus;
import com.morning.star.retail.order.enums.RefundType;
import com.morning.star.retail.order.facade.AfterSalesServiceFacade;
import com.morning.star.retail.order.facade.RefundServiceFacade;
import com.morning.star.retail.order.facade.dto.FinishRefundDTO;
import com.morning.star.retail.order.facade.dto.RefundDTO;
import com.morning.star.retail.order.facade.dto.RefundSearchDTO;
import com.morning.star.retail.task.utils.PageIterator;
import com.morning.star.retail.task.utils.PageLoader;

/**
 * 查询退款成功的退款订单，修改售后订单状态
 * Created by liangguobin on 2017/5/27.
 */
@Service
public class AfterSalesCheckRefundSuccessTask {
    private Logger logger = LoggerFactory.getLogger(AfterSalesCheckRefundSuccessTask.class);

    @Autowired
    private RefundServiceFacade refundService;


    @Autowired
    private AfterSalesServiceFacade afterService;

    public void execute() {
        logger.info("------- AfterSalesCheckRefundSuccessTask start -------");

        RefundSearchDTO refundSearchDTO = new RefundSearchDTO();
        refundSearchDTO.setStartModifyTime(DateUtils.addMinutes(new Date(), -30));
        refundSearchDTO.setEndModifyTime(DateUtils.addMinutes(new Date(), -5));
        refundSearchDTO.setStatus(RefundPayStatus.REFUND_SUCCESS.getCode());
        refundSearchDTO.setType(RefundType.AFTER_SALES_REFUND.getCode());


//        List<Integer> statuses = new ArrayList<>();
//        statuses.add(RefundPayStatus.WAIT_PAY.getCode());
//        statuses.add(RefundPayStatus.ASK_FAIL.getCode());
//        statuses.add(RefundPayStatus.REFUND_SUCCESS.getCode());
//        statuses.add(RefundPayStatus.UNSUPPORTED.getCode());
//        refundSearchDTO.setStatuses(statuses);

        new PageIterator<RefundDTO>(pageNo -> {
            // 查询款成功的退款订单
            refundSearchDTO.setPageNo(pageNo);
            refundSearchDTO.setPageSize(PageLoader.DEFAULT_PAGE_SIZE);
            return refundService.queryRefund(refundSearchDTO);
        }).forEachRemaining(dto -> {
            // 修改对应售后订单的状态
            FinishRefundDTO refundDTO = new FinishRefundDTO();
            BeanUtils.copyProperties(dto, refundDTO);
            afterService.finishRefund(refundDTO);
        });


        logger.info("------- AfterSalesCheckRefundSuccessTask end -------");
    }
}
