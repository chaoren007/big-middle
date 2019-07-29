package com.morning.star.retail.order.facade.dto;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

public class DeliveryDTO implements Serializable {

    private static final long serialVersionUID = 1L;
    
    @Min(0) @Max(0) private Integer type;   //配送方式 1快递 2自提
    private Date deliveryStartTime;		//订单配送时间段起始时间
    private Date deliveryEndTime;		//订单配送时间段结束时间
    private String typeDesc;
    private BigDecimal fee;
    private String receiver;
    private String phone;
    private String address;
    private Coordinate pos;
    
    public DeliveryDTO() {
        this(0, null, null, null, null, null, null, null);
    }
    
    public DeliveryDTO(Integer type, String typeDesc, BigDecimal fee, 
    		String receiver, String phone, String address, 
    	    Date deliveryStartTime, Date deliveryEndTime) {
        this.type = type;
        this.fee = fee;
        this.receiver = receiver;
        this.phone = phone;
        this.address = address;
        this.typeDesc = typeDesc;
        this.deliveryStartTime = deliveryStartTime;
        this.deliveryEndTime = deliveryEndTime;
    }
    
    
    
    public DeliveryDTO(Coordinate pos) {
		this.pos = pos;
	}

	public void setType(Integer type) {
		this.type = type;
	}

	public void setFee(BigDecimal fee) {
		this.fee = fee;
	}

	public void setReceiver(String receiver) {
		this.receiver = receiver;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public void setPos(Coordinate pos) {
		this.pos = pos;
	}




	public Date getDeliveryStartTime() {
		return deliveryStartTime;
	}

	public void setDeliveryStartTime(Date deliveryStartTime) {
		this.deliveryStartTime = deliveryStartTime;
	}

	public Date getDeliveryEndTime() {
		return deliveryEndTime;
	}

	public void setDeliveryEndTime(Date deliveryEndTime) {
		this.deliveryEndTime = deliveryEndTime;
	}

	public Integer getType() {
        return type;
    }
    public BigDecimal getFee() {
        return fee;
    }
    public String getReceiver() {
        return receiver;
    }
    public String getPhone() {
        return phone;
    }
    public String getAddress() {
        return address;
    }

    public String getTypeDesc() {
        return typeDesc;
    }

    public Coordinate getPos() {
        return pos;
    }

    public void setTypeDesc(String typeDesc) {
        this.typeDesc = typeDesc;
    }


    
}
