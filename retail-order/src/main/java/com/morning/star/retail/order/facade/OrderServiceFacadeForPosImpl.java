package com.morning.star.retail.order.facade;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.morning.star.retail.order.facade.dto.HomeSearchDTO;
import com.morning.star.retail.order.facade.dto.OfflineOrderPayFormDTO;
import com.morning.star.retail.order.facade.dto.OfflineOrderPayResultDTO;
import com.morning.star.retail.order.facade.dto.PosOrderPayResultDTO;
import com.morning.star.retail.order.facade.dto.SalesDTO;
import com.morning.star.retail.order.facade.dto.SalesItemSummaryDTO;
import com.morning.star.retail.order.facade.dto.SalesOrderDTO;
import com.morning.star.retail.order.facade.order.req.OrderListReqParams;
import com.morning.star.retail.order.facade.order.req.OrderReqParams;
import com.morning.star.retail.order.logicservice.OrderPayLogicService;
import com.morning.star.retail.order.service.ApplyRefundService;
import com.morning.star.retail.order.service.IndexService;
import com.morning.star.retail.order.service.OrderService;
import com.morning.star.retail.utils.page.PageBean;

@Service
public class OrderServiceFacadeForPosImpl implements OrderServiceFacadeForPos {

    @Autowired
    private OrderService orderService;
    @Autowired
    IndexService indexService;
    @Autowired
    ApplyRefundService applyRefundService;
    @Autowired
    private OrderPayLogicService orderPayLogicService;

    @Override
    public String submitPosOrder(OrderReqParams form) {
        return orderService.posOrder(form);
    }

    @Override
    public void syncPosOrder(List<OrderReqParams> forms) {

    }

    @Override
    public PageBean<SalesOrderDTO> querySalesOrderForPos(OrderListReqParams search) {
        return null;
    }

    @Override
    public SalesOrderDTO getSalesOrderDetail(String orderCode) {
        return null;
    }

    @Override
    public void agreeCancelSalesOrder(String orderCode) {

    }

    @Override
    public SalesDTO querySales(OrderListReqParams search) {
        return null;
    }

    @Override
    public SalesOrderDTO getSalesOrder(String orderCode) {
        return null;
    }

    @Override
    public List<Map<String, Object>> queryBatchOrderPayStatus(List<String> orderCodes) {
        return null;
    }


    /**
     * 线下支付宝微信支付
     * @param dto
     * @return
     */
    @Override
    public OfflineOrderPayResultDTO offlinePayForOrder(OfflineOrderPayFormDTO dto) {
        return orderPayLogicService.offlinePayForOrder(dto);
    }

    @Override
    public PosOrderPayResultDTO getOfflineScanPayResult(String orderCode) {
        return orderPayLogicService.getOfflineScanPayResult(orderCode);
    }

    @Override
    public PageBean<SalesItemSummaryDTO> countSaleItems(HomeSearchDTO search) {
        return null;
    }


}
