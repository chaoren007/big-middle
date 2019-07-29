package com.morning.star.retail.admin.group.helper;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.morning.star.retail.dto.store.StoreCreateDTO;
import com.morning.star.retail.dto.store.StoreDTO;
import com.morning.star.retail.dto.store.StoreModifyDTO;
import com.morning.star.retail.dto.store.StoreQueryDTO;
import com.morning.star.retail.facade.StoreFacade;
import com.morning.star.retail.utils.page.PageBean;

@Service
public class StoreService {
    
    private static final String pre = "GS";
    @Autowired
    private StoreFacade storeFacade;

    public StoreDTO getStore(String storeCode) {
        return storeFacade.getStore(storeCode);
    }

    public String genCode() {
        String code = storeFacade.getCode();
        if (org.apache.commons.lang.StringUtils.isBlank(code)) {
            code = pre + "0";
        }
        return autoGenericCode(Integer.parseInt(code.split(pre)[1]), 8);
    }
    
    
    private static String autoGenericCode(int code, int num) {
        String result = "";
        // 保留num的位数
        // 0 代表前面补充0
        // d 代表参数为正数型
        result = String.format(pre + "%0" + num + "d", code + 1);
        return result;
    }

    
    /**
     * 新增门店信息
     */
    public void addStore(StoreCreateDTO dto) {
        storeFacade.addStore(dto);
    }


    /**
     * 修改门店信息
     */
    public void modifyStore(StoreModifyDTO storeDO) {
        storeFacade.modifyStore(storeDO);
    }

    /**
     * 分页查询门店信息
     */
    public PageBean<StoreDTO> pageListStore(StoreQueryDTO storeBO) {
        return storeFacade.pageListStore(storeBO);
    }

    /**
     * 查询门店列表信息
     */
    public List<StoreDTO> listStore(StoreQueryDTO storeBO) {
        return storeFacade.listStore(storeBO);
    }
    /**
     * 门店冻结操作
     */
    public void freezeStore(String storeCode) {
        storeFacade.freezeStore(storeCode);
    }

    /**
     * 门店解冻操作
     */
    public void unfreezeStore(String storeCode) {
        storeFacade.unfreezeStore(storeCode);
    }
    

}
