package com.morning.star.retail.admin.order.vo;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.Map;

import com.morning.star.retail.order.facade.dto.AfterSalesItemDTO;
import com.morning.star.retail.order.facade.dto.AfterSalesTrackDTO;
import com.morning.star.retail.order.facade.dto.StoreDTO;

/**
 * Created by liangguobin on 2017/5/21.
 */
public class AfterSalesOrderVO {

    private long id;
    
    private Integer status;
    private String storeName;
    private String storeCode;
    private String code;
    private String orderCode;
    private Date applyTime;   // 申请时间

    private BigDecimal orderAmount;				//订单商品总金额
    private BigDecimal orderPaymentAmount;		//订单第三方支付金额
    private Integer orderPayChannel;			//订单第三方支付渠道
    private String OrderPayChannelDesc;			//订单第三方支付描述
    private BigDecimal orderPrepayCardAmount = BigDecimal.ZERO;	// 订单的预付卡金额
    private BigDecimal orderDiscountAmount = BigDecimal.ZERO;		// 订单的优惠金额

    private BigDecimal normalRefundAmount = BigDecimal.ZERO;      // 系统第三方退款金额
    private BigDecimal normalPrepayAmount = BigDecimal.ZERO;      // 正常情况下的预付卡的售后退还金额    系统计算
    private BigDecimal refundAmount = BigDecimal.ZERO;    // 实际第三方退款金额


    private BigDecimal prepayCardAmount = BigDecimal.ZERO;	//售后订单的预付卡金额

    private String refundReason;
    
    private String statusName;
    private String deliveryPhone;   // 收货人手机
    private String deliveryReceiver;    // 收货人

    List<AfterSalesItemDTO> refundItems;
    private Integer refundType; // 退货类别 1-全部退货  2-部分退货 3-拒收
    private String refundTypeDesc;
    private Integer afterSalesType; // 售后类型 1：退货 2：换货
    private String afterSalesTypeDesc;


    List<AfterSalesTrackDTO> tracks;

    // StoreDTO/SalesOrderDTO 是为了兼容前api
    private StoreDTO store;
    private Map<String, Object> order;
    private BigDecimal totalRefundAmount;   // 总退款金额
    private BigDecimal totalNormalRefundAmount;

    


	public Integer getOrderPayChannel() {
		return orderPayChannel;
	}

	public void setOrderPayChannel(Integer orderPayChannel) {
		this.orderPayChannel = orderPayChannel;
	}

	public String getOrderPayChannelDesc() {
		return OrderPayChannelDesc;
	}

	public void setOrderPayChannelDesc(String orderPayChannelDesc) {
		OrderPayChannelDesc = orderPayChannelDesc;
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

	private String buyerCode;
    private String buyerName;
    private String buyerPhone;
  
    
    
    

	public BigDecimal getPrepayCardAmount() {
		return prepayCardAmount;
	}

	public void setPrepayCardAmount(BigDecimal prepayCardAmount) {
		this.prepayCardAmount = prepayCardAmount;
	}
    
    
	public String getBuyerCode() {
		return buyerCode;
	}

	public void setBuyerCode(String buyerCode) {
		this.buyerCode = buyerCode;
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

	public StoreDTO getStore() {
        return store;
    }

    public void setStore(StoreDTO store) {
        this.store = store;
    }


    public Map<String, Object> getOrder() {
        return order;
    }

    public void setOrder(Map<String, Object> order) {
        this.order = order;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
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

    public BigDecimal getOrderPaymentAmount() {
        return orderPaymentAmount;
    }

    public void setOrderPaymentAmount(BigDecimal orderPaymentAmount) {
        this.orderPaymentAmount = orderPaymentAmount;
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

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
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

    public List<AfterSalesItemDTO> getRefundItems() {
        return refundItems;
    }

    public void setRefundItems(List<AfterSalesItemDTO> refundItems) {
        this.refundItems = refundItems;
    }

    public List<AfterSalesTrackDTO> getTracks() {
        return tracks;
    }

    public void setTracks(List<AfterSalesTrackDTO> tracks) {
        this.tracks = tracks;
    }

    public String getStatusName() {
        return statusName;
    }

    public void setStatusName(String statusName) {
        this.statusName = statusName;
    }



    public String getRefundTypeDesc() {
        return refundTypeDesc;
    }

    public void setRefundTypeDesc(String refundTypeDesc) {
        this.refundTypeDesc = refundTypeDesc;
    }


    public Integer getRefundType() {
        return refundType;
    }

    public void setRefundType(Integer refundType) {
        this.refundType = refundType;
    }

    public Integer getAfterSalesType() {
        return afterSalesType;
    }

    public void setAfterSalesType(Integer afterSalesType) {
        this.afterSalesType = afterSalesType;
    }

    public String getAfterSalesTypeDesc() {
        return afterSalesTypeDesc;
    }

    public void setAfterSalesTypeDesc(String afterSalesTypeDesc) {
        this.afterSalesTypeDesc = afterSalesTypeDesc;
    }

    public BigDecimal getNormalRefundAmount() {
        return normalRefundAmount;
    }

    public void setNormalRefundAmount(BigDecimal normalRefundAmount) {
        this.normalRefundAmount = normalRefundAmount;
    }


    public BigDecimal getTotalRefundAmount() {
        return totalRefundAmount;
    }

    public void setTotalRefundAmount(BigDecimal totalRefundAmount) {
        this.totalRefundAmount = totalRefundAmount;
    }


    public BigDecimal getTotalNormalRefundAmount() {
        return totalNormalRefundAmount;
    }

    public void setTotalNormalRefundAmount(BigDecimal totalNormalRefundAmount) {
        this.totalNormalRefundAmount = totalNormalRefundAmount;
    }

    public BigDecimal getNormalPrepayAmount() {
        return normalPrepayAmount;
    }

    public void setNormalPrepayAmount(BigDecimal normalPrepayAmount) {
        this.normalPrepayAmount = normalPrepayAmount;
    }
}
