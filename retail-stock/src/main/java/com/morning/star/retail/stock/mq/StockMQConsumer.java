package com.morning.star.retail.stock.mq;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.morning.star.retail.stock.dto.StockMQMsgDTO;
import com.morning.star.retail.stock.dto.StockOrderDTO;
import com.morning.star.retail.stock.enums.StockRecordTypeEnum;
import com.morning.star.retail.stock.logicservice.StockLogicService;

/**
 * 库存消息队列服务-消费者
 *
 * @author jiangyf
 * @date 2017年9月12日 下午4:20:52
 */
@Component
public class StockMQConsumer {
    public static final Logger LOGGER = LoggerFactory.getLogger(StockMQConsumer.class);

    @Autowired
    private StockLogicService stockLogicService;


    public void process(StockMQMsgDTO msg) {
        try {
            LOGGER.info("---------------- StockMQConsumer receiver message : {}", msg);
            handleStock(msg);
        } catch (Exception e) {
            LOGGER.error("---------------- StockMQConsumer process message fail ---> {}", e.getMessage());
        }
    }

    /**
     * 处理库存数据
     *
     * @param msg
     * @return
     */
    private boolean handleStock(StockMQMsgDTO msg) {
        String action = msg.getAction();
        StockOrderDTO dto = msg.getStockOrderDTO();
        if ("onlinePreStock".equals(action)) { // 预占库存
            return stockLogicService.onlinePreStock(dto);
        }
        if ("checkOnlinePreStock".equals(action)) { // 确认预占库存
            return stockLogicService.checkOnlinePreStock(dto);
        }
        if ("onlineFreeStock".equals(action)) { // 线上订单释放库存
            return stockLogicService.onlineFreeStock(dto);
        }
        if ("onlineOutStock".equals(action)) { // 线上订单销售出库
            return stockLogicService.onlineOutStock(dto);
        }
        if ("rejectInStock".equals(action)) { // 拒收入库
            return stockLogicService.directInStock(dto, StockRecordTypeEnum.REJECT_IN);
        }
        if ("returnInStock".equals(action)) { // 退货入库
            return stockLogicService.directInStock(dto, StockRecordTypeEnum.RETURN_IN);
        }
        if ("offlineOutStock".equals(action)) { // 线下订单销售出库
            return stockLogicService.offlineOutStock(dto);
        }
        return false;
    }

}
