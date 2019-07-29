package com.morning.star.retail.stock.listener.event;

import com.morning.star.retail.event.AbstractWithUserEvent;
import com.morning.star.retail.facade.dto.out.OutStockDTO;

/**
 * 采购入库单生成事件
 */
public class OutStockSuccessEvent extends AbstractWithUserEvent {

	public OutStockSuccessEvent(OutStockDTO source) {
		super(source);
	}

}
