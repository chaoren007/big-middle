package com.morning.star.retail.entity.repository;

import com.morning.star.retail.entity.UpcCodeEntity;
import org.springframework.data.repository.Repository;

import java.util.List;

public interface UpcCodeRepository extends Repository<UpcCodeEntity, Long> {
	void save(UpcCodeEntity entity);

	Boolean existsByUpcCode(String code);

	Boolean existsByUpcCodeIn(List<String> codes);

	Boolean existsBySapProductCodeAndUpcCode(String sapCode, String upcCode);

	List<UpcCodeEntity> getByUpcCode(String code);

	List<UpcCodeEntity> getByUpcCodeIn(List<String> codes);

}
