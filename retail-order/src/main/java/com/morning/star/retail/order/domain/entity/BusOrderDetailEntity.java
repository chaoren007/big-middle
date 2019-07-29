package com.morning.star.retail.order.domain.entity;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "retail_bus_order_items")
public class BusOrderDetailEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(length = 10)
    private Long id;

    @Comment("运营点编码")
    @Column(length = 36)
    private String opc 	;// 	运营点编码

    @Comment("包裹单编码")
    @Column(length = 36)
    private String pkgNo 	;// 	包裹单编码

    @Comment("订单编码")
    @Column(length = 36)
    private String orderNo 	;// 	订单编码

    @Comment("团购编码")
    @Column(length = 36)
    private String activityCode 	;// 	团购编码

    @Comment("团购标题")
    @Column(length = 36)
    private String title 	;// 	团购标题

    @Comment("商品编码")
    @Column(length = 36)
    private String pCode 	;// 	商品编码

    @Comment("商品名称")
    @Column(length = 64)
    private String pName 	;// 	商品名称

    @Comment("类目编码")
    @Column(length = 36)
    private String pCategCode 	;// 	类目编码

    @Comment("类目名称")
    @Column(length = 64)
    private String pCategName 	;// 	类目名称

    @Comment("商品类型（0：单品:1：spu）")
    @Column(length = 36)
    private Integer productType ;//	商品类型（0：单品:1：spu）

    @Comment("团长编码")
    @Column(length = 36)
    private String agentCode 	;// 	团长编码

    @Comment("小区名称")
    @Column(length = 36)
    private String communityName 	;// 	小区名称

    @Comment("车次编码")
    @Column(length = 36)
    private String tnCode 	;// 	车次编码

    @Comment("车次")
    @Column(length = 36)
    private String tnName 	;// 	车次

    @Comment("仓库编码")
    @Column(length = 36)
    private String depotCode 	;// 	仓库编码

    @Comment("仓库")
    @Column(length = 36)
    private String depotName 	;// 	仓库

    @Comment("群组编码")
    @Column(length = 36)
    private String agpCode 	;// 	群组编码

    @Comment("群组")
    @Column(length = 36)
    private String agpName 	;// 	群组

    @Comment("总额=商品金额+运费-优惠金额")
    @Column(length = 36)
    private BigDecimal totalFee ;// 	总额=商品金额+运费-优惠金额

    @Comment("商品金额")
    @Column(length = 36)
    private BigDecimal goodsTotalFee ;// 	商品金额

    @Comment("优惠金额")
    @Column(length = 36)
    private BigDecimal discountAmount ;// 	优惠金额

    @Comment("发货类型")
    @Column(length = 36)
    private String deliveryType ;// 	发货类型

    @Comment("运费")
    @Column(length = 36)
    private BigDecimal deliveryCost ;// 	运费

    @Comment("佣金")
    @Column(length = 36)
    private BigDecimal commissionFee ;// 	佣金

    @Comment("期数")
    @Column(length = 36)
    private String period ;// 	期数

    @Comment("购买数量")
    @Column(length = 36)
    private Integer count ;// 	购买数量

    @Comment("买家")
    @Column(length = 36)
    private String buyerOpenId;

    @Comment("买家电话")
    @Column(length = 36)
    private String buyerTelephone;

    @Comment("城市")
    @Column(length = 36)
    private String cityId;

    @Comment("城市")
    @Column(length = 36)
    private String cityName;

    @Comment("开团时的版本号")
    @Column(length = 36)
    private String versionCode;

    @Comment("创建时间")
    @Column(length = 36)
    private String createdTime;

    @Comment("收件地址")
    @Column(length = 36)
    private String deliveryAddress;

    @Comment("收件人")
    @Column(length = 36)
    private String deliveryReceiver;

    @Comment("收件人嗲电话")
    @Column(length = 36)
    private String deliveryTelephone;

    @Comment("性别")
    @Column(length = 36)
    private String gender;

    @Comment("昵称")
    @Column(length = 36)
    private String nickName;

    @Comment("支付时间")
    @Column(length = 36)
    private String payTime;

    @Comment("跟新时间")
    @Column(length = 36)
    private String updatedTime;

    @Comment("处理状态0未处理 1已处理")
    @Column(length = 8)
    private Integer dealWith;


    public Integer getDealWith() {
        return dealWith;
    }

    public void setDealWith(Integer dealWith) {
        this.dealWith = dealWith;
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

    public String getPkgNo() {
        return pkgNo;
    }

    public void setPkgNo(String pkgNo) {
        this.pkgNo = pkgNo;
    }

    public String getOrderNo() {
        return orderNo;
    }

    public void setOrderNo(String orderNo) {
        this.orderNo = orderNo;
    }

    public String getActivityCode() {
        return activityCode;
    }

    public void setActivityCode(String activityCode) {
        this.activityCode = activityCode;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getpCode() {
        return pCode;
    }

    public void setpCode(String pCode) {
        this.pCode = pCode;
    }

    public String getpName() {
        return pName;
    }

    public void setpName(String pName) {
        this.pName = pName;
    }

    public String getpCategCode() {
        return pCategCode;
    }

    public void setpCategCode(String pCategCode) {
        this.pCategCode = pCategCode;
    }

    public String getpCategName() {
        return pCategName;
    }

    public void setpCategName(String pCategName) {
        this.pCategName = pCategName;
    }

    public Integer getProductType() {
        return productType;
    }

    public void setProductType(Integer productType) {
        this.productType = productType;
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

    public String getDeliveryType() {
        return deliveryType;
    }

    public void setDeliveryType(String deliveryType) {
        this.deliveryType = deliveryType;
    }

    public BigDecimal getDeliveryCost() {
        return deliveryCost;
    }

    public void setDeliveryCost(BigDecimal deliveryCost) {
        this.deliveryCost = deliveryCost;
    }

    public BigDecimal getCommissionFee() {
        return commissionFee;
    }

    public void setCommissionFee(BigDecimal commissionFee) {
        this.commissionFee = commissionFee;
    }

    public String getPeriod() {
        return period;
    }

    public void setPeriod(String period) {
        this.period = period;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public String getBuyerOpenId() {
        return buyerOpenId;
    }

    public void setBuyerOpenId(String buyerOpenId) {
        this.buyerOpenId = buyerOpenId;
    }

    public String getBuyerTelephone() {
        return buyerTelephone;
    }

    public void setBuyerTelephone(String buyerTelephone) {
        this.buyerTelephone = buyerTelephone;
    }

    public String getCityId() {
        return cityId;
    }

    public void setCityId(String cityId) {
        this.cityId = cityId;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public String getVersionCode() {
        return versionCode;
    }

    public void setVersionCode(String versionCode) {
        this.versionCode = versionCode;
    }

    public String getCreatedTime() {
        return createdTime;
    }

    public void setCreatedTime(String createdTime) {
        this.createdTime = createdTime;
    }

    public String getDeliveryAddress() {
        return deliveryAddress;
    }

    public void setDeliveryAddress(String deliveryAddress) {
        this.deliveryAddress = deliveryAddress;
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

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public String getPayTime() {
        return payTime;
    }

    public void setPayTime(String payTime) {
        this.payTime = payTime;
    }

    public String getUpdatedTime() {
        return updatedTime;
    }

    public void setUpdatedTime(String updatedTime) {
        this.updatedTime = updatedTime;
    }
}
