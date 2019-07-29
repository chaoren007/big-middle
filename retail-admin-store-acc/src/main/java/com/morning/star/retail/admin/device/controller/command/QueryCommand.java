package com.morning.star.retail.admin.device.controller.command;

import java.io.Serializable;

import io.swagger.annotations.ApiModelProperty;

/**
 * 设备
 *
 * @author jiangyf (rebuild:kimhuhg)
 * @date 2017年5月24日 上午11:22:54
 */
public class QueryCommand implements Serializable {
    private static final long serialVersionUID = 4700941315542549468L;

    @ApiModelProperty(value = "门店编码")
    private String storeCode;

    @ApiModelProperty(value = "集团编码")
    private String GroupCode;

    public String getStoreCode() {
        return storeCode;
    }

    public void setStoreCode(String storeCode) {
        this.storeCode = storeCode;
    }

    public String getGroupCode() {
        return GroupCode;
    }

    public void setGroupCode(String groupCode) {
        GroupCode = groupCode;
    }
}
