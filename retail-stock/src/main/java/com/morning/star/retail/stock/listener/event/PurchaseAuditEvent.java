package com.morning.star.retail.stock.listener.event;

import com.morning.star.retail.event.AbstractWithUserEvent;
import com.morning.star.retail.facade.dto.purchase.PurchaseOrderDTO;

/**
 * 采购订单审核事件
 */
public class PurchaseAuditEvent extends AbstractWithUserEvent {

	public PurchaseAuditEvent(PurchaseOrderDTO source) {
		super(source);
	}

}
