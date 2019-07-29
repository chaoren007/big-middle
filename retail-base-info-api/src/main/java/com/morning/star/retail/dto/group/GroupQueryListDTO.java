package com.morning.star.retail.dto.group;

import java.io.Serializable;

import io.swagger.annotations.ApiModelProperty;

/**
 * Created by kimhuhg.
 */
public class GroupQueryListDTO implements Serializable {

    private static final long serialVersionUID = -6786572429451431400L;

    @ApiModelProperty(value = "集团编码")
    private String groupCode;

    @ApiModelProperty(value = "集团名称")
    private String groupName;

    @ApiModelProperty(value = "类型(1-集团型,2-POP型)")
    private Integer type;

    /**
     * 页码
     */
    private Integer pageNo;
    /**
     * 记录数
     */
    private Integer pageSize;

    /**
     * 查找包含门店方案
     */
    @ApiModelProperty(value = "查找包含门店方案")
    private String findRoleIds;
    /**
     * 查找包含集团方案
     */
    @ApiModelProperty(value = "查找包含集团方案")
    private String findGroupAccessIds;

    public GroupQueryListDTO() {
    }

    public GroupQueryListDTO(String groupCode) {
        this.groupCode = groupCode;
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

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Integer getPageNo() {
        return pageNo;
    }

    public void setPageNo(Integer pageNo) {
        this.pageNo = pageNo;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public String getFindRoleIds() {
        return findRoleIds;
    }

    public void setFindRoleIds(String findRoleIds) {
        this.findRoleIds = findRoleIds;
    }

    public String getFindGroupAccessIds() {
        return findGroupAccessIds;
    }

    public void setFindGroupAccessIds(String findGroupAccessIds) {
        this.findGroupAccessIds = findGroupAccessIds;
    }
}
