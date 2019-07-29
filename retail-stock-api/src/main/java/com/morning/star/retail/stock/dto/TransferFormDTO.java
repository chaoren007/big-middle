package com.morning.star.retail.stock.dto;

import com.morning.star.retail.bean.AdminLoginContent;
import com.morning.star.retail.validate.CreateGroup;
import com.morning.star.retail.validate.ModifyGroup;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.List;

@ApiModel(value = "调拨单")
public class TransferFormDTO implements Serializable {
    private static final long serialVersionUID = 5708018644854459788L;

    @NotNull(message = "调拨单号不能为空")
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
    @NotNull(message = "调出门店编码不能为空", groups = {ModifyGroup.class})
    private String senderCode;

    @ApiModelProperty(value = "调出门店名称")
    private String senderName;

    @ApiModelProperty(value = "调拨商品")
    @NotNull(message = "调拨商品不能为空", groups = {CreateGroup.class})
    private List<TransferItemDTO> items;

    public static TransferFormDTO supply(TransferFormDTO formDTO, AdminLoginContent content) {
        formDTO.setReceiverCode(content.getStoreCode());
        formDTO.setReceiverName(content.getStoreName());
        formDTO.setGroupCode(content.getGroupCode());
        return formDTO;
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

    public List<TransferItemDTO> getItems() {
        return items;
    }

    public void setItems(List<TransferItemDTO> items) {
        this.items = items;
    }
}
