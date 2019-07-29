package com.morning.star.retail.admin.dto;

import com.morning.star.retail.admin.enums.ChangeTypeEnum;

import java.io.Serializable;

/**
 * 变更集团的集团/门店方案（上帝端），变更门店的门店方案（门店端）
 *
 * @author jiangyf
 * @date 2018/3/2
 */
public class ChangeRoleDTO implements Serializable {
    private static final long serialVersionUID = 1121924113081975126L;

    /**
     * 新方案
     */
    private String newRoleIds;
    /**
     * 原方案
     */
    private String oldRoleIds;
    /**
     * 集团（门店）方案变更方式
     */
    private ChangeTypeEnum changeType;
    /**
     * 集团编码
     */
    private String groupCode;
    /**
     * 门店编码（门店编码）
     */
    private String StoreCode;

    public String getNewRoleIds() {
        return newRoleIds;
    }

    public void setNewRoleIds(String newRoleIds) {
        this.newRoleIds = newRoleIds;
    }

    public String getOldRoleIds() {
        return oldRoleIds;
    }

    public void setOldRoleIds(String oldRoleIds) {
        this.oldRoleIds = oldRoleIds;
    }

    public ChangeTypeEnum getChangeType() {
        return changeType;
    }

    public void setChangeType(ChangeTypeEnum changeType) {
        this.changeType = changeType;
    }

    public String getGroupCode() {
        return groupCode;
    }

    public void setGroupCode(String groupCode) {
        this.groupCode = groupCode;
    }

    public String getStoreCode() {
        return StoreCode;
    }

    public void setStoreCode(String StoreCode) {
        this.StoreCode = StoreCode;
    }
}
