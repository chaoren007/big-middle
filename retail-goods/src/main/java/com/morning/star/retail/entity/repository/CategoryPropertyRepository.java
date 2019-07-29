package com.morning.star.retail.entity.repository;


import com.morning.star.retail.entity.CategoryPropertyEntity;
import org.springframework.data.repository.Repository;

import java.util.List;

public interface CategoryPropertyRepository extends Repository<CategoryPropertyEntity, Long> {


    void save(CategoryPropertyEntity categoryPropertyEntry);

    List<CategoryPropertyEntity> getByCategoryId(Long categoryId);


}
