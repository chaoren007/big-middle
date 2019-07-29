package com.morning.star.retail.stock.mq;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.stereotype.Service;

import com.google.gson.Gson;
import com.morning.star.retail.stock.dto.StockMQMsgDTO;
import com.morning.star.retail.stock.dto.StockOrderDTO;

/**
 * 库存消息队列服务-生产者
 *
 * @author jiangyf
 * @date 2017年9月12日 下午4:20:52
 */
@Service("stockMQProducer")
public class StockMQProducer {
    private static final Logger LOGGER = LoggerFactory.getLogger(StockMQProducer.class);
    private static final Gson GSON = new Gson();

    @Resource
    private AmqpTemplate amqpTemplate;

    /**
     * 发送消息(mantou-mq)
     *
     * @param key
     * @param action 调用服务名称
     * @param dto    调用服务入参
     * @return
     */
    public boolean sendMessage(String key, String action, StockOrderDTO dto) {
        try {
            amqpTemplate.convertAndSend(key, new StockMQMsgDTO(action, dto));
        } catch (Exception e) {
            LOGGER.error("-------- StockMQProducer -------- 库存消息队列服务生产者发送消息失败，服务：{}，入参：{}，错误：{}", action, GSON.toJson(dto), e.getMessage());
            return false;
        }
        return true;

    }

}
