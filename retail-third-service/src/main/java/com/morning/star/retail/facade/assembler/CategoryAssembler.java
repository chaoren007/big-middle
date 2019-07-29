package com.morning.star.retail.facade.assembler;

import com.morning.star.retail.facade.dto.CategoryWmsDTO;
import com.morning.star.retail.validate.Validate;
import com.wms.GoodsType;
import com.wms.Partner;

import javax.xml.bind.JAXBElement;
import javax.xml.namespace.QName;
import java.util.ArrayList;
import java.util.List;

public class CategoryAssembler {

	@Validate
	public List<GoodsType> transform(CategoryWmsDTO dto) {

		GoodsType goodsType = new GoodsType();
		// 分类编码	字符		　	是	否	　
		goodsType.setCode(new JAXBElement<>(new QName("code"),String.class, String.valueOf(dto.getCategoryId())));
		// 分类名称	字符		　	　	否	　
		goodsType.setName(new JAXBElement<>(new QName("name"),String.class, dto.getCategoryName()));
		ArrayList<GoodsType> list = new ArrayList<>();
		list.add(goodsType);
		return list;
	}
}
