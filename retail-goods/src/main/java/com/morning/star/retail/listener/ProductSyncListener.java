package com.morning.star.retail.listener;

import com.alibaba.fastjson.JSON;
import com.morning.star.retail.application.GoodsApplication;
import com.morning.star.retail.facade.dto.ProductSyncGoodsDTO;
import com.morning.star.retail.listener.event.ProductSyncEvent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author ethan
 * @create_time 2018/7/26 11:09
 */
@Component
public class ProductSyncListener implements ApplicationListener<ProductSyncEvent> {
	private static final Logger LOG = LoggerFactory.getLogger(ProductSyncListener.class);

	@Autowired
	private GoodsApplication goodsApplication;

	@Override
	@Async
	public void onApplicationEvent(ProductSyncEvent event) {
		List<ProductSyncGoodsDTO> productSyncGoodsDTOS = (List<ProductSyncGoodsDTO>) event.getSource();
		syncProductToGoods(productSyncGoodsDTOS);
	}

	private void syncProductToGoods(List<ProductSyncGoodsDTO> dtos) {
		LOG.info("开始同步集团货品数据到门店商品:" + JSON.toJSONString(dtos));
		if (dtos != null && dtos.size() > 0) {
			dtos.forEach(e -> goodsApplication.syncProductInfo(e));
		}
	}
}
