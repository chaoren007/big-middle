package com.morning.star.retail.listener.event;

import com.morning.star.retail.event.AbstractWithUserEvent;
import com.morning.star.retail.facade.dto.ProductSyncGoodsDTO;

import java.util.List;

/**
 * 集团添加商品事件
 */
public class ProductSyncEvent extends AbstractWithUserEvent {

	public ProductSyncEvent(List<ProductSyncGoodsDTO> source) {
		super(source);
	}

}
