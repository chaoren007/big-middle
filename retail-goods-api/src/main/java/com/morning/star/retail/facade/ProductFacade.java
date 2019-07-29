package com.morning.star.retail.facade;

import java.util.List;

import com.morning.star.retail.facade.dto.*;
import com.morning.star.retail.utils.page.PageBean;

/**
 * Created by Administrator on 2017/5/3.
 */
public interface ProductFacade {
	List<String> getSapCodeByUpc(String upcCode);

	void addProduct(List<ProductSubmitDTO> dtos);

	void submitImportProduct(List<ProductImportDTO> dtos);

	void importProduct(List<ProductImportDTO> dtos);

	void pullProduct(ProductPullDTO dto);

	void updateProduct(List<ProductUpdateDTO> dtos);

	PageBean<ProductDTO> queryProduct(ProductQueryDTO dto);

	List<ProductDTO> queryList(ProductQueryDTO dto);

	/**
	 * 为引入展示的商品列表
	 * @param dto
	 * @return
	 */
	PageBean<ProductPullInfoDTO> queryForPull(ProductQueryDTO dto);

	ProductDTO getDetail(ProductGetDTO dto);

	ProductDTO getBySapCode(String groupCode, String sapCode);

	List<ProductDTO> getByUpc(ProductGetUpcDTO dto);

//	List<ProductForPurchaseDTO> getByUpcForPurchase(ProductGetUpcDTO dto);

	void onMarket(List<String> productCodes);

	void offMarket(List<String> productCodes);

	void onSale(List<String> productCodes);

	void offSale(List<String> productCodes);

	ProductDTO getByProductCode(String productCode);

	ProductDTO getByCode(String productCode);

}
