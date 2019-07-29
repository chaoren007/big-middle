package com.morning.star.retail.stock.entity;

import javax.persistence.Column;
import javax.persistence.Comment;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.Where;

/**
 * 出库单
 *
 */
@Table(name = "retail_outstock")
@Where(clause = "delete_flag <> 1")
@Entity
public class OutstockOrderEntity extends BaseEntity {

    private static final long serialVersionUID = 1L;
    
    /**
     * 出库单号
     */
    @Id
    @Column(length = 64)
    @Comment(value="出库单号")
    private String outstockCode;
    /**
     * 入库单号
     */
    @Column(length = 64)
    @Comment(value="入库单号")
    private String instockCode;
    /**
     * 集团编码
     */
    @Column(length = 64)
    @Comment(value="集团编码")
    private String groupCode;
    /**
     * 调入门店编码
     */
    @Column(length = 64)
    @Comment(value="调入门店编码")
    private String receiverCode;
    /**
     * 调入门店名称
     */
    @Column(length = 64)
    @Comment(value="调入门店名称")
    private String receiverName;
    /**
     * 调出门店编码
     */
    @Column(length = 64)
    @Comment(value="调出门店编码")
    private String senderCode;
    /**
     * 调出门店名称
     */
    @Column(length = 64)
    @Comment(value="调出门店名称")
    private String senderName;
    /**
     * 出库类型（0：其他，1：出库出库）
     */
    @Column(length = 10)
    @Comment(value="出库类型（0：其他，1：调拨出库）")
    private Integer type;
    /**
     * 审核状态：0、草稿 10、待审核 20、已审核、30、驳回
     */
    @Column(length = 10)
    @Comment(value="审核状态：0、草稿 10、待审核 20、已审核、30、驳回")
    private Integer status;
    
    @Column(length = 10)
    @Comment(value="审核状态：0、草稿 10、待审核 20、已审核、30、驳回")
    private Integer lastStatus;
    /**
     * 详情备注
     */
    @Column(length = 64)
    @Comment(value="审核状态：0、草稿 10、待审核 20、已审核、30、驳回 40、已出库")
    private String remark;

    @Comment("仓库编码")
    @Column(length = 128, nullable = false)
    private String warehouseCode;

    @Comment("仓库名称")
    @Column(length = 128, nullable = false)
    private String warehouseName;


    public String getOutstockCode() {
        return outstockCode;
    }

    public void setOutstockCode(String outstockCode) {
        this.outstockCode = outstockCode;
    }

    public String getInstockCode() {
        return instockCode;
    }

    public void setInstockCode(String instockCode) {
        this.instockCode = instockCode;
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

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
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

    public String getWarehouseCode() {
        return warehouseCode;
    }

    public void setWarehouseCode(String warehouseCode) {
        this.warehouseCode = warehouseCode;
    }

    public String getWarehouseName() {
        return warehouseName;
    }

    public void setWarehouseName(String warehouseName) {
        this.warehouseName = warehouseName;
    }
}
