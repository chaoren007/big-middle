package com.morning.star.retail.helper;

import com.morning.star.retail.dto.store.StoreDTO;
import com.morning.star.retail.facade.StoreFacade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StoreService {

    @Autowired
    private StoreFacade storeFacade;

    public StoreDTO getStore(String storeCode) {
        return storeFacade.getStore(storeCode);
    }

    public StoreDTO findOneByName(String storeName) {
        // TODO Auto-generated method stub
        return null;
    }

    /**
     * 更具城市查询分公司
     *
     * @param cityid
     * @param groupCode
     * @return
     */
    public StoreDTO getStoreByCityId(Long cityid, String groupCode) {
        return storeFacade.getStoreByCity(groupCode, cityid);
    }

}
