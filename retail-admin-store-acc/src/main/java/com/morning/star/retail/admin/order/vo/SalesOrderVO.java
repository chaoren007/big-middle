package com.morning.star.retail.admin.order.vo;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import com.morning.star.retail.order.enums.SalesOrderStatus;
import com.morning.star.retail.order.facade.dto.DeliveryDTO;
import com.morning.star.retail.order.facade.dto.ExpressDTO;
import com.morning.star.retail.order.facade.dto.SalesOrderDTO;
import com.morning.star.retail.order.facade.dto.SalesOrderWaterDTO;
import com.morning.star.retail.order.facade.dto.StoreDTO;

public class SalesOrderVO {
    
    private int type;
    private String typeDesc;
    private String code;
   
    private String companyCode;
    private String companyName;
    
    private BigDecimal totalPrice;
    private BigDecimal payAmount;			//订单总金额  	totalPrice - discountAmount
    private SalesOrderPaymentVO payment;	//第三方支付
    private BigDecimal discountAmount = BigDecimal.ZERO;      //优惠金额
    private BigDecimal discountSpecial = BigDecimal.ZERO;  //优惠金额
    private BigDecimal prepayCardAmount = BigDecimal.ZERO;	//订单预付卡的金额
    private Date prepayCardTime;					//预付卡支付时间
   
    private int totalBuyNum;
    private int status;
    private Date createTime;
    
    private StoreDTO store;
    private List<SalesOrderItemVO> items;
    
    private String remark;
    private DeliveryDTO delivery;
    private List<SalesOrderWaterDTO> track;
    private ExpressDTO express;
    
    
    private String statusName;
    private BigDecimal totalWeight;
    
    private int canceling;
    private int push;
    
    
    private String orderPayWay;
    
    private String memberNo;		//积分会员卡号
    private String cdnr;			//会员可磁道号
    //促销员编码
    private String sellerCode;
    private String sellerName;
    
