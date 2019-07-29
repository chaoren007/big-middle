package com.morning.star.retail.order.facade;

import java.util.List;
import java.util.Map;

import com.morning.star.retail.order.facade.dto.HomeSearchDTO;
import com.morning.star.retail.order.facade.dto.OfflineOrderPayFormDTO;
import com.morning.star.retail.order.facade.dto.OfflineOrderPayResultDTO;
import com.morning.star.retail.order.facade.dto.PosOrderPayResultDTO;
import com.morning.star.retail.order.facade.order.req.OrderReqParams;
import com.morning.star.retail.order.facade.dto.SalesDTO;
import com.morning.star.retail.order.facade.dto.SalesItemSummaryDTO;
import com.morning.star.retail.order.facade.dto.SalesOrderDTO;
import com.morning.star.retail.order.facade.order.req.OrderListReqParams;
import com.morning.star.retail.utils.page.PageBean;

/**
 * POS端的订单远程服务接口
 *
 * @author Administrator
 */
public interface OrderServiceFacadeForPos {


    /**
     * POS提交线下订单
     *
     * @param form
     * @return
     */
    String submitPosOrder(OrderReqParams form);


    /**
     * 插入POS线下订单列表
     *
     * @param forms
     * @return 插入失败的订单列表
     */
    void syncPosOrder(List<OrderReqParams> forms);

    /**
     * 查询POS订单
     *
     * @param search
     * @return
     */
    PageBean<SalesOrderDTO> querySalesOrderForPos(OrderListReqParams search);


    /**
     * 获取订单详情
     *
     * @param orderCode
     * @return
     */
    SalesOrderDTO getSalesOrderDetail(String orderCode);


    /**
     * 确认取消订单
     *
     * @param orderCode
     */
    void agreeCancelSalesOrder(String orderCode);


    /**
     * 查询销售情况
     *
     * @param search
     * @return
     */
    SalesDTO querySales(OrderListReqParams search);

    /**
     * 取订单详情
     *
     * @return
     */
    SalesOrderDTO getSalesOrder(String orderCode);


    /**
     * 批量查询线下订单的支付状态
     *
     * @param orderCodes
     * @return
     */
    List<Map<String, Object>> queryBatchOrderPayStatus(List<String> orderCodes);

    /**
     * 线下订单扫码支付    （商户扫支付宝微信支付码）
     *
     * @param dto
     * @return
     */
    OfflineOrderPayResultDTO offlinePayForOrder(OfflineOrderPayFormDTO dto);


    /**
     * 查询聚合支付的结果
     *
     * @param orderCode
     * @return
     */
    PosOrderPayResultDTO getOfflineScanPayResult(String orderCode);

    /**
     * 统计商品销量
     *
     * @param search
     * @return
     */
    PageBean<SalesItemSummaryDTO> countSaleItems(HomeSearchDTO search);


}
