package com.morning.star.retail.listener.event;

import com.morning.star.retail.entity.ProductEntity;
import com.morning.star.retail.event.AbstractWithUserEvent;

import java.util.List;

/**
 * 集团添加商品事件
 */
public class ProductAddEvent extends AbstractWithUserEvent {

	public ProductAddEvent(List<ProductEntity> source) {
		super(source);
	}

}
