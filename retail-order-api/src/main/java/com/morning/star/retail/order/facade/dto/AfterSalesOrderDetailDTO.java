package com.morning.star.retail.order.facade.dto;

import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

/**
 * Created by liangguobin on 2017/5/18.
 */
public class AfterSalesOrderDetailDTO implements Serializable{

	private static final long serialVersionUID = -5859775385672290615L;

    @ApiModelProperty(value = "售后单编码")
    private String afterSalesOrderCode;

    @ApiModelProperty(value = "状态")
	private Integer status;

    @ApiModelProperty(value = "门店名称")
	private String storeName;

    @ApiModelProperty(value = "门店编码")
	private String storeCode;

    @ApiModelProperty(value = "订单编码")
    private String orderCode;

    @ApiModelProperty(value = "申请时间")
    private Date applyTime;
    @ApiModelProperty(value = "申请结束时间")
    private Date endApplyTime;
    @ApiModelProperty(value = "集团编码")
    private String groupCode;
//    private String companyCode;
    private Integer pageNo = 1;
    private Integer pageSize = 20;

    @ApiModelProperty(value = "订单商品总金额")
    private BigDecimal orderAmount = BigDecimal.ZERO;
    @ApiModelProperty(value = "订单第三方支付总金额")
    private BigDecimal orderPaymentAmount  = BigDecimal.ZERO;

    @ApiModelProperty(value = "订单的第三方支付渠道")
    private Integer orderPayChannel;
    @ApiModelProperty(value = "订单预付卡金额")
    private BigDecimal orderPrepayCardAmount = BigDecimal.ZERO;
    @ApiModelProperty(value = "订单商品总金额")
    private BigDecimal orderDiscountAmount = BigDecimal.ZERO;
    @ApiModelProperty(value = "第三方售后金额")
    private BigDecimal refundAmount  = BigDecimal.ZERO;
    @ApiModelProperty(value = "售后订单的预付卡金额")
    private BigDecimal prepayCardAmount = BigDecimal.ZERO;
    @ApiModelProperty(value = "退货类别 1-全部退货  2-部分退货 3-拒收")
    private Integer refundType;
    @ApiModelProperty(value = "售后类型 1：退货 2：换货")
    private Integer afterSalesType;
    @ApiModelProperty(value = "退货原因")
    private String refundReason;

    @ApiModelProperty(value = "收货人手机")
    private String deliveryPhone;
    @ApiModelProperty(value = "收货人")
    private String deliveryReceiver;
    @ApiModelProperty(value = "退货数量")
    private Integer refundNum;
    @ApiModelProperty(value = "售后细表")
    private List<AfterSalesItemDTO> refundItems;
    @ApiModelProperty(value = "售后轨迹数据")
    private List<AfterSalesTrackDTO> tracks;
    @ApiModelProperty(value = "下单人编码")
    private String buyerCode;
    @ApiModelProperty(value = "下单人名称")
    private String buyerName;
    @ApiModelProperty(value = "下单人联系方式")
    private String buyerPhone;
    @ApiModelProperty(value = "正常情况下退款金额")
    private BigDecimal normalRefundAmount = BigDecimal.ZERO;
    @ApiModelProperty(value = "正常情况下的预付卡的售后退还金额")
    private BigDecimal normalPrepayAmount = BigDecimal.ZERO;
    @ApiModelProperty(value = "订单类型")
    private Integer type;

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

//	public long getId() {
//        return id;
//    }
//
//    public void setId(long id) {
//        this.id = id;
//    }
//
//    public String getCode() {
//        return code;
//    }
//
//    public void setCode(String code) {
//        this.code = code;
//    }

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

    public List<AfterSalesTrackDTO> getTracks() {
        return tracks;
    }

    public void setTracks(List<AfterSalesTrackDTO> tracks) {
        this.tracks = tracks;
    }

    public List<AfterSalesItemDTO> getRefundItems() {
        return refundItems;
    }

    public void setRefundItems(List<AfterSalesItemDTO> refundItems) {
        this.refundItems = refundItems;
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


    public String getGroupCode() {
        return groupCode;
    }

    public void setGroupCode(String groupCode) {
        this.groupCode = groupCode;
    }

    public Integer getRefundNum() {
        return refundNum;
    }

    public void setRefundNum(Integer refundNum) {
        this.refundNum = refundNum;
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

    public Date getEndApplyTime() {
		return endApplyTime;
	}

	public void setEndApplyTime(Date endApplyTime) {
		this.endApplyTime = endApplyTime;
	}

	public Integer getPageNo() {
		return pageNo;
	}

	public void setPageNo(Integer pageNo) {
		this.pageNo = pageNo;
	}

	public Integer getPageSize() {
		return pageSize;
	}

	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
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

    public String getAfterSalesOrderCode() {
        return afterSalesOrderCode;
    }

    public void setAfterSalesOrderCode(String afterSalesOrderCode) {
        this.afterSalesOrderCode = afterSalesOrderCode;
    }
}
