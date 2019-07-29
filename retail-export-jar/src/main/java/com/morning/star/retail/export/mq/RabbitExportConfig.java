package com.morning.star.retail.export.mq;

import org.springframework.amqp.core.Queue;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitExportConfig {
    @Value("${spring.application.name}")
    private String appName;

    @Bean
    public Queue Queue() {
        return new Queue(appName + "-export");
    }

//    @Bean
//    @Primary
//    public RabbitTemplate rabbitTemplate(ConnectionFactory connectionFactory) {
//        RabbitTemplate rabbitTemplate = new RabbitTemplate(connectionFactory);
//        rabbitTemplate.setMessageConverter(new Gson2JsonMessageConverter());
//        return rabbitTemplate;
//    }

}
