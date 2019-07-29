package com.morning.star.retail.stock.facade.impl;

import com.github.pagehelper.Page;
import com.morning.star.retail.facade.OutStockFacade;
import com.morning.star.retail.facade.dto.out.*;
import com.morning.star.retail.stock.application.OutStockApplication;
import com.morning.star.retail.stock.dao.OutStockDAO;
import com.morning.star.retail.stock.entity.OutStockEntity;
import com.morning.star.retail.stock.entity.repository.OutStockRepository;
import com.morning.star.retail.utils.page.PageBean;
import com.morning.star.retail.utils.page.PageBeanAssembler;
import com.morning.star.retail.utils.page.RowBoundsBuilder;
import org.apache.commons.lang.Validate;
import org.apache.ibatis.session.RowBounds;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OutStockFacadeImpl implements OutStockFacade {
	@Autowired
	private OutStockApplication outStockApplication;
	@Autowired
	private OutStockDAO outStockDAO;
	@Autowired
	private OutStockRepository outStockRepository;


	@Override
	public PageBean<OutStockDTO> pageQuery(OutStockQueryDTO queryDTO) {
		RowBounds rowBounds = RowBoundsBuilder.build(queryDTO.getPageNo(), queryDTO.getPageSize());
		Page<OutStockDTO> page = outStockDAO.queryPage(queryDTO, rowBounds);
		return new PageBeanAssembler().toBean(page);
	}

	@Override
	public void save(OutStockSubmitDTO outStockSubmitDTO) {
		outStockApplication.save(outStockSubmitDTO);
	}

	@Override
	public void delete(String code) {
		outStockApplication.delete(code);
	}

	@Override
	public OutStockDTO detail(OutStockGetDTO outStockGetDTO) {
		OutStockEntity entity = outStockRepository.findOne(outStockGetDTO.getOutStockCode());
		Validate.notNull(entity, "该出库单不存在");
		return OutStockEntity.toDTO(entity);
	}

	@Override
	public void audit(OutStockAuditDTO outStockAuditDTO) {
		outStockApplication.audit(outStockAuditDTO);
	}

	@Override
	public void auditOut(OutStockOutDTO outStockOutDTO) {
		outStockApplication.auditOut(outStockOutDTO);
	}

	@Override
	public void wmsOutStock(OutStockDTO dto) {
		outStockApplication.wmsOutStock(dto);
	}

}
