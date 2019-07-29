package com.morning.star.retail.order.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.morning.star.retail.facade.GoodsAdminFacade;
import com.morning.star.retail.facade.dto.GoodsDTO;
import com.morning.star.retail.order.domain.entity.AfterSalesOrderEntity;
import com.morning.star.retail.order.domain.entity.AfterSalesOrderItemEntity;
import com.morning.star.retail.order.domain.entity.BuyerEntity;
import com.morning.star.retail.order.domain.entity.CategoryEntity;
import com.morning.star.retail.order.domain.entity.DepartmentEntity;
import com.morning.star.retail.order.enums.AfterSalesOrderStatus;
import com.morning.star.retail.order.enums.AfterSalesTypeEnum;
import com.morning.star.retail.order.enums.RefundTypeEnum;
import com.morning.star.retail.order.enums.SalesTypeEnum;
import com.morning.star.retail.order.exception.OrderException;
import com.morning.star.retail.order.facade.order.dto.OrderGoodsItemDTO;
import com.morning.star.retail.order.facade.order.req.ApplyRefundGoodsReqParams;
import com.morning.star.retail.order.facade.order.req.ApplyRefundReqParams;
import com.morning.star.retail.order.service.ApplyRefundService;
import com.morning.star.retail.order.service.OrderService;
import com.morning.star.retail.util.DateUtil;

@Service
public class ApplyRefundServiceImpl implements ApplyRefundService {

    @Autowired
    private GoodsAdminFacade goodsFacade;

    @Autowired
    private OrderService orderService;


    @Override
    public String refundAmount(ApplyRefundReqParams applyRefundReqParams) {
        //售后表主体：RETAIL_AFTER_SALES_ORDER
        AfterSalesOrderEntity afterSalesOrderEntity = buildAfterSalesOrderEntity(applyRefundReqParams);

        List<AfterSalesOrderItemEntity> list = buildAfterSalesOrderItemEntity(applyRefundReqParams);
        afterSalesOrderEntity.setItems(list);



        return null;
    }

    private List<AfterSalesOrderItemEntity> buildAfterSalesOrderItemEntity(ApplyRefundReqParams params) {
        List<ApplyRefundGoodsReqParams> refundGoods = params.getRefundGoods();
        if (CollectionUtils.isEmpty(refundGoods)) {
            throw new OrderException("售后入参退款商品为空");
        }
        List<AfterSalesOrderItemEntity> list = new ArrayList<>();
        refundGoods.stream().forEach(req -> {
            AfterSalesOrderItemEntity entity = new AfterSalesOrderItemEntity();
            //判断退货商品是否在原订单中
            //获取订单下的商品明细
            List<OrderGoodsItemDTO> orderGoodsItem = orderService.getOrderGoodsItem(params.getOrderCode());
            if (CollectionUtils.isEmpty(orderGoodsItem)) {
                throw new OrderException("原订单商品明细查询异常！订单code："+params.getOrderCode());
            }
            List<String> goodsCodes = orderGoodsItem.stream().map(OrderGoodsItemDTO::getGoodsCode).collect(Collectors.toList());
            if (!goodsCodes.contains(req.getGoodsCode())) {
                throw new OrderException("原订单商品明细中无该退款商品：商品code：" + req.getGoodsCode());
            }

            for (OrderGoodsItemDTO dto : orderGoodsItem) {
                if (dto.getGoodsCode().equals(req.getGoodsCode())){
                    entity.setBuyNum(dto.getBuyNum());
                    entity.setOriginalPrice(dto.getOriginalPrice());
                    entity.setNowPrice(dto.getNowPrice());
                    entity.setBuyTime(DateUtil.parse(dto.getBuyTime()));
                    entity.setRefundTime(new Date());
                }
            }

            BeanUtils.copyProperties(req, entity);

            entity.setAfterSalesCode(params.getAfterSalesCode());
            entity.setOrderCode(params.getOrderCode());


            GoodsDTO goods = goodsFacade.getGoods(req.getGoodsCode());
            BeanUtils.copyProperties(goods, entity);
            entity.setGoodsName(goods.getProductName());

            //5级类目
            CategoryEntity categoryEntity = new CategoryEntity();
            BeanUtils.copyProperties(goods, categoryEntity);

            //5级组织结构(为了统计小柜组销量所以冗余)
            DepartmentEntity departmentEntity = new DepartmentEntity();
            BeanUtils.copyProperties(goods, departmentEntity);

            entity.setCategoryEntity(categoryEntity);
            entity.setDepartment(departmentEntity);

            list.add(entity);
        });
        return list;
    }

    private AfterSalesOrderEntity buildAfterSalesOrderEntity(ApplyRefundReqParams params) {
        AfterSalesOrderEntity entity = new AfterSalesOrderEntity();
        BeanUtils.copyProperties(params, entity);

        //待退款
        entity.setAfterSalesOrderStatus(AfterSalesOrderStatus.WAIT_REFUND);
        entity.setApplyTime(params.getApplyTime() == null ? new Date() : params.getApplyTime());

        BuyerEntity buyerEntity = new BuyerEntity();
        BeanUtils.copyProperties(params.getBuyer(), buyerEntity);
        entity.setBuyer(buyerEntity);

        DepartmentEntity departmentEntity = new DepartmentEntity();
        BeanUtils.copyProperties(params.getLoginParams(), departmentEntity);
        entity.setDepartment(departmentEntity);

        //退货
        entity.setAfterSalesType(AfterSalesTypeEnum.RETURN_GOODS);
        //部分退货（全部退货也是部分退货的一种）
        entity.setRefundType(RefundTypeEnum.PART);
        //线下订单
        entity.setOrderType(SalesTypeEnum.OUTLINE);
        return entity;
    }
}
