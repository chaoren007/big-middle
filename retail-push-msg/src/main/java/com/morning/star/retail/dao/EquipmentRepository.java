package com.morning.star.retail.dao;

import com.morning.star.retail.entity.EquipmentEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Created by Dell on 2018/7/17.
 */
public interface EquipmentRepository extends JpaRepository<EquipmentEntity, Long> {

	List<EquipmentEntity> getByStoreCode(String storeCode);

	List<EquipmentEntity> getByUin(Long uin);

	List<EquipmentEntity> getByUinOrEquipmentId(Long uin, String equipmentId);

	EquipmentEntity getByEquipmentId(String equipmentId);

	EquipmentEntity getByToken(String token);

	void deleteByEquipmentId(String equipmentId);

	Boolean existsByToken(String token);
}
