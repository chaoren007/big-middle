package com.morning.star.retail.stock.listener;

import com.google.gson.Gson;
import com.morning.star.retail.facade.dto.purchase.PurchaseOrderDTO;
import com.morning.star.retail.stock.application.PurchaseInApplication;
import com.morning.star.retail.stock.listener.event.PurchaseAuditEvent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

/**
 * @author ethan
 * @create_time 2018/7/26 11:09
 */
@Component
public class PurchaseAuditListener implements ApplicationListener<PurchaseAuditEvent> {
	private static final Logger LOG = LoggerFactory.getLogger(PurchaseAuditListener.class);
	private static final Gson gson = new Gson();

	@Autowired
	private PurchaseInApplication purchaseInApplication;

	@Override
	@Async
	public void onApplicationEvent(PurchaseAuditEvent event) {
		PurchaseOrderDTO source = (PurchaseOrderDTO) event.getSource();
		LOG.info("采购入库单信息：" + gson.toJson(source));
		purchaseInApplication.pushThird(source.getPurchaseCode());
	}
}
