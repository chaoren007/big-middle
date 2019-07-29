package com.morning.star.retail.stock.listener.event;

import com.morning.star.retail.event.AbstractWithUserEvent;
import com.morning.star.retail.stock.dto.ReceiptAddEventDTO;

/**
 * 入库单生成事件
 */
public class ReceiptAddEvent extends AbstractWithUserEvent {

	public ReceiptAddEvent(ReceiptAddEventDTO source) {
		super(source);
	}

}
