package com.morning.star.retail.facade.impl;

import com.morning.star.retail.application.ThirdServiceStockApplication;
import com.morning.star.retail.facade.OutStockWmsFacade;
import com.morning.star.retail.facade.assembler.OutStockAssembler;
import com.morning.star.retail.facade.dto.OutStockSubmitWmsDTO;
import com.morning.star.retail.facade.dto.OutStockWmsDTO;
import com.morning.star.retail.validate.Validate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OutStockWmsFacadeImpl implements OutStockWmsFacade {
	@Autowired
	private ThirdServiceStockApplication thirdServiceStockApplication;


	@Override
	@Validate
	public Integer add(OutStockWmsDTO dto) {
		return thirdServiceStockApplication.addOutStock(dto);
	}

	@Override
	public Integer sellOutSubmit(OutStockSubmitWmsDTO dto) {
		OutStockWmsDTO outStockWmsDTO = new OutStockAssembler().transform(dto);
		outStockWmsDTO.setPushType("S");
		return thirdServiceStockApplication.addOutStock(outStockWmsDTO);
	}

	@Override
	public Integer transferOutSubmit(OutStockSubmitWmsDTO dto) {
		OutStockWmsDTO outStockWmsDTO = new OutStockAssembler().transform(dto);
		outStockWmsDTO.setPushType("P");
		return thirdServiceStockApplication.addOutStock(outStockWmsDTO);
	}

	@Override
	public Integer sellInSubmit(OutStockSubmitWmsDTO dto) {
		OutStockWmsDTO outStockWmsDTO = new OutStockAssembler().transform(dto);
		outStockWmsDTO.setPushType("SR");
		return thirdServiceStockApplication.addOutStock(outStockWmsDTO);
	}

	@Override
	public Integer transferInSubmit(OutStockSubmitWmsDTO dto) {
		OutStockWmsDTO outStockWmsDTO = new OutStockAssembler().transform(dto);
		outStockWmsDTO.setPushType("PR");
		return thirdServiceStockApplication.addOutStock(outStockWmsDTO);
	}
}
