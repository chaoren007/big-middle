package com.morning.star.retail.stock.dto;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import io.swagger.annotations.ApiModelProperty;

/**
 * 出库单
 *
 * @author jiangyf
 * @date 2018/3/13
 */
public class OutstockOrderDTO implements Serializable {
    private static final long serialVersionUID = 8604292107731703710L;

    /**
     * 出库单号
     */
    @ApiModelProperty(value="出库单号")
    private String outstockCode;
    /**
     * 入库单号
     */
    private String instockCode;
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
    @ApiModelProperty(value="出库门店编码")
    private String senderCode;
    /**
     * 调出门店名称
     */
    @ApiModelProperty(value="出库门店名称")
    private String senderName;
    /**
     * 出库类型（0：其他，1：调拨出库）
     */
    private Integer type;
    /**
     * 审核状态：0、草稿 10、待审核 20、已审核、30、驳回、40、出库
     */
    private Integer status;
    /**
     * 创建时间
     */
    private Date createTime;
    /**
     * 详情备注
     */
    private String remark;
    /**
     * 出库商品
     */
    private List<OutstockOrderDetailDTO> details;

    public static OutstockOrderDTO of(List<OutstockOrderDetailDTO> details, String remark) {
        OutstockOrderDTO orderDTO = new OutstockOrderDTO();
        orderDTO.setDetails(details);
        orderDTO.setRemark(remark);
        return orderDTO;
    }

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

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public List<OutstockOrderDetailDTO> getDetails() {
        return details;
    }

    public void setDetails(List<OutstockOrderDetailDTO> details) {
        this.details = details;
    }
}
