package com.morning.star.retail.order.qo;

import java.io.Serializable;

/**
 * Created by lenovo on 2018/1/26.
 */
public class BaseQueryQO implements Serializable {

    private static final long serialVersionUID = -886591422596963020L;

    private String groupCode;

    private String companyCode;

    private String storeCode;

    public BaseQueryQO(String groupCode, String companyCode, String storeCode) {
        this.groupCode = groupCode;
        this.companyCode = companyCode;
        this.storeCode = storeCode;
    }

    public String getGroupCode() {
        return groupCode;
    }

    public void setGroupCode(String groupCode) {
        this.groupCode = groupCode;
    }

    public String getCompanyCode() {
        return companyCode;
    }

    public void setCompanyCode(String companyCode) {
        this.companyCode = companyCode;
    }

    public String getStoreCode() {
        return storeCode;
    }

    public void setStoreCode(String storeCode) {
        this.storeCode = storeCode;
    }
}
