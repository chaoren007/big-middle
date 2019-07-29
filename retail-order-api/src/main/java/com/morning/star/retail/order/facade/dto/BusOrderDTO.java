package com.morning.star.retail.order.facade.dto;

import io.swagger.annotations.ApiModel;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

/**
 * 外部服务商品dto
 */
@ApiModel
public class BusOrderDTO implements Serializable {
    private static final long serialVersionUID = 735382006815547012L;

    private String opc ;	//运营点编码
    private String orderNo ;// 	订单编码
    private String agentCode ;// 	团长编码
    private String communityName ;// 	小区名称
    private String tnCode ;// 	车次编号
    private String tnName ;// 	车次名称
    private String depotCode ;// 	仓库编号
    private String depotName ;// 	仓库
    private String agpCode ;// 	群组编码
    private String agpName ;// 	群组名
    private String period ;// 	期数
    private String buyerOpenId ;// 	购买者openId
    private String nickName ;// 	昵称
    private String deliveryReceiver ;// 	收件人
    private String deliveryTelephone ;// 	收件人电话
    private String deliveryAddress ;// 	收件地址
    private String buyerTelephone ;// 	购买者联系电话
    private BigDecimal totalFee ;// 总额（包括运费）
    private BigDecimal goodsTotalFee ;//	decimal 	商品金额
    private BigDecimal discountAmount ;//	decimal 	优惠金额
    private BigDecimal deliveryCost ;//	decimal 	运费private String
    private String deliveryType ;//	 	发货类型
    private String gender ;//	 	性别
    private String city ;//	 	所在城市
    private String payTime ;//	 	支付时间
    private String createdTime;
    private String payChannel;
    private String updatedTime;

    private List<Detail> detailList ;// 商品信息集合


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

    public List<Detail> getDetailList() {
        return detailList;
    }

    public void setDetailList(List<Detail> detailList) {
        this.detailList = detailList;
    }

    public static class Detail implements Serializable{
        private Long id;
        private String opc 	;// 	运营点编码
        private String pkgNo 	;// 	包裹单编码
        private String orderNo 	;// 	订单编码
        private String activityCode 	;// 	团购编码
        private String title 	;// 	团购标题
        private String pCode 	;// 	商品编码
        private String pName 	;// 	商品名称
        private String pCategCode 	;// 	类目编码
        private String pCategName 	;// 	类目名称
        private Integer productType ;//	商品类型（0：单品:1：spu）
        private String agentCode 	;// 	团长编码
        private String communityName 	;// 	小区名称
        private String tnCode 	;// 	车次编码
        private String tnName 	;// 	车次
        private String depotCode 	;// 	仓库编码
        private String depotName 	;// 	仓库
        private String agpCode 	;// 	群组编码
        private String agpName 	;// 	群组
        private BigDecimal totalFee ;// 	总额=商品金额+运费-优惠金额
        private BigDecimal goodsTotalFee ;// 	商品金额
        private BigDecimal discountAmount ;// 	优惠金额
        private String deliveryType ;// 	发货类型
        private BigDecimal deliveryCost ;// 	运费
        private BigDecimal commissionFee ;// 	佣金
        private String period ;// 	期数
        private Integer count ;// 	购买数量

        private String buyerOpenId;
        private String buyerTelephone;
        private String cityId;
        private String cityName;
        private String versionCode;
        private String createdTime;
        private String deliveryAddress;
        private String deliveryReceiver;
        private String deliveryTelephone;
        private String gender;
        private String nickName;

        private String payTime;

        private String updatedTime;

        private Integer dealWith;

        public Detail() {
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

        public Long getId() {
            return id;
        }

        public void setId(Long id) {
            this.id = id;
        }

        public Integer getDealWith() {
            return dealWith;
        }

        public void setDealWith(Integer dealWith) {
            this.dealWith = dealWith;
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
    }
}
