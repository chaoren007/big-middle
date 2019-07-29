package com.morning.star.retail.order.facade.dto;

import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

/**
 * 提交退货信息
 *
 * @author jiangyf
 * @date 2017/12/28
 */
public class RefundOrderFormDTO implements Serializable {

    private static final long serialVersionUID = 9170344888758084532L;

    /**
     * 订单编号
     */
    @NotNull(message = "订单编号不能为空")
    private String orderCode;
    /**
     * 门店编码
     */
    private String storeCode;

    private String storeName;
    /**
     * 退货明细
     */
    @NotNull(message = "退货明细不能为空")
    private List<RefundItemDTO> items;
    /**
     * 退款金额
     */
    @NotNull(message = "退款金额不能为空")
    private BigDecimal refundAmount;
    /**
     * 退款备注
     */
    private String remark = "";

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public String getStoreName() {
        return storeName;
    }

    public void setStoreName(String storeName) {
        this.storeName = storeName;
    }

    public String getOrderCode() {
        return orderCode;
    }

    public void setOrderCode(String orderCode) {
        this.orderCode = orderCode;
    }

    public String getStoreCode() {
        return storeCode;
    }

    public void setStoreCode(String storeCode) {
        this.storeCode = storeCode;
    }

    public List<RefundItemDTO> getItems() {
        return items;
    }

    public void setItems(List<RefundItemDTO> items) {
        this.items = items;
    }

    public BigDecimal getRefundAmount() {
        return refundAmount;
    }

    public void setRefundAmount(BigDecimal refundAmount) {
        this.refundAmount = refundAmount;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

}
