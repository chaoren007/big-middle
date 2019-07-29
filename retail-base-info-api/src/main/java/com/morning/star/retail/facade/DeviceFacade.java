package com.morning.star.retail.facade;

import java.util.Date;

import com.morning.star.retail.dto.BindDeviceDTO;
import com.morning.star.retail.dto.DeviceInfoDTO;
import com.morning.star.retail.dto.QueryPageDeviceDTO;
import com.morning.star.retail.utils.page.PageBean;

/**
 * 设备
 *
 * @author jiangyf (rebuild:kimhuhg)
 * @date 2017年5月23日 下午1:41:21
 */
public interface DeviceFacade {
    /**
     * 查询设备
     *
     * @param deviceId
     * @return
     */
    DeviceInfoDTO getDevice(String deviceId);

    /**
     * 查询设备
     *
     * @param deviceId
     * @return
     */
    DeviceInfoDTO checkGetDevice(String deviceId);

    /**
     * 设备列表
     *
     * @param queryPageDeviceDTO
     * @return
     */
    PageBean<DeviceInfoDTO> listDevice(QueryPageDeviceDTO queryPageDeviceDTO);

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
     */
    void unlockKey(String storeCode, String key);

    /**
     * 绑定设备
     * @return
     */
    void bindDevice(BindDeviceDTO dto);

    /**
     * 解绑设备
     * @return
     */
    void unbindDevice(String storeCode, String key);

    /**
     * 分配秘钥到门店
     */
    void distributeKey(String storeCode, String key);

    /**
     * 分配秘钥到集团
     * @return
     */
    void distributeForGod(String GroupCode, String key);

    /**
     * 回收秘钥
     *
     * @param key
     * @return
     */
    void recover(String key);
}
