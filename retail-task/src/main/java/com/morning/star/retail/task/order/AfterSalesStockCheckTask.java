package com.morning.star.retail.task.order;

import com.morning.star.retail.facade.StockFacade;
import com.morning.star.retail.order.enums.AfterSalesOrderStatus;
import com.morning.star.retail.order.enums.AfterSalesRefundType;
import com.morning.star.retail.order.facade.AfterSalesServiceFacade;
import com.morning.star.retail.order.facade.dto.AfterSalesOrderDTO;
import com.morning.star.retail.order.qo.AfterSalesRecentlyOrderQO;
import com.morning.star.retail.stock.dto.ItemDTO;
import com.morning.star.retail.stock.dto.StockOrderDTO;
import com.morning.star.retail.task.utils.PageIterator;
import com.morning.star.retail.task.utils.PageLoader;
import org.apache.commons.lang3.time.DateUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 验货成功后(包括拒收)要入库
 * 该task检查验货成功去却没有入库记录的情况，进行补偿
 * Created by liangguobin on 2017/5/27.
 */
@Service
public class AfterSalesStockCheckTask {
    private Logger logger = LoggerFactory.getLogger(AfterSalesStockCheckTask.class);

    @Autowired
    private AfterSalesServiceFacade afterService;

    @Autowired
    private StockFacade stockFacade;

    public void execute() {
        logger.info("------- AfterSalesStockCheckTask start -------");

        new PageIterator<AfterSalesOrderDTO>(pageNo -> {
            AfterSalesRecentlyOrderQO qo = new AfterSalesRecentlyOrderQO();
            qo.setStartTime(DateUtils.addMinutes(new Date(), -30));
            qo.setEndTime(DateUtils.addMinutes(new Date(), -5));
            qo.setPageNo(pageNo);
            qo.setPageSize(PageLoader.DEFAULT_PAGE_SIZE);
            qo.setStatus(AfterSalesOrderStatus.WAIT_REFUND.getCode());
            qo.setIncludeTrack(AfterSalesRecentlyOrderQO.LATEST_TRACK);
            qo.setHasReturnedItem(1);
            return afterService.listRecentlyOrder(qo);    // 查询半小时的
        }).forEachRemaining(afterOrder -> {

            // TODO 入库记录
            boolean isInStock = false;

            if (isInStock) {    // 没有入库记录
                // 进行补偿
                if (afterOrder.getRefundType() == AfterSalesRefundType.REJECTION.getCode()) {
                    stockFacade.returnInStock(toStockOrderDTO(afterOrder));
                } else {
                    stockFacade.returnInStock(toStockOrderDTO(afterOrder));
                }
            }
        });

        logger.info("------- AfterSalesStockCheckTask end -------");
    }

    private StockOrderDTO toStockOrderDTO(AfterSalesOrderDTO order) {
        List<ItemDTO> items = order.getRefundItems().stream().map(item -> new ItemDTO(item.getGoodsCode(), item.getBuyNum(), item.getBuyNum(), item.getUnit())).collect(Collectors.toList());
        return new StockOrderDTO(order.getGroupCode(), order.getStoreCode(), order.getOrderCode(), String.valueOf(order.getStatus()), items);
    }
}
