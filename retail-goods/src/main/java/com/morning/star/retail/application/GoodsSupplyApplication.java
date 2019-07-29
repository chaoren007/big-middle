package com.morning.star.retail.application;

import com.morning.star.retail.enums.GoodsSupplyStatus;
import com.morning.star.retail.facade.dto.supply.*;

import java.util.List;

/**
 * 店铺货品
 */
public interface GoodsSupplyApplication {

	GoodsSupplyDTO submit(GoodsSupplySubmitDTO dto, GoodsSupplyStatus status);

	void audit(GoodsSupplyAuditDTO dto, GoodsSupplyStatus status);

	void auditGroup(GoodsSupplyAuditGroupDTO dto, GoodsSupplyStatus status);

	void saleOutStock(List<GoodsSupplyStockReduceDTO> dtoList);

	void remove(GoodsSupplyDelDTO dto);
}
