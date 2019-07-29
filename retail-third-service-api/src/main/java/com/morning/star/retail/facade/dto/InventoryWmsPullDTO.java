package com.morning.star.retail.facade.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.hibernate.validator.constraints.Range;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.List;

/**
 * 外部服务盘点信息回写dto
 * @author kimhuhg
 */
@ApiModel
public class InventoryWmsPullDTO implements Serializable {
    private static final long serialVersionUID = 735382006815547012L;

    @ApiModelProperty(required = true, value = "盘点入库单号")
    @NotNull(message = "盘点入库单号不能为空")
    private String icode;

    @ApiModelProperty(required = true, value = "请求类型（1-其他，2-盘点入库）")
    @NotNull(message = "请求类型不能为空")
    @Range(min=1, max=2)
    private Integer type;

    @ApiModelProperty(required = true, value = "仓库编号")
    @NotNull(message = "仓库编号不能为空")
    private String wcode;

    @ApiModelProperty(required = true, value = "备注")
    private String desc;

    @Valid
    @NotNull(message = "盘点详情detail不能为空")
    private List<InventoryWmsDetailPullDTO> detail;

    public String getIcode() {
        return icode;
    }

    public void setIcode(String icode) {
        this.icode = icode;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
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

    public List<InventoryWmsDetailPullDTO> getDetail() {
        return detail;
    }

    public void setDetail(List<InventoryWmsDetailPullDTO> detail) {
        this.detail = detail;
    }
}
