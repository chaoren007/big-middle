package com.morning.star.retail.facade.dto;

import java.io.Serializable;

public class CategoryPropertyDTO implements Serializable {
    private String propertyKey;
    private String propertyVal;

    public String getPropertyKey() {
        return propertyKey;
    }

    public void setPropertyKey(String propertyKey) {
        this.propertyKey = propertyKey;
    }

    public String getPropertyVal() {
        return propertyVal;
    }

    public void setPropertyVal(String propertyVal) {
        this.propertyVal = propertyVal;
    }
}
