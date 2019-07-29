package com.morning.star.retail.facade;

import com.morning.star.retail.stock.dto.*;
import com.morning.star.retail.utils.page.PageBean;

import java.util.List;

public interface InventoryFacade {

    /**
     * 创建盘点单
     *
     * @param formDTO
     * @return
     */
    boolean create(InventoryFormDTO formDTO);

    /**
     * 提交盘点（生产者）
     *
     * @param dto
     * @return
     */
    boolean submit(InventorySubmitDTO dto);

    /**
     * 保存盘点（消费者）
     *
     * @param dto
     * @return
     */
    boolean save(InventorySubmitDTO dto);

    /**
     * 查询盘点数据
     *
     * @param queryDTO
     * @return
     */
    PageBean<InventoryDTO> list(InventoryQueryDTO queryDTO);

    /**
     * 盘点详情
     *
     * @param queryDTO
     * @return
     */
    InventoryDTO get(InventoryItemQueryDTO queryDTO);

    /**
     * 根据盘点编号批量查阅
     *
     * @param inventoryCodes
     * @param storeCode
     * @return
     */
    int batchRead(String inventoryCodes, String storeCode);

    /**
     * 审核成功
     *
     * @param inventoryCode 盘点单号
     * @return
     */
    void stash(String inventoryCode);

    /**
     * 审核成功
     *
     * @param inventoryCodes 盘点单号
     * @return
     */
    void auditSucc(String inventoryCodes, String storeCode);

    /**
     * 审核失败
     *
     * @param inventoryCodes 盘点单号
     * @return
     */
    void auditFail(String inventoryCodes, String storeCode);

    /**
     * 查询导出的盘点明细数据-全部
     *
     * @param inventoryCode
     * @param storeCode
     * @return
     */
    List<ExportInventoryItemDTO> queryExportAllItem(String inventoryCode, String storeCode);

    /**
     * 查询导出的盘点明细数据-异常 盘盈 盘亏
     *
     * @param inventoryCode
     * @param storeCode
     * @return
     */
    List<ExportInventoryItemDTO> queryExportWarnItem(String inventoryCode, String storeCode);

    /**
     * 查询导出的盘点明细数据-漏盘
     *
     * @param inventoryCode
     * @param storeCode
     * @return
     */
    List<ExportInventoryItemDTO> queryExportLossItem(String inventoryCode, String storeCode);

    /**
     * 创建盘点调整记录
     *
     * @param dto
     * @return
     */
    void createAdjust(InventoryAdjustDTO dto);

    /**
     * 查询盘点调整记录
     *
     * @param inventoryCode
     * @param goodsCode
     * @return
     */
    List<InventoryAdjustDTO> queryAdjust(String inventoryCode, String goodsCode);

    /**
     * 生成长短单
     *
     * @param inventoryCode
     * @param isFormal      是否正式
     */
    void createStatement(String inventoryCode, boolean isFormal);

    /**
     * 确认长短单
     *
     * @param inventoryCode
     */
    void confirmStatement(String inventoryCode);

    /**
     * 取消确认长短单
     *
     * @param inventoryCode
     */
    void cancelStatement(String inventoryCode);

    /**
     * 存档长短单
     *
     * @param inventoryCode
     */
    void archiveStatement(String inventoryCode);

    /**
     * 查询盘点长短单
     *
     * @param inventoryCode
     * @return
     */
    List<InventoryStatementDTO> queryStatement(String inventoryCode);

    /**
     * 查询盘点长短单明细
     *
     * @param queryDTO
     * @return
     */
    PageBean<InventoryStatementItemDTO> queryStatementItem(InventoryStatementQueryDTO queryDTO);

    /**
     * 查询盘点操作流水
     *
     * @param inventoryCode
     * @return
     */
    List<InventoryWaterDTO> queryWater(String inventoryCode);

    /**
     * 查询盘点明细操作流水
     *
     * @param queryDTO
     * @return
     */
    PageBean<InventoryItemWaterDTO> queryItemWater(InventoryItemQueryDTO queryDTO);

}
