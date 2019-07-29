package com.morning.star.retail.mq.consumer;

import com.alibaba.fastjson.JSON;
import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.morning.star.retail.facade.GoodsAdminFacade;
import com.morning.star.retail.facade.dto.ProductSyncGoodsDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author ethan
 * @create_time 2018/7/31 10:35
 * 货品修改后同步修改相关商品信息
 */
@Component
public class SyncProductCustomer {
	private static Logger logger = LoggerFactory.getLogger(SyncProductCustomer.class);
	private static ObjectMapper mapper = new ObjectMapper();

	@Autowired
	private GoodsAdminFacade goodsAdminFacade;

	static {
		mapper.setVisibility(PropertyAccessor.FIELD, JsonAutoDetect.Visibility.ANY);
		mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
		mapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);
		mapper.configure(SerializationFeature.FAIL_ON_EMPTY_BEANS, false);
	}

	@RabbitListener(queues = "SyncProductQueue")
	public void onMessage(Message msg) {
		JsonNode json = null;
		try {
			json = mapper.readTree(msg.getBody());
		} catch (IOException e) {
			e.printStackTrace();
		}

		logger.info("messages ：" + json.toString());
		List<ProductSyncGoodsDTO> dataList = new ArrayList<>();
		for (final JsonNode objNode : json) {
			dataList.add(mapper.convertValue(objNode, ProductSyncGoodsDTO.class));
		}
		syncProductToGoods(dataList);

	}

	private void syncProductToGoods(List<ProductSyncGoodsDTO> dtos) {
		logger.info("开始同步集团货品数据到门店商品:" + JSON.toJSONString(dtos));
		if (dtos != null && dtos.size() > 0) {
			dtos.forEach(item -> goodsAdminFacade.syncProductInfo(item));
		}
	}
}
