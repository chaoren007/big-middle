package com.morning.star.retail.facade;

import com.morning.star.retail.facade.dto.ThirdServiceFailDTO;
import com.morning.star.retail.facade.dto.ThirdServiceQueryDTO;
import com.morning.star.retail.utils.page.PageBean;

/**
 * 分类基础错误数据
 */
public interface ThirdServiceFailFacade {
	PageBean<ThirdServiceFailDTO> page(ThirdServiceQueryDTO dto);

	ThirdServiceFailDTO reTry(Long id);
}
