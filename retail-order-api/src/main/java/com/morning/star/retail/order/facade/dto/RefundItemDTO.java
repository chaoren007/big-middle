package com.morning.star.retail.order.facade.dto;

import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.math.BigDecimal;

/**
 * 退货商品明细
 *
 * @author jiangyf
 * @date 2017/12/28
 */
public class RefundItemDTO implements Serializable {
    private static final long serialVersionUID = -1201214968270265879L;

    /**
     * 货品编码
     */
    @NotNull(message = "货品编码不能为空")
    private String goodsCode;
    /**
     * 退货数量
     */
    @NotNull(message = "退货数量不能为空")
    private BigDecimal refundNum;
    
    private BigDecimal refundAmount;

    public String getGoodsCode() {
        return goodsCode;
    }

    public void setGoodsCode(String goodsCode) {
        this.goodsCode = goodsCode;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public BigDecimal getRefundNum() {
        return refundNum;
    }

    public void setRefundNum(BigDecimal refundNum) {
        this.refundNum = refundNum;
    }

    public BigDecimal getRefundAmount() {
        return refundAmount;
    }

    public void setRefundAmount(BigDecimal refundAmount) {
        this.refundAmount = refundAmount;
    }

}
