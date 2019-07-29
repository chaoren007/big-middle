package com.morning.star.retail.order.domain.entity;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "retail_bus_order")
public class BusOrderEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(length = 10)
    private Long id;

    @Comment("运营点编码")
    @Column(length = 36)
    private String opc ;	//运营点编码

    @Comment("订单编码")
    @Column(length = 36)
    private String orderNo ;// 	订单编码

    @Comment("团长编码")
    @Column(length = 36)
    private String agentCode ;// 	团长编码

    @Comment("小区名称")
    @Column(length = 36)
    private String communityName ;// 	小区名称

    @Comment("车次编号")
    @Column(length = 36)
    private String tnCode ;// 	车次编号

    @Comment("车次名称")
    @Column(length = 36)
    private String tnName ;// 	车次名称

    @Comment("仓库编号")
    @Column(length = 36)
    private String depotCode ;// 	仓库编号

    @Comment("仓库")
    @Column(length = 36)
    private String depotName ;// 	仓库

    @Comment("群组编码")
    @Column(length = 36)
    private String agpCode ;// 	群组编码


    @Comment("群组名")
    @Column(length = 36)
    private String agpName ;// 	群组名


    @Comment("期数")
    @Column(length = 36)
    private String period ;// 	期数


    @Comment("购买者openId")
    @Column(length = 36)
    private String buyerOpenId ;// 	购买者openId


    @Comment("昵称")
    @Column(length = 36)
    private String nickName ;// 	昵称


    @Comment("收件人")
    @Column(length = 36)
    private String deliveryReceiver ;// 	收件人


    @Comment("收件人电话")
    @Column(length = 36)
    private String deliveryTelephone ;// 	收件人电话


    @Comment("收件地址")
    @Column(length = 36)
    private String deliveryAddress ;// 	收件地址


    @Comment("购买者联系电话")
    @Column(length = 36)
    private String buyerTelephone ;// 	购买者联系电话


    @Comment("总额（包括运费）")
    @Column(length = 36)
    private BigDecimal totalFee ;// 总额（包括运费）


    @Comment("商品金额")
    @Column(length = 36)
    private BigDecimal goodsTotalFee ;//	decimal 	商品金额

    @Comment("优惠金额")
    @Column(length = 36)
    private BigDecimal discountAmount ;//	decimal 	优惠金额

    @Comment("运费")
    @Column(length = 36)
    private BigDecimal deliveryCost ;//	decimal 	运费

    @Comment("发货类型")
    @Column(length = 36)
    private String deliveryType ;//	 	发货类型

    @Comment("性别")
    @Column(length = 36)
    private String gender ;//	 	性别

    @Comment("所在城市")
    @Column(length = 36)
    private String city ;//	 	所在城市

    @Comment("支付时间")
    @Column(length = 36)
    private String payTime ;//	 	支付时间

    @Comment("创建时间")
    @Column(length = 36)
    private String createdTime;

    @Comment("支付渠道")
    @Column(length = 36)
    private String payChannel;

    @Comment("跟新时间")
    @Column(length = 36)
    private String updatedTime;

    public BusOrderEntity() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getOpc() {
        return opc;
    }

    public void setOpc(String opc) {
        this.opc = opc;
    }

    public String getOrderNo() {
        return orderNo;
    }

    public void setOrderNo(String orderNo) {
        this.orderNo = orderNo;
    }

    public String getAgentCode() {
        return agentCode;
    }

    public void setAgentCode(String agentCode) {
        this.agentCode = agentCode;
    }

    public String getCommunityName() {
        return communityName;
    }

    public void setCommunityName(String communityName) {
        this.communityName = communityName;
    }

    public String getTnCode() {
        return tnCode;
    }

    public void setTnCode(String tnCode) {
        this.tnCode = tnCode;
    }

    public String getTnName() {
        return tnName;
    }

    public void setTnName(String tnName) {
        this.tnName = tnName;
    }

    public String getDepotCode() {
        return depotCode;
    }

    public void setDepotCode(String depotCode) {
        this.depotCode = depotCode;
    }

    public String getDepotName() {
        return depotName;
    }

    public void setDepotName(String depotName) {
        this.depotName = depotName;
    }

    public String getAgpCode() {
        return agpCode;
    }

    public void setAgpCode(String agpCode) {
        this.agpCode = agpCode;
    }

    public String getAgpName() {
        return agpName;
    }

    public void setAgpName(String agpName) {
        this.agpName = agpName;
    }

    public String getPeriod() {
        return period;
    }

    public void setPeriod(String period) {
        this.period = period;
    }

    public String getBuyerOpenId() {
        return buyerOpenId;
    }

    public void setBuyerOpenId(String buyerOpenId) {
        this.buyerOpenId = buyerOpenId;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public String getDeliveryReceiver() {
        return deliveryReceiver;
    }

    public void setDeliveryReceiver(String deliveryReceiver) {
        this.deliveryReceiver = deliveryReceiver;
    }

    public String getDeliveryTelephone() {
        return deliveryTelephone;
    }

    public void setDeliveryTelephone(String deliveryTelephone) {
        this.deliveryTelephone = deliveryTelephone;
    }

    public String getDeliveryAddress() {
        return deliveryAddress;
    }

    public void setDeliveryAddress(String deliveryAddress) {
        this.deliveryAddress = deliveryAddress;
    }

    public String getBuyerTelephone() {
        return buyerTelephone;
    }

    public void setBuyerTelephone(String buyerTelephone) {
        this.buyerTelephone = buyerTelephone;
    }

    public BigDecimal getTotalFee() {
        return totalFee;
    }

    public void setTotalFee(BigDecimal totalFee) {
        this.totalFee = totalFee;
    }

    public BigDecimal getGoodsTotalFee() {
        return goodsTotalFee;
    }

    public void setGoodsTotalFee(BigDecimal goodsTotalFee) {
        this.goodsTotalFee = goodsTotalFee;
    }

    public BigDecimal getDiscountAmount() {
        return discountAmount;
    }

    public void setDiscountAmount(BigDecimal discountAmount) {
        this.discountAmount = discountAmount;
    }

    public BigDecimal getDeliveryCost() {
        return deliveryCost;
    }

    public void setDeliveryCost(BigDecimal deliveryCost) {
        this.deliveryCost = deliveryCost;
    }

    public String getDeliveryType() {
        return deliveryType;
    }

    public void setDeliveryType(String deliveryType) {
        this.deliveryType = deliveryType;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getPayTime() {
        return payTime;
    }

    public void setPayTime(String payTime) {
        this.payTime = payTime;
    }

    public String getCreatedTime() {
        return createdTime;
    }

    public void setCreatedTime(String createdTime) {
        this.createdTime = createdTime;
    }

    public String getPayChannel() {
        return payChannel;
    }

    public void setPayChannel(String payChannel) {
        this.payChannel = payChannel;
    }

    public String getUpdatedTime() {
        return updatedTime;
    }

    public void setUpdatedTime(String updatedTime) {
        this.updatedTime = updatedTime;
    }
}
