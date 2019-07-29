package com.morning.star.retail.facade.impl;

import com.morning.star.retail.RabbitConfig;
import com.morning.star.retail.entity.CategoryEntity;
import com.morning.star.retail.entity.GoodsEntity;
import com.morning.star.retail.entity.repository.CategoryRepository;
import com.morning.star.retail.entity.repository.GoodsRepository;
import com.morning.star.retail.facade.GoodsModelWmsFacade;
import com.morning.star.retail.facade.dto.CategoryWmsDTO;
import com.morning.star.retail.facade.dto.GoodsWmsDTO;
import com.morning.star.retail.helper.MqHelperService;
import com.morning.star.retail.listener.mq.WmsGoodPullQueue;
import org.apache.commons.lang3.Validate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author ethan
 * @create_time 2018/12/28 10:03
 */
@Service
public class GoodsModelWmsFacadeImpl implements GoodsModelWmsFacade {

	@Autowired
	private GoodsRepository goodsRepository;
	@Autowired
	private CategoryRepository categoryRepository;

	@Autowired
	private WmsGoodPullQueue wmsGoodPullQueue;

	@Autowired
	private RabbitConfig rabbitConfig;
	@Autowired
	private MqHelperService mqHelperService;

	@Override
	public void pushGoods(String goodsCode) {
		GoodsEntity entity = goodsRepository.findOne(goodsCode);
		Validate.notNull(entity, "商品信息不存在：" + goodsCode);
		GoodsWmsDTO wmsDTO = GoodsEntity.toWmsDTO(entity);
		wmsGoodPullQueue.send(wmsDTO);
	}

	@Override
	public void pushGoodsByProduct(String storeCode, String productCode) {
		GoodsEntity entity = goodsRepository.getByStoreCodeAndProductInfoProductCode(storeCode, productCode);
		Validate.notNull(entity, "商品信息不存在：" + productCode);
		GoodsWmsDTO wmsDTO = GoodsEntity.toWmsDTO(entity);
		wmsGoodPullQueue.send(wmsDTO);
	}

	@Override
	public void pushCategory(Long id) {
		CategoryEntity entity = categoryRepository.getByCategoryId(id);
		Validate.notNull(entity, "分类信息不存在：" + id);
		CategoryWmsDTO wms = CategoryEntity.toWmsDTO(entity);
		mqHelperService.send(rabbitConfig.getExchange(), rabbitConfig.getCreateCategoryQueue(), wms);
	}
}
