package com.morning.star.retail.facade.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.hibernate.validator.constraints.Range;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.List;

/**
 * 外部服务物料加工信息回写dto
 * @author kimhuhg
 */
@ApiModel
public class PackWmsPullDTO implements Serializable {
    private static final long serialVersionUID = 735382006815547012L;

    @ApiModelProperty(required = true, value = "加工单号")
    @NotNull(message = "加工单号不能为空")
    private String packcode;

    @ApiModelProperty(required = true, value = "加工出库单号")
    @NotNull(message = "加工出库单号不能为空")
    private String poutcode;

    @ApiModelProperty(required = true, value = "加工入库单号")
    private String pincode;

    @ApiModelProperty(required = true, value = "仓库编号")
    @NotNull(message = "仓库编号不能为空")
    private String wcode;

    @ApiModelProperty(required = true, value = "备注")
    private String desc;

    @Valid
    @NotNull(message = "出库商品详情不能为空")
    private List<PackOutWmsDetailPullDTO> outdetail;

    @Valid
    @NotNull(message = "入库商品详情不能为空")
    private List<PackInWmsDetailPullDTO> indetail;

    public String getPackcode() {
        return packcode;
    }

    public void setPackcode(String packcode) {
        this.packcode = packcode;
    }

    public String getPoutcode() {
        return poutcode;
    }

    public void setPoutcode(String poutcode) {
        this.poutcode = poutcode;
    }

    public String getPincode() {
        return pincode;
    }

    public void setPincode(String pincode) {
        this.pincode = pincode;
    }

    public String getWcode() {
        return wcode;
    }

    public void setWcode(String wcode) {
        this.wcode = wcode;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public List<PackOutWmsDetailPullDTO> getOutdetail() {
        return outdetail;
    }

    public void setOutdetail(List<PackOutWmsDetailPullDTO> outdetail) {
        this.outdetail = outdetail;
    }

    public List<PackInWmsDetailPullDTO> getIndetail() {
        return indetail;
    }

    public void setIndetail(List<PackInWmsDetailPullDTO> indetail) {
        this.indetail = indetail;
    }
}
