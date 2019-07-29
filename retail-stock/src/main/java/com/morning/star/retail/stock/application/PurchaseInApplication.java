package com.morning.star.retail.stock.application;

import com.morning.star.retail.facade.dto.purchasein.PurchaseInAuditDTO;
import com.morning.star.retail.facade.dto.purchasein.PurchaseInUpdateDTO;
import com.morning.star.retail.stock.enums.PurchaseInStatusEnum;

public interface PurchaseInApplication {

	void updatePreReceiptTime(PurchaseInUpdateDTO purchaseInUpdateDTO);

	void updateReceiptQty(PurchaseInUpdateDTO purchaseInUpdateDTO);

	void audit(PurchaseInAuditDTO purchaseInAuditDTO, PurchaseInStatusEnum status);

	void pushThird(String code);
}
