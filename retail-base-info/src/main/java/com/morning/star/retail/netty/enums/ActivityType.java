package com.morning.star.retail.netty.enums;

/**
 * Created by liangguobin on 2017/7/6.
 */
public enum  ActivityType {

    // 限时购
    LIMIT("LIMIT"),
    // 促销
    PROMOTION("PROMOTION");


    private String code;

    ActivityType(String code) {
        this.code = code;
    }

    public String getCode() {
        return code;
    }


}
