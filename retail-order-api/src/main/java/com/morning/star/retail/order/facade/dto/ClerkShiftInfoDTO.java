package com.morning.star.retail.order.facade.dto;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

/**
 * Created by lenovo on 2017/12/28.
 */
public class ClerkShiftInfoDTO implements Serializable {
    private static final long serialVersionUID = -4703571460670777631L;
    private Integer shiftRecordId;

    private String companyCode;

    private String storeCode;

    private String storeName;

    private String surrenderAccount;

    private String surrenderName;

    private String receiverAccount;

    private String receiverName;

    private Date handoverTime;

    private Date loginTime;

    /**
     * 交接金额
     */
    private BigDecimal cash;

    /**
     * 销售订单数量
     */
    private Integer saleNum;

    private BigDecimal saleAmount;

    private Integer refundNum;

    private BigDecimal refundAmount;

    /**
     * 实收金额
     */
    private BigDecimal realAmount;
    /**
     * 销售情况
     */
    private List<ClerkShiftDetailDO> saleDetail;

    /**
     * 退款情况
     */
    private List<ClerkShiftDetailDO> refundDetail;

    /**
     * 实际销售情况
     */
    private List<ClerkShiftDetailDO> realDetail;

    public Integer getShiftRecordId() {
        return shiftRecordId;
    }

    public void setShiftRecordId(Integer shiftRecordId) {
        this.shiftRecordId = shiftRecordId;
    }

    public String getCompanyCode() {
        return companyCode;
    }

    public void setCompanyCode(String companyCode) {
        this.companyCode = companyCode;
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

    public String getSurrenderAccount() {
        return surrenderAccount;
    }

    public void setSurrenderAccount(String surrenderAccount) {
        this.surrenderAccount = surrenderAccount;
    }

    public String getSurrenderName() {
        return surrenderName;
    }

    public void setSurrenderName(String surrenderName) {
        this.surrenderName = surrenderName;
    }

    public String getReceiverAccount() {
        return receiverAccount;
    }

    public void setReceiverAccount(String receiverAccount) {
        this.receiverAccount = receiverAccount;
    }

    public String getReceiverName() {
        return receiverName;
    }

    public void setReceiverName(String receiverName) {
        this.receiverName = receiverName;
    }

    public Date getHandoverTime() {
        return handoverTime;
    }

    public void setHandoverTime(Date handoverTime) {
        this.handoverTime = handoverTime;
    }

    public Date getLoginTime() {
        return loginTime;
    }

    public void setLoginTime(Date loginTime) {
        this.loginTime = loginTime;
    }

    public BigDecimal getCash() {
        return cash;
    }

    public void setCash(BigDecimal cash) {
        this.cash = cash;
    }

    public Integer getSaleNum() {
        return saleNum;
    }

    public void setSaleNum(Integer saleNum) {
        this.saleNum = saleNum;
    }

    public BigDecimal getSaleAmount() {
        return saleAmount;
    }

    public void setSaleAmount(BigDecimal saleAmount) {
        this.saleAmount = saleAmount;
    }

    public Integer getRefundNum() {
        return refundNum;
    }

    public void setRefundNum(Integer refundNum) {
        this.refundNum = refundNum;
    }

    public BigDecimal getRefundAmount() {
        return refundAmount;
    }

    public void setRefundAmount(BigDecimal refundAmount) {
        this.refundAmount = refundAmount;
    }

    public BigDecimal getRealAmount() {
        return realAmount;
    }

    public void setRealAmount(BigDecimal realAmount) {
        this.realAmount = realAmount;
    }

    public List<ClerkShiftDetailDO> getSaleDetail() {
        return saleDetail;
    }

    public void setSaleDetail(List<ClerkShiftDetailDO> saleDetail) {
        this.saleDetail = saleDetail;
    }

    public List<ClerkShiftDetailDO> getRefundDetail() {
        return refundDetail;
    }

    public void setRefundDetail(List<ClerkShiftDetailDO> refundDetail) {
        this.refundDetail = refundDetail;
    }

    public List<ClerkShiftDetailDO> getRealDetail() {
        return realDetail;
    }

    public void setRealDetail(List<ClerkShiftDetailDO> realDetail) {
        this.realDetail = realDetail;
    }
}
