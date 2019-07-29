package com.morning.star.retail.listener.mq;

import com.morning.star.retail.facade.dto.ProductSyncGoodsDTO;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author ethan
 * @create_time 2018/7/31 14:20
 */
@Component
public class SyncProductQueue extends AbstractQueue<List<ProductSyncGoodsDTO>> {
	public SyncProductQueue() {
		super(SyncProductQueue.class.getSimpleName());
	}
}
