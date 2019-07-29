package com.morning.star.retail.dao;

import org.apache.ibatis.session.RowBounds;

import com.github.pagehelper.Page;
import com.morning.star.retail.facade.dto.ProductPackDTO;
import com.morning.star.retail.facade.dto.ProductPackQueryDTO;

public interface ProductPackDAO {

	Page<ProductPackDTO> query(ProductPackQueryDTO productPackQueryDTO, RowBounds rowBounds);

}
