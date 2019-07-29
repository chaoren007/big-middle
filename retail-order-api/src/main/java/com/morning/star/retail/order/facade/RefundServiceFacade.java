package com.morning.star.retail.order.facade;

import java.util.List;

import com.morning.star.retail.order.enums.RefundPayStatus;
import com.morning.star.retail.order.facade.dto.ApplyRefundDTO;
import com.morning.star.retail.order.facade.dto.ConfirmRefundDTO;
import com.morning.star.retail.order.facade.dto.RefundDTO;
import com.morning.star.retail.order.facade.dto.RefundPayTrackDTO;
import com.morning.star.retail.order.facade.dto.RefundSearchDTO;
import com.morning.star.retail.utils.page.PageBean;

/**
 * 退款门面类.
 * @author Tim
 *
 */
public interface RefundServiceFacade {
    

    /**
     * 申请退款
     * @param dto
     */
    void applyRefund(ApplyRefundDTO dto);

    /**
     * 查询退款列表
     * @param search
     * @return
     */
    PageBean<RefundDTO> queryRefund(RefundSearchDTO search);
    
    /**
     * 进行退款
     * @param code
     * @param form
     */
    RefundPayStatus refund(String code, ConfirmRefundDTO form);
    
    /**
     * 获取售后退款
     * @param afterSalesCode
     * @return
     */
    RefundDTO getAfterSalesRefund(String afterSalesCode);

    /**
     * 获取取消退款
     * @param orderCode
     * @return
     */
    RefundDTO getCancelRefund(String orderCode);

    void updateRefundResult(String requestNo);

    PageBean<String> queryPayRequestNo(RefundSearchDTO searchDTO);

    /**
     * 查询退款
     * @param code
     * @return
     */
    RefundDTO getRefund(String code);

    /**
     * 查询退款记录
     * @param code
     * @return
     */
    List<RefundPayTrackDTO> listTrack(String code);
}
