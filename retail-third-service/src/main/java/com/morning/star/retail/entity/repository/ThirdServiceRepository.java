package com.morning.star.retail.entity.repository;

import com.morning.star.retail.entity.ThirdServiceEntity;
import com.morning.star.retail.entity.enums.RequestStatusEnum;
import org.springframework.data.repository.Repository;

public interface ThirdServiceRepository extends Repository<ThirdServiceEntity, Long> {

	ThirdServiceEntity save(ThirdServiceEntity entity);

	ThirdServiceEntity findOne(Long id);

	ThirdServiceEntity getByRequestParamAndRequestApi(String requestParam,String requestApi);

}
