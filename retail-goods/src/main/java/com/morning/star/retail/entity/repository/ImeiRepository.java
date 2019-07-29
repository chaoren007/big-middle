package com.morning.star.retail.entity.repository;

import com.morning.star.retail.entity.ImeiEntity;
import org.springframework.data.repository.Repository;

public interface ImeiRepository extends Repository<ImeiEntity, Long> {

	ImeiEntity save(ImeiEntity entity);
	
	ImeiEntity findOne(Long code);


	ImeiEntity getByImeiCode(String imeiCode);

	
}
