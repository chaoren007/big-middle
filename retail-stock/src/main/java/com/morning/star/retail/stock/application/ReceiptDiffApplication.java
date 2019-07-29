package com.morning.star.retail.stock.application;

import java.util.List;

import com.morning.star.retail.stock.dto.ModifyReceiptDiffDTO;

/**
 * Created by kimhuhg
 */
public interface ReceiptDiffApplication {
	/**
	 * 填写差异单明细
	 */

	void writeDiffItem(ModifyReceiptDiffDTO modifyReceiptDiffDTO);

	/**
	 * 批量填写差异单明细
	 */

	void batchWriteDiffItem(List<ModifyReceiptDiffDTO> list);
}
