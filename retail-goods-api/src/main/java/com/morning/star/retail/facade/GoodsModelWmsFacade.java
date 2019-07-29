package com.morning.star.retail.facade;

/**
 * @author Dell
 * <p>
 * 推送WMS服务
 */
public interface GoodsModelWmsFacade {
	void pushGoods(String goodsCode);

	void pushGoodsByProduct(String storeCode, String productCode);

	void pushCategory(Long id);
}
