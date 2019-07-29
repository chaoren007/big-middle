package com.morning.star.retail.order.domain.entity;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import com.morning.star.retail.order.enums.RefundPayStatus;

/**
 * RefundEntity Domain.
 * 
 * @author Tim
 *
 */
@Entity
@Table(name = "retail_refund")
public class RefundEntity extends BaseEntity {

    /**
     * 
     */
    private static final long serialVersionUID = 1L;
    
    @Id
    @Column(length = 64)
    private String refundCode;
    private int status;
    private int type;
    private String orderCode;
    private String afterSalesCode;
    private BigDecimal amount;
    private String remark;
    private Integer channel;
    private Integer payChannel;
    private String refundInfo;
    private Date refundTime;
    private String refundWaterCode;
    
    private BigDecimal prepayCardAmount = BigDecimal.ZERO;	//预付卡金额
    @Embedded
    private StoreInfo store;
    private Integer way;
    private Integer amountRefundStatus;
    private Integer prepayRefundStatus;
    private String prepayRefundWater;
    private String prepayRefundInfo;

    private String receiverPhone;	//收货人手机号
    private String buyerPhone;		//购买人手机号
    private String payRequestNo;    //退款支付requestNo
    
    
    
    
    public String getBuyerPhone() {
		return buyerPhone;
	}

	public void setBuyerPhone(String buyerPhone) {
		this.buyerPhone = buyerPhone;
	}

	public String getReceiverPhone() {
		return receiverPhone;
	}

	public void setReceiverPhone(String receiverPhone) {
		this.receiverPhone = receiverPhone;
	}

	public BigDecimal getPrepayCardAmount() {
		return prepayCardAmount;
	}

	public void setPrepayCardAmount(BigDecimal prepayCardAmount) {
		this.prepayCardAmount = prepayCardAmount;
	}

	public RefundEntity() {
    }
    
    public RefundEntity(String refundCode, int type, String orderCode, String afterSalesCode, BigDecimal amount, String remark, BigDecimal prepayCardAmount) {
        this.refundCode = refundCode;
        this.type = type;
        this.status = RefundPayStatus.WAIT_REFUND.getCode();
        this.orderCode = orderCode;
        this.afterSalesCode = afterSalesCode;
        this.amount = amount;
        this.prepayCardAmount = prepayCardAmount;
        this.remark = remark;
        this.channel = null;
        this.refundInfo = null;
    }


    public String getOrderCode() {
        return orderCode;
    }
    public BigDecimal getAmount() {
        return amount;
    }

    public String getRemark() {
        return remark;
    }

    public int getStatus() {
        return status;
    }

    public Integer getChannel() {
        return channel;
    }

    public String getRefundInfo() {
        return refundInfo;
    }

    public int getType() {
        return type;
    }

    public String getAfterSalesCode() {
        return afterSalesCode;
    }

    public String getRefundCode() {
        return refundCode;
    }

    public void setRefundCode(String refundCode) {
        this.refundCode = refundCode;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public void setType(int type) {
        this.type = type;
    }

    public void setOrderCode(String orderCode) {
        this.orderCode = orderCode;
    }

    public void setAfterSalesCode(String afterSalesCode) {
        this.afterSalesCode = afterSalesCode;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public void setChannel(Integer channel) {
        this.channel = channel;
    }

    public void setRefundInfo(String refundInfo) {
        this.refundInfo = refundInfo;
    }

    public Date getRefundTime() {
        return refundTime;
    }

    public void setRefundTime(Date refundTime) {
        this.refundTime = refundTime;
    }

	public String getRefundWaterCode() {
		return refundWaterCode;
	}

	public void setRefundWaterCode(String refundWaterCode) {
		this.refundWaterCode = refundWaterCode;
	}

    public StoreInfo getStore() {
        return store;
    }

    public void setStore(StoreInfo store) {
        this.store = store;
    }

    public Integer getPayChannel() {
        return payChannel;
    }

    public void setPayChannel(Integer payChannel) {
        this.payChannel = payChannel;
    }

    public Integer getWay() {
        return way;
    }

    public void setWay(Integer way) {
        this.way = way;
    }


    public Integer getAmountRefundStatus() {
        return amountRefundStatus;
    }

    public void setAmountRefundStatus(Integer amountRefundStatus) {
        this.amountRefundStatus = amountRefundStatus;
    }

    public Integer getPrepayRefundStatus() {
        return prepayRefundStatus;
    }

    public void setPrepayRefundStatus(Integer prepayRefundStatus) {
        this.prepayRefundStatus = prepayRefundStatus;
    }

    public String getPrepayRefundWater() {
        return prepayRefundWater;
    }

    public void setPrepayRefundWater(String prepayRefundWater) {
        this.prepayRefundWater = prepayRefundWater;
    }

    public String getPrepayRefundInfo() {
        return prepayRefundInfo;
    }

    public void setPrepayRefundInfo(String prepayRefundInfo) {
        this.prepayRefundInfo = prepayRefundInfo;
    }

    public String getPayRequestNo() {
        return payRequestNo;
    }

    public void setPayRequestNo(String payRequestNo) {
        this.payRequestNo = payRequestNo;
    }
}
