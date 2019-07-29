package com.morning.star.retail.facade.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.List;

/**
 * 外部服务移库dto（推送类型：3-其他入库单接口，2-其他出库单接口,1-移库单接口）
 */
@ApiModel
public class MoveStockWmsDTO implements Serializable {
    private static final long serialVersionUID = 735382006815547012L;

    @ApiModelProperty(required = true, value = "单据单号（其他入库单号，移库单号）")
    @NotNull(message = "单据单号不能为空")
    private String pushCode;

    @ApiModelProperty(required = true, value = "作废标示：D-作废，I-插入")
    @NotNull(message = "作废标示不能为空（D-作废，I-插入）")
    private String flag;

    @ApiModelProperty(required = true, value = "推送类型：3-其他入库单接口，2-其他出库单接口,1-移库单接口")
    @NotNull(message = "推送类型不能为空（推送类型：3-其他入库单接口，2-其他出库单接口,1-移库单接口）")
    private String pushType;

    @ApiModelProperty(required = true, value = "创建时间")
    @NotNull(message = "创建时间不能为空")
    private String createTime;

    @ApiModelProperty(required = true, value = "操作人")
    @NotNull(message = "操作人不能为空")
    private String operatorName;

    @ApiModelProperty(required = true, value = "联系人电话")
    @NotNull(message = "联系人电话不能为空")
    private String phone;

    @ApiModelProperty(required = true, value = "备注")
    private String remark;

    @ApiModelProperty(required = true, value = "仓库编码(移出仓库)")
    @NotNull(message = "仓库编码不能为空")
    private String warehouseCode;

    @ApiModelProperty(required = true, value = "移入仓库编码")
    @NotNull(message = "移入仓库编码不能为空")
    private String pushWarehouseCode;

    @ApiModelProperty(required = true, value = "分公司")
    @NotNull(message = "分公司不能为空")
    private String storeCode;


    @ApiModelProperty(required = true, value = "详情")
    private List<MoveStockDetailWmsDTO> detail;

    public String getPushCode() {
        return pushCode;
    }

    public void setPushCode(String pushCode) {
        this.pushCode = pushCode;
    }

    public String getFlag() {
        return flag;
    }

    public void setFlag(String flag) {
        this.flag = flag;
    }

    public String getPushType() {
        return pushType;
    }

    public void setPushType(String pushType) {
        this.pushType = pushType;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public String getOperatorName() {
        return operatorName;
    }

    public void setOperatorName(String operatorName) {
        this.operatorName = operatorName;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getWarehouseCode() {
        return warehouseCode;
    }

    public void setWarehouseCode(String warehouseCode) {
        this.warehouseCode = warehouseCode;
    }

    public String getStoreCode() {
        return storeCode;
    }

    public void setStoreCode(String storeCode) {
        this.storeCode = storeCode;
    }

    public List<MoveStockDetailWmsDTO> getDetail() {
        return detail;
    }

    public void setDetail(List<MoveStockDetailWmsDTO> detail) {
        this.detail = detail;
    }

    public String getPushWarehouseCode() {
        return pushWarehouseCode;
    }

    public void setPushWarehouseCode(String pushWarehouseCode) {
        this.pushWarehouseCode = pushWarehouseCode;
    }
}
