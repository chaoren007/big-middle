package com.morning.star.retail.stock.helper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.morning.star.retail.dto.SupplierDTO;
import com.morning.star.retail.dto.SupplierItemDTO;
import com.morning.star.retail.dto.SupplierQueryDTO;
import com.morning.star.retail.facade.SupplierFacade;
import com.morning.star.retail.stock.helper.vo.SupplierInfo;
import com.morning.star.retail.stock.helper.vo.SupplierItemInfo;
import com.morning.star.retail.utils.entity.BeanUtils;

@Service
public class SupplierService {
    @Autowired
    private SupplierFacade facade;

    public SupplierItemInfo getSupplierItemInfo(String productCode, String supplierCode, String groupCode) {
        SupplierItemDTO itemDTO = facade.getItem(SupplierQueryDTO.byProductCode(productCode, supplierCode, groupCode));
        if(itemDTO == null) {
            return null;
        }
        SupplierItemInfo info = new SupplierItemInfo();
        BeanUtils.copy(itemDTO, info);
        return info;
    }

    public SupplierInfo getSupplierInfo(String groupCode, String supplierCode) {
        SupplierDTO supplierDTO = facade.get(supplierCode, groupCode);
        if(supplierDTO == null) {
            return null;
        }
        SupplierInfo info = new SupplierInfo();
        BeanUtils.copy(supplierDTO, info);
        return info;
    }

}
