package com.morning.star.retail.facade.dto;

import io.swagger.annotations.ApiModel;

import java.io.Serializable;

/**
 *
 */
@ApiModel
public class BusResultDTO  implements Serializable {

    private Integer code;
    private Object data ;
    private String desc ;

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }
}
