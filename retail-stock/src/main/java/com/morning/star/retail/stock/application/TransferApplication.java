package com.morning.star.retail.stock.application;

import java.util.List;

import com.morning.star.retail.bean.AdminLoginContent;
import com.morning.star.retail.stock.dto.TransferFormDTO;
import com.morning.star.retail.stock.dto.TransferItemDTO;
import com.morning.star.retail.stock.entity.TransferEntity;
import com.morning.star.retail.stock.enums.TransferStatus;
import com.morning.star.retail.util.MultipartFileWrapper;

/**
 * 库存调拨
 *
 * @author jiangyf
 */
public interface TransferApplication {

    /**
     * 保存调拨单
     *
     * @param formDTO
     * @param status
     * @return
     */
    boolean save(TransferFormDTO formDTO, TransferStatus status);

    /**
     * 审核调拨单
     *
     * @param formDTO
     * @param status
     * @return
     */
    boolean audit(TransferFormDTO formDTO, TransferStatus status);

    /**
     * 解析导入数据
     *
     * @param importFile
     * @param content
     * @return
     */
    List<TransferItemDTO> getImportData(MultipartFileWrapper importFile, AdminLoginContent content);

    /**
     * 查询并检查调拨单
     *
     * @param transferCode
     * @return
     */
    TransferEntity checkQueryOne(String transferCode);

    //根据出库单号获取调拨单号
    TransferEntity getTran(String outstockCode);

}
