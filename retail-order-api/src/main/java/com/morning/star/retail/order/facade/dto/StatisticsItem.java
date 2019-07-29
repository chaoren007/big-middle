package com.morning.star.retail.order.facade.dto;

import java.io.Serializable;

/**
 * Created by lenovo on 2018/2/2.
 */
public class StatisticsItem implements Serializable {
    private static final long serialVersionUID = 6798010314173359533L;

    private  String Key;
    private  String Value;
    //0:按渠道统计 1：按业务统计
    private  Integer type;

    public StatisticsItem(String key, String value, Integer type) {
        Key = key;
        Value = value;
        this.type = type;
    }

    public String getKey() {
        return Key;
    }

    public void setKey(String key) {
        Key = key;
    }

    public String getValue() {
        return Value;
    }

    public void setValue(String value) {
        Value = value;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }
}
