package com.morning.star.retail.order.domain.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Comment;

public class DepartmentEntity implements Serializable{

    @Comment("门店编号")
    @Column(length = 36)
    private String storeCode;

    @Comment("门店名称")
    @Column(length = 50)
    private String storeName;

    @Comment("集团编号")
    @Column(length = 36)
    private String groupCode;

    @Comment("集团名称")
    @Column(length = 50)
    private String groupName;

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

}
