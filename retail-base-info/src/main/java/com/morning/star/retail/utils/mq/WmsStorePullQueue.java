package com.morning.star.retail.utils.mq;

import com.morning.star.retail.facade.StoreWmsFacade;
import com.morning.star.retail.facade.dto.StoreWmsDTO;
import org.springframework.stereotype.Component;


@Component
public class WmsStorePullQueue extends AbstractQueue<StoreWmsDTO> {

	public WmsStorePullQueue() {
		super("topic." + StoreWmsFacade.class.getSimpleName() + "Impl");
	}

}
