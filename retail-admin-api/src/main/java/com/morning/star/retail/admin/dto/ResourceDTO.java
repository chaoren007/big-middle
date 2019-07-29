package com.morning.star.retail.admin.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.List;

/**
 * 资源
 *
 * @author jiangyf
 * @date 2017年10月16日 下午5:58:46
 */
@ApiModel("资源")
public class ResourceDTO implements Serializable {
    private static final long serialVersionUID = -5409840033154077044L;

    @ApiModelProperty(value = "资源id")
    private Long id;

    @ApiModelProperty(value = "资源名称")
    private String name;

    @ApiModelProperty(value = "资源类型（menu：菜单；button：按钮）")
    private String type;

    @ApiModelProperty(value = "级别（group：分组；mode：模块；method：方法）")
    private String resourceLevel;

    @ApiModelProperty(value = "访问路径")
    private String url;

    @ApiModelProperty(value = "上级资源id")
    private Long parentId;

    @ApiModelProperty(value = "上级资源id")
    private String parentIds;

    @ApiModelProperty(value = "权限")
    private String power;

    @ApiModelProperty(value = "序号")
    private Integer priority;

    @ApiModelProperty(value = "是否拥有资源(true：是；false：否)")
    private boolean hasResource;

    @ApiModelProperty(value = "子资源集")
    List<ResourceDTO> children;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getResourceLevel() {
        return resourceLevel;
    }

    public void setResourceLevel(String resourceLevel) {
        this.resourceLevel = resourceLevel;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Long getParentId() {
        return parentId;
    }

    public void setParentId(Long parentId) {
        this.parentId = parentId;
    }

    public String getParentIds() {
        return parentIds;
    }

    public void setParentIds(String parentIds) {
        this.parentIds = parentIds;
    }

    public String getPower() {
        return power;
    }

    public void setPower(String power) {
        this.power = power;
    }

    public Integer getPriority() {
        return priority;
    }

    public void setPriority(Integer priority) {
        this.priority = priority;
    }

    public boolean isHasResource() {
        return hasResource;
    }

    public void setHasResource(boolean hasResource) {
        this.hasResource = hasResource;
    }

    public List<ResourceDTO> getChildren() {
        return children;
    }

    public void setChildren(List<ResourceDTO> children) {
        this.children = children;
    }

}
