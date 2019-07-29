package com.morning.star.retail.order.facade.dto;

import com.morning.star.retail.order.facade.order.dto.OrderGoodsItemDTO;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

public class SalesOrderDTO implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "订单code")
    private String orderCode;

    @ApiModelProperty(value = "总金额")
    private BigDecimal totalAmount;

    @ApiModelProperty(value = "商品总个数")
    private int totalBuyNum;

    @ApiModelProperty(value = "优惠金额")
    private BigDecimal discountAmount;        //优惠金额

    @ApiModelProperty(value = "支付Code")
    private String payCode;

    @ApiModelProperty(value = "支付金额")
    private BigDecimal payAmount;

    @ApiModelProperty(value = "支付渠道 0-现金支付    1-支付宝     2-微信    3-翼支付    4-银联")
    private Integer payChannel;

    @ApiModelProperty(value = "支付客户端  0-ios   1-安卓")
    private Integer payClient;

    @ApiModelProperty(value = "支付状态  0，1，2，3 等待支付  支付中  支付成功  支付失败")
    private int payStatus;

    @ApiModelProperty(value = "支付时间")
    private Date payTime;

    @ApiModelProperty(value = "支付交易流水号")
    private String payTradeNo;

    @ApiModelProperty(value = "门店code")
    private String storeCode;

    @ApiModelProperty(value = "门店名称")
    private String storeName;

    @ApiModelProperty(value = "集团code")
    private String groupCode;

    @ApiModelProperty(value = "集团名称")
    private String groupName;

    @ApiModelProperty(value = "订单状态")
    private Integer orderStatus;

    @ApiModelProperty(value = "关联商品明细")
    private List<OrderGoodsItemDTO> items;

    @ApiModelProperty(value = "购买人code")
    private String buyerCode;

    @ApiModelProperty(value = "购买人名称")
    private String buyerName;

    @ApiModelProperty(value = "购买人电话")
    private String buyerPhone;

    @ApiModelProperty(value = "购买备注")
    private String remark; //购买备注、留言

    @ApiModelProperty(value = "是否关闭")
    private boolean canceling;
    private boolean push;

    @ApiModelProperty(value = "订单类型  0：线上    1：线下")
    private Integer orderType = 0;        //订单类型   0：线上    1：线下

    @ApiModelProperty(value = "订单类型描述  0：线上    1：线下")
    private String orderTypeDesc;

    @ApiModelProperty(value = "订单关闭类型  100：取消关闭    110：拒收关闭")
    private Integer closedType;        //订单关闭类型  100：取消关闭    110：拒收关闭

    @ApiModelProperty(value = "优惠券code")
    private String couponCode;

    private Date createTime;

    @ApiModelProperty(value = "下单时间")
    private String orderTime;


    public String getOrderTypeDesc() {
        return orderTypeDesc;
    }

    public void setOrderTypeDesc(String orderTypeDesc) {
        this.orderTypeDesc = orderTypeDesc;
    }

    public String getOrderTime() {
        return orderTime;
    }

    public void setOrderTime(String orderTime) {
        this.orderTime = orderTime;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getOrderCode() {
        return orderCode;
    }

    public void setOrderCode(String orderCode) {
        this.orderCode = orderCode;
    }


    public int getTotalBuyNum() {
        return totalBuyNum;
    }

    public void setTotalBuyNum(int totalBuyNum) {
        this.totalBuyNum = totalBuyNum;
    }

    public BigDecimal getDiscountAmount() {
        return discountAmount;
    }

    public void setDiscountAmount(BigDecimal discountAmount) {
        this.discountAmount = discountAmount;
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

    public BigDecimal getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(BigDecimal totalAmount) {
        this.totalAmount = totalAmount;
    }

    public Integer getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(Integer orderStatus) {
        this.orderStatus = orderStatus;
    }

    public List<OrderGoodsItemDTO> getItems() {
        return items;
    }

    public void setItems(List<OrderGoodsItemDTO> items) {
        this.items = items;
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

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public boolean isCanceling() {
        return canceling;
    }

    public void setCanceling(boolean canceling) {
        this.canceling = canceling;
    }

    public boolean isPush() {
        return push;
    }

    public void setPush(boolean push) {
        this.push = push;
    }

    public Integer getOrderType() {
        return orderType;
    }

    public void setOrderType(Integer orderType) {
        this.orderType = orderType;
    }

    public Integer getClosedType() {
        return closedType;
    }

    public void setClosedType(Integer closedType) {
        this.closedType = closedType;
    }

    public String getCouponCode() {
        return couponCode;
    }

    public void setCouponCode(String couponCode) {
        this.couponCode = couponCode;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public String getPayCode() {
        return payCode;
    }

    public void setPayCode(String payCode) {
        this.payCode = payCode;
    }

    public BigDecimal getPayAmount() {
        return payAmount;
    }

    public void setPayAmount(BigDecimal payAmount) {
        this.payAmount = payAmount;
    }

    public Integer getPayChannel() {
        return payChannel;
    }

    public void setPayChannel(Integer payChannel) {
        this.payChannel = payChannel;
    }

    public Integer getPayClient() {
        return payClient;
    }

    public void setPayClient(Integer payClient) {
        this.payClient = payClient;
    }

    public int getPayStatus() {
        return payStatus;
    }

    public void setPayStatus(int payStatus) {
        this.payStatus = payStatus;
    }

    public Date getPayTime() {
        return payTime;
    }

    public void setPayTime(Date payTime) {
        this.payTime = payTime;
    }

    public String getPayTradeNo() {
        return payTradeNo;
    }

    public void setPayTradeNo(String payTradeNo) {
        this.payTradeNo = payTradeNo;
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

}
