package com.morning.star.retail.entity.repository;


import org.springframework.data.repository.Repository;

import com.morning.star.retail.entity.CategoryEntity;

import java.util.List;

public interface CategoryRepository extends Repository<CategoryEntity, Long> {


    void save(CategoryEntity categoryEntry);

    CategoryEntity getByCategoryId(Long categoryId);

    boolean existsByCategoryName(String categoryName);

    boolean existsByCategoryId(Long categoryId);

    boolean existsByParentId(Long categoryId);

    List<CategoryEntity> getByParentId(Long parentId);

}
