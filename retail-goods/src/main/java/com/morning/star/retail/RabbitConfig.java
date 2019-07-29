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

	@Value("${createCategoryQueue}")
	private String createCategoryQueue;

	@Value("${createUnitsQueue}")
	private String createUnitsQueue;

	@Value("${deleteUnitsQueue}")
	private String deleteUnitsQueue;

	@Value("${createSupplyGoodsQueue}")
	private String createSupplyGoodsQueue;

	@Value("${onOffSaleSupplyGoodsQueue}")
	private String onOffSaleSupplyGoodsQueue;

	public String getExchange() {
		return exchange;
	}

	public void setExchange(String exchange) {
		this.exchange = exchange;
	}

	public String getCreateCategoryQueue() {
		return createCategoryQueue;
	}

	public void setCreateCategoryQueue(String createCategoryQueue) {
		this.createCategoryQueue = createCategoryQueue;
	}

	public String getCreateUnitsQueue() {
		return createUnitsQueue;
	}

	public void setCreateUnitsQueue(String createUnitsQueue) {
		this.createUnitsQueue = createUnitsQueue;
	}

	public String getDeleteUnitsQueue() {
		return deleteUnitsQueue;
	}

	public void setDeleteUnitsQueue(String deleteUnitsQueue) {
		this.deleteUnitsQueue = deleteUnitsQueue;
	}

	public String getCreateSupplyGoodsQueue() {
		return createSupplyGoodsQueue;
	}

	public void setCreateSupplyGoodsQueue(String createSupplyGoodsQueue) {
		this.createSupplyGoodsQueue = createSupplyGoodsQueue;
	}

	public String getOnOffSaleSupplyGoodsQueue() {
		return onOffSaleSupplyGoodsQueue;
	}

	public void setOnOffSaleSupplyGoodsQueue(String onOffSaleSupplyGoodsQueue) {
		this.onOffSaleSupplyGoodsQueue = onOffSaleSupplyGoodsQueue;
	}

	@Bean
	public Queue createCategoryQueue() {
		return new Queue(createCategoryQueue);
	}

	@Bean
	public Queue createUnitsQueue() {
		return new Queue(createUnitsQueue);
	}

	@Bean
	public Queue deleteUnitsQueue() {
		return new Queue(deleteUnitsQueue);
	}

	@Bean
	public Queue createSupplyGoodsQueue() {
		return new Queue(createSupplyGoodsQueue);
	}

	@Bean
	public Queue onOffSaleSupplyGoodsQueue() {
		return new Queue(onOffSaleSupplyGoodsQueue);
	}

	@Bean
	TopicExchange exchange() {
		return new TopicExchange(exchange);
	}

	/**
	 * 将队列topic.message与exchange绑定，binding_key为topic.message,就是完全匹配
	 */
	@Bean
	Binding bindingCategoryQueue(@Qualifier("createCategoryQueue") Queue queue, TopicExchange exchange) {
		return BindingBuilder.bind(queue).to(exchange).with(createCategoryQueue);
	}

	@Bean
	Binding bindingUnitsQueue(@Qualifier("createUnitsQueue") Queue queue, TopicExchange exchange) {
		return BindingBuilder.bind(queue).to(exchange).with(createUnitsQueue);
	}

	@Bean
	Binding bindingDeleteUnitsQueue(@Qualifier("deleteUnitsQueue") Queue queue, TopicExchange exchange) {
		return BindingBuilder.bind(queue).to(exchange).with(deleteUnitsQueue);
	}

	@Bean
	Binding bindingCreateSupplyGoodsQueue(@Qualifier("createSupplyGoodsQueue") Queue queue, TopicExchange exchange) {
		return BindingBuilder.bind(queue).to(exchange).with(createSupplyGoodsQueue);
	}

	@Bean
	Binding bindingOnOffSaleSupplyGoodsQueue(@Qualifier("onOffSaleSupplyGoodsQueue") Queue queue, TopicExchange exchange) {
		return BindingBuilder.bind(queue).to(exchange).with(onOffSaleSupplyGoodsQueue);
	}

	@Bean
	@Primary
	public RabbitTemplate rabbitTemplate(ConnectionFactory connectionFactory) {
		RabbitTemplate rabbitTemplate = new RabbitTemplate(connectionFactory);
		rabbitTemplate.setMessageConverter(new Jackson2JsonMessageConverter());
		return rabbitTemplate;
	}

}
