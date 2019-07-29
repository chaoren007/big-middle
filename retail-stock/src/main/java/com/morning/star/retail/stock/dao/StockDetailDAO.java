package com.morning.star.retail.stock.dao;

import org.apache.ibatis.annotations.Param;

import com.morning.star.retail.stock.bean.StockDetailDO;

/**
 * 库存明细DAO
 * 
 * @author Tim
 *
 */
public interface StockDetailDAO {

    /**
     * 添加明细
     * @param stockDetailDO
     */
    void save(StockDetailDO stockDetailDO);
    
    /**
     * 添加明细流水
     * @param stockDetailDO
     */
    void saveWater(StockDetailDO stockDetailDO);

    /**
     * 更新明细
     * @param stockDetailDO
     * @return
     */
    int update(StockDetailDO stockDetailDO);

    /**
     * 查找明细
     * @param storeId 门店编号
     * @param goodsId 货品编号
     * @param status 状态
     * @return
     */
    StockDetailDO findOne(@Param("companyCode") String companyCode,@Param("storeId") String storeId, @Param("goodsId") String goodsId, @Param("status") int status);
    
    /**
     * 查找明细
     * @param companyCode 总部编号
     * @param storeId 门店编号
     * @param serialId 序列号
     * @return
     */
    StockDetailDO findBySerialId(@Param("companyCode") String companyCode, @Param("storeId") String storeId, @Param("serialId") String serialId);


}
