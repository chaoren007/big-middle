package com.morning.star.retail.stock.helper;

import com.morning.star.retail.facade.OutStockWmsFacade;
import com.morning.star.retail.facade.dto.OutStockWmsDTO;
import com.morning.star.retail.facade.dto.out.OutStockDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author ethan
 * @create_time 2018/12/10 17:11
 */
@Service
public class OutStockWmsService {

	@Autowired
	private OutStockWmsFacade outStockWmsFacade;

	public Integer addByOutStock(OutStockDTO source) {
		OutStockWmsDTO param = new OutStockWmsDTO();
		return outStockWmsFacade.add(param);
	}
}
