package com.morning.star.retail.admin.god.device.controller.command;

import java.io.Serializable;
import java.util.Date;

import javax.validation.constraints.NotNull;

import io.swagger.annotations.ApiModelProperty;

/**
 * 设备
 *
 * @author jiangyf (rebuild:kimhuhg)
 * @date 2017年5月24日 上午11:22:54
 */
public class EditExpireDateCommand implements Serializable {
    private static final long serialVersionUID = 4700941315542549468L;

    @ApiModelProperty(value = "过期时间")
    @NotNull(message = "过期时间不能为空")
    private Date expireDate;

    @NotNull(message = "密钥不能为空")
    @ApiModelProperty(value = "密钥")
    private String key;

    public Date getExpireDate() {
        return expireDate;
    }

    public void setExpireDate(Date expireDate) {
        this.expireDate = expireDate;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }
}
