package com.morning.star.retail.application;

import com.morning.star.retail.facade.dto.GoodsPullDTO;
import com.morning.star.retail.facade.dto.GoodsSubmitDTO;
import com.morning.star.retail.facade.dto.GoodsUpdateDTO;
import com.morning.star.retail.facade.dto.ProductSyncGoodsDTO;

import java.math.BigDecimal;
import java.util.List;

/**
 * 店铺货品
 */
public interface GoodsApplication {

	void makePrice(String goodsCode, BigDecimal price);

	String createStoreGoods(GoodsPullDTO goodsPullDTO);

	void onSale(String code);

	void offSale(String code);

	void batchPull(List<GoodsPullDTO> goodsPullDTOS);

	void addGoods(List<GoodsSubmitDTO> dtos);

	void update(GoodsUpdateDTO dto);

	void syncGoods(String groupCode, String storeCode);

	void syncProductInfo(ProductSyncGoodsDTO dto);
}
