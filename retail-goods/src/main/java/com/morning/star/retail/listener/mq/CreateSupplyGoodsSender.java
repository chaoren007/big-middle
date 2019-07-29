package com.morning.star.retail.listener.mq;

import com.morning.star.retail.RabbitConfig;
import com.morning.star.retail.facade.dto.supply.GoodsSupplyDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CreateSupplyGoodsSender extends AbstractQueue<GoodsSupplyDTO> {
	@Autowired
	private RabbitConfig config;

	public CreateSupplyGoodsSender() {
		super(CreateSupplyGoodsSender.class.getSimpleName());
	}

	@Override
	public String getRoutingKey() {
		return config.getCreateSupplyGoodsQueue();
	}
}
