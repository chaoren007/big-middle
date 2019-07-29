package com.morning.star.retail.application.impl;

import com.morning.star.retail.application.ProductPackApplication;
import com.morning.star.retail.entity.ProductEntity;
import com.morning.star.retail.entity.ProductPackEntity;
import com.morning.star.retail.entity.ProductPackInfo;
import com.morning.star.retail.entity.repository.ProductPackRepository;
import com.morning.star.retail.entity.repository.ProductRepository;
import com.morning.star.retail.enums.ProductPackStatus;
import com.morning.star.retail.facade.dto.ProductPackAddDTO;
import com.morning.star.retail.user.UserPermission;
import com.morning.star.retail.user.UserUtils;
import com.morning.star.retail.utils.entity.BeanUtils;
import org.apache.commons.lang.Validate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author ethan
 * @create_time 2018/8/4 10:18
 */
@Service
public class ProductPackApplicationImpl implements ProductPackApplication {
	@Autowired
	private ProductRepository productRepository;

	@Autowired
	private ProductPackRepository productPackRepository;

	@Override
	@Transactional
	public void add(ProductPackAddDTO dto) {
		Validate.isTrue(!productPackRepository.existsByProductPackInfoSapProductCode(dto.getSapProductCode()), "该货品存在包装信息");

		ProductEntity productEntity = productRepository.getBySapProductCode(dto.getSapProductCode());
		Validate.notNull(productEntity, "货品信息不存在：" + dto.getSapProductCode());
		new UserPermission(UserUtils.currentUser())
			.tag("groupCode", productEntity.getGroupCode())
			.msg("不允许添加改货品大小包装：" + dto.getSapProductCode())
			.pass();

		ProductEntity smallProductEntity = productRepository.getBySapProductCode(dto.getPackSapProductCode());
		Validate.notNull(smallProductEntity, "货品信息不存在：" + dto.getPackSapProductCode());
		new UserPermission(UserUtils.currentUser())
			.tag("groupCode", smallProductEntity.getGroupCode())
			.msg("不允许添加改货品大小包装：" + dto.getPackSapProductCode())
			.pass();

		Validate.isTrue(!productEntity.getSapProductCode().equals(smallProductEntity.getSapProductCode()), "大小包装编码不能一样");

		ProductPackInfo productPackInfo = new ProductPackInfo();
		BeanUtils.copy(productEntity, productPackInfo);
		ProductPackInfo smallProductPackInfo = new ProductPackInfo();
		BeanUtils.copy(smallProductEntity, smallProductPackInfo);
		ProductPackEntity entity = new ProductPackEntity();
		entity.setGroupCode(dto.getGroupCode());
		entity.setPackNum(dto.getPackNum());
		entity.setPriority(dto.getPriority());
		entity.setProductPackInfo(productPackInfo);
		entity.setSmallProductPackInfo(smallProductPackInfo);
		entity.setStatus(ProductPackStatus.ON);

		productPackRepository.save(entity);
	}

	@Override
	@Transactional
	public void batchImport(List<ProductPackAddDTO> dtos) {
		dtos.forEach(e -> add(e));
	}
}
