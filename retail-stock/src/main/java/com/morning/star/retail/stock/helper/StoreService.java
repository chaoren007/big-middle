package com.morning.star.retail.stock.helper;

import com.morning.star.retail.dto.store.StoreDTO;
import com.morning.star.retail.facade.StoreFacade;
import com.morning.star.retail.stock.helper.vo.StoreInfo;
import com.morning.star.retail.utils.entity.BeanUtils;
import org.apache.commons.lang3.Validate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StoreService {
	@Autowired
	private StoreFacade storeFacade;

	public StoreInfo getStore(String storeCode) {
		StoreDTO dto = storeFacade.getStore(storeCode);
		if (dto != null) {
			StoreInfo info = new StoreInfo();
			BeanUtils.copy(dto, info);
			return info;
		}
		return null;
	}

	public StoreInfo getStoreByCity(String groupCode, Long cityId) {
		StoreDTO dto = storeFacade.getStoreByCity(groupCode, cityId);
		if (dto != null) {
			StoreInfo info = new StoreInfo();
			BeanUtils.copy(dto, info);
			return info;
		}
		return null;
	}

	public String getStoreName(String storeCode) {
		StoreDTO dto = storeFacade.getStore(storeCode);
		Validate.notNull(dto, String.format("未找到该门店【编码：%s】信息", storeCode));
		return dto.getStoreName();
	}

}
