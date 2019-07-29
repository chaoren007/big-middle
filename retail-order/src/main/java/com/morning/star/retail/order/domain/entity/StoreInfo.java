package com.morning.star.retail.order.domain.entity;

public class StoreInfo {
    private String storeCode;
    private String storeName;
    private String storePhone;
    
    private String groupCode;
    private String groupName;
    
    public StoreInfo() {
        this(null, null);
    }

    public StoreInfo(String storeCode, String storeName) {
        this.storeCode = storeCode;
        this.storeName = storeName;
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

    public String getStorePhone() {
        return storePhone;
    }

    public void setStorePhone(String storePhone) {
        this.storePhone = storePhone;
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
