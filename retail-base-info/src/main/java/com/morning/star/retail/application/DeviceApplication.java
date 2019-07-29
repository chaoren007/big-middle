package com.morning.star.retail.application;

import java.util.Date;

import com.morning.star.retail.dto.BindDeviceDTO;
import com.morning.star.retail.dto.group.GroupInfoDTO;
import com.morning.star.retail.dto.store.StoreDTO;

/**
 * 设备
 *
 * @author jiangyf (rebuild:kimhuhg)
 * @date 2017年5月23日 下午1:38:47
 */
public interface DeviceApplication {

    /**
     * 新增设备秘钥
     *
     * @return
     */
    void addKey(Date expireDate);

    /**
     * 修改到期日期
     *
     * @return
     */
    void modifyExpireDate(String key, Date expireDate);

    /**
     * 初始化秘钥（创建门店）
     *
     * @return
     */
    void initKey(String storeCode);

    /**
     * 锁定秘钥
     *
     */
    void lockKey(String storeCode, String key);

    /**
     * 解锁秘钥
     *
     */
    void unlockKey(String storeCode, String key);

    /**
     * 绑定设备
     *
     * @return
     */
    void bindDevice(BindDeviceDTO dto);

    /**
     * 解绑设备
     *
     * @return
     */
    void unbindDevice(String storeCode, String key);


    /**
     * 分配秘钥
     *
     * @return
     */
    void distributeToGroup(String keys, GroupInfoDTO groupInfo);
    
    void distributeToStore(String keys, StoreDTO store);

    /**
     * 回收秘钥
     *
     * @param key
     * @return
     */
    void recoverKey(String key);


}
