package com.morning.star.retail.facade;

import com.morning.star.retail.bean.AdminLoginContent;
import com.morning.star.retail.stock.dto.*;
import com.morning.star.retail.util.MultipartFileWrapper;
import com.morning.star.retail.utils.page.PageBean;

import java.util.List;

/**
 * 库存调拨
 *
 * @author jiangyf
 * @date 2018/3/13
 */
public interface TransferFacade {

    /**
     * 分页查询
     *
     * @param queryDTO
     * @return
     */
    PageBean<TransferDTO> pageQuery(TransferQueryDTO queryDTO);

    /**
     * 保存调拨单-草稿
     *
     * @param formDTO
     * @return
     */
    boolean saveDraft(TransferFormDTO formDTO);

    /**
     * 保存调拨单-待审核
     *
     * @param formDTO
     * @return
     */
    boolean submit(TransferFormDTO formDTO);

    /**
     * 删除调拨单
     *
     * @param formDTO
     * @return
     */
    boolean delete(TransferFormDTO formDTO);

    /**
     * 调拨单详情
     *
     * @param queryDTO
     * @return
     */
    TransferDTO get(TransferQueryDTO queryDTO);

    /**
     * 查询导出数据
     *
     * @param queryDTO
     * @return
     */
    List<TransferExportDTO> queryExportData(TransferQueryDTO queryDTO);

    /**
     * 解析导入数据
     *
     * @param importFile
     * @param content
     * @return
     */
    List<TransferItemDTO> getImportData(MultipartFileWrapper importFile, AdminLoginContent content);

    /**
     * 审核调拨单-通过
     *
     * @param formDTO
     * @return
     */
    boolean auditSuccess(TransferFormDTO formDTO);

    /**
     * 审核调拨单-驳回
     *
     * @param formDTO
     * @returno
     */
    boolean auditReject(TransferFormDTO formDTO);

}
