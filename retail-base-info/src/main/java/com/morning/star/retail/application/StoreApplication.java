package com.morning.star.retail.application;

import com.morning.star.retail.dto.store.StoreCreateDTO;
import com.morning.star.retail.dto.store.StoreModifyDTO;

/**
 * 门店
 *
 */
public interface StoreApplication {

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


    String getCode();

    void freezeStore(String storeCode);

    void unfreezeStore(String storeCode);

}
