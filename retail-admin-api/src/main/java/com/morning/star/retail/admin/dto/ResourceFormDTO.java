package com.morning.star.retail.admin.dto;

import com.morning.star.retail.bean.AdminLoginContent;
import com.morning.star.retail.validate.CreateGroup;
import com.morning.star.retail.validate.ModifyGroup;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 * 资源
 *
 * @author jiangyf
 * @date 2017年10月16日 下午5:58:46
 */
@ApiModel(value = "资源")
public class ResourceFormDTO implements Serializable {
    private static final long serialVersionUID = -2713953570411725852L;

    @ApiModelProperty(value = "资源编码")
    @NotNull(message = "资源编码")
    private Long id;

    @ApiModelProperty(value = "资源名称")
    @NotNull(message = "资源名称", groups = {CreateGroup.class, ModifyGroup.class})
    private String name;

    @ApiModelProperty(value = "级别（group：分组；mode：模块；method：方法）")
    @NotNull(message = "级别", groups = CreateGroup.class)
    private String resourceLevel;

    @ApiModelProperty(value = "上级资源编码")
    @NotNull(message = "上级资源编码", groups = CreateGroup.class)
    private Long parentId;

    @ApiModelProperty(value = "分类")
    private String classify;

    @ApiModelProperty(value = "集团编码")
    private String groupCode;

    @ApiModelProperty(value = "门店编码")
    private String StoreCode;

    @ApiModelProperty(value = "操作人id")
    private String operatorId;

    @ApiModelProperty(value = "操作人名称")
    private String operatorName;

    public static ResourceFormDTO from(ResourceFormDTO formDTO, AdminLoginContent login) {
        formDTO.setGroupCode(login.getGroupCode());
        formDTO.setStoreCode(login.getStoreCode());
        formDTO.setOperatorId(String.valueOf(login.getId()));
        formDTO.setOperatorName(login.getName());
        return formDTO;
    }

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

    public String getResourceLevel() {
        return resourceLevel;
    }

    public void setResourceLevel(String resourceLevel) {
        this.resourceLevel = resourceLevel;
    }

    public Long getParentId() {
        return parentId;
    }

    public void setParentId(Long parentId) {
        this.parentId = parentId;
    }

    public String getClassify() {
        return classify;
    }

    public void setClassify(String classify) {
        this.classify = classify;
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

    public String getOperatorId() {
        return operatorId;
    }

    public void setOperatorId(String operatorId) {
        this.operatorId = operatorId;
    }

    public String getOperatorName() {
        return operatorName;
    }

    public void setOperatorName(String operatorName) {
        this.operatorName = operatorName;
    }
}
