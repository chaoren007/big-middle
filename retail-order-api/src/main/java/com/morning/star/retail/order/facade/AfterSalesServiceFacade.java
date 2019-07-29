package com.morning.star.retail.order.facade;

import com.morning.star.retail.order.facade.dto.QueryWaitExamineOrderDTO;
import com.morning.star.retail.order.facade.dto.*;
import com.morning.star.retail.order.qo.AfterSalesRecentlyOrderQO;
import com.morning.star.retail.order.qo.ExamineGoodsQO;
import com.morning.star.retail.utils.page.PageBean;

import java.util.List;

/**
 * Created by liangguobin on 2017/5/18.
 */
public interface AfterSalesServiceFacade {

    /**
     * 审核售后订单
     *
     * @param afterSalesCode
     * @param agree          0不通过 1通过
     * @param auditComment
     */
    void auditOrder(String afterSalesCode, int agree, String auditComment);

    /**
     * 售后验货
     */
    void examineGoods(ExamineGoodsQO qo);

    /**
     * 查询详情
     *
     * @param afterSalesCode
     * @return
     */
    AfterSalesOrderDTO getDetail(String afterSalesCode);

    /**
     * 售后订单列表 不包括轨迹和退货货品
     *
     * @param search
     * @return
     */
    PageBean<AfterSalesOrderDTO> listAfterSalesOrders(AfterSalesOrderDTO search);

    /**
     * 待验货的售后订单，用于pos,包括退货货品
     */
    PageBean<AfterSalesOrderDTO> listWaitExamineOrder(QueryWaitExamineOrderDTO pageQO);

    /**
     * 申请全部退货
     * @param orderCode
     * @param reason
     */
    //void applyAllRefund(String orderCode, String reason);

    /**
     * 申请部分退货
     * @param orderCode
     * @param reason
     * @param refundItems
     */
    //void applyPortionRefund(String orderCode, String reason, List<AfterSalesItemQO> refundItems);

    /**
     * 查询用户所有的售后
     * @param pageNo
     * @param pageSize
     * @param buyerCode
     * @return
     */
    //PageBean<AfterSalesOrderDTO> listUserOrders(int pageNo, int pageSize, String buyerCode);

    /**
     * 完成退款操作
     *
     * @param refundDTO 退款信息
     */
    void finishRefund(FinishRefundDTO refundDTO);

    /**
     * 查询最近操作的售后订单
     *
     * @return
     */
    PageBean<AfterSalesOrderDTO> listRecentlyOrder(AfterSalesRecentlyOrderQO qo);

    /**
     * 查询退货商品
     *
     * @param afterOrderCode
     * @return
     */
    List<AfterSalesItemDTO> listRefundItems(String afterOrderCode);

    /**
     * 退货订单信息
     *
     * @param orderCode
     * @return
     */
    RefundOrderDTO refundOrderInfo(String orderCode);

    /**
     * 部分退货接口
     *
     * @param formDTO
     * @return
     */
    void portionRefund(RefundOrderFormDTO formDTO);



}
