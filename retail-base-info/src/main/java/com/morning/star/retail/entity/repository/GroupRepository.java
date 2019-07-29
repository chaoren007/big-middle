package com.morning.star.retail.entity.repository;

import org.springframework.data.repository.Repository;

import com.morning.star.retail.entity.GroupEntity;

public interface GroupRepository extends Repository<GroupEntity, String> {

	GroupEntity save(GroupEntity groupEntity);

	GroupEntity getByGroupCode(String groupCode);

	Boolean existsByGroupName(String name);

	Boolean exists(String code);

	GroupEntity getFirstByOrderByGroupCode();
//
//	void delete(Long id);

}
