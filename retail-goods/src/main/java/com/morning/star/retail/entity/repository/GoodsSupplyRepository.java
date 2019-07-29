package com.morning.star.retail.entity.repository;


import com.morning.star.retail.entity.GoodsSupplyEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Set;

public interface GoodsSupplyRepository extends JpaRepository<GoodsSupplyEntity, Long> {
	void deleteByGoodsSupplyCode(String code);

	List<GoodsSupplyEntity> findByGoodsSupplyCode(String code);

	List<GoodsSupplyEntity> findByGoodsSupplyCodeIn(Set<String> codes);

	List<GoodsSupplyEntity> findBySpuCode(String code);

	GoodsSupplyEntity findByProductCode(String code);

	List<GoodsSupplyEntity> findByProductCodeIn(Set<String> codes);

	boolean existsByProductCode(String code);

}
