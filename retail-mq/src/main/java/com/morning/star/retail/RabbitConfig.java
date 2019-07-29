package com.morning.star.retail;

import com.morning.star.retail.mq.consumer.StockSyncMQConsumer;
import org.springframework.amqp.core.AcknowledgeMode;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.listener.SimpleMessageListenerContainer;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitConfig {

    @Value("${queue.sync.stock}")
    private String syncStockQueue;

    public String getSyncStockQueue() {
        return syncStockQueue;
    }

    @Bean
    public Queue syncStockQueueQueue() {
        return new Queue(syncStockQueue, true, false, false);
    }

    @Bean
    public SimpleMessageListenerContainer syncStockListenerContainer(ConnectionFactory connectionFactory,
                                                                     StockSyncMQConsumer consumer) {
        SimpleMessageListenerContainer container = new SimpleMessageListenerContainer(connectionFactory);
        container.setAcknowledgeMode(AcknowledgeMode.AUTO);
        container.setQueues(syncStockQueueQueue());
        container.setMessageListener(consumer);
        return container;
    }

}
