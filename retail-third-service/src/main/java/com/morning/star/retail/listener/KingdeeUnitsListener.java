package com.morning.star.retail.listener;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.morning.star.retail.facade.KingdeeUnitsFacade;
import com.morning.star.retail.facade.dto.UnitsKdDTO;
import com.rabbitmq.client.Channel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class KingdeeUnitsListener {

    @Autowired
    private KingdeeUnitsFacade unitsFdFacade;
    private static Logger log = LoggerFactory.getLogger(KingdeeUnitsListener.class);

    private static ObjectMapper mapper = new ObjectMapper();

    static {
        mapper.setVisibility(PropertyAccessor.FIELD, JsonAutoDetect.Visibility.ANY);
        mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        mapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);
        mapper.configure(SerializationFeature.FAIL_ON_EMPTY_BEANS, false);
    }

    @RabbitListener(queues = "topic.KdUnitsFacadeImpl")
    public void add(Message msg, Channel channel) throws IOException {
        log.info("========================================发送消息队列:topic.UnitsKdFacadeImpl");
        try {
            JsonNode json = mapper.readTree(msg.getBody());
            log.info("kingdee添加单位信息监听参数：" + json);
            UnitsKdDTO dto = mapper.convertValue(json, UnitsKdDTO.class);
            unitsFdFacade.add(dto);
        } catch (Exception e) {
            log.info("==============异常================"+e);
        } finally {
            channel.basicAck(msg.getMessageProperties().getDeliveryTag(), false);
        }
    }


    @RabbitListener(queues = "topic.KdDeleteUnits")
    public void delete(Message msg, Channel channel) throws IOException {
        try {
            JsonNode json = mapper.readTree(msg.getBody());
            log.info("kingdee删除单位信息监听参数：" + json);
            UnitsKdDTO dto = mapper.convertValue(json.get("msg"), UnitsKdDTO.class);
            unitsFdFacade.delete(dto);
        } catch (Exception e) {
            log.info("==============异常================"+e);
        } finally {
            channel.basicAck(msg.getMessageProperties().getDeliveryTag(), false);
        }
    }
}
