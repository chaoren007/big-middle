package com.morning.star.retail.facade.impl;

import com.github.pagehelper.PageHelper;
import com.morning.star.retail.application.WarehouseApplication;
import com.morning.star.retail.base.page.PageBeans;
import com.morning.star.retail.dao.WarehouseDAO;
import com.morning.star.retail.dto.AddressDTO;
import com.morning.star.retail.dto.WarehouseDTO;
import com.morning.star.retail.dto.WarehouseQueryDTO;
import com.morning.star.retail.dto.store.StoreDTO;
import com.morning.star.retail.entity.WarehouseEntity;
import com.morning.star.retail.entity.repository.WarehouseRepository;
import com.morning.star.retail.facade.AddressFacade;
import com.morning.star.retail.facade.StoreFacade;
import com.morning.star.retail.facade.WarehouseFacade;
import com.morning.star.retail.utils.PhoneFormatCheckUtils;
import com.morning.star.retail.utils.entity.BeanUtils;
import org.apache.commons.lang3.Validate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

/**
 * @Description TODO
 * @Author LiquorSea
 * @Date 2018/12/5 14:05
 **/
@Service
public class WarehouseFacadeImpl implements WarehouseFacade {


    private static Logger log = LoggerFactory.getLogger(WarehouseFacadeImpl.class);
    @Autowired
    private WarehouseApplication warehouseApplication;
    @Autowired
    private WarehouseDAO warehouseDAO;
    @Autowired
    private StoreFacade storeFacade;
    @Autowired
    private AddressFacade addressFacade;
    @Autowired
    private WarehouseRepository warehouseRepository;

    @Override
    public String create(WarehouseDTO dto) {
        Validate.notNull(dto.getWarehouseName(), "仓库名称不能为空");
        Validate.notNull(dto.getWarehouseAddress(), "仓库地址不能为空");
        if (dto.getTel() != null && !dto.getTel().isEmpty()) {
            Validate.isTrue(PhoneFormatCheckUtils.isPhoneLegal(dto.getTel()), "手机号格式错误");
        }
        if (dto.getStoreCode() != null && !dto.getStoreCode().isEmpty()) {
            //门店端过来，要把城市名称set进去
            StoreDTO store = storeFacade.getStore(dto.getStoreCode());
            if (store != null && store.getCityId() != null && store.getCityName() != null) {
                dto.setCity(store.getCityName());
                dto.setCityId(store.getCityId());
            } else {
                throw new RuntimeException("门店城市不存在");
            }

        } else {
            Validate.notNull(dto.getCityId(), "城市ID不能为空");
            try {
                AddressDTO addressById = addressFacade.getAddressById(dto.getCityId());
                dto.setCity(addressById.getAddressName());
            } catch (Exception e) {
                throw new RuntimeException("通过城市ID获取城市名称错误，城市ID" + dto.getCityId());
            }
        }
        return warehouseApplication.create(dto);
    }

    @Override
    public PageBeans<WarehouseDTO> queryPage(WarehouseQueryDTO dto) {
        Validate.notNull(dto.getPageNo(), "分页参数不能为空");
        Validate.notNull(dto.getPageSize(), "分页参数不能为空");
        PageHelper.startPage(dto.getPageNo(), dto.getPageSize());
        List<WarehouseDTO> list = warehouseDAO.list(dto);
        return new PageBeans<>(list);
    }

    @Override
    public List<WarehouseDTO> queryList(WarehouseQueryDTO dto) {
        List<WarehouseDTO> list = warehouseDAO.list(dto);
        return list;
    }

    @Override
    public void edit(WarehouseDTO dto) {
        warehouseApplication.edit(dto);
    }

    @Override
    public void delete(WarehouseQueryDTO dto) {
        warehouseApplication.delete(dto);

    }

    @Override
    public List<WarehouseDTO> listcity(String groupCode) {
        return warehouseDAO.listcity(groupCode);
    }

    @Override
    public List<WarehouseDTO> listWarehouse(WarehouseQueryDTO dto) {
        if (dto.getStoreCode() != null && !dto.getStoreCode().isEmpty()) {
            StoreDTO store = storeFacade.getStore(dto.getStoreCode());
            if (store != null && store.getCityId() != null) {
                dto.setCityId(store.getCityId());
            } else {
                return Collections.emptyList();
            }

        }
        WarehouseQueryDTO query = new WarehouseQueryDTO();
        query.setCityId(dto.getCityId());
        query.setGroupCode(dto.getGroupCode());
        return warehouseDAO.listWarehouse(query);
    }

    @Override
    public WarehouseDTO getByWarehouseCode(String warehouseCode) {
        WarehouseEntity entity = warehouseRepository.getByWarehouseCode(warehouseCode);
        WarehouseDTO dto = new WarehouseDTO();
        if(entity!=null){
            BeanUtils.copy(entity, dto);
        }
        return dto;
    }
}
  
  
   