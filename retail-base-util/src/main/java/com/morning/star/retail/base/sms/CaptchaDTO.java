package com.morning.star.retail.base.sms;

import com.morning.star.retail.validate.SaveGroup;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotNull;
import java.io.Serializable;

@ApiModel(value = "验证码")
public class CaptchaDTO implements Serializable {
    private static final long serialVersionUID = 4505193978818395702L;

    @ApiModelProperty(value = "手机号")
    @NotNull(message = "手机号不能为空")
    private String mobile;

    @ApiModelProperty(value = "验证码")
    @NotNull(message = "验证码不能为空", groups = SaveGroup.class)
    private String captcha;

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getCaptcha() {
        return captcha;
    }

    public void setCaptcha(String captcha) {
        this.captcha = captcha;
    }
}
