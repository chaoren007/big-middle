package com.morning.star.retail.stock.dto;

import com.morning.star.retail.bean.AdminLoginContent;
import com.morning.star.retail.consts.RetailDefaultConst;
import com.morning.star.retail.validate.DetailGroup;
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
public class TransferQueryDTO implements Serializable {
    private static final long serialVersionUID = 8604292107731703710L;

    @ApiModelProperty(value = "调拨单号")
    @NotNull(message = "调拨单号不能为空", groups = DetailGroup.class)
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
    private String senderCode;

    @ApiModelProperty(value = "调出门店名称")
    private String senderName;

    @ApiModelProperty(value = "审核状态：0、草稿 10、待审核 20、已审核、30、驳回")
    private Integer status;

    @ApiModelProperty(value = "开始时间")
    private Date startTime;

    @ApiModelProperty(value = "结束时间")
    private Date endTime;

    @ApiModelProperty(value = "SAP货品编码")
    private String sapProductCode;

    @ApiModelProperty(value = "商品编码")
    private String goodsCode;

    @ApiModelProperty(value = "商品名称")
    private String goodsName;

    private Integer deleteFlag;

    @ApiModelProperty(value = "upc")
    private String upcCode;

    @ApiModelProperty(value = "页码")
    private Integer pageNo;

    @ApiModelProperty(value = "每页记录数")
    private Integer pageSize;

    @ApiModelProperty(value = "平台")
    private String platform;

    public static TransferQueryDTO of(String transferCode, AdminLoginContent content) {
        TransferQueryDTO queryDTO = new TransferQueryDTO();
        queryDTO.setTransferCode(transferCode);
        queryDTO.setGroupCode(content.getGroupCode());
        return queryDTO;
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

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    public String getSapProductCode() {
        return sapProductCode;
    }

    public void setSapProductCode(String sapProductCode) {
        this.sapProductCode = sapProductCode;
    }

    public String getGoodsCode() {
        return goodsCode;
    }

    public void setGoodsCode(String goodsCode) {
        this.goodsCode = goodsCode;
    }

    public String getGoodsName() {
        return goodsName;
    }

    public void setGoodsName(String goodsName) {
        this.goodsName = goodsName;
    }

    public String getUpcCode() {
        return upcCode;
    }

    public void setUpcCode(String upcCode) {
        this.upcCode = upcCode;
    }

    public Integer getDeleteFlag() {
        return deleteFlag;
    }

    public void setDeleteFlag(Integer deleteFlag) {
        this.deleteFlag = deleteFlag;
    }

    public Integer getPageNo() {
        if (pageNo == null || pageNo <= 0) {
            return 1;
        }
        return pageNo;
    }

    public void setPageNo(Integer pageNo) {
        this.pageNo = pageNo;
    }

    public Integer getPageSize() {
        if (pageSize == null || pageSize <= 0) {
            return RetailDefaultConst.ADMIN_PAGE_SIZE;
        }
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public String getPlatform() {
        return platform;
    }

    public void setPlatform(String platform) {
        this.platform = platform;
    }
}
