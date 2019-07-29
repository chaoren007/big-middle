package com.morning.star.retail.order.qo;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.validation.constraints.NotNull;
import java.io.Serializable;

public class CartUpdateQO implements Serializable {

    @NotNull
    private Integer num;

    private String pprd;


    // 购物车id
    @JsonProperty("cid")
    @NotNull
    private Long id;

    private Long userId;

    private Integer selectFlag;

    public Integer getNum() {
        return num;
    }

    public void setNum(Integer num) {
        this.num = num;
    }

    public String getPprd() {
        return pprd;
    }

    public void setPprd(String pprd) {
        this.pprd = pprd;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Integer getSelectFlag() {
        return selectFlag;
    }

    public void setSelectFlag(Integer selectFlag) {
        this.selectFlag = selectFlag;
    }
}
