package com.morning.star.retail.admin.entity.repository;


import java.util.List;

import org.springframework.data.repository.Repository;

import com.morning.star.retail.admin.entity.AccountEntity;


public interface AccountRepository extends Repository<AccountEntity, Long> {

	AccountEntity save(AccountEntity accountEntity);

	void save(Iterable<AccountEntity> list);

	AccountEntity findOne(Long id);

	AccountEntity getByAccount(String account);

	AccountEntity getByAccountAndAccountLevelIn(String account, List<String> accountLevels);

	Boolean existsByAccount(String account);

	Boolean existsByGroupCodeAndAccountLevel(String code, String accountLevel);

	Boolean existsByStoreCodeAndAccountLevel(String code, String accountLevel);

	Boolean existsBySupplierCodeAndAccountLevel(String code, String accountLevel);

	Boolean existsByGroupCode(String code);

	List<AccountEntity> getByGroupCode(String groupCode);

	List<AccountEntity> getByStoreCode(String storeCode);

	List<AccountEntity> getByGroupCodeAndAccountLevel(String groupCode, String accountLevel);

	List<AccountEntity> getByStoreCodeAndAccountLevel(String storeCode, String accountLevel);

}
