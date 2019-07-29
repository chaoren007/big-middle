package com.morning.star.retail.application;

import com.morning.star.retail.facade.dto.UnitsAddDTO;

/**
 * 单位
 *
 * @author ethan
 */
public interface UnitsApplication {

	void create(UnitsAddDTO dto);

	void delete(Long id);
	

}
