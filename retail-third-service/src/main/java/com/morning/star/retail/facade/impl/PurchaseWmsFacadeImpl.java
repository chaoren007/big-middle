package com.morning.star.retail.facade.impl;

import com.morning.star.retail.application.ThirdServiceStockApplication;
import com.morning.star.retail.facade.PurchaseWmsFacade;
import com.morning.star.retail.facade.assembler.PurchaseAssembler;
import com.morning.star.retail.facade.dto.PurchaseSubmitWmsDTO;
import com.morning.star.retail.facade.dto.PurchaseWmsDTO;
import com.morning.star.retail.validate.Validate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PurchaseWmsFacadeImpl implements PurchaseWmsFacade {
	@Autowired
	ThirdServiceStockApplication thirdServiceStockApplication;


	@Override
	@Validate
	public Integer add(PurchaseWmsDTO dto) {
		return thirdServiceStockApplication.addPurchase(dto);
	}

	@Override
	public Integer submit(PurchaseSubmitWmsDTO dto) {
		PurchaseWmsDTO purchaseWmsDTO = new PurchaseAssembler().transform(dto);
		purchaseWmsDTO.setFlag("I");
		purchaseWmsDTO.setPushType("PO");
		return thirdServiceStockApplication.addPurchase(purchaseWmsDTO);
	}

	@Override
	public Integer close(PurchaseSubmitWmsDTO dto) {
		PurchaseWmsDTO purchaseWmsDTO = new PurchaseAssembler().transform(dto);
		purchaseWmsDTO.setFlag("D");
		purchaseWmsDTO.setPushType("PO");
		return thirdServiceStockApplication.addPurchase(purchaseWmsDTO);
	}

	@Override
	public Integer out(PurchaseSubmitWmsDTO dto) {
		PurchaseWmsDTO purchaseWmsDTO = new PurchaseAssembler().transform(dto);
		purchaseWmsDTO.setFlag("I");
		purchaseWmsDTO.setPushType("P1");
		return thirdServiceStockApplication.addPurchase(purchaseWmsDTO);
	}
}
