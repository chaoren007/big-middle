package com.morning.star.retail.stock.helper;

import com.morning.star.retail.dto.WarehouseDTO;
import com.morning.star.retail.facade.WarehouseFacade;
import com.morning.star.retail.stock.helper.vo.WarehouseInfo;
import com.morning.star.retail.utils.entity.BeanUtils;
import org.apache.commons.lang.Validate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class WarehouseService {
    @Autowired
    private WarehouseFacade warehouseFacade;

    public WarehouseInfo get(String code) {
        WarehouseDTO dto = warehouseFacade.getByWarehouseCode(code);
        if (dto != null) {
            WarehouseInfo info = new WarehouseInfo();
            BeanUtils.copy(dto, info);
            return info;
        }
        return null;
    }

    public WarehouseInfo checkGet(String code) {
        WarehouseInfo warehouseInfo = get(code);
        Validate.notNull(warehouseInfo, String.format("未找到该仓库【编号：%s】信息", code));
        return warehouseInfo;
    }

}
