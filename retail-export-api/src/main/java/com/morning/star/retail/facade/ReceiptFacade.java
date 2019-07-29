package com.morning.star.retail.facade;

import com.morning.star.retail.export.dto.ReceiptInfoDTO;
import com.morning.star.retail.export.dto.ReceiptQueryDTO;

import java.util.List;

/**
 * Created by lenovo on 2017/11/15.
 */
public interface ReceiptFacade {
    /**
     * 条件查询入库单分页信息
     * @return
     */
    List<ReceiptInfoDTO> queryOrder(ReceiptQueryDTO searchDTO);

}
