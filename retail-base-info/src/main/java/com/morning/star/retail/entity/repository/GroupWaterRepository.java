package com.morning.star.retail.entity.repository;

import org.springframework.data.repository.Repository;

import com.morning.star.retail.entity.GroupWaterEntity;

public interface GroupWaterRepository extends Repository<GroupWaterEntity, Long> {

	GroupWaterEntity save(GroupWaterEntity groupWaterEntity);

//	TopicEntity findOne(String code);
//
//	void delete(String code);

}
