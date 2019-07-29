package com.morning.star.retail.admin.group.order.vo;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import org.springframework.beans.BeanUtils;

import com.morning.star.retail.order.enums.PayChannel;
import com.morning.star.retail.order.facade.dto.RefundDTO;
import com.morning.star.retail.order.facade.dto.StoreDTO;

public class RefundVO {
    private String code;
    private int status;
    private String statusDesc;
    private int type;
    private String orderCode;
    private String afterSalesCode;
    private BigDecimal amount;			//第三方退款金额
    private String remark;
    private Integer channel;
    private String refundInfo;
    private Date createTime;
    private Date modifyTime;
    private Date refundTime;
    private String operatorCode;
    private String operatorName;
    
    private Integer payChannel;
    private String payChannelDesc;
    
    private String refundWaterCode;
    
    private BigDecimal prepayCardAmount = BigDecimal.ZERO;	//预付卡退款金额
    
    private StoreDTO store;
    
    private BigDecimal totalRefundAmount;		//退款总金额

    List<RefundPayTrackVO> tracks;
    List<RefundDetail> details;
    
    private String receiverPhone;
    private String buyerPhone;
    
    private String orderPayWay;		//支付方式，含混合支付
    
    
    
    
    public BigDecimal getTotalRefundAmount() {
		return totalRefundAmount;
	}

	public void setTotalRefundAmount(BigDecimal totalRefundAmount) {
		this.totalRefundAmount = totalRefundAmount;
	}

	public String getOrderPayWay() {
		return orderPayWay;
	}

	public void setOrderPayWay(String orderPayWay) {
		this.orderPayWay = orderPayWay;
	}

	public BigDecimal getPrepayCardAmount() {
		return prepayCardAmount;
	}

	public void setPrepayCardAmount(BigDecimal prepayCardAmount) {
		this.prepayCardAmount = prepayCardAmount;
	}
    
    public static RefundVO fromDTO(RefundDTO dto) {
        if(dto == null) {
            return null;
        }
        RefundVO vo = new RefundVO();
        BeanUtils.copyProperties(dto, vo);
        if(dto.getPayChannel() != null ) {
            vo.setPayChannelDesc(PayChannel.getName(dto.getPayChannel()));
        }
        vo.setOrderPayWay(vo.getOrderPayWay(dto));
        vo.setTotalRefundAmount(
        				(dto.getAmount() == null ? BigDecimal.ZERO : dto.getAmount())
        		);
        return vo;
    }

    
    private String getOrderPayWay(RefundDTO dto){
    	String thirdPay = dto.getPayChannel() == null ? "" : PayChannel.getName(dto.getPayChannel());
    	return thirdPay;
    }
    

    public String getCode() {
        return code;
    }



    public void setCode(String code) {
        this.code = code;
    }



    public int getStatus() {
        return status;
    }



    public void setStatus(int status) {
        this.status = status;
    }



    public int getType() {
        return type;
    }



    public void setType(int type) {
        this.type = type;
    }



    public String getOrderCode() {
        return orderCode;
    }



    public void setOrderCode(String orderCode) {
        this.orderCode = orderCode;
    }



    public String getAfterSalesCode() {
        return afterSalesCode;
    }



    public void setAfterSalesCode(String afterSalesCode) {
        this.afterSalesCode = afterSalesCode;
    }



    public BigDecimal getAmount() {
        return amount;
    }



    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }



    public String getRemark() {
        return remark;
    }



    public void setRemark(String remark) {
        this.remark = remark;
    }



    public Integer getChannel() {
        return channel;
    }



    public void setChannel(Integer channel) {
        this.channel = channel;
    }



    public String getRefundInfo() {
        return refundInfo;
    }



    public void setRefundInfo(String refundInfo) {
        this.refundInfo = refundInfo;
    }



    public Date getCreateTime() {
        return createTime;
    }



    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }



    public Date getModifyTime() {
        return modifyTime;
    }



    public void setModifyTime(Date modifyTime) {
        this.modifyTime = modifyTime;
    }



    public Date getRefundTime() {
        return refundTime;
    }



    public void setRefundTime(Date refundTime) {
        this.refundTime = refundTime;
    }



    public String getOperatorCode() {
        return operatorCode;
    }



    public void setOperatorCode(String operatorCode) {
        this.operatorCode = operatorCode;
    }



    public String getOperatorName() {
        return operatorName;
    }



    public void setOperatorName(String operatorName) {
        this.operatorName = operatorName;
    }

	public String getRefundWaterCode() {
		return refundWaterCode;
	}

	public void setRefundWaterCode(String refundWaterCode) {
		this.refundWaterCode = refundWaterCode;
	}

    public StoreDTO getStore() {
        return store;
    }

    public void setStore(StoreDTO store) {
        this.store = store;
    }

    public Integer getPayChannel() {
        return payChannel;
    }

    public void setPayChannel(Integer payChannel) {
        this.payChannel = payChannel;
    }

    public String getPayChannelDesc() {
        return payChannelDesc;
    }

    public void setPayChannelDesc(String payChannelDesc) {
        this.payChannelDesc = payChannelDesc;
    }

    public String getStatusDesc() {
        return statusDesc;
    }

    public void setStatusDesc(String statusDesc) {
        this.statusDesc = statusDesc;
    }

    public List<RefundPayTrackVO> getTracks() {
        return tracks;
    }

    public void setTracks(List<RefundPayTrackVO> tracks) {
        this.tracks = tracks;
    }

    public List<RefundDetail> getDetails() {
        return details;
    }

    public void setDetails(List<RefundDetail> details) {
        this.details = details;
    }

	public String getReceiverPhone() {
		return receiverPhone;
	}

	public void setReceiverPhone(String receiverPhone) {
		this.receiverPhone = receiverPhone;
	}

	public String getBuyerPhone() {
		return buyerPhone;
	}

	public void setBuyerPhone(String buyerPhone) {
		this.buyerPhone = buyerPhone;
	}
    
    
}
