package com.morning.star.retail.facade.impl;

import com.github.pagehelper.Page;
import com.morning.star.retail.application.ConsumableApplication;
import com.morning.star.retail.dao.ConsumableDAO;
import com.morning.star.retail.dao.ConsumableLogDAO;
import com.morning.star.retail.facade.ConsumableFacade;
import com.morning.star.retail.facade.dto.*;
import com.morning.star.retail.utils.page.PageBean;
import com.morning.star.retail.utils.page.PageBeanAssembler;
import com.morning.star.retail.utils.page.RowBoundsBuilder;
import org.apache.ibatis.session.RowBounds;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author ethan
 * @create_time 2018/8/7 14:41
 */
@Service
public class ConsumableFacadeImpl implements ConsumableFacade {
	@Autowired
	private ConsumableApplication consumableApplication;

	@Autowired
	private ConsumableLogDAO consumableLogDAO;

	@Autowired
	private ConsumableDAO consumableDAO;

	@Override
	public void addConsumable(List<ConsumableAddDTO> dtos) {
		consumableApplication.addConsumable(dtos);
	}

	@Override
	public void importConsumable(List<ConsumableImportDTO> dtos) {
		consumableApplication.importConsumable(dtos);
	}

	@Override
	public void useConsumable(ConsumableUseReturnDTO dto) {
		consumableApplication.useConsumable(dto);
	}

	@Override
	public void backConsumable(ConsumableUseReturnDTO dto) {
		consumableApplication.backConsumable(dto);
	}

	@Override
	public PageBean<ConsumableDTO> query(ConsumableQueryDTO dto) {
		RowBounds rowBounds = RowBoundsBuilder.build(dto.getPageNo(), dto.getPageSize());
		Page<ConsumableDTO> page = consumableDAO.query(dto, rowBounds);
		return new PageBeanAssembler().toBean(page);
	}

	@Override
	public PageBean<ConsumableWaterDTO> getLog(ConsumableWaterQueryDTO dto) {
		RowBounds rowBounds = RowBoundsBuilder.build(dto.getPageNo(), dto.getPageSize());
		Page<ConsumableWaterDTO> page = consumableLogDAO.query(dto, rowBounds);
		return new PageBeanAssembler().toBean(page);
	}
}
