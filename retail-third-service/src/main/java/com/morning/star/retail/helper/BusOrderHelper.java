package com.morning.star.retail.helper;

import com.morning.star.retail.order.facade.BusOrderFacade;
import com.morning.star.retail.order.facade.dto.BusOrderDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BusOrderHelper {

    @Autowired
    private BusOrderFacade busOrderFacade;

    public void add(BusOrderDTO dto) {
        System.out.println("============================" + "调用busOrderFrade");
        busOrderFacade.add(dto);
    }
}
