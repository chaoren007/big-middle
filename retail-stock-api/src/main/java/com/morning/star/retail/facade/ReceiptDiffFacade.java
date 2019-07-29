package com.morning.star.retail.facade;

import com.morning.star.retail.facade.dto.receipt.ReceiptImeiDTO;
import com.morning.star.retail.facade.dto.receipt.SureReceiptDTO;
import com.morning.star.retail.stock.dto.*;
import com.morning.star.retail.utils.page.PageBean;

import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * Created by kimhuhg on 2018/08/17.
 */
public interface ReceiptDiffFacade {
    /**
     * 条件查询入库单分页信息
     * @return
     */
    PageBean<ReceiptDiffInfoDTO> query(QueryReceiptDiffDTO searchDTO);

    /**
     * 获取主细表信息
     */
    ReceiptDiffInfoDTO list(String code);

    /**
     * 填写差异单明细
     */

    void writeDiffItem(ModifyReceiptDiffDTO modifyReceiptDiffDTO);

    /**
     * 批量填写差异单明细
     */

    void batchWriteDiffItem(List<ModifyReceiptDiffDTO> list);
}
