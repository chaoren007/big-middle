package com.morning.star.retail.facade.dto.replenish;


import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.List;

@ApiModel
public class ReplenishAuditDTO implements Serializable {
    private static final long serialVersionUID = 700733871275750587L;

    @NotNull(message = "补货单号不能为空")
    @ApiModelProperty(value = "补货单号")
    private String replenishCode;

    @ApiModelProperty(value = "补货商品信息")
    private List<ReplenishItemSubmitDTO> items;

    private String remark;

    public ReplenishAuditDTO() {
    }

    public String getReplenishCode() {
        return replenishCode;
    }

    public void setReplenishCode(String replenishCode) {
        this.replenishCode = replenishCode;
    }

    public List<ReplenishItemSubmitDTO> getItems() {
        return items;
    }

    public void setItems(List<ReplenishItemSubmitDTO> items) {
        this.items = items;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }
}
