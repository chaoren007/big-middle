package com.morning.star.retail.listener.mq;

import com.morning.star.retail.mq.MessageWithUserPostProcessor;
import com.morning.star.retail.util.Context;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.amqp.core.Queue;

public abstract class AbstractQueue<T> extends Queue {

	private String name;

	public String getRoutingKey() {
		return this.name;
	}

	public AbstractQueue(String name) {
		super(name, true);
		this.name = name;
	}

	public void send(T msg) {
		AmqpTemplate amqpTemplate = Context.getBean(AmqpTemplate.class);
		amqpTemplate.convertAndSend(this.getRoutingKey(), msg, new MessageWithUserPostProcessor());
	}

}
