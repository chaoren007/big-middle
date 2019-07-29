package com.morning.star.retail.admin.entity.repository;

import java.util.List;

import org.springframework.data.repository.Repository;

import com.morning.star.retail.admin.entity.RoleEntity;

/**
 * @author ethan
 * @create_time 2018/8/11 9:31
 */
public interface RoleRepository extends Repository<RoleEntity, Long> {
	void save(RoleEntity roleEntity);

	List<RoleEntity> queryByIdIn(List<Long> ids);

	RoleEntity findOne(Long id);

	void deleteById(Long id);
}