	public String getTypeDesc() {
		return typeDesc;
	}
	public void setTypeDesc(String typeDesc) {
		this.typeDesc = typeDesc;
	}
	public String getCdnr() {
		return cdnr;
	}
	public void setCdnr(String cdnr) {
		this.cdnr = cdnr;
	}
	public String getCompanyName() {
		return companyName;
	}
	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}
	public String getCompanyCode() {
		return companyCode;
	}
	public void setCompanyCode(String companyCode) {
		this.companyCode = companyCode;
	}
	public String getMemberNo() {
		return memberNo;
	}
	public void setMemberNo(String memberNo) {
		this.memberNo = memberNo;
	}
	public Date getPrepayCardTime() {
		return prepayCardTime;
	}
	public void setPrepayCardTime(Date prepayCardTime) {
		this.prepayCardTime = prepayCardTime;
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
    public BigDecimal getDiscountSpecial() {
        return discountSpecial;
    }
    public void setDiscountSpecial(BigDecimal discountSpecial) {
        this.discountSpecial = discountSpecial;
    }
    
    public static SalesOrderVO fromDTO(SalesOrderDTO dto, List<SalesOrderItemVO> items, BigDecimal totalWeight) {
        if(dto == null) {
            return null;
        }
        SalesOrderVO vo = new SalesOrderVO();
//        vo.setType(dto.getOrderType());
//        vo.setTypeDesc(SalesOrderType.getName(dto.getOrderType()));
//        BeanUtils.copyProperties(dto, vo, "items");
//        vo.setPayment(SalesOrderPaymentVO.from(dto.getPayment()));
//        vo.setItems(items);
//        vo.setStatusName(SalesOrderStatus.getName(vo.getStatus()));
//        if(vo.getTrack() != null) {
//            vo.getTrack().stream().forEach(e -> e.setRemark(getStatusRemark(e.getOrderStatus())));
//        }
//        vo.setTotalWeight(totalWeight);
//        vo.setCanceling(dto.isCanceling() ? 1 : 0);
//        vo.setPush(dto.isPush() ? 1 : 0);
//        
//        vo.setOrderPayWay(getPayWay(dto));		//支付方式
        
        return vo;
    }
    
    
	/**
     * 支付方式
     * @param salesOrder
     * @return
     */
    private static String getPayWay(SalesOrderDTO salesOrder) {
    	String payWay = "";
//    	SalesOrderPaymentDTO payment = salesOrder.getPayment();
//    	if(salesOrder.getPrepayCardAmount().compareTo(BigDecimal.ZERO) != 0){	//有预付卡支付
//    		if(payment.getChannel() != null && payment.getAmount().compareTo(BigDecimal.ZERO) != 0 &&   
//    				payment.getStatus() == PaymentStatus.PAY_SUCC.getCode() 		
//    				&& salesOrder.getPrepayCardStatus() == PrepayCardStatus.USED.getCode()){ //第三方支付跟预付卡支付否成功  （混合支付）
//    			
//    			payWay = PayChannel.get(payment.getChannel()).getDesc() + "/" + "预付卡支付";
//    		
//    		}else if(payment.getChannel() == null && payment.getAmount().compareTo(BigDecimal.ZERO) == 0 
//    				&& salesOrder.getPrepayCardStatus() == PrepayCardStatus.USED.getCode()){		//订单全额使用预付卡支付
//    			payWay = "预付卡支付";
//    		}
//    	} else {	//无预付卡支付
//    		if(payment.getChannel() != null && payment.getAmount().compareTo(BigDecimal.ZERO) != 0 
//    				&& payment.getStatus() == PaymentStatus.PAY_SUCC.getCode()){			//第三方支付
//    			payWay = PayChannel.get(payment.getChannel()).getDesc();
//    		}
//    	}
    	return payWay;
	}
    
    
    private static String getStatusRemark(int status) {
        if(status == SalesOrderStatus.WAIT_PAY.getCode()) {
            return "用户提交订单，未付款";
        } else if(status == SalesOrderStatus.PAYED.getCode()) {
            return "用户完成付款，等待配送";
        } else if(status == SalesOrderStatus.PENDING_DELIVERY.getCode()) {
            return "商户拣货完成，等待配送";
        } else if(status == SalesOrderStatus.DELIVERED.getCode()) {
            return "货物已经出库，正在配送途中";
        } else if(status == SalesOrderStatus.RECEIVED.getCode()) {
            return "用户已经签收";
        } else if(status == SalesOrderStatus.DONE.getCode()) {
            return "订单完成";
        } else if(status == SalesOrderStatus.CLOSE.getCode()) {
            return "用户成功取消了订单";
        } else {
            return "";
        }
    }

    public String getStatusName() {
        return statusName;
    }

    public void setStatusName(String statusName) {
        this.statusName = statusName;
    }
    
    public String getCode() {
        return code;
    }

    public BigDecimal getTotalPrice() {
        return totalPrice;
    }

    public int getTotalBuyNum() {
        return totalBuyNum;
    }

    public BigDecimal getPayAmount() {
        return payAmount;
    }

    public int getStatus() {
        return status;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public StoreDTO getStore() {
        return store;
    }

    public List<SalesOrderItemVO> getItems() {
        return items;
    }

    public String getRemark() {
        return remark;
    }

    public DeliveryDTO getDelivery() {
        return delivery;
    }


    public List<SalesOrderWaterDTO> getTrack() {
        return track;
    }

    public ExpressDTO getExpress() {
        return express;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public void setTotalPrice(BigDecimal totalPrice) {
        this.totalPrice = totalPrice;
    }

    public void setTotalBuyNum(int totalBuyNum) {
        this.totalBuyNum = totalBuyNum;
    }

    public void setPayAmount(BigDecimal payAmount) {
        this.payAmount = payAmount;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public void setStore(StoreDTO store) {
        this.store = store;
    }

    public void setItems(List<SalesOrderItemVO> items) {
        this.items = items;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public void setDelivery(DeliveryDTO delivery) {
        this.delivery = delivery;
    }

    public void setTrack(List<SalesOrderWaterDTO> track) {
        this.track = track;
    }

    public void setExpress(ExpressDTO express) {
        this.express = express;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public BigDecimal getDiscountAmount() {
        return discountAmount;
    }

    public void setDiscountAmount(BigDecimal discountAmount) {
        this.discountAmount = discountAmount;
    }

    public BigDecimal getTotalWeight() {
        return totalWeight;
    }

    public void setTotalWeight(BigDecimal totalWeight) {
        this.totalWeight = totalWeight;
    }

    public int getCanceling() {
        return canceling;
    }

    public void setCanceling(int canceling) {
        this.canceling = canceling;
    }

    public int getPush() {
        return push;
    }

    public void setPush(int push) {
        this.push = push;
    }
    public SalesOrderPaymentVO getPayment() {
        return payment;
    }
    public void setPayment(SalesOrderPaymentVO payment) {
        this.payment = payment;
    }

    public String getSellerCode() {
        return sellerCode;
    }

    public void setSellerCode(String sellerCode) {
        this.sellerCode = sellerCode;
    }

    public String getSellerName() {
        return sellerName;
    }

    public void setSellerName(String sellerName) {
        this.sellerName = sellerName;
    }
}