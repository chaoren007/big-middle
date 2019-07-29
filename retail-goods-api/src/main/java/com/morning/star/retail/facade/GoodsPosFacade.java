package com.morning.star.retail.facade;

import com.morning.star.retail.facade.dto.GoodsDTO;
import com.morning.star.retail.facade.dto.GoodsPosSyncDTO;
import com.morning.star.retail.facade.dto.GoodsPosSyncQueryDTO;
import com.morning.star.retail.utils.page.PageBean;

import java.math.BigDecimal;
import java.util.List;

public interface GoodsPosFacade {

	PageBean<GoodsDTO> queryGoods(GoodsPosSyncQueryDTO dto);

	List<GoodsDTO> queryGoodsByUpc(GoodsPosSyncQueryDTO dto);

	void makePrice(String goodsCode, BigDecimal price);

}

