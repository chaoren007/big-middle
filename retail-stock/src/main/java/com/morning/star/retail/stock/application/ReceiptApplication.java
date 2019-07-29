package com.morning.star.retail.stock.application;

import java.util.Date;
import java.util.List;
import java.util.Map;

import com.morning.star.retail.facade.dto.receipt.ReceiptImeiDTO;
import com.morning.star.retail.facade.dto.receipt.SureReceiptDTO;
import com.morning.star.retail.stock.dto.ReceiptAddDTO;
import com.morning.star.retail.stock.dto.ReceiptDiffInfoDTO;
import com.morning.star.retail.stock.dto.ReceiptItemDTO;

/**
 * Created by lenovo on 2017/11/14.
 */
public interface 	ReceiptApplication {
	String saveReceipt(ReceiptAddDTO receiptAddDTO);

	void sureReceipt(SureReceiptDTO sureReceiptDTO, Map<String,List<ReceiptImeiDTO>> iemis);

	void waitReceipt(String receiptCode);

	void modifyReceiptDetail(ReceiptItemDTO receiptItemInfoDTO);

	/**
	 * 手动入库
	 */

	void saveReceiptDifference(ReceiptDiffInfoDTO receiptDifferenceDTO);

	/**
	 * 第三方出库单号填写
	 */
	void addOutStockCode(String receiptCode, String outstockCode);

	/**
	 * 填写预计入库时间
	 */
	void addExpectedReceiptTime(String receiptCode, Date expectedReceiptTime);

	/**
	 * 修改入库状态
	 */
	void modifyTransStatus(String receiptCode, Integer transStatus);

	/**
	 * 批量导入产生入库单
	 * @param list
	 * @return
	 */
	void batchSaveReceipt(List<ReceiptAddDTO> list);
}
