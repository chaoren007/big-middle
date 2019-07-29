package com.morning.star.retail.listener.mq;

import com.morning.star.retail.facade.ProductWmsFacade;
import com.morning.star.retail.facade.dto.GoodsWmsDTO;
import org.springframework.stereotype.Component;

@Component
public class WmsGoodPullQueue extends AbstractQueue<GoodsWmsDTO> {

	public WmsGoodPullQueue() {
		super("topic." + ProductWmsFacade.class.getSimpleName() + "Impl");
	}

}
