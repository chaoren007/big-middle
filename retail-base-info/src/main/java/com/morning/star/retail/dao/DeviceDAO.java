package com.morning.star.retail.dao;

import org.apache.ibatis.session.RowBounds;

import com.github.pagehelper.Page;
import com.morning.star.retail.dto.DeviceInfoDTO;
import com.morning.star.retail.dto.QueryPageDeviceDTO;

public interface DeviceDAO {

	Page<DeviceInfoDTO> selectAll(QueryPageDeviceDTO queryPageDeviceDTO, RowBounds rowBounds);

    DeviceInfoDTO getDeviceByDeviceId(String deviceId);
    DeviceInfoDTO getDeviceBySecretKey(String secretKey);

}