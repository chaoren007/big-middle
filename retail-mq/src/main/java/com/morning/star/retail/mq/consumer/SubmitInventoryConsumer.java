package com.morning.star.retail.mq.consumer;

import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.morning.star.retail.facade.InventoryFacade;
import com.morning.star.retail.stock.dto.InventorySubmitDTO;
import com.morning.star.retail.util.Json;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class SubmitInventoryConsumer {
    private static final Logger LOGGER = LoggerFactory.getLogger(SubmitInventoryConsumer.class);
    private static ObjectMapper mapper = new ObjectMapper();

    @Autowired
    private InventoryFacade inventoryFacade;

    static {
        mapper.setVisibility(PropertyAccessor.FIELD, Visibility.ANY);
        mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        mapper.setSerializationInclusion(Include.NON_NULL);
        mapper.configure(SerializationFeature.FAIL_ON_EMPTY_BEANS, false);
    }

    @RabbitListener(queues = "SubmitInventoryQueue")
    public void onMessage(Message msg) {
        try {
            LOGGER.info(" start ------------------------ SubmitInventoryConsumer ------------------------ ");
            JsonNode json = mapper.readTree(msg.getBody());

            InventorySubmitDTO formDTO = Json.from(json, InventorySubmitDTO.class);
            inventoryFacade.save(formDTO);
            LOGGER.info(" end ------------------------ SubmitInventoryConsumer ------------------------ ");
        } catch (IOException e) {
            LOGGER.error("import stock consumer", e);
        }
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
        }
    }

}
