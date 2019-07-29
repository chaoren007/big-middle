package com.morning.star.retail;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

@Configuration
public class RabbitConfig {
    @Value("${exchange}")
    private String exchange;


    @Value("${queue.import.goods}")
    private String importGoodsQueue;
    /**
     * 添加仓库队列
     */
    @Value("${createStorageQueue}")
    private  String createStorageQueue ;
    /**
     * 添加分公司队列
     */
    @Value("${createStoreQueue}")
    private  String createStoreQueue ;
    /**
     * 添加供应商队列
     */
    @Value("${createSupplierQueue}")
    private  String createSupplierQueue ;

    /**
     * 添加税率队列
     */
    @Value("${creatTaxRate}")
    private  String createTaxRate ;

    /**
     * 添加税种队列
     */
    @Value("${creatTaxType}")
    private  String createTaxType ;

    public String getExchange() {
        return exchange;
    }

    public String getCreateStorageQueue() {
        return createStorageQueue;
    }

    public String getCreateSupplierQueue() {
        return createSupplierQueue;
    }

    public String getCreateStoreQueue() {
        return createStoreQueue;
    }

    public String getCreateTaxRate() { return createTaxRate; }

    public String getCreateTaxType() { return createTaxType; }

    @Bean
    TopicExchange exchange() { return new TopicExchange(exchange); }

    @Bean
    public Queue createStorageQueue() {
        return new Queue(createStorageQueue);
    }

    @Bean
    public Queue createSupplierQueue() {
        return new Queue(createSupplierQueue);
    }

    @Bean
    public Queue createStoreQueue() {
        return new Queue(createStoreQueue);
    }

    @Bean
    public Queue importGoodsQueue() {
        return new Queue(importGoodsQueue, true);
    }

    @Bean
    public Queue createTaxRateQueue() {
        return new Queue(createTaxRate);
    }

    @Bean
    public Queue createTaxTypeQueue() {
        return new Queue(createTaxType);
    }

    @Bean
    Binding bindingStorageQueue(@Qualifier("createStorageQueue") Queue queue, TopicExchange exchange) {
        return BindingBuilder.bind(queue).to(exchange).with(createStorageQueue);
    }

    @Bean
    Binding bindingSupplierQueue(@Qualifier("createSupplierQueue")Queue queue, TopicExchange exchange) {
        return BindingBuilder.bind(queue).to(exchange).with(createSupplierQueue);
    }

    @Bean
    Binding bindingStoreQueue(@Qualifier("createStoreQueue") Queue queue, TopicExchange exchange) {
        return BindingBuilder.bind(queue).to(exchange).with(createStoreQueue);
    }

    @Bean
    Binding bindingGoodsQueue(@Qualifier("importGoodsQueue")Queue queue, TopicExchange exchange) {
        return BindingBuilder.bind(queue).to(exchange).with(importGoodsQueue);
    }

    @Bean
    Binding bindingTaxRateQueue(@Qualifier("createTaxRateQueue")Queue queue, TopicExchange exchange) {
        return BindingBuilder.bind(queue).to(exchange).with(createTaxRate);
    }

    @Bean
    Binding bindingTaxTypeQueue(@Qualifier("createTaxTypeQueue")Queue queue, TopicExchange exchange) {
        return BindingBuilder.bind(queue).to(exchange).with(createTaxType);
    }

    @Bean
    @Primary
    public RabbitTemplate rabbitTemplate(ConnectionFactory connectionFactory) {
        RabbitTemplate rabbitTemplate = new RabbitTemplate(connectionFactory);
        rabbitTemplate.setMessageConverter(new Jackson2JsonMessageConverter());
        return rabbitTemplate;
    }


}
