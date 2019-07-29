package com.morning.star.retail.stock.helper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.morning.star.retail.facade.ProductFacade;
import com.morning.star.retail.facade.dto.ProductDTO;
import com.morning.star.retail.facade.dto.ProductGetDTO;
import com.morning.star.retail.stock.helper.vo.ProductInfo;
import com.morning.star.retail.utils.entity.BeanUtils;

@Service
public class ProductService {
	@Autowired
	private ProductFacade productFacade;

	ProductInfo form(ProductDTO dto) {
		if (dto == null) {
			return null;
		}
		ProductInfo info = new ProductInfo();
		BeanUtils.copy(dto, info);

		return info;
	}

	public ProductInfo get(String productCode) {
		ProductGetDTO getDTO = new ProductGetDTO();
		getDTO.setProductCode(productCode);
		return form(productFacade.getDetail(getDTO));
	}

}
