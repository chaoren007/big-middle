package com.morning.star.retail.listener;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.morning.star.retail.facade.BusTransferFacade;
import com.morning.star.retail.facade.KingdeeAddGoodsFacade;
import com.morning.star.retail.facade.dto.BusGoodsOnOffDTO;
import com.rabbitmq.client.Channel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class OnOffSupplyGoodsListener {
    @Autowired
    private BusTransferFacade busTransferFacade;
    @Autowired
    private KingdeeAddGoodsFacade kingdeeAddGoodsFacade;

    private static Logger log = LoggerFactory.getLogger(OnOffSupplyGoodsListener.class);

    private static ObjectMapper mapper = new ObjectMapper();

    static {
        mapper.setVisibility(PropertyAccessor.FIELD, JsonAutoDetect.Visibility.ANY);
        mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        mapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);
        mapper.configure(SerializationFeature.FAIL_ON_EMPTY_BEANS, false);
    }

    @RabbitListener(queues = "topic.OnOffSaleSupplyGoodsQueue")
    public void add(Message msg, Channel channel) throws IOException {
        log.info("========================================接收消息队列:topic.OnOffSaleSupplyGoodsQueue");
        try {
            JsonNode json = mapper.readTree(msg.getBody());
            log.info("推送到运营端商品：" + json);
            BusGoodsOnOffDTO dto = mapper.convertValue(json, BusGoodsOnOffDTO.class);
            //busTransferFacade.onOffGoods(dto);
            if (BusGoodsOnOffDTO.AUDIT_ON.equals(dto.getStatus())) {
                //传数据到金蝶云
                kingdeeAddGoodsFacade.add(dto.getGoodsSupplyCode());
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            channel.basicAck(msg.getMessageProperties().getDeliveryTag(), false);
        }
    }
}
