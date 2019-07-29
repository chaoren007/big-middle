package com.morning.star.retail.application.impl;

import java.util.Date;

import com.morning.star.retail.user.UserPermission;
import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.Validate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.morning.star.retail.application.DeviceApplication;
import com.morning.star.retail.consts.RetailDefaultConst;
import com.morning.star.retail.dto.BindDeviceDTO;
import com.morning.star.retail.dto.group.GroupInfoDTO;
import com.morning.star.retail.dto.store.StoreDTO;
import com.morning.star.retail.entity.DeviceEntity;
import com.morning.star.retail.entity.repository.DeviceRepository;
import com.morning.star.retail.entity.repository.DeviceWaterEntity;
import com.morning.star.retail.entity.repository.WaterRepository;
import com.morning.star.retail.enums.DeviceStatusEnum;
import com.morning.star.retail.exception.DeviceErrorCode;
import com.morning.star.retail.helper.StoreService;
import com.morning.star.retail.user.UserUtils;
import com.morning.star.retail.util.RandomUtil;

@Service
public class DeviceApplicationImpl implements DeviceApplication {
    
    @Autowired
    private StoreService storeService;
    @Autowired
    private DeviceRepository deviceRepository;
    @Autowired
    private WaterRepository waterRepository;

    @Override
    public void addKey(Date expireDate) {
        DeviceEntity entity = new DeviceEntity();
        entity.setExpireDate(expireDate);
        entity.setSecretKey(getKey());
        entity.setStatus(DeviceStatusEnum.UNACTIVATED.getCode());
        deviceRepository.save(entity);
        waterRepository.save(entity, DeviceWaterEntity.class,"添加秘钥");
    }

    @Override
    public void modifyExpireDate(String key, Date expireDate) {
        DeviceEntity entity = deviceRepository.findOneBySecretKey(key);

        entity.setExpireDate(expireDate);
        deviceRepository.save(entity);
        waterRepository.save(entity, DeviceWaterEntity.class,"修改秘钥过期时间");
    }

    /**
     * 获取秘钥
     *
     * @return
     */
    private String getKey() {
        String key = RandomUtil.generateLowerString(RetailDefaultConst.KEY_LENGTH);
        DeviceEntity entity = deviceRepository.findOneBySecretKey(key);
        // 判断秘钥是否存在
        if (entity != null) {
            return getKey();
        }
        return key;
    }

    @Override
    public void initKey(String storeCode) {
    }

    @Override
    public void lockKey(String storeCode, String key) {
        DeviceEntity entity = deviceRepository.findOneBySecretKey(key);
        new UserPermission(UserUtils.currentUser())
            .tag("storeCode", entity.getStoreCode())
            .msg("该秘钥不允许操作:"+entity.getSecretKey())
            .pass();
        Validate.notNull(entity, "秘钥不存在");
        Validate.isTrue(entity.getStatus().intValue() == DeviceStatusEnum.ACTIVATED.getCode().intValue()
                , "该设备处于非激活状态，不能进行锁定秘钥操作");
        entity.setStatus(DeviceStatusEnum.LOCKED.getCode());
        deviceRepository.save(entity);
        waterRepository.save(entity, DeviceWaterEntity.class,"秘钥锁定门店");
    }

    @Override
    public void unlockKey(String storeCode, String key) {
        DeviceEntity entity = deviceRepository.findOneBySecretKey(key);
        new UserPermission(UserUtils.currentUser())
            .tag("storeCode", entity.getStoreCode())
            .msg("该秘钥不允许操作:"+entity.getSecretKey())
            .pass();
        Validate.notNull(entity, "秘钥不存在");
        Validate.isTrue(entity.getStatus().intValue() == DeviceStatusEnum.LOCKED.getCode().intValue()
                , "该设备处于非锁定状态，不能进行解锁秘钥操作");
        entity.setStatus(DeviceStatusEnum.UNACTIVATED.getCode());
        entity.setDeviceId(null);
        entity.setDeviceVersion(null);
        entity.setSoftwareVersion(null);
        entity.setActivityTime(null);
        entity.setLastLoginTime(null);
        entity.setLastRegTime(null);
        entity.setLastHeartbeatTime(null);
        
        deviceRepository.save(entity);
        waterRepository.save(entity, DeviceWaterEntity.class,"秘钥解锁门店");
    }

