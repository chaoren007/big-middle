package com.morning.star.retail.entity.repository;

import com.morning.star.retail.entity.ThirdServiceEntity;
import com.morning.star.retail.entity.ThirdServiceFailEntity;
import org.springframework.data.repository.Repository;

public interface ThirdServiceFailRepository extends Repository<ThirdServiceFailEntity, Long> {

	ThirdServiceFailEntity save(ThirdServiceFailEntity entity);

	ThirdServiceFailEntity findOne(Long id);

}
