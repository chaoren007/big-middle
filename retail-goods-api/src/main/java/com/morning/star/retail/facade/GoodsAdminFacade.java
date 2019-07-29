package com.morning.star.retail.facade;

import com.morning.star.retail.facade.dto.*;
import com.morning.star.retail.utils.page.PageBean;

import java.math.BigDecimal;
import java.util.List;

/**
 * 店铺货品
 */
public interface GoodsAdminFacade {

	void makePrice(String goodsCode, BigDecimal price);

	GoodsDTO getGoods(String goodsCode);

	GoodsDTO getBySapCode(String storeCode, String sapCode);

	/**
	 * 获取商品的母码商品
	 * @param goodsCode
	 * @return
	 */
	GoodsDTO getMotherGoods(String goodsCode);

	GoodsDTO getGoodsByCode(String storeCode, String productCode);

	List<GoodsDTO> getGoodsByUpc(String storeCode, String upcCode);

	String createStoreGoods(GoodsPullDTO goodsPullDTO);

	void onSale(String code);

	void offSale(String code);

	PageBean<GoodsDTO> queryGoods(GoodsQueryDTO dto);

	List<GoodsDTO> queryList(GoodsQueryDTO dto);

	PageBean<GoodsDTO> queryGoodsForCity(GoodsQueryDTO dto);

	void batchPull(List<GoodsPullDTO> goodsPullDTOS);

	void addGoods(List<GoodsSubmitDTO> dtos);

	void update(GoodsUpdateDTO dto);

	void syncGoods(String groupCode, String storeCode);

	/**
	 * 集团货品修改后同步到相关商品信息上
	 * @param dto
	 */
	void syncProductInfo(ProductSyncGoodsDTO dto);

}

