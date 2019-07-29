package com.morning.star.retail.application.impl;

import com.morning.star.retail.application.ProductImgApplication;
import com.morning.star.retail.entity.ProductImgEntity;
import com.morning.star.retail.entity.repository.ProductImgRepository;
import com.morning.star.retail.enums.ProductImgType;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author ethan
 * @create_time 2018/9/13 14:29
 */
@Service
public class ProductImgApplicationImpl implements ProductImgApplication {

	@Autowired
	private ProductImgRepository productImgRepository;

	@Override
	public void add(String groupCode, String storeCode, String sapCode, String productCodeOrGoodsCode, String imgPath, ProductImgType imgType) {
		if (StringUtils.isNotBlank(imgPath)) {
			List<ProductImgEntity> productImgEntityList = Arrays.stream(imgPath.split(","))
				.map(imgStr -> new ProductImgEntity(groupCode, storeCode, sapCode,
						productCodeOrGoodsCode, imgStr, imgType, 1))
				.collect(Collectors.toList());
			productImgEntityList.forEach(item -> productImgRepository.save(item));
		}
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRES_NEW)
	public void deleteByProductCode(String productCode, String groupCode) {
		productImgRepository.deleteByProductCodeAndGroupCode(productCode, groupCode);
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRES_NEW)
	public void deleteBySapCode(String code) {
		productImgRepository.deleteBySapProductCode(code);
	}

	@Override
	public void addForStore(String productCode, String storeCode, String goodsCode, ProductImgType imgType) {
		List<ProductImgEntity> productImgEntities = productImgRepository.getByProductCode(productCode);
		productImgEntities.forEach(e -> {
			if (imgType.getCode().equals(e.getImgType().getCode())) {
				add(e.getGroupCode(), storeCode, e.getSapProductCode(), goodsCode, e.getImgUri(), imgType);
			}
		});
	}
}
