package com.morning.star.retail.order.facade.dto;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

public class RefundSearchDTO implements Serializable {

    private static final long serialVersionUID = 1L;
    
    private Integer status;			
    private String code;							//退款单编号
    private String orderCode;						//关联订单号
    private String afterSalesCode;					//售后订单号
    private Integer type;			
    private String operatorName;					//操作人名字
    private Date createRefundStartTime;				//订单创建时间段的起始时间
    private Date createRefundEndTime;				//订单创建时间段的终止时间
    private Date startTime;
    private Date endTime;
    private String groupCode;
    private String companyCode;

    /** 页码 */
    private int pageNo;
    /** 每页记录数 */
    private int pageSize;
    private Date startModifyTime;
    private Date endModifyTime;
    
    private String refundWaterCode;		//退款流水
    
    private String storeCode;
    private String storeName;
    
    private Integer payChannel;
    
    private Date RefundStartTime;				//订单退款起始时间
    private Date RefundEndTime;				//订单退款终止时间
    private List<Integer> statuses ;    // 状态范围查询
    private String receiverPhone; //收货人手机号
    private String buyerPhone;//购买人手机号
    
    public RefundSearchDTO() {
    }
    
    public int getPageNo() {
        return pageNo;
    }

    public void setPageNo(int pageNo) {
        this.pageNo = pageNo;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public Integer getStatus() {
        return status;
    }
    public Integer getType() {
        return type;
    }
    public Date getStartTime() {
        return startTime;
    }
    public Date getEndTime() {
        return endTime;
    }
    public Date getStartModifyTime() {
        return startModifyTime;
    }

    public void setStartModifyTime(Date startModifyTime) {
        this.startModifyTime = startModifyTime;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    public String getGroupCode() {
        return groupCode;
    }

    public void setGroupCode(String groupCode) {
        this.groupCode = groupCode;
    }

    public String getCompanyCode() {
        return companyCode;
    }

    public void setCompanyCode(String companyCode) {
        this.companyCode = companyCode;
    }

    public static long getSerialversionuid() {
        return serialVersionUID;
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


	public String getAfterSalesCode() {
		return afterSalesCode;
	}

	public void setAfterSalesCode(String afterSalesCode) {
		this.afterSalesCode = afterSalesCode;
	}



	public String getOperatorName() {
		return operatorName;
	}

	public void setOperatorName(String operatorName) {
		this.operatorName = operatorName;
	}

	public Date getCreateRefundStartTime() {
		return createRefundStartTime;
	}

	public void setCreateRefundStartTime(Date createRefundStartTime) {
		this.createRefundStartTime = createRefundStartTime;
	}

	public Date getCreateRefundEndTime() {
		return createRefundEndTime;
	}

	public void setCreateRefundEndTime(Date createRefundEndTime) {
		this.createRefundEndTime = createRefundEndTime;
	}

	public String getRefundWaterCode() {
		return refundWaterCode;
	}

	public void setRefundWaterCode(String refundWaterCode) {
		this.refundWaterCode = refundWaterCode;
	}

    public String getStoreCode() {
        return storeCode;
    }

    public void setStoreCode(String storeCode) {
        this.storeCode = storeCode;
    }

    public String getStoreName() {
        return storeName;
    }

    public void setStoreName(String storeName) {
        this.storeName = storeName;
    }

    public Integer getPayChannel() {
        return payChannel;
    }

    public void setPayChannel(Integer payChannel) {
        this.payChannel = payChannel;
    }
	
	public Date getRefundStartTime() {
		return RefundStartTime;
	}

	public void setRefundStartTime(Date refundStartTime) {
		RefundStartTime = refundStartTime;
	}

	public Date getRefundEndTime() {
		return RefundEndTime;
	}

	public void setRefundEndTime(Date refundEndTime) {
		RefundEndTime = refundEndTime;
	}

    public List<Integer> getStatuses() {
        return statuses;
    }

    public void setStatuses(List<Integer> statuses) {
        this.statuses = statuses;
    }

    public Date getEndModifyTime() {
        return endModifyTime;
    }

    public void setEndModifyTime(Date endModifyTime) {
        this.endModifyTime = endModifyTime;
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
