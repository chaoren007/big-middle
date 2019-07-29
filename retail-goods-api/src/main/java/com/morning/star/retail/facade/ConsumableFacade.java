package com.morning.star.retail.facade;

import com.morning.star.retail.facade.dto.*;
import com.morning.star.retail.utils.page.PageBean;

import java.util.List;


public interface ConsumableFacade {

	/**
	 * 添加耗材信息
	 */
	void addConsumable(List<ConsumableAddDTO> dtos);

	/**
	 * 导入耗材数量
	 */
	void importConsumable(List<ConsumableImportDTO> dtos);

	/**
	 * 使用耗材
	 */
	void useConsumable(ConsumableUseReturnDTO dto);

	/**
	 * 归还耗材
	 */
	void backConsumable(ConsumableUseReturnDTO dto);

	/**
	 * 查询耗材信息
	 */
	PageBean<ConsumableDTO> query(ConsumableQueryDTO dto);

	PageBean<ConsumableWaterDTO> getLog(ConsumableWaterQueryDTO dto);
}
