package com.morning.star.retail.order.facade;

import com.morning.star.retail.order.domain.entity.BusAfterSalesOrderEntity;
import com.morning.star.retail.order.domain.entity.repository.BusAfterSalesOrderRepository;
import com.morning.star.retail.order.enums.BusAfterSalesStatusEnum;
import com.morning.star.retail.order.facade.dto.BusAfterSalesDTO;
import com.morning.star.retail.order.facade.dto.BusAfterSalesQueryDTO;
import com.morning.star.retail.order.service.OrderService;
import com.morning.star.retail.utils.page.PageBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BusAfterSalesServiceFacadeImpl implements BusAfterSalesServiceFacade {
    @Autowired
    private OrderService orderService;
    @Autowired
    private BusAfterSalesOrderRepository busAfterSalesOrderRepository;

    @Override
    public PageBean<BusAfterSalesDTO> getBusAfterSales(BusAfterSalesQueryDTO busAfterSalesQueryDTO) {
        return orderService.getBusAfterSales(busAfterSalesQueryDTO);
    }

    @Override
    public void confirm(String afterSalesCode) {
        BusAfterSalesOrderEntity byAfterSalesCode = busAfterSalesOrderRepository.getByAfterSalesCode(afterSalesCode);
        byAfterSalesCode.setStatus(BusAfterSalesStatusEnum.DEALED.getCode());
        byAfterSalesCode.setStatusName(BusAfterSalesStatusEnum.DEALED.getDesc());
        busAfterSalesOrderRepository.save(byAfterSalesCode);
    }
}