    @Override
    public void bindDevice(BindDeviceDTO dto) {
        DeviceEntity entity = deviceRepository.findOneBySecretKey(dto.getSecretKey());
        Validate.isTrue(entity != null, "没有相关设备秘钥信息");
        Validate.isTrue(!StringUtils.isBlank(entity.getGroupCode()), "秘钥"+dto.getSecretKey()+"尚未分配到任何集团");
        Validate.isTrue(!(entity.getExpireDate() != null && entity.getExpireDate().before(new Date())), "该秘钥无效");
        // 判断该秘钥是否已绑定
        if (DeviceStatusEnum.ACTIVATED.getCode().equals(entity.getStatus())) {
            // 同一设备重复绑定同一秘钥
            if (entity.getDeviceId().equals(dto.getDeviceId())) {
                throw DeviceErrorCode.KEY_DEVICE_BINDED.build();
            }
            throw DeviceErrorCode.KEY_IS_BINDED.build();
        }
        // 判断该秘钥是否被锁定
        if (DeviceStatusEnum.LOCKED.getCode().equals(entity.getStatus())) {
            throw DeviceErrorCode.DEVICE_IS_LOCKED.build();
        }
        // 校验deviceId是否已绑定
        DeviceEntity device = deviceRepository.findOneByDeviceId(dto.getDeviceId());
        if (device != null) {
            throw DeviceErrorCode.DEVICE_IS_BINDED.build();
        }
        entity.setStatus(DeviceStatusEnum.ACTIVATED.getCode());
        entity.setDeviceId(dto.getDeviceId());
        entity.setDeviceVersion(dto.getDeviceVersion());
        entity.setSoftwareVersion(dto.getSoftwareVersion());
        entity.setActivityTime(new Date());
        deviceRepository.save(entity);
        waterRepository.save(entity, DeviceWaterEntity.class,"秘钥绑定");
    }

    @Override
    public void unbindDevice(String storeCode, String key) {
        DeviceEntity entity = deviceRepository.findOneBySecretKey(key);
        if (!storeCode.equals(entity.getStoreCode())) {
            throw DeviceErrorCode.DEVICE_STORE_ERROR.build();
        }
        if (DeviceStatusEnum.UNACTIVATED.getClass().equals(entity.getStatus())) {
            throw DeviceErrorCode.DEVICE_CANNOT_UNBIND.build();
        }
        
        entity.setStatus(DeviceStatusEnum.UNACTIVATED.getCode());
        entity.setDeviceId(null);
        entity.setDeviceVersion(null);
        entity.setSoftwareVersion(null);
        entity.setActivityTime(null);
        deviceRepository.save(entity);
        waterRepository.save(entity, DeviceWaterEntity.class,"秘钥解绑");
    }
    
    @Transactional
    @Override
    public void distributeToStore(String keys, StoreDTO store) {
        String[] keyList = keys.split(",");
        for (String key : keyList) {
            DeviceEntity entity = deviceRepository.findOneBySecretKey(key);
            new UserPermission(UserUtils.currentUser())
                .tag("groupCode", entity.getStoreCode())
                .tag("storeCode", entity.getStoreCode())
                .msg("该秘钥不允许被操作:"+entity.getSecretKey())
                .pass();
            Validate.notNull(entity, "秘钥" + key + "不存在");
            Validate.notEmpty(entity.getGroupCode(), "秘钥" + key + "尚未分配到任何集团");
            Validate.isTrue(store.getGroupCode().equals(entity.getGroupCode()), "秘钥" + key + "已分配到其他集团");
            Validate.isTrue(StringUtils.isEmpty(entity.getStoreCode()), "秘钥" + key + "已分配到其他门店");

            entity.setStoreCode(store.getStoreCode());
            entity.setStoreName(store.getStoreName());
            // 更新秘钥信息
            deviceRepository.save(entity);
            waterRepository.save(entity, DeviceWaterEntity.class,"秘钥分配到门店");
        }
    }

    @Transactional
    @Override
    public void distributeToGroup(String keys, GroupInfoDTO groupInfo) {
        String[] keyList = keys.split(",");
        for (String key : keyList) {
            DeviceEntity entity = deviceRepository.findOneBySecretKey(key);
            Validate.notNull(entity, "秘钥" + key + "不存在");
            Validate.isTrue(StringUtils.isEmpty(entity.getGroupCode()), "秘钥" + key + "已分配到其他集团");
            entity.setGroupCode(groupInfo.getGroupCode());
            entity.setGroupName(groupInfo.getGroupName());
            deviceRepository.save(entity);
            waterRepository.save(entity, DeviceWaterEntity.class,"秘钥分配到集团");
        }
    }

    @Override
    public void recoverKey(String key) {
        DeviceEntity entity = deviceRepository.findOneBySecretKey(key);
        entity.setGroupCode(null);
        entity.setGroupName(null);
        entity.setStoreCode(null);
        entity.setStoreName(null);
        entity.setDeviceId(null);
        entity.setDeviceVersion(null);
        entity.setSoftwareVersion(null);
        entity.setStatus(DeviceStatusEnum.UNACTIVATED.getCode());
        entity.setActivityTime(null);
        entity.setLastLoginTime(null);
        entity.setLastRegTime(null);
        entity.setLastHeartbeatTime(null);
        entity.setRemark(null);
        deviceRepository.save(entity);
        waterRepository.save(entity, DeviceWaterEntity.class,"回收秘钥");
    }

}
