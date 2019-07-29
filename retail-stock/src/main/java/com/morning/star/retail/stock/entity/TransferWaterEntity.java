package com.morning.star.retail.stock.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Comment;
import javax.persistence.ConstraintMode;
import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ForeignKey;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.morning.star.retail.stock.enums.TransferStatus;

/**
 * 调拨单
 *
 * @author jiangyf
 * @date 2018/3/13
 */
@Entity
@Table(name = "retail_transfer_water")
public class TransferWaterEntity extends WaterEntity {
    private static final long serialVersionUID = -8486923471118173785L;

    @Comment("调拨单号")
    @Column(length = 64, unique = true, nullable = false, updatable = false)
    private String transferCode;

    @Comment("出库单号")
    @Column(length = 64)
    private String outstockCode;

    @Comment("集团编码")
    @Column(length = 64, nullable = false, updatable = false)
    private String groupCode;

    @Comment("调入门店编码")
    @Column(length = 64, nullable = false, updatable = false)
    private String receiverCode;

    @Comment("调入门店名称")
    @Column(length = 64, nullable = false, updatable = false)
    private String receiverName;

    @Comment("调出门店编码")
    @Column(length = 64)
    private String senderCode;

    @Comment("调出门店名称")
    @Column(length = 64)
    private String senderName;

    @Comment("审核状态：0、草稿 10、待审核 20、已审核、30、驳回")
    @Convert(converter = TransferStatus.TransferStatusConverter.class)
    private TransferStatus status;

    @Comment("详情备注")
    @Column
    private String remark;
    /**
     * 级联调拨明细
     */
    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "transferCode", referencedColumnName = "transferCode", foreignKey = @ForeignKey(name = "none", value = ConstraintMode.NO_CONSTRAINT))
    private List<TransferItemEntity> items;

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

    public TransferStatus getStatus() {
        return status;
    }

    public void setStatus(TransferStatus status) {
        this.status = status;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public List<TransferItemEntity> getItems() {
        return items;
    }

    public void setItems(List<TransferItemEntity> items) {
        this.items = items;
    }
}
