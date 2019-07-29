package com.morning.star.retail.facade;

import com.morning.star.retail.facade.dto.MoveStockWmsDTO;
import com.morning.star.retail.facade.dto.OutStockWmsDTO;

/**
 *移库订单业务数据
 * @author kimhuhg
 */
public interface MoveStockWmsFacade {
	/**
	 *
	 * @param dto
	 * @return 返回1为成功，0为失败
	 */
	Integer add(MoveStockWmsDTO dto);
}
