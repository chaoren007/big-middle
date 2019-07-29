package com.morning.star.retail.mq.consumer;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * @author ethan
 * @create_time 2018/7/31 10:35
 * 商品添加消息队列监听
 */
@Component
public class ImportGoodsCustomer {
	private static Logger logger = LoggerFactory.getLogger(ImportGoodsCustomer.class);
	private static ObjectMapper mapper = new ObjectMapper();

	static {
		mapper.setVisibility(PropertyAccessor.FIELD, JsonAutoDetect.Visibility.ANY);
		mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
		mapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);
		mapper.configure(SerializationFeature.FAIL_ON_EMPTY_BEANS, false);
	}

	@RabbitListener(queues = "ImportGoodsQueue")
	public void onMessage(Message msg) {
		try {
			JsonNode json = mapper.readTree(msg.getBody());
			logger.info("messages ：" + json.toString());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
