package com.morning.star.retail.application;

import com.morning.star.retail.facade.dto.*;

import java.util.List;


public interface ProductApplication {

	List<String> add(List<ProductSubmitDTO> dtos);

	void batchImport(List<ProductImportDTO> dtos);

	void pullProduct(ProductPullDTO dto);

	void update(List<ProductUpdateDTO> dtos);

	void onMarket(List<String> codes);

	void offMarket(List<String> codes);

	void onSale(List<String> codes);

	void offSale(List<String> codes);

	ProductDTO getByCode(String productCode);
}
