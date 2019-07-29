package com.morning.star.retail.application;

import com.morning.star.retail.facade.dto.*;

import java.util.List;


public interface ConsumableApplication {

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
}
