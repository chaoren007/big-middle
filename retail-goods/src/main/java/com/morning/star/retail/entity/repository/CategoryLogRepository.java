package com.morning.star.retail.entity.repository;


import com.morning.star.retail.entity.CategoryLogEntity;
import org.springframework.data.repository.Repository;

public interface CategoryLogRepository extends Repository<CategoryLogEntity, Long> {
    void save(CategoryLogEntity entity);
}
