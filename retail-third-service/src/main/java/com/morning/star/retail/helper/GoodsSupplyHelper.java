package com.morning.star.retail.helper;

import com.morning.star.retail.facade.GoodsSupplyFacade;
import com.morning.star.retail.facade.dto.supply.GoodsSupplyAuditGroupDTO;
import com.morning.star.retail.facade.dto.supply.GoodsSupplyBusDTO;
import com.morning.star.retail.facade.dto.supply.GoodsSupplyDTO;
import com.morning.star.retail.facade.dto.supply.GoodsSupplyQueryDTO;
import com.morning.star.retail.utils.page.PageBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GoodsSupplyHelper {

	@Autowired
	private GoodsSupplyFacade goodsSupplyFacade;

	public void busAuditOpenGroup(GoodsSupplyAuditGroupDTO dto) {
		goodsSupplyFacade.openGroup(dto);
	}

	public void busAuditOpenGroupEnd(GoodsSupplyAuditGroupDTO dto) {
		goodsSupplyFacade.closeGroup(dto);
	}

	public PageBean<GoodsSupplyBusDTO> page(GoodsSupplyQueryDTO queryDTO) {
		return goodsSupplyFacade.busPage(queryDTO);
	}

	public GoodsSupplyDTO getDetailBySupplyCode(String code) {
		return goodsSupplyFacade.getDetailBySupplyCode(code);
	}

	/**
	 * 获取单个规格商品信息
	 */
	public GoodsSupplyDTO getDetailByProductCode(String code) {
		return goodsSupplyFacade.getDetailByProductCode(code);
	}
}
