package com.morning.star.retail.entity.repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.morning.star.retail.entity.WaterEntity;

@Repository
public class WaterRepository {
	@PersistenceContext
	private EntityManager entityManager;

	@Transactional
	public void save(Object entity, Class<? extends WaterEntity> cls ,String remark) {
		try {
			WaterEntity newInstance = cls.newInstance();
			BeanUtils.copyProperties(entity, newInstance);
			newInstance.setOperatorRemark(remark);
			entityManager.persist(newInstance);
		} catch (Exception e) {
		    throw new RuntimeException("-------保存流水出错------",e);
		}
	}

}
