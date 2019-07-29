package com.morning.star.retail.stock.listener.mq;

import com.morning.star.retail.event.AbstractWithUserEvent;
import com.morning.star.retail.stock.dto.InventorySubmitDTO;
import org.springframework.stereotype.Component;

public class SubmitInventoryQueue extends AbstractWithUserEvent {

	public SubmitInventoryQueue(InventorySubmitDTO source) {
		super(source, false, true);
	}

}
