package com.morning.star.retail.stock.dao;

import com.github.pagehelper.Page;
import com.morning.star.retail.facade.dto.purchase.PurchaseOrderDetailDTO;
import com.morning.star.retail.facade.dto.purchase.PurchaseQueryDTO;

public interface PurchaseOrderDetailDAO {

	/**
	 * 查询采购单
	 *
	 * @param purchaseQueryDTO
	 * @return
	 */
	Page<PurchaseOrderDetailDTO> queryDetail(PurchaseQueryDTO purchaseQueryDTO);


}
