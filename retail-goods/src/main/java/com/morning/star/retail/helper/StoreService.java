package com.morning.star.retail.helper;

import com.morning.star.retail.dto.store.StoreQueryDTO;
import com.morning.star.retail.dto.store.StoreDTO;
import com.morning.star.retail.facade.StoreFacade;
import com.morning.star.retail.helper.vo.StoreInfo;
import com.morning.star.retail.utils.entity.BeanUtils;
import com.morning.star.retail.utils.page.PageBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @author ethan
 * @create_time 2018/7/26 10:52
 */
@Service
public class StoreService {
	@Autowired
	private StoreFacade storeFacade;

	public StoreInfo form(StoreDTO storeDTO) {

		if (storeDTO != null) {
			StoreInfo storeInfo = new StoreInfo();
			BeanUtils.copy(storeDTO, storeInfo);
			return storeInfo;
		} else {
			return null;
		}

	}


	public List<StoreInfo> formList(List<StoreDTO> storeInfoDTOS) {
		List<StoreInfo> storeInfoS = new ArrayList<>(storeInfoDTOS.size());
		storeInfoDTOS.forEach(e -> storeInfoS.add(form(e)));
		return storeInfoS;
	}

	public List<StoreInfo> queryByGroupCode(String groupCode) {
		StoreQueryDTO storeQueryDTO = new StoreQueryDTO();
		storeQueryDTO.setGroupCode(groupCode);
		storeQueryDTO.setPageNo(1);
		storeQueryDTO.setPageSize(Integer.MAX_VALUE);
		PageBean<StoreDTO> storePage = storeFacade.pageListStore(storeQueryDTO);
		return formList(storePage.getRecord());
	}

	public StoreInfo getByCode(String code) {
		StoreDTO store = storeFacade.getStore(code);
		return form(store);
	}

}
