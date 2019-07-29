package com.morning.star.retail.entity.repository;

import com.morning.star.retail.entity.ConsumableEntity;
import org.springframework.data.repository.Repository;

/**
 * @author ethan
 * @create_time 2018/8/7 11:13
 */
public interface ConsumableRepository extends Repository<ConsumableEntity, Long> {
	void save(ConsumableEntity consumableEntity);

	ConsumableEntity findOne(Long id);

	ConsumableEntity getByConsumableCode(String code);

	Boolean existsByConsumableCode(String code);
}
