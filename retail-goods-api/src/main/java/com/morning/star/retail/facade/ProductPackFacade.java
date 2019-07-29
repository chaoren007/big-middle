package com.morning.star.retail.facade;

import com.morning.star.retail.facade.dto.*;
import com.morning.star.retail.utils.page.PageBean;

import java.util.List;

/**
 * Created by Administrator on 2017/5/3.
 */
public interface ProductPackFacade {
	void add(ProductPackAddDTO dto);

	PageBean<ProductPackDTO> query(ProductPackQueryDTO dto);

	void batchImport(List<ProductPackAddDTO> dtos);

}
