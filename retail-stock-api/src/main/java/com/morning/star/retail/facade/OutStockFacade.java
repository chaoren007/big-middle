package com.morning.star.retail.facade;

import com.morning.star.retail.facade.dto.out.*;
import com.morning.star.retail.utils.page.PageBean;

/**
 * 出库
 */
public interface OutStockFacade {

	/**
	 * 分页查询
	 */
	PageBean<OutStockDTO> pageQuery(OutStockQueryDTO queryDTO);

	/**
	 * 保存出库单
	 */
	void save(OutStockSubmitDTO outStockSubmitDTO);

	/**
	 * 删除出库单
	 */
	void delete(String code);

	/**
	 * 出库单详情
	 */
	OutStockDTO detail(OutStockGetDTO queryDTO);

	/**
	 * 审核出库单
	 */
	void audit(OutStockAuditDTO outStockAuditDTO);

	/**
	 * 出库
	 *
	 * @param
	 * @return
	 */
	void auditOut(OutStockOutDTO outStockOutDTO);

	/**
	 * 其他出库
	 *
	 * @param
	 * @return
	 */
	void wmsOutStock(OutStockDTO dto);

}
