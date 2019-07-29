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

	@Value("${topic_name}")
	private String topicName;

	@Value("${queue.import.goods}")
	private String importGoodsQueue;

	public String getTopicName() {
		return topicName;
	}

	public String getImportGoodsQueue() {
		return importGoodsQueue;
	}


	@Bean
	public Queue importGoodsQueue() {
		return new Queue(getImportGoodsQueue(), true);
	}


	@Bean
	TopicExchange exchange() {
		TopicExchange exchange = new TopicExchange(getTopicName());
		return exchange;
	}

	@Bean
	Binding binding1(@Qualifier("importGoodsQueue")Queue queue, TopicExchange exchange) {
		return BindingBuilder.bind(queue).to(exchange).with(importGoodsQueue);
	}

	@Bean
	@Primary
	public RabbitTemplate rabbitTemplate(ConnectionFactory connectionFactory) {
		RabbitTemplate rabbitTemplate = new RabbitTemplate(connectionFactory);
		rabbitTemplate.setMessageConverter(new Jackson2JsonMessageConverter());
		return rabbitTemplate;
	}
}
