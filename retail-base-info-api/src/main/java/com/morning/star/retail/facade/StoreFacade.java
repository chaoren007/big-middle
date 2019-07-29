package com.morning.star.retail.facade;

import com.morning.star.retail.dto.store.*;
import com.morning.star.retail.utils.page.PageBean;

import java.util.List;

/**
 * 门店
 */
public interface StoreFacade {

    /**
     * 新增门店信息
     *
     * @param storeDO 实体对象
     * @return
     */
    void addStore(StoreCreateDTO storeDO);


    /**
     * 修改门店信息
     *
     * @param storeDO 实体对象
     * @return
     */
    void modifyStore(StoreModifyDTO storeDO);


    /**
     * 分页查询门店信息
     */
    PageBean<StoreDTO> pageListStore(StoreQueryDTO storeBO);

    /**
     * 分页查询门店信息
     */
    List<StoreDTO> listStore(StoreQueryDTO storeBO);

    /**
     * 门店冻结操作
     */
    void freezeStore(String storeCode);

    /**
     * 门店解冻操作
     */
    void unfreezeStore(String storeCode);


    /**
     * 查询门店
     */
    StoreDTO getStore(String storeCode);

    /**
     * 查询门店
     */
    StoreDTO getStoreByCity(String groupCode, Long id);


    String getCode();

    /**
     * 查询常驻城市
     *
     * @param groupCode
     * @return
     */
    List<CityDTO> queryCity(String groupCode);

}
