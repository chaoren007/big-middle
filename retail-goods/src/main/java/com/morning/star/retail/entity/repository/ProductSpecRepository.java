package com.morning.star.retail.entity.repository;


import com.morning.star.retail.entity.ProductSpecEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.Repository;

import java.util.List;

public interface ProductSpecRepository extends JpaRepository<ProductSpecEntity, Long> {
	List<ProductSpecEntity> getByProductCodeIn(List<String> codes);

}
