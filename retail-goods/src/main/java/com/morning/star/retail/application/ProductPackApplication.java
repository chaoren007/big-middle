package com.morning.star.retail.application;

import com.morning.star.retail.facade.dto.ProductPackAddDTO;

import java.util.List;

/**
 * @author ethan
 */
public interface ProductPackApplication {
	void add(ProductPackAddDTO dto);

	void batchImport(List<ProductPackAddDTO> dtos);
}
