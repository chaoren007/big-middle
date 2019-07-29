package com.morning.star.retail.facade.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.List;

/**
 * 外部服务出库dto（S-销售出库单，P-调拨出库单，SR-销售入库单，PR-调拨入库单）
 */
@ApiModel
public class OutStockWmsDTO implements Serializable {
    private static final long serialVersionUID = 735382006815547012L;

    @ApiModelProperty(required = true, value = "出库单号")
    @NotNull(message = "出库单号不能为空")
    private String outStockCode;

    @ApiModelProperty(required = true, value = "客户编码")
    @NotNull(message = "客户编码不能为空")
    private String userId;

    @ApiModelProperty(required = true, value = "联系人电话")
    @NotNull(message = "联系人电话不能为空")
    private String phone;

    @ApiModelProperty(required = true, value = "联系人名称")
    @NotNull(message = "联系人名称不能为空")
    private String username;

    @ApiModelProperty(required = true, value = "联系人地址")
    @NotNull(message = "联系人地址不能为空")
    private String address;

    @ApiModelProperty(required = true, value = "操作人")
    @NotNull(message = "操作人不能为空")
    private String operatorName;

    @ApiModelProperty(required = true, value = "创建时间, yyyy-MM-dd HH:mm:ss")
    @NotNull(message = "创建时间不能为空")
    private String createTime;

    @ApiModelProperty(required = true, value = "分公司")
    @NotNull(message = "分公司不能为空")
    private String storeCode;

    @ApiModelProperty(required = true, value = "仓库编码")
    @NotNull(message = "仓库编码不能为空")
    private String warehouseCode;

    @ApiModelProperty(required = true, value = "推送类型（S-销售出库单，P-调拨出库单，SR-销售入库单，PR-调拨入库单）")
    @NotNull(message = "推送类型不能为空（推送类型（S-销售出库单，P-调拨出库单，SR-销售入库单，PR-调拨入库单）")
    private String pushType;

    @ApiModelProperty(required = true, value = "备注")
    private String remark;

    @ApiModelProperty(required = true, value = "详情")
    private List<OutStockDetailWmsDTO> detail;

    public String getOutStockCode() {
        return outStockCode;
    }

    public void setOutStockCode(String outStockCode) {
        this.outStockCode = outStockCode;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getOperatorName() {
        return operatorName;
    }

    public void setOperatorName(String operatorName) {
        this.operatorName = operatorName;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public String getStoreCode() {
        return storeCode;
    }

    public void setStoreCode(String storeCode) {
        this.storeCode = storeCode;
    }

    public String getWarehouseCode() {
        return warehouseCode;
    }

    public void setWarehouseCode(String warehouseCode) {
        this.warehouseCode = warehouseCode;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public List<OutStockDetailWmsDTO> getDetail() {
        return detail;
    }

    public void setDetail(List<OutStockDetailWmsDTO> detail) {
        this.detail = detail;
    }

    public String getPushType() {
        return pushType;
    }

    public void setPushType(String pushType) {
        this.pushType = pushType;
    }
}
