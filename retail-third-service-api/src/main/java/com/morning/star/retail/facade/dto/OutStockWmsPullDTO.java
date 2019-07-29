package com.morning.star.retail.facade.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.hibernate.validator.constraints.Range;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.List;

/**
 * 外部服务出库信息回写dto
 * @author kimhuhg
 */
@ApiModel
public class OutStockWmsPullDTO implements Serializable {
    private static final long serialVersionUID = 735382006815547012L;

    @ApiModelProperty(required = true, value = "出库单号")
    @NotNull(message = "出库单号不能为空")
    private String ocode;

    @ApiModelProperty(required = true, value = "供应商编码")
    private String supcode;

    @ApiModelProperty(required = true, value = "出库类型（1-其他出库，2-销售出库，3-采购退货出库，4-地推出库，5-加工出库）")
    @NotNull(message = "出库类型不能为空")
    @Range(min=1, max=5)
    private Integer type;

    @ApiModelProperty(required = true, value = "仓库编号")
    @NotNull(message = "仓库编号不能为空")
    private String wcode;

    @ApiModelProperty(required = true, value = "关联单号")
    @NotNull(message = "关联单号不能为空")
    private String tcode;

    @ApiModelProperty(required = true, value = "备注")
    private String desc;

    @Valid
    @NotNull(message = "出库详情detail不能为空")
    private List<OutStockWmsDetailPullDTO> detail;

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getOcode() {
        return ocode;
    }

    public void setOcode(String ocode) {
        this.ocode = ocode;
    }

    public List<OutStockWmsDetailPullDTO> getDetail() {
        return detail;
    }

    public void setDetail(List<OutStockWmsDetailPullDTO> detail) {
        this.detail = detail;
    }

    public String getSupcode() {
        return supcode;
    }

    public void setSupcode(String supcode) {
        this.supcode = supcode;
    }

    public String getWcode() {
        return wcode;
    }

    public void setWcode(String wcode) {
        this.wcode = wcode;
    }

    public String getTcode() {
        return tcode;
    }

    public void setTcode(String tcode) {
        this.tcode = tcode;
    }
}
