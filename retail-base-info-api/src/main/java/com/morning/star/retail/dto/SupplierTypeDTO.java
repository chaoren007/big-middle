package com.morning.star.retail.dto;

import java.io.Serializable;

import javax.validation.constraints.NotNull;

import com.morning.star.retail.validate.CreateGroup;
import com.morning.star.retail.validate.DeleteGroup;
import com.morning.star.retail.validate.ModifyGroup;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value = "供应商类别")
public class SupplierTypeDTO implements Serializable {
    private static final long serialVersionUID = 559028683041454996L;

    @ApiModelProperty(value = "编码")
    @NotNull(message = "编码不能为空", groups = {ModifyGroup.class, DeleteGroup.class})
    private String code;

    @ApiModelProperty(value = "名称")
    @NotNull(message = "名称不能为空", groups = {CreateGroup.class, ModifyGroup.class})
    private String name;

    @ApiModelProperty(value = "上级编码")
    @NotNull(message = "上级编码不能为空", groups = CreateGroup.class)
    private String parentCode;

    @ApiModelProperty(value = "集团编码")
    private String groupCode;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getParentCode() {
        return parentCode;
    }

    public void setParentCode(String parentCode) {
        this.parentCode = parentCode;
    }

    public String getGroupCode() {
        return groupCode;
    }

    public void setGroupCode(String groupCode) {
        this.groupCode = groupCode;
    }
}
