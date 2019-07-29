package com.morning.star.retail.stock.dao;

import org.apache.ibatis.session.RowBounds;

import com.github.pagehelper.Page;
import com.morning.star.retail.facade.dto.purchase.PurchaseOrderDetailDTO;
import com.morning.star.retail.facade.dto.purchase.PurchaseOrderRptDTO;
import com.morning.star.retail.facade.dto.purchase.PurchaseOrderSimpleDTO;
import com.morning.star.retail.facade.dto.purchase.PurchaseQueryDTO;

public interface PurchaseOrderDAO {

	Page<PurchaseOrderSimpleDTO> queryPage(PurchaseQueryDTO purchaseQueryDTO, RowBounds rowBounds);

	Page<PurchaseOrderDetailDTO> queryPurchaseDetail(PurchaseQueryDTO purchaseQueryDTO, RowBounds rowBounds);
	
	/**
	 * 采购明细报表
	 * @param purchaseQueryDTO
	 * @return
	 */
	Page<PurchaseOrderRptDTO> queryPurchaseDetailRpt(PurchaseQueryDTO purchaseQueryDTO, RowBounds rowBounds);
}
