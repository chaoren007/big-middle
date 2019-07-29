package com.morning.star.retail.order.domain;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import com.morning.star.retail.order.facade.dto.AfterSalesItemDTO;

/**
 * 售后订单
 * Created by liangguobin on 2017/5/18.
 */
public class AfterSalesOrderDO {
    private long id;
    
    private Integer status;
    private String storeName;
    private String storeCode;
    private String code;
    private String orderCode;
    private Date applyTime;   					// 申请时间
    private String groupCode;
    private String groupName;
    private String companyCode;
    private String companyName;
    
    private String buyerCode;
    private String buyerName;
    private String buyerPhone;
    
    
    

    private BigDecimal orderAmount = BigDecimal.ZERO; 			// 订单商品总金额
    private BigDecimal orderPaymentAmount = BigDecimal.ZERO;  	// 订单第三方支付金额
    private Integer orderPayChannel;			//订单的第三方支付渠道
    private BigDecimal orderPrepayCardAmount = BigDecimal.ZERO;	// 订单的预付卡金额
    private BigDecimal orderDiscountAmount = BigDecimal.ZERO;		// 订单的优惠金额

    private BigDecimal normalRefundAmount = BigDecimal.ZERO;      // 正常情况下退款金额    系统计算
    private BigDecimal normalPrepayAmount = BigDecimal.ZERO;      // 正常情况下的预付卡的售后退还金额    系统计算
    private BigDecimal refundAmount = BigDecimal.ZERO;			// 第三方支付售后金额
    private BigDecimal prepayCardAmount = BigDecimal.ZERO;		//预付卡的售后退还金额
    private Integer refundNum;

    private Integer afterSalesType; 				// 售后类型 1-退货 2-换货
    private String refundReason;
    private Integer refundType; 					// 退货类别 1-全部退货  2-部分退货 3-拒收
    
    
    private String deliveryPhone;   			// 收货人手机
    private String deliveryReceiver;    		// 收货人
    /**
     * 订单类型 0线上 1线下
     */
    private Integer type;
    /**
     * 退货商品项
     */
    private List<AfterSalesItemDTO> refundItems;
    
    
    
	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public Integer getOrderPayChannel() {
		return orderPayChannel;
	}

	public void setOrderPayChannel(Integer orderPayChannel) {
		this.orderPayChannel = orderPayChannel;
	}

	public BigDecimal getOrderPrepayCardAmount() {
		return orderPrepayCardAmount;
	}

	public void setOrderPrepayCardAmount(BigDecimal orderPrepayCardAmount) {
		this.orderPrepayCardAmount = orderPrepayCardAmount;
	}

	public BigDecimal getOrderDiscountAmount() {
		return orderDiscountAmount;
	}

	public void setOrderDiscountAmount(BigDecimal orderDiscountAmount) {
		this.orderDiscountAmount = orderDiscountAmount;
	}

	public BigDecimal getPrepayCardAmount() {
		return prepayCardAmount;
	}

	public void setPrepayCardAmount(BigDecimal prepayCardAmount) {
		this.prepayCardAmount = prepayCardAmount;
	}

	public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    
    
    
    
    public String getBuyerName() {
		return buyerName;
	}

	public void setBuyerName(String buyerName) {
		this.buyerName = buyerName;
	}

	public String getBuyerPhone() {
		return buyerPhone;
	}

	public void setBuyerPhone(String buyerPhone) {
		this.buyerPhone = buyerPhone;
	}

	public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getOrderCode() {
        return orderCode;
    }

    public void setOrderCode(String orderCode) {
        this.orderCode = orderCode;
    }

    public String getStoreName() {
        return storeName;
    }

    public void setStoreName(String storeName) {
        this.storeName = storeName;
    }

    public String getStoreCode() {
        return storeCode;
    }

    public void setStoreCode(String storeCode) {
        this.storeCode = storeCode;
    }


    public BigDecimal getOrderAmount() {
        return orderAmount;
    }

    public void setOrderAmount(BigDecimal orderAmount) {
        this.orderAmount = orderAmount;
    }

    public BigDecimal getRefundAmount() {
        return refundAmount;
    }

    public void setRefundAmount(BigDecimal refundAmount) {
        this.refundAmount = refundAmount;
    }

    public String getRefundReason() {
        return refundReason;
    }

    public void setRefundReason(String refundReason) {
        this.refundReason = refundReason;
    }



    public Date getApplyTime() {
        return applyTime;
    }

    public void setApplyTime(Date applyTime) {
        this.applyTime = applyTime;
    }

    public String getDeliveryPhone() {
        return deliveryPhone;
    }

    public void setDeliveryPhone(String deliveryPhone) {
        this.deliveryPhone = deliveryPhone;
    }

    public String getDeliveryReceiver() {
        return deliveryReceiver;
    }

    public void setDeliveryReceiver(String deliveryReceiver) {
        this.deliveryReceiver = deliveryReceiver;
    }


    public BigDecimal getOrderPaymentAmount() {
        return orderPaymentAmount;
    }

    public void setOrderPaymentAmount(BigDecimal orderPaymentAmount) {
        this.orderPaymentAmount = orderPaymentAmount;
    }


    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getRefundNum() {
        return refundNum;
    }

    public void setRefundNum(Integer refundNum) {
        this.refundNum = refundNum;
    }

    public Integer getAfterSalesType() {
        return afterSalesType;
    }

    public void setAfterSalesType(Integer afterSalesType) {
        this.afterSalesType = afterSalesType;
    }

    public Integer getRefundType() {
        return refundType;
    }

    public void setRefundType(Integer refundType) {
        this.refundType = refundType;
    }

    public String getBuyerCode() {
        return buyerCode;
    }

    public void setBuyerCode(String buyerCode) {
        this.buyerCode = buyerCode;
    }

    public String getGroupCode() {
        return groupCode;
    }

    public void setGroupCode(String groupCode) {
        this.groupCode = groupCode;
    }

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    public String getCompanyCode() {
        return companyCode;
    }

    public void setCompanyCode(String companyCode) {
        this.companyCode = companyCode;
    }

    public BigDecimal getNormalRefundAmount() {
        return normalRefundAmount;
    }

    public void setNormalRefundAmount(BigDecimal normalRefundAmount) {
        this.normalRefundAmount = normalRefundAmount;
    }

    public BigDecimal getNormalPrepayAmount() {
        return normalPrepayAmount;
    }

    public void setNormalPrepayAmount(BigDecimal normalPrepayAmount) {
        this.normalPrepayAmount = normalPrepayAmount;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public List<AfterSalesItemDTO> getRefundItems() {
        return refundItems;
    }

    public void setRefundItems(List<AfterSalesItemDTO> refundItems) {
        this.refundItems = refundItems;
    }
}
