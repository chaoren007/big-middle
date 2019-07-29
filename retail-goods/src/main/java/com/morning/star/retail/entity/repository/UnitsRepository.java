package com.morning.star.retail.entity.repository;


import org.springframework.data.repository.Repository;

import com.morning.star.retail.entity.UnitsEntity;

public interface UnitsRepository extends Repository<UnitsEntity, Long> {


	UnitsEntity save(UnitsEntity unitsEntity);

	UnitsEntity findOne(Long id);

	UnitsEntity getByUnitsName(String unitsName);

}
