package com.morning.star.retail.order.helper;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.morning.star.retail.facade.StockFacade;
import com.morning.star.retail.order.domain.entity.SalesOrderEntity;
import com.morning.star.retail.stock.dto.ItemDTO;
import com.morning.star.retail.stock.dto.StockOrderDTO;

@Component
public class StorkReduceHelper {

    @Autowired
    private StockFacade stockFacade;


    public void offlineOutStock(SalesOrderEntity order) {
        List<ItemDTO> items = new ArrayList<>();
        order.getItems().forEach(e -> {
            items.add(new ItemDTO(e.getGoodsCode(), e.getBuyNum(), e.getBuyNum(), e.getUnit()));
        });
        StockOrderDTO dto = new StockOrderDTO(
                order.getDepartment().getGroupCode(),
                order.getDepartment().getStoreCode(),
                order.getOrderCode(),
                String.valueOf(order.getOrderStatus()), items);
        stockFacade.offlineOutStock(dto);
    }
}
