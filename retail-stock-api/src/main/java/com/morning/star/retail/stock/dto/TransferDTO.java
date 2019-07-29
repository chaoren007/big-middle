package com.morning.star.retail.stock.dto;

import com.morning.star.retail.utils.page.PageBean;
import com.morning.star.retail.validate.ModifyGroup;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Date;

/**
 * 调拨单
 *
 * @author jiangyf
 * @date 2018/3/13
 */
@ApiModel(value = "调拨单")
public class TransferDTO implements Serializable {
    private static final long serialVersionUID = 8604292107731703710L;

    @ApiModelProperty(value = "调拨单号")
    private String transferCode;

    @ApiModelProperty(value = "出库单号")
    private String outstockCode;

    @ApiModelProperty(value = "集团编码")
    private String groupCode;

    @ApiModelProperty(value = "调入门店编码")
    private String receiverCode;

    @ApiModelProperty(value = "调入门店名称")
    private String receiverName;

    @ApiModelProperty(value = "调出门店编码")
    @NotNull(message = "不能为空", groups = {ModifyGroup.class})
    private String senderCode;

    @ApiModelProperty(value = "调出门店名称")
    private String senderName;

    @ApiModelProperty(value = "审核状态：0、草稿 10、待审核 20、已审核、30、驳回")
    private Integer status;

    @ApiModelProperty(value = "创建时间")
    private Date createTime;

    @ApiModelProperty(value = "详情备注")
    private String remark;

    @ApiModelProperty(value = "调拨商品")
    private PageBean<TransferItemDTO> transferItems;

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

    public PageBean<TransferItemDTO> getTransferItems() {
        return transferItems;
    }

    public void setTransferItems(PageBean<TransferItemDTO> transferItems) {
        this.transferItems = transferItems;
    }
}
