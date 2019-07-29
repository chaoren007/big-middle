package com.morning.star.retail.helper;

import com.morning.star.retail.facade.CategoryFacade;
import com.morning.star.retail.facade.GoodsSupplyFacade;
import com.morning.star.retail.facade.dto.supply.GoodsSupplyDTO;
import com.morning.star.retail.order.facade.BusOrderFacade;
import com.morning.star.retail.order.facade.dto.BusOrderDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
public class BusItemHelper {

    @Autowired
    private BusOrderFacade busOrderFacade;
    @Autowired
    private GoodsSupplyFacade goodsSupplyFacade;
    @Autowired
    private CategoryFacade categoryFacade;

    public BusOrderDTO getByDealWith() {
        return busOrderFacade.getByDealWith();
    }


    public void updateStatus(List<Long> ids) {
        busOrderFacade.updateStatus(ids);
    }


    public GoodsSupplyDTO getSupInfo(String productCode) {
        return goodsSupplyFacade.getDetailByProductCode(productCode);
    }

    public BigDecimal getCategoryRate(Long categoryId) {
        BigDecimal minCommission = categoryFacade.getByCode(categoryId).getMinCommission();


        return minCommission.divide(new BigDecimal(100));
    }


}
