package com.morning.star.retail.helper;

import com.morning.star.retail.admin.dto.AccountDTO;
import com.morning.star.retail.admin.facade.AccountFacade;
import com.morning.star.retail.helper.info.AccountInfo;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author ethan
 * @create_time 2018/9/21 14:29
 */
@Service
public class AccountService {

	@Autowired
	private AccountFacade accountFacade;

	public static AccountInfo defaultInfo() {
		AccountInfo info = new AccountInfo();
		info.setId(0L);
		return info;
	}

	public static AccountInfo form(AccountDTO dto) {
		if (dto == null) {
			return null;
		}
		AccountInfo info = new AccountInfo();
		BeanUtils.copyProperties(dto, info);
		return info;
	}

	public List<AccountInfo> getByStore(String storeCode) {
//		return Collections.singletonList(defaultInfo());
		List<AccountDTO> accountDTOS = accountFacade.getAccountByStore(storeCode);
		return accountDTOS.stream().map(dto -> form(dto)).collect(Collectors.toList());
	}

	public AccountInfo getById(Long uin) {
//		return defaultInfo();
		AccountDTO accountDTOS = accountFacade.getAccountById(uin);
		return form(accountDTOS);
	}

	public AccountInfo getByAccount(String account) {
//		return defaultInfo();
		AccountDTO accountDTOS = accountFacade.getAccount(account);
		return form(accountDTOS);
	}
}
