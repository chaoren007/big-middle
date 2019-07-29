package com.morning.star.retail.application;

import com.morning.star.retail.enums.ProductImgType;


public interface ProductImgApplication {

	void add(String groupCode, String storeCode, String sapCode, String productCodeOrGoodsCode, String imgPath, ProductImgType imgType);

	void deleteByProductCode(String productCode, String groupCode);

	void deleteBySapCode(String code);

	void addForStore(String productCode, String storeCode, String goodsCode, ProductImgType imgType);
}
