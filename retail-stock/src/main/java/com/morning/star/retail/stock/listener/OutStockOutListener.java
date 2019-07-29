package com.morning.star.retail.stock.listener;

import com.google.gson.Gson;
import com.morning.star.retail.facade.dto.out.OutStockDTO;
import com.morning.star.retail.stock.helper.OutStockWmsService;
import com.morning.star.retail.stock.listener.event.OutStockSuccessEvent;
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
public class OutStockOutListener implements ApplicationListener<OutStockSuccessEvent> {
	private static final Logger LOG = LoggerFactory.getLogger(OutStockOutListener.class);
	private static final Gson gson = new Gson();

	@Autowired
	private OutStockWmsService outStockWmsService;

	@Override
	@Async
	public void onApplicationEvent(OutStockSuccessEvent event) {
		OutStockDTO source = (OutStockDTO) event.getSource();
		LOG.info("出库单信息：" + gson.toJson(source));
//		outStockWmsService.addByOutStock(source);
	}
}
