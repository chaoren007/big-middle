package com.morning.star.retail.stock.helper;

import com.morning.star.retail.facade.PurchaseWmsFacade;
import com.morning.star.retail.facade.dto.PurchaseDetailSubmitWmsDTO;
import com.morning.star.retail.facade.dto.PurchaseSubmitWmsDTO;
import com.morning.star.retail.facade.dto.purchasein.PurchaseInOrderDTO;
import com.morning.star.retail.util.DateUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.stream.Collectors;

/**
 * @author ethan
 * @create_time 2018/12/10 17:11
 */
@Service
public class PurchaseWmsService {

	@Autowired
	private PurchaseWmsFacade purchaseWmsFacade;

	public PurchaseSubmitWmsDTO toWms(PurchaseInOrderDTO source) {
		return new PurchaseSubmitWmsDTO(source.getPurchaseInCode(),
			source.getStoreCode(),
			source.getCityName(),
			source.getWarehouseCode(),
			source.getSupplierCode(),
			source.getRemark(),
			DateUtil.toDateTime(source.getCreateTime()),
			source.getOperatorName(),
			source.getOrderDetail().stream().map(item -> new PurchaseDetailSubmitWmsDTO(
				item.getProductCode(),
				item.getProductName(),
				item.getUnitsName(),
				item.getQty(),
				item.getRatePrice(),
				item.getRateAmount(),
				item.getSpuInfo(),
				item.getExpiredAllow()))
				.collect(Collectors.toList()));
	}

	/**
	 * 把采购入库单推送给第三方
	 */
	public Integer addByPurchaseIn(PurchaseInOrderDTO purchaseInOrderDTO) {
		return purchaseWmsFacade.submit(toWms(purchaseInOrderDTO));
	}

	/**
	 * 通知第三方采购单关闭
	 */
	public Integer closePurchaseIn(PurchaseInOrderDTO purchaseInOrderDTO) {
		return purchaseWmsFacade.close(toWms(purchaseInOrderDTO));
	}
}
