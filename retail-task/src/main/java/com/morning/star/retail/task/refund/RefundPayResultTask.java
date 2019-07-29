package com.morning.star.retail.task.refund;


import java.util.Date;
import java.util.List;

import org.apache.commons.lang3.time.DateUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.morning.star.retail.order.enums.RefundPayStatus;
import com.morning.star.retail.order.facade.RefundServiceFacade;
import com.morning.star.retail.order.facade.dto.RefundSearchDTO;
import com.morning.star.retail.order.util.Page;
import com.morning.star.retail.order.util.PageIterator;

/**
 * 退款支付结果
 */
@Service
public class RefundPayResultTask implements Runnable{
    private Logger loggerUtils = LoggerFactory.getLogger(RefundPayResultTask.class);

    @Autowired
    private RefundServiceFacade refundServiceFacade;

    @Override
    public void run() {
        loggerUtils.info("RefundPayResultTask start", null, null);

        Date startDate = DateUtils.addMinutes(new Date(), -30);

        PageIterator<String> ite = new PageIterator<>(new Page(1, 1000), new PageIterator.PageLoader<String>() {
            @Override
            public List<String> load(Page page) {
                RefundSearchDTO  searchDTO = new RefundSearchDTO();
                searchDTO.setStartTime(startDate);
                searchDTO.setStatus(RefundPayStatus.WAIT_PAY.getCode());
                searchDTO.setPageNo(page.getPageNo());
                searchDTO.setPageSize(page.getPageSize());
                return refundServiceFacade.queryPayRequestNo(searchDTO).getRecord();
            }
        });


        ite.forEachRemaining(e -> handlePayResult(e));

    }

    /**
     * 补尝
     */
    public void handlePayResult(String requestNo) {
        if(requestNo != null && !"".equals(requestNo))
            refundServiceFacade.updateRefundResult(requestNo);
    }
}
