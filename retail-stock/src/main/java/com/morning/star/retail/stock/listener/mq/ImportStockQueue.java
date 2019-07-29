package com.morning.star.retail.stock.listener.mq;

import com.morning.star.retail.event.AbstractWithUserEvent;
import com.morning.star.retail.stock.dto.StockImportDTO;

import java.util.List;

public class ImportStockQueue extends AbstractWithUserEvent {

	public ImportStockQueue(List<StockImportDTO> source) {
		super(source, false, true);
	}

}
