package com.morning.star.retail.order.testController;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.morning.star.retail.order.facade.OrderFacade;
import com.morning.star.retail.order.facade.order.req.IndexReqParams;
import com.morning.star.retail.order.facade.order.req.OrderListReqParams;
import com.morning.star.retail.order.facade.order.req.OrderReqParams;
import com.morning.star.retail.order.facade.order.resp.IndexVo;
import com.morning.star.retail.order.facade.order.resp.SalesOrderVO;
import com.morning.star.retail.utils.entity.ValidationUtils;
import com.morning.star.retail.utils.page.PageBean;

@RestController
@RequestMapping("api/v1/order")
public class OrderController {


    @Autowired
    private OrderFacade orderFacade;


    @PostMapping
    public String doOrder(@RequestBody OrderReqParams orderReqParams) {
        ValidationUtils.validate(orderReqParams);
        return orderFacade.posOrder(orderReqParams);
    }


    @GetMapping
    public PageBean<SalesOrderVO> getOrder(OrderListReqParams orderListReqParams) {
        PageBean<SalesOrderVO> salesOrderDTOPageBean = orderFacade.querySalesOrderPage(orderListReqParams);
        return salesOrderDTOPageBean;
    }

    @GetMapping("/{orderCode}")
    public Object getOrder(@PathVariable String orderCode) {
        SalesOrderVO salesOrder = orderFacade.getSalesOrder(orderCode);
        return salesOrder;
    }

    public IndexVo getUpIndex(IndexReqParams reqParams) {
        return orderFacade.getUpIndex(reqParams);
    }

    @GetMapping("/test")
    public void test() {
        orderFacade.test();
    }
}
