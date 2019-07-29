package com.morning.star.retail.dto;

import java.io.Serializable;
import java.util.List;

import javax.validation.constraints.NotNull;

import com.morning.star.retail.validate.CreateGroup;
import com.morning.star.retail.validate.ModifyGroup;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value = "供应商货品-保存")
public class SupplierItemFormDTO implements Serializable {
    private static final long serialVersionUID = -1932115876410624055L;

    @ApiModelProperty(value = "供应商编码")
    @NotNull(message = "供应商编码不能为空")
    private String supplierCode;

    @ApiModelProperty(value = "供应商货品-新增")
    @NotNull(message = "供应商货品不能为空", groups = CreateGroup.class)
    private List<SupplierItemSaveDTO> createItems;

    @ApiModelProperty(value = "供应商货品-修改")
    @NotNull(message = "供应商货品不能为空", groups = ModifyGroup.class)
    private SupplierItemSaveDTO modifyItem;

    private String groupCode;

    public String getSupplierCode() {
        return supplierCode;
    }

    public void setSupplierCode(String supplierCode) {
        this.supplierCode = supplierCode;
    }

    public List<SupplierItemSaveDTO> getCreateItems() {
        return createItems;
    }

    public void setCreateItems(List<SupplierItemSaveDTO> createItems) {
        this.createItems = createItems;
    }

    public SupplierItemSaveDTO getModifyItem() {
        return modifyItem;
    }

    public void setModifyItem(SupplierItemSaveDTO modifyItem) {
        this.modifyItem = modifyItem;
    }

    public String getGroupCode() {
        return groupCode;
    }

    public void setGroupCode(String groupCode) {
        this.groupCode = groupCode;
    }
}
