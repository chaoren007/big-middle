package com.morning.star.retail.stock.service;

import java.util.List;

import com.morning.star.retail.stock.bean.SupplierStockDO;
import com.morning.star.retail.stock.dto.SupplierStockQueryDTO;
import com.morning.star.retail.stock.po.SupplierStockPO;

/**
 * 供应商库存
 *
 * @author jiangyf
 * @date 2017/11/16
 */
public interface SupplierStockService {

    /**
     * 盘点是否存在
     *
     * @param queryDTO
     * @return
     */
    boolean isExist(SupplierStockQueryDTO queryDTO);

    /**
     * 检查是否存在，不存在，抛异常
     *
     * @param queryDTO
     * @return
     */
    boolean checkExist(SupplierStockQueryDTO queryDTO);

    /**
     * 检查是否不存在，存在，抛异常
     *
     * @param queryDTO
     * @return
     */
    boolean checkNotExist(SupplierStockQueryDTO queryDTO);

    /**
     * 新增供应商库存
     *
     * @param supplierStockDO
     * @return
     */
    int add(SupplierStockDO supplierStockDO);

    /**
     * 增量修改供应商库存
     *
     * @param supplierStockDO
     * @return
     */
    int modifyByInc(SupplierStockDO supplierStockDO);

    /**
     * 增量修改供应商库存（不存在，则新增）
     *
     * @param supplierStockDO
     * @return
     */
    int checkModifyByInc(SupplierStockDO supplierStockDO);

    /**
     * 查询供应商库存
     *
     * @param queryDTO
     * @return
     */

    List<SupplierStockPO> query(SupplierStockQueryDTO queryDTO);

    /**
     * 查询指定公司，门店，货品，供应商和销售类型的供应商库存
     *
     * @param queryDTO
     * @return
     */
    SupplierStockPO queryOne(SupplierStockQueryDTO queryDTO);
}
