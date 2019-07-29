package com.morning.star.retail.listener;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.morning.star.retail.facade.BusTransferFacade;
import com.morning.star.retail.facade.assembler.BusGoodsAssembler;
import com.morning.star.retail.facade.dto.BusGoodsDTO;
import com.morning.star.retail.facade.dto.supply.GoodsSupplyDTO;
import com.rabbitmq.client.Channel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class CreateSupplyGoodsListener {
	@Autowired
	private BusTransferFacade busTransferFacade;


	private static Logger log = LoggerFactory.getLogger(CreateSupplyGoodsListener.class);

	private static ObjectMapper mapper = new ObjectMapper();

	static {
		mapper.setVisibility(PropertyAccessor.FIELD, JsonAutoDetect.Visibility.ANY);
		mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
		mapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);
		mapper.configure(SerializationFeature.FAIL_ON_EMPTY_BEANS, false);
	}

	@RabbitListener(queues = "topic.CreateSupplyGoodsQueue")
	public void add(Message msg, Channel channel) throws IOException {
		log.info("========================================接收消息队列:topic.CreateSupplyGoodsQueue");
		try {
			JsonNode json = mapper.readTree(msg.getBody());
			log.info("推送到运营端商品：" + json);
//			GoodsSupplyDTO dto = mapper.convertValue(json, GoodsSupplyDTO.class);
//			busTransferFacade.addGoods(BusGoodsAssembler.builder(dto));
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			channel.basicAck(msg.getMessageProperties().getDeliveryTag(), false);
		}
	}
}
