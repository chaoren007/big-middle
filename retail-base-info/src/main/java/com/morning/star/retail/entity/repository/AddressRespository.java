package com.morning.star.retail.entity.repository;

import com.morning.star.retail.entity.AddressEntity;
import org.springframework.data.repository.Repository;

import java.util.List;

public interface AddressRespository extends Repository<AddressEntity, Long> {

	void save(AddressEntity entity);

	AddressEntity findOne(Long id);

	List<AddressEntity> findByParentAddressId(Long parentId);

	List<AddressEntity> findByParentAddressIdAndAddressCodeNotNull(Long parentId);

	List<AddressEntity> findByAddressLevel(int level);

	List<AddressEntity> findByRegionCode(String code);

	List<AddressEntity> findByRegionBind(Integer bind);

	boolean existsByAddressCode(String code);
}
