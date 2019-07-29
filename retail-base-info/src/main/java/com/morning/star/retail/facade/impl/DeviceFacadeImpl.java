package com.morning.star.retail.facade.impl;

import java.util.Date;

import org.apache.ibatis.session.RowBounds;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.github.pagehelper.Page;
import com.morning.star.retail.application.DeviceApplication;
import com.morning.star.retail.dao.DeviceDAO;
import com.morning.star.retail.dto.BindDeviceDTO;
import com.morning.star.retail.dto.DeviceInfoDTO;
import com.morning.star.retail.dto.QueryPageDeviceDTO;
import com.morning.star.retail.dto.group.GroupInfoDTO;
import com.morning.star.retail.dto.store.StoreDTO;
import com.morning.star.retail.enums.DeviceStatusEnum;
import com.morning.star.retail.exception.DeviceErrorCode;
import com.morning.star.retail.facade.DeviceFacade;
import com.morning.star.retail.helper.GroupService;
import com.morning.star.retail.helper.StoreService;
import com.morning.star.retail.utils.page.PageBean;
import com.morning.star.retail.utils.page.PageBeanAssembler;
import com.morning.star.retail.utils.page.RowBoundsBuilder;

@Service
public class DeviceFacadeImpl implements DeviceFacade {

    @Autowired
    private DeviceApplication deviceApplication;
    
    @Autowired
    private StoreService storeService;
    @Autowired
    private GroupService groupService;
    @Autowired
    private DeviceDAO deviceDAO;

    @Override
    public DeviceInfoDTO getDevice(String deviceId) {
        DeviceInfoDTO dto =  deviceDAO.getDeviceByDeviceId(deviceId);
        if(dto == null) {
            return null;
        }
        return dealOverdue(dto);
    }

    @Override
    public DeviceInfoDTO checkGetDevice(String deviceId) {
        DeviceInfoDTO deviceInfoDTO = deviceDAO.getDeviceByDeviceId(deviceId);
        if (deviceInfoDTO == null) {
            throw DeviceErrorCode.DEVICE_IS_NULL.build();
        }
        if (DeviceStatusEnum.UNACTIVATED.getCode().equals(deviceInfoDTO.getStatus())) {
            throw DeviceErrorCode.DEVICE_IS_UNACTIVATE.build();
        }
        if (DeviceStatusEnum.LOCKED.getCode().equals(deviceInfoDTO.getStatus())) {
            throw DeviceErrorCode.DEVICE_IS_LOCKED.build();
        }
        return dealOverdue(deviceInfoDTO);
    }

    @Override
    public PageBean<DeviceInfoDTO> listDevice(QueryPageDeviceDTO queryPageDeviceDTO) {
        RowBounds rowBounds = RowBoundsBuilder.build(queryPageDeviceDTO.getPageNo(), queryPageDeviceDTO.getPageSize());
        Page<DeviceInfoDTO> list = deviceDAO.selectAll(queryPageDeviceDTO, rowBounds);
        list.forEach(e -> dealOverdue(e));
        return new PageBeanAssembler().toBean(list);
    }

    private DeviceInfoDTO dealOverdue(DeviceInfoDTO dto) {
        dto.setOverdue(dto.getExpireDate() == null || dto.getExpireDate().after(new Date()) ? 1 : 2);
        return dto;
    }

    @Override
    public void addKey(Date expireDate) {
        deviceApplication.addKey(expireDate);
    }

    @Override
    public void modifyExpireDate(String key, Date expireDate) {
        this.deviceApplication.modifyExpireDate(key, expireDate);
    }

    @Override
    public void initKey(String storeCode) {
        deviceApplication.initKey(storeCode);
    }

    @Override
    public void lockKey(String storeCode, String key) {
        deviceApplication.lockKey(storeCode, key);
    }

    @Override
    public void unlockKey(String storeCode, String key) {
        deviceApplication.unlockKey(storeCode, key);
    }

    @Transactional
    @Override
    public void bindDevice(BindDeviceDTO dto) {
        deviceApplication.bindDevice(dto);
    }

    @Transactional
    @Override
    public void unbindDevice(String storeCode, String key) {
        deviceApplication.unbindDevice(storeCode, key);
    }

    @Transactional
    @Override
    public void distributeKey(String storeCode, String keys) {
        StoreDTO store = storeService.getStore(storeCode);
        deviceApplication.distributeToStore(keys, store);
    }

    @Override
    public void distributeForGod(String groupCode, String keys) {
        GroupInfoDTO groupInfo = groupService.getGroupInfo(groupCode);
        deviceApplication.distributeToGroup(keys, groupInfo);
    }

    @Override
    public void recover(String key) {
        this.deviceApplication.recoverKey(key);
    }

}
