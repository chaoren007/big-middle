package com.morning.star.retail.stock.listener;

import com.google.gson.Gson;
import com.morning.star.retail.stock.dto.*;
import com.morning.star.retail.stock.enums.ReceiptTypeEnum;
import com.morning.star.retail.stock.listener.event.ReceiptAddEvent;
import com.morning.star.retail.stock.logicservice.StockLogicService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * @author ethan
 * @create_time 2018/7/26 11:09
 */
@Component
public class ReceiptAddListener implements ApplicationListener<ReceiptAddEvent> {
	private static final Logger LOG = LoggerFactory.getLogger(ReceiptAddListener.class);
	private static final Gson gson = new Gson();

	@Autowired
	private StockLogicService stockLogicService;

	@Override
	public void onApplicationEvent(ReceiptAddEvent event) {
		ReceiptAddEventDTO receiptInfoDTO = (ReceiptAddEventDTO) event.getSource();
		receiptWaitInStock(receiptInfoDTO);
	}

	/**
	 * 入库单生成库存记录
	 *
	 * @param receiptInfoDTO
	 * @return
	 */
	@Transactional
	public Boolean receiptWaitInStock(ReceiptAddEventDTO receiptInfoDTO) {
		LOG.info("入库单信息：" + gson.toJson(receiptInfoDTO));

		List<ReceiptItemAddDTO> receiptDetailList = receiptInfoDTO.getItem();
//		if (ReceiptTypeEnum.OTHER.getCode() == receiptInfoDTO.getReceiptType()) {
//			return false;
//		}

		StockOrderDTO stockOrderDTO = new StockOrderDTO();
        stockOrderDTO.setGroupCode(receiptInfoDTO.getGroupCode());
        stockOrderDTO.setStoreCode(receiptInfoDTO.getStoreCode());
        stockOrderDTO.setOrderCode(receiptInfoDTO.getReceiptCode());
//        stockOrderDTO.setStatus(ReceiptStatusEnum.NO_DISTRIBUTION.getDesc());

		List<ItemDTO> items = new ArrayList();

		for (ReceiptItemAddDTO vo : receiptDetailList) {
			BigDecimal qty = vo.getNum();
            ItemDTO item = new ItemDTO();
//            item.set(vo.getGoodsCode());
            item.setOrderNum(qty);
            item.setRealNum(BigDecimal.ZERO);
//            item.setPurchasePrice(vo.getPrice());

			List<SupplierItemDTO> supplierItems = new ArrayList<>();
            SupplierItemDTO supplierItem = new SupplierItemDTO();
//            supplierItem.setGoodsCode(vo.getGoodsCode());
            supplierItem.setSupplierCode(receiptInfoDTO.getSupplierCode());
            supplierItem.setSupplierName(receiptInfoDTO.getSupplierName());
            supplierItem.setSalesType(null);
            supplierItem.setOrderNum(qty);
            supplierItem.setRealNum(BigDecimal.ZERO);
			supplierItems.add(supplierItem);

			item.setSupplierItems(supplierItems);

            items.add(item);
		}
        stockOrderDTO.setItems(items);

		//采购单入库写库存
		LOG.info("入库单转化库存记录：" + gson.toJson(stockOrderDTO));

        if (ReceiptTypeEnum.PURCHASE_IN.getCode() == receiptInfoDTO.getReceiptType()) {
            return stockLogicService.purchaseWaitInStock(stockOrderDTO);
        } else if (ReceiptTypeEnum.TRANSFER_IN.getCode() == receiptInfoDTO.getReceiptType()) {
            return stockLogicService.transferWaitInStock(stockOrderDTO);
        } else {
	        LOG.error("入库单转化库存状态：" + receiptInfoDTO.getReceiptType());
        }
		return true;
	}
}
