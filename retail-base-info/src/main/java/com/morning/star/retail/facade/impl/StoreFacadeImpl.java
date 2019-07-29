package com.morning.star.retail.facade.impl;

import com.github.pagehelper.Page;
import com.morning.star.retail.application.StoreApplication;
import com.morning.star.retail.consts.RetailDefaultConst;
import com.morning.star.retail.dao.StoreDAO;
import com.morning.star.retail.dto.store.*;
import com.morning.star.retail.entity.StoreEntity;
import com.morning.star.retail.entity.repository.StoreRepository;
import com.morning.star.retail.facade.StoreFacade;
import com.morning.star.retail.utils.entity.BeanUtils;
import com.morning.star.retail.utils.page.PageBean;
import com.morning.star.retail.utils.page.PageBeanAssembler;
import com.morning.star.retail.utils.page.RowBoundsBuilder;
import org.apache.ibatis.session.RowBounds;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;

@Service
public class StoreFacadeImpl implements StoreFacade {

    @Autowired
    private StoreApplication storeApplication;

    @Autowired
    private StoreDAO storeDAO;

    @Autowired
    private StoreRepository storeRepository;

    @Override
    public void addStore(StoreCreateDTO storeDO) {
        storeApplication.addStore(storeDO);
    }


    @Override
    public void modifyStore(StoreModifyDTO storeDO) {
        storeApplication.modifyStore(storeDO);
    }

    @Override
    public PageBean<StoreDTO> pageListStore(StoreQueryDTO storeBO) {
        RowBounds rowBounds = RowBoundsBuilder.build(storeBO.getPageNo(), storeBO.getPageSize());
        Page<StoreDTO> list = storeDAO.selectAll(storeBO, rowBounds);
        return new PageBeanAssembler().toBean(list);
    }

    @Override
    public List<StoreDTO> listStore(StoreQueryDTO storeBO) {

        return storeDAO.selectAllList(storeBO);
    }

    @Override
    public void freezeStore(String storeCode) {
        storeApplication.freezeStore(storeCode);
    }

    @Override
    public void unfreezeStore(String storeCode) {
        storeApplication.unfreezeStore(storeCode);
    }

    @Override
    public StoreDTO getStore(String storeCode) {
        StoreEntity entity = storeRepository.findOne(storeCode);
        if (entity == null) {
            return null;
        }
        StoreDTO store = new StoreDTO();
        BeanUtils.copy(entity, store);
        return store;
    }

    @Override
    public StoreDTO getStoreByCity(String groupCode, Long id) {
        StoreEntity entity = storeRepository.findByGroupCodeAndCityId(groupCode, id);
        if (entity == null) {
            return null;
        }
        StoreDTO store = new StoreDTO();
        BeanUtils.copy(entity, store);
        return store;
    }

    @Override
    public String getCode() {
        return storeApplication.getCode();
    }

    @Override
    public List<CityDTO> queryCity(String groupCode) {
        List<CityDTO> list = storeDAO.selectCity(groupCode);
        CityDTO cityDTO = new CityDTO();
        cityDTO.setCityId(RetailDefaultConst.DEFAULT_CITY_ID);
        cityDTO.setCityName(RetailDefaultConst.DEFAULT_CITY_NAME);
        list.add(cityDTO);

        // 排序
        list.sort(new Comparator<CityDTO>() {
            @Override
            public int compare(CityDTO o1, CityDTO o2) {
                if (o1.getCityId() > o2.getCityId()) {
                    return 1;
                }
                return -1;
            }
        });
        return list;
    }

}
