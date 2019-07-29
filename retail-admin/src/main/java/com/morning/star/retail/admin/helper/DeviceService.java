package com.morning.star.retail.admin.helper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.morning.star.retail.dto.DeviceInfoDTO;
import com.morning.star.retail.facade.DeviceFacade;

@Service
public class DeviceService {

    @Autowired
    private DeviceFacade deviceFacade;

    public DeviceInfoDTO checkGetDevice(String deviceId) {
        return deviceFacade.checkGetDevice(deviceId);
    }

}
