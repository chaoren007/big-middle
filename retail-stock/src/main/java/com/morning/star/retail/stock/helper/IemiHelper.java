package com.morning.star.retail.stock.helper;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.morning.star.retail.facade.ImeiFacade;
import com.morning.star.retail.facade.dto.ImeiAddDTO;

/**
 * kimhuhg
 * 串码服务
 */

@Service
public class IemiHelper {
	@Autowired
	private ImeiFacade imeiFacade;

	public void addList(List<ImeiAddDTO> list,String storeCode, String groupCode) {
		imeiFacade.createList(list,storeCode,groupCode);
	}

}
