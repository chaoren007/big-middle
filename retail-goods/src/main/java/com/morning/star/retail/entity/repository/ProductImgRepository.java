package com.morning.star.retail.entity.repository;


import com.morning.star.retail.entity.ProductImgEntity;
import com.morning.star.retail.entity.ProductSpecEntity;
import com.morning.star.retail.enums.ProductImgType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.Repository;

import java.util.List;

public interface ProductImgRepository extends JpaRepository<ProductImgEntity, Long> {

	List<ProductImgEntity> getByProductCode(String code);

	List<ProductImgEntity> getBySapProductCode(String code);

	void deleteByProductCodeAndGroupCode(String productCode, String groupCode);

	void deleteBySapProductCode(String code);

}
