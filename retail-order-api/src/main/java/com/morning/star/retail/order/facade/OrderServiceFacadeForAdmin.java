package com.morning.star.retail.order.facade;

import com.morning.star.retail.order.facade.dto.HomeSearchDTO;
import com.morning.star.retail.order.facade.dto.ItemStatisticsInfo;
import com.morning.star.retail.order.facade.dto.SalesDaySummaryDTO;
import com.morning.star.retail.order.facade.dto.SalesItemSummaryDTO;
import com.morning.star.retail.order.facade.order.req.OrderListReqParams;
import com.morning.star.retail.order.facade.order.resp.SalesOrderVO;
import com.morning.star.retail.utils.page.PageBean;

/**
 * 管理端端的订单远程服务接口
 * @author Administrator
 *
 */
public interface OrderServiceFacadeForAdmin {

    /**
     * 获取订单详情
     * @return
     */
    SalesOrderVO getSalesOrder(String orderCode);
    
    /**
     * 获取订单列表
     * @param search
     * @return
     */
    PageBean<SalesOrderVO> querySalesOrder(OrderListReqParams search);

    /**
     * 统计商品销量
     * @param searchDTO
     * @return
     */
    PageBean<SalesItemSummaryDTO> countSaleItems(HomeSearchDTO searchDTO);

    /**
     * 统计分类销量
     * @param searchDTO
     * @return
     */
    PageBean<SalesItemSummaryDTO> countItemCategory(HomeSearchDTO searchDTO);

    /**
     * 统计每日销量
     * @param searchDTO
     * @return
     */
    SalesDaySummaryDTO salesDaySummary(HomeSearchDTO searchDTO);

    /**
     * 统计商品总数
     * @param searchDTO
     * @return
     */
    ItemStatisticsInfo saleItemsSummary(HomeSearchDTO searchDTO);

}
