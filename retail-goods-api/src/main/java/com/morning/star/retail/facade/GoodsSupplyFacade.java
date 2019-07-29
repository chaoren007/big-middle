package com.morning.star.retail.facade;

import com.morning.star.retail.facade.dto.supply.*;
import com.morning.star.retail.utils.page.PageBean;

import java.util.List;

public interface GoodsSupplyFacade {

	void draft(GoodsSupplySubmitDTO dto);

	void submit(GoodsSupplySubmitDTO dto);

	void auditFail(GoodsSupplyAuditDTO dto);

	void auditSuccess(GoodsSupplyAuditDTO dto);

	void onSale(GoodsSupplyAuditDTO dto);

	void offSale(GoodsSupplyAuditDTO dto);

	void openGroup(GoodsSupplyAuditGroupDTO dto);

	void closeGroup(GoodsSupplyAuditGroupDTO dto);

	/**
	 * 获取商品全规格信息
	 */
	GoodsSupplyDTO getDetailBySupplyCode(String code);

	/**
	 * 获取商品全规格信息,供货区域分组
	 */
	GoodsSupplyDTO getDetailBySupplyCodeV2(String code);

	/**
	 * 获取单个规格商品信息
	 */
	GoodsSupplyDTO getDetailByProductCode(String code);

	PageBean<GoodsSupplyDTO> page(GoodsSupplyQueryDTO queryDTO);

	/**
	 * 运营端查询商品信息
	 * @param queryDTO
	 * @return
	 */
	PageBean<GoodsSupplyBusDTO> busPage(GoodsSupplyQueryDTO queryDTO);

	PageBean<GoodsSupplySimpleDTO> pageBySpu(GoodsSupplyQueryDTO queryDTO);

	List<GoodsSupplyLogDTO> getOperateLog(GoodsSupplyQueryDTO queryDTO);

	/**
	 * 销售扣减库存
	 */
	void saleOutStock(List<GoodsSupplyStockReduceDTO> dtoList);

	void remove(GoodsSupplyDelDTO dto);

}

