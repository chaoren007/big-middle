package com.morning.star.retail.admin.entity.repository;


import com.morning.star.retail.admin.entity.SupplierAccountEntity;
import org.springframework.data.jpa.repository.JpaRepository;


public interface SupplierAccountRepository extends JpaRepository<SupplierAccountEntity, Long> {

	Boolean existsBySupplierCodeAndAccountLevel(String code, String accountLevel);

	Boolean existsByAccount(String code);

	Boolean existsByName(String name);

	SupplierAccountEntity getByAccount(String account);

	SupplierAccountEntity getByName(String name);

	SupplierAccountEntity getByAccountAndAccountLevel(String account, String accountLevel);
}
