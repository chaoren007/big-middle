package com.morning.star.retail.admin.entity.repository;

import org.springframework.data.repository.Repository;

import com.morning.star.retail.admin.entity.ResourceEntity;

/**
 * @author ethan
 * @create_time 2018/8/11 9:31
 */
public interface ResourceRepository extends Repository<ResourceEntity, Long> {
	void save(ResourceEntity resourceEntity);

	ResourceEntity findOne(Long id);

	Boolean existsById(Long id);

	Boolean existsByParentId(Long parentId);

	Boolean existsByIdAndParentId(Long id, Long parentId);

	Boolean existsByNameAndParentIdAndClassify(String name, Long parentId, String classify);

	void deleteById(Long id);
}
