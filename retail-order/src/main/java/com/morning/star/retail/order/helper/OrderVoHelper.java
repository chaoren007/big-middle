package com.morning.star.retail.order.helper;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import com.morning.star.retail.order.domain.entity.BuyerEntity;
import com.morning.star.retail.order.domain.entity.DepartmentEntity;
import com.morning.star.retail.order.domain.entity.PaymentEntity;
import com.morning.star.retail.order.domain.entity.SalesOrderEntity;
import com.morning.star.retail.order.domain.entity.SalesOrderItemEntity;
import com.morning.star.retail.order.domain.entity.SalesOrderOperationEntity;
import com.morning.star.retail.order.exception.OrderException;
import com.morning.star.retail.order.facade.order.dto.OrderGoodsItemDTO;
import com.morning.star.retail.order.facade.order.dto.PaymentDTO;
import com.morning.star.retail.order.facade.order.dto.SalesOrderOperationDTO;
import com.morning.star.retail.order.facade.order.resp.SalesOrderVO;
import com.morning.star.retail.util.DateUtil;

@Component
public class OrderVoHelper {

    private SalesOrderVO salesOrderVO = new SalesOrderVO();


    public OrderVoHelper buildBase(SalesOrderEntity entity) {
        BeanUtils.copyProperties(entity, salesOrderVO);
        salesOrderVO.setOrderStatus(entity.getOrderStatus().getCode());

        DepartmentEntity department = entity.getDepartment();
        BeanUtils.copyProperties(department, salesOrderVO);

        salesOrderVO.setDiscountAmount(entity.getDiscountAmount());
        return this;
    }

    public OrderVoHelper buildBuyer(BuyerEntity buyer) {
        //购买人信息
        if (buyer != null) {
            BeanUtils.copyProperties(buyer, salesOrderVO);
        }
        return this;
    }

    public OrderVoHelper buildPayment(List<PaymentEntity> payments) {
        if (!CollectionUtils.isEmpty(payments)) {
            List<PaymentDTO> list = new ArrayList<>();
            payments.stream().forEach(entity -> {
                PaymentDTO dto = new PaymentDTO();
                dto.setPayTime(DateUtil.toDateTime(entity.getPayTime()));
                BeanUtils.copyProperties(entity, dto);
                list.add(dto);
            });
            salesOrderVO.setPayment(list);
        }
        return this;
    }

    public OrderVoHelper buildGoods(List<SalesOrderItemEntity> items) {
        if (CollectionUtils.isEmpty(items)) {
            throw new OrderException("订单详情商品明细构建异常");
        }
        //商品明细
        List<OrderGoodsItemDTO> list = new ArrayList<>();
        items.stream().forEach(a -> {
            OrderGoodsItemDTO dto = new OrderGoodsItemDTO();
            BeanUtils.copyProperties(a, dto);
            dto.setBuyTime(DateUtil.toDateTime(a.getBuyTime()));
            list.add(dto);
        });
        salesOrderVO.setItems(list);
        return this;
    }

    public OrderVoHelper buildOperation(List<SalesOrderOperationEntity> operation) {
        if (CollectionUtils.isEmpty(operation)) {
            throw new OrderException("订单详情操作记录异常");
        }

        List<SalesOrderOperationDTO> list = new ArrayList<>();
        operation.stream().forEach(entity -> {
            SalesOrderOperationDTO dto = new SalesOrderOperationDTO();
            dto.setOperationContent(entity.getRemark());
            dto.setOperationId(entity.getOperator().getOperatorId().toString());
            dto.setOperationName(entity.getOperator().getOperatorName());
            dto.setOrderStatus(entity.getOrderStatus().getCode());
            dto.setOperationTime(DateUtil.toDateTime(entity.getOperateTime()));
            list.add(dto);
        });
        salesOrderVO.setOperation(list);
        return this;
    }

    public SalesOrderVO done() {
        return this.salesOrderVO;
    }
}
