package com.morning.star.retail.facade;

import java.util.List;

import com.morning.star.retail.facade.dto.UnitsAddDTO;
import com.morning.star.retail.facade.dto.UnitsDTO;
import com.morning.star.retail.facade.dto.UnitsQueryDTO;
import com.morning.star.retail.utils.page.PageBean;

/**
 * 单位
 *
 * @author obama
 */
public interface UnitsFacade {
	void create(UnitsAddDTO dto);

	PageBean<UnitsDTO> queryPage(UnitsQueryDTO dto);

	void delete(Long id);

	List<UnitsDTO> queryList();
}
