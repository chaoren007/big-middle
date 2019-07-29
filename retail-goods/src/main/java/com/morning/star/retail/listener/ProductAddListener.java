package com.morning.star.retail.listener;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

import com.morning.star.retail.application.GoodsApplication;
import com.morning.star.retail.entity.ProductEntity;
import com.morning.star.retail.facade.dto.GoodsPullDTO;
import com.morning.star.retail.helper.StoreService;
import com.morning.star.retail.helper.vo.StoreInfo;
import com.morning.star.retail.listener.event.ProductAddEvent;

/**
 * @author ethan
 * @create_time 2018/7/26 11:09
 */
@Component
public class ProductAddListener implements ApplicationListener<ProductAddEvent> {
	private static final Logger LOG = LoggerFactory.getLogger(ProductAddListener.class);

	@Autowired
	private GoodsApplication goodsApplication;

	@Autowired
	private StoreService storeService;

	@Override
	@Async
	public void onApplicationEvent(ProductAddEvent event) {
		List<ProductEntity> productEntityList = (List<ProductEntity>) event.getSource();
		if (productEntityList.size() > 0) {
			syncProductToStore(productEntityList);
		}
	}

	private void syncProductToStore(List<ProductEntity> productEntityList) {
		LOG.info("开始同步集团商品数据:" + productEntityList.size());
		String groupCode = productEntityList.get(0).getGroupCode();
		List<StoreInfo> storeInfoList = storeService.queryByGroupCode(groupCode);
		if (storeInfoList != null && storeInfoList.size() > 0) {
			storeInfoList.forEach(storeInfo -> {
				List<GoodsPullDTO> goodsPullDTOS = new ArrayList<>(productEntityList.size());
				productEntityList.forEach(productEntity -> {
					LOG.info("同步集团商品数据:" + storeInfo.getStoreCode() + "/" + productEntity.getProductCode());
					GoodsPullDTO goodsPullDTO = new GoodsPullDTO();
					goodsPullDTO.setGroupCode(productEntity.getGroupCode());
					goodsPullDTO.setStoreCode(storeInfo.getStoreCode());
					goodsPullDTO.setProductCode(productEntity.getProductCode());

					goodsPullDTOS.add(goodsPullDTO);
				});
				//goodsApplication.batchPull(goodsPullDTOS);
			});
		}
	}
}
