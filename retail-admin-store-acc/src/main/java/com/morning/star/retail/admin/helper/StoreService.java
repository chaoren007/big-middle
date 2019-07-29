package com.morning.star.retail.admin.helper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.morning.star.retail.dto.store.StoreDTO;
import com.morning.star.retail.facade.StoreFacade;

@Service
public class StoreService {
    
    @Autowired
    private StoreFacade storeFacade;

    public StoreDTO getStore(String storeCode) {
        return storeFacade.getStore(storeCode);
    }

}
