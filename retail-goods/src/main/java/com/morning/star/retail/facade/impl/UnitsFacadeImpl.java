package com.morning.star.retail.facade.impl;

import java.util.List;

import org.apache.ibatis.session.RowBounds;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.Page;
import com.morning.star.retail.application.UnitsApplication;
import com.morning.star.retail.dao.UnitsDAO;
import com.morning.star.retail.facade.UnitsFacade;
import com.morning.star.retail.facade.dto.UnitsAddDTO;
import com.morning.star.retail.facade.dto.UnitsDTO;
import com.morning.star.retail.facade.dto.UnitsQueryDTO;
import com.morning.star.retail.utils.page.PageBean;
import com.morning.star.retail.utils.page.PageBeanAssembler;
import com.morning.star.retail.utils.page.RowBoundsBuilder;

@Service
public class UnitsFacadeImpl implements UnitsFacade {
	@Autowired
	private UnitsApplication unitsApplication;
	@Autowired
	private UnitsDAO unitsDAO;
	
	@Override
	public void create(UnitsAddDTO dto) {
		unitsApplication.create(dto);	
	}
	@Override
	public void delete(Long id) {
		unitsApplication.delete(id);
	}
	@Override
	public PageBean<UnitsDTO> queryPage(UnitsQueryDTO dto) {
		RowBounds build = RowBoundsBuilder.build(dto.getPageNo(), dto.getPageSize());
		if("".equals(dto.getUnitsName())){
			dto.setUnitsName(null);
		}
		Page<UnitsDTO> queryByPage = unitsDAO.queryPage(dto,build);
		
		return new PageBeanAssembler().toBean(queryByPage);
	}
	@Override
	public List<UnitsDTO> queryList() {
		
		return unitsDAO.queryList();
	}

	
}
