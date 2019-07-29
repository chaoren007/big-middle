package com.morning.star.retail.listener.mq;

import com.morning.star.retail.RabbitConfig;
import com.morning.star.retail.facade.dto.BusGoodsOnOffDTO;
import com.morning.star.retail.facade.dto.BusProductDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class OnOffSaleSupplyGoodsSender extends AbstractQueue<BusGoodsOnOffDTO> {
	@Autowired
	private RabbitConfig config;

	public OnOffSaleSupplyGoodsSender() {
		super(OnOffSaleSupplyGoodsSender.class.getSimpleName());
	}

	@Override
	public String getRoutingKey() {
		return config.getOnOffSaleSupplyGoodsQueue();
	}
}
