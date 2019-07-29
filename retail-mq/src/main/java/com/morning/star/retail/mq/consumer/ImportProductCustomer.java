package com.morning.star.retail.mq.consumer;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.morning.star.retail.facade.ProductFacade;
import com.morning.star.retail.facade.dto.ProductImportDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * @author ethan
 * @create_time 2018/7/31 10:35
 * 商品添加消息队列监听
 */
@Component
public class ImportProductCustomer {
	private static Logger logger = LoggerFactory.getLogger(ImportProductCustomer.class);
	private static ObjectMapper mapper = new ObjectMapper();

	@Autowired
	private ProductFacade productFacade;

	static {
		mapper.setVisibility(PropertyAccessor.FIELD, JsonAutoDetect.Visibility.ANY);
		mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
		mapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);
		mapper.configure(SerializationFeature.FAIL_ON_EMPTY_BEANS, false);
	}

	@RabbitListener(queues = "ImportProductQueue")
	public void onMessage(Message msg) {
		try {
			JsonNode json = mapper.readTree(msg.getBody());

			List<ProductImportDTO> dataList = new ArrayList<>();
			for (final JsonNode objNode : json) {
				dataList.add(mapper.convertValue(objNode, ProductImportDTO.class));
			}
			productFacade.importProduct(dataList);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
