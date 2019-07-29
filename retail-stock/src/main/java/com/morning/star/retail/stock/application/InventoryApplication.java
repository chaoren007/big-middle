package com.morning.star.retail.stock.application;

import com.morning.star.retail.stock.dto.InventoryAdjustDTO;
import com.morning.star.retail.stock.dto.InventoryFormDTO;
import com.morning.star.retail.stock.dto.InventorySubmitDTO;
import com.morning.star.retail.stock.entity.InventoryEntity;
import com.morning.star.retail.stock.enums.InventoryStatementStatus;

/**
 * 库存盘点
 */
public interface InventoryApplication {

    /**
     * 创建盘点单
     *
     * @param formDTO
     * @return
     */
    boolean create(InventoryFormDTO formDTO);

    /**
     * 保存盘点数据
     *
     * @param dto
     * @return
     */
    boolean save(InventorySubmitDTO dto);

    /**
     * 盘点成功
     *
     * @param inventoryCode 盘点单号
     * @param storeCode     盘点单号
     * @return
     */
    void auditSucc(String inventoryCode, String storeCode);

    /**
     * 盘点失败
     *
     * @param inventoryCode 盘点单号
     * @return
     */
    void auditFail(String inventoryCode, String storeCode);

    /**
     * 批量阅读
     *
     * @param inventoryCodes
     * @param storeCode
     * @return
     */
    int batchRead(String[] inventoryCodes, String storeCode);

    /**
     * 检查盘点单
     *
     * @param inventoryCode
     * @return
     */
    InventoryEntity checkGet(String inventoryCode);

    /**
     * 创建盘点调整记录
     *
     * @param dto
     * @return
     */
    void createAdjust(InventoryAdjustDTO dto);

    /**
     * 生成长短单
     *
     * @param inventoryCode
     * @param isFormal      是否正式
     */
    void createStatement(String inventoryCode, boolean isFormal);

    /**
     * 更新长短单状态（确认 / 取消确认 / 存档）
     *
     * @param inventoryCode
     * @param status
     */
    void modifyStatementStatus(String inventoryCode, InventoryStatementStatus status);

}
