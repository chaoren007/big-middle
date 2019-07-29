package com.morning.star.retail.task.helper.impl;

import com.morning.star.retail.facade.StockFacade;
import com.morning.star.retail.order.facade.dto.SalesOrderDTO;
import com.morning.star.retail.stock.dto.ItemDTO;
import com.morning.star.retail.stock.dto.StockOrderDTO;
import com.morning.star.retail.task.helper.StockServiceHelper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class StockServiceHelperImpl implements StockServiceHelper {
    private Logger logger = LoggerFactory.getLogger(StockServiceHelperImpl.class);

    @Autowired
    private StockFacade stockFacade;

    @Override
    public void confirmStock(SalesOrderDTO order) {
        try {
            stockFacade.checkOnlinePreStock(toStockOrderDTO(order));
        } catch (Exception e) {
            logger.error("confirm stock error", e);
            // TODO 邮件通知
//            RetailNoticeUtils.noticeForTopic(NoticeTopic.ORDER_TOPIC, 
//                    "订单确认预占库存异常", String.format("订单号：%s，错误信息：%s", order.getCode(), e.getMessage()));
        }
    }

    @Override
    public void releaseStock(SalesOrderDTO order) {
        try {
            stockFacade.onlineFreeStock(toStockOrderDTO(order));
        } catch (Exception e) {
            logger.error("release stock error", e);
            // TODO 邮件通知
//            RetailNoticeUtils.noticeForTopic(NoticeTopic.ORDER_TOPIC, 
//                    "释放预占库存异常", String.format("订单号：%s，错误信息：%s", order.getCode(), e.getMessage()));
        }
    }

    @Override
    public void consumeStock(SalesOrderDTO order) {
        try {
            stockFacade.onlineOutStock(toStockOrderDTO(order));
        } catch (Exception e) {
            logger.error("consume stock error", e);
            // TODO 邮件通知
//            RetailNoticeUtils.noticeForTopic(NoticeTopic.ORDER_TOPIC, 
//                    "库存销售出库异常", String.format("订单号：%s，错误信息：%s", order.getCode(), e.getMessage()));
        }
    }


    private StockOrderDTO toStockOrderDTO(SalesOrderDTO order) {
        List<ItemDTO> items = order.getItems().stream().map(item -> new ItemDTO(item.getGoodsCode(), item.getBuyNum(), item.getBuyNum(), item.getUnit())).collect(Collectors.toList());
        return new StockOrderDTO(order.getGroupCode(), order.getStoreCode(), order.getOrderCode(), String.valueOf(order.getOrderStatus()), items);
    }

}
