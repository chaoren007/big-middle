package com.morning.star.retail.mq.consumer;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.morning.star.retail.stock.bean.StockMQMsgBean;
import com.morning.star.retail.stock.bean.StockSyncMQBean;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessageListener;
import org.springframework.stereotype.Service;

import java.lang.reflect.Type;

/**
 * 库存同步消息队列服务-消费者
 */
@Service("stockSyncMQConsumer")
public class StockSyncMQConsumer implements MessageListener {

    public static final Logger LOGGER = LoggerFactory.getLogger(StockSyncMQConsumer.class);
    public static final Gson GSON = new Gson();

    @Override
    public void onMessage(Message message) {
        try {
            String msgJson = new String(message.getBody(), "UTF-8");
            LOGGER.info("consumer receive message success ---> {}", msgJson);
            Type objectType = new TypeToken<StockMQMsgBean<StockSyncMQBean>>() {
            }.getType();
            handle(GSON.fromJson(msgJson, objectType));
            LOGGER.info("consumer handle message success");
        } catch (Exception e) {
            LOGGER.error("consumer receive message fail ---> {}", e.getMessage());
        }
    }

    private void handle(StockMQMsgBean<StockSyncMQBean> stockMQMsgBean) {
    }
}
