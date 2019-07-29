package com.morning.star.retail.entity.repository;

import org.springframework.data.repository.Repository;

import com.morning.star.retail.entity.DeviceEntity;

public interface DeviceRepository extends Repository<DeviceEntity, Long> {

	void save(DeviceEntity entity);

	DeviceEntity findOne(Long id);

	DeviceEntity findOneBySecretKey(String key);

    DeviceEntity findOneByDeviceId(String deviceId);

}
