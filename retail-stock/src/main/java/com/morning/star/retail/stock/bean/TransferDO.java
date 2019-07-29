package com.morning.star.retail.stock.bean;

import java.util.Date;

/**
 * 调拨单
 *
 * @author jiangyf
 * @date 2018/3/13
 */
public class TransferDO {

    /**
     * 主键
     */
    private Long id;
    /**
     * 调拨单号
     */
    private String transferCode;
    /**
     * 出库单号
     */
    private String outstockCode;
    /**
     * 集团编码
     */
    private String groupCode;
    /**
     * 调入门店编码
     */
    private String receiverCode;
    /**
     * 调入门店名称
     */
    private String receiverName;
    /**
     * 调出门店编码
     */
    private String senderCode;
    /**
     * 调出门店名称
     */
    private String senderName;
    /**
     * 审核状态：0、草稿 10、待审核 20、已审核、30、驳回
     */
    private Integer status;
    /**
     * 删除标记，0：正常；1：删除
     */
    private Integer deleteFlag;
    /**
     * 创建时间
     */
    private Date createTime;
    /**
     * 修改时间
     */
    private Date modifyTime;
    /**
     * 操作人ID
     */
    private String operatorId;
    /**
     * 操作人姓名
     */
    private String operatorName;
    /**
     * 详情备注
     */
    private String remark;
    /**
     * 审核状态：0、草稿 10、待审核 20、已审核、30、驳回
     */
    private Integer lastStatus;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTransferCode() {
        return transferCode;
    }

    public void setTransferCode(String transferCode) {
        this.transferCode = transferCode;
    }

    public String getOutstockCode() {
        return outstockCode;
    }

    public void setOutstockCode(String outstockCode) {
        this.outstockCode = outstockCode;
    }

    public String getGroupCode() {
        return groupCode;
    }

    public void setGroupCode(String groupCode) {
        this.groupCode = groupCode;
    }

    public String getReceiverCode() {
        return receiverCode;
    }

    public void setReceiverCode(String receiverCode) {
        this.receiverCode = receiverCode;
    }

    public String getReceiverName() {
        return receiverName;
    }

    public void setReceiverName(String receiverName) {
        this.receiverName = receiverName;
    }

    public String getSenderCode() {
        return senderCode;
    }

    public void setSenderCode(String senderCode) {
        this.senderCode = senderCode;
    }

    public String getSenderName() {
        return senderName;
    }

    public void setSenderName(String senderName) {
        this.senderName = senderName;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getDeleteFlag() {
        return deleteFlag;
    }

    public void setDeleteFlag(Integer deleteFlag) {
        this.deleteFlag = deleteFlag;
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

    public String getOperatorId() {
        return operatorId;
    }

    public void setOperatorId(String operatorId) {
        this.operatorId = operatorId;
    }

    public String getOperatorName() {
        return operatorName;
    }

    public void setOperatorName(String operatorName) {
        this.operatorName = operatorName;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public Integer getLastStatus() {
        return lastStatus;
    }

    public void setLastStatus(Integer lastStatus) {
        this.lastStatus = lastStatus;
    }
}
