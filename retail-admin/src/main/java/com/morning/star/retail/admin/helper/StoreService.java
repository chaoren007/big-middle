package com.morning.star.retail.admin.helper;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.morning.star.retail.dto.store.StoreDTO;
import com.morning.star.retail.dto.store.StoreQueryDTO;
import com.morning.star.retail.facade.StoreFacade;

@Service
public class StoreService {

    @Autowired
    private StoreFacade storeFacade;


    public StoreDTO get(String storeCode) {
        return storeFacade.getStore(storeCode);
    }


    public List<StoreDTO> queryStore(String findAccessIds) {
        StoreQueryDTO storeBO = new StoreQueryDTO();
        storeBO.setFindAccessIds(findAccessIds);
        storeBO.setPageNo(1);
        storeBO.setPageSize(Integer.MAX_VALUE);
        return storeFacade.pageListStore(storeBO).getRecord();
    }

}