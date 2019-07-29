package com.morning.star.retail;

import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import com.morning.star.retail.stock.mq.Gson2JsonMessageConverter;

@Configuration
public class RabbitConfig {

    @Value("${queue.sync.stock}")
    private String syncStockQueue;

    public String getSyncStockQueue() {
        return syncStockQueue;
    }

    // 创建消息队列
    @Bean
    public Queue stockSyncQueue() {
        return new Queue(syncStockQueue, true, false, false);
    }

    @Bean
    @Primary
    public RabbitTemplate rabbitTemplate(ConnectionFactory connectionFactory) {
        RabbitTemplate rabbitTemplate = new RabbitTemplate(connectionFactory);
        rabbitTemplate.setMessageConverter(new Gson2JsonMessageConverter());
        return rabbitTemplate;
    }
}
