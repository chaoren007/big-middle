package com.morning.star.retail.admin.order.vo;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import com.morning.star.retail.order.facade.dto.DeliveryDTO;
import com.morning.star.retail.order.facade.dto.ExpressDTO;
import com.morning.star.retail.order.facade.dto.SalesOrderDTO;
import com.morning.star.retail.order.facade.dto.SalesOrderWaterDTO;
import com.morning.star.retail.order.facade.dto.StoreDTO;
import com.morning.star.retail.order.facade.order.dto.OrderGoodsItemDTO;

public class SalesOrderCancelVO implements Serializable{
    
    /**
	 * 
	 */
	private static final long serialVersionUID = -6693015777790133784L;
	private String code;
    private BigDecimal totalPrice;
    private int totalBuyNum;
    private BigDecimal payAmount;
    private int status;
    private Date createTime;
    
    private StoreDTO store;
    private List<OrderGoodsItemDTO> items;
    private SalesOrderPaymentVO payment;
    
    private String remark;
    private DeliveryDTO delivery;
    private List<SalesOrderWaterDTO> track;
    private ExpressDTO express;
    
    private String statusName;

    private BigDecimal prepayCardAmount = BigDecimal.ZERO;	//订单预付卡的金额
    
    public BigDecimal getPrepayCardAmount() {
		return prepayCardAmount;
	}
	public void setPrepayCardAmount(BigDecimal prepayCardAmount) {
		this.prepayCardAmount = prepayCardAmount;
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

    public List<OrderGoodsItemDTO> getItems() {
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

    public void setItems(List<OrderGoodsItemDTO> items) {
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

    public SalesOrderPaymentVO getPayment() {
        return payment;
    }

    public void setPayment(SalesOrderPaymentVO payment) {
        this.payment = payment;
    }

    public static SalesOrderCancelVO fromDTO(SalesOrderDTO dto) {
        if(dto == null) {
            return null;
        }
        SalesOrderCancelVO vo = new SalesOrderCancelVO();
//        BeanUtils.copyProperties(dto, vo);
//        vo.setStatusName(SalesOrderStatus.getName(vo.getStatus()));
//        vo.setPayment(SalesOrderPaymentVO.from(dto.getPayment()));
        return vo;
    }
    
}