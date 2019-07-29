package com.morning.star.retail.order.facade;

import com.morning.star.retail.order.facade.dto.PosOrderPayResultDTO;
import com.morning.star.retail.order.facade.dto.SalesOrderDTO;
import com.morning.star.retail.order.facade.order.req.OrderListReqParams;
import com.morning.star.retail.utils.page.PageBean;

/**
 * Facade of OrderService
 * 
 * @author Tim
 *
 */
public interface OrderServiceFacadeForInner {
    
    /**
     * 获取订单列表
     * @return
     */
    PageBean<SalesOrderDTO> querySalesOrder(OrderListReqParams search);
    
    

    
    
    /**
     * 获取订单
     * @param orderCode
     * @return
     */
    SalesOrderDTO getSalesOrder(String orderCode);
    
    


    /**
     * 支付结果回调
     * @param orderCode
     */
    void updatePayResult(String orderCode);




    /**
     * 完成
     * @param orderCode
     * @param remark
     */
    void done(String orderCode, String remark);


    /**
     * 超时取消
     * @param orderCode
     * @param remark
     */
    void timeout(String orderCode, String remark);



    
	/**
	 * 查询聚合支付的结果
	 * @param orderCode
	 * @return
	 */
	public PosOrderPayResultDTO getOfflineScanPayResult(String orderCode);



}