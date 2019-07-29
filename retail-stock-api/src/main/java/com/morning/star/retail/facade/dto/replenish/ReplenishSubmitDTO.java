package com.morning.star.retail.facade.dto.replenish;


import com.morning.star.retail.bean.AdminLoginContent;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.List;

@ApiModel
public class ReplenishSubmitDTO implements Serializable {
    private static final long serialVersionUID = 700733871275750587L;

    @ApiModelProperty(value = "集团编码", hidden = true)
    private String groupCode;

    @ApiModelProperty(value = "集团名称", hidden = true)
    private String groupName;

    @ApiModelProperty(value = "门店编码", hidden = true)
    private String storeCode;

    @ApiModelProperty(value = "门店名称", hidden = true)
    private String storeName;

    @NotNull(message = "补货单明细不能为空")
    @ApiModelProperty(value = "补货商品信息")
    private List<ReplenishItemSubmitDTO> items;

    @ApiModelProperty(value = "补货类型: 0：门店申请补货，1：总部主动补货", hidden = true)
    private Integer replenishType;

    public String getGroupCode() {
        return groupCode;
    }

    public void setGroupCode(String groupCode) {
        this.groupCode = groupCode;
    }

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    public String getStoreCode() {
        return storeCode;
    }

    public void setStoreCode(String storeCode) {
        this.storeCode = storeCode;
    }

    public String getStoreName() {
        return storeName;
    }

    public void setStoreName(String storeName) {
        this.storeName = storeName;
    }

    public List<ReplenishItemSubmitDTO> getItems() {
        return items;
    }

    public void setItems(List<ReplenishItemSubmitDTO> items) {
        this.items = items;
    }

    public Integer getReplenishType() {
        return replenishType;
    }

    public void setReplenishType(Integer replenishType) {
        this.replenishType = replenishType;
    }

    public void fillLoginUser(AdminLoginContent login) {
        this.setGroupCode(login.getGroupCode());
        this.setGroupName(login.getGroupName());
        this.setStoreCode(login.getStoreCode());
        this.setStoreName(login.getStoreName());
    }

}
