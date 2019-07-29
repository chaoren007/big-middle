package com.morning.star.retail.dto;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.validation.constraints.NotNull;

import com.morning.star.retail.base.page.PageBeans;
import com.morning.star.retail.bean.AdminLoginContent;
import com.morning.star.retail.enums.SupplierChangeStatusEnum;
import com.morning.star.retail.validate.SaveGroup;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value = "供应商更单")
public class SupplierChangeDTO implements Serializable {
    private static final long serialVersionUID = 4505193978818395702L;

    @ApiModelProperty(value = "变更单号")
    @NotNull(message = "不能为空")
    private String code;

    @ApiModelProperty(value = "供应商编码")
    @NotNull(message = "供应商编码不能为空")
    private String supplierCode;

    @ApiModelProperty(value = "供应商名称")
    @NotNull(message = "供应商名称不能为空", groups = SaveGroup.class)
    private String supplierName;

    @ApiModelProperty(value = "集团编码")
    private String groupCode;

    @ApiModelProperty(value = "状态")
    private Integer status;

    @ApiModelProperty(value = "类型：0 增加， 1 取消")
    @NotNull(message = "类型不能为空", groups = SaveGroup.class)
    private Integer type;

    @ApiModelProperty(value = "创建人id")
    private Long createrId;

    @ApiModelProperty(value = "创建人名称")
    private String createrName;

    @ApiModelProperty(value = "审核人id")
    private Long auditorId;

    @ApiModelProperty(value = "审核人名称")
    private String auditorName;

    @ApiModelProperty(value = "审核时间")
    private Date auditTime;

    @ApiModelProperty(value = "备注")
    private String remark;

    @ApiModelProperty(value = "供货门店【提交表单】")
    private List<SupplierStoreDTO> supplierStores;

    @ApiModelProperty(value = "供货明细【提交表单】")
    private List<SupplierItemDTO> supplierItems;

    @ApiModelProperty(value = "供货门店【变更单详情】")
    private PageBeans<SupplierStoreDTO> stores;

    @ApiModelProperty(value = "供货明细【变更单详情】")
    private PageBeans<SupplierItemDTO> items;

    public static SupplierChangeDTO forSave(SupplierChangeDTO dto, AdminLoginContent content, SupplierChangeStatusEnum status) {
        dto.setGroupCode(content.getGroupCode());
        dto.setStatus(status.getCode());
        dto.setCreaterId(content.getId());
        dto.setCreaterName(content.getName());
        return dto;
    }

    public static SupplierChangeDTO forAudit(SupplierChangeDTO dto, AdminLoginContent content, SupplierChangeStatusEnum status) {
        dto.setGroupCode(content.getGroupCode());
        dto.setStatus(status.getCode());
        dto.setAuditorId(content.getId());
        dto.setAuditorName(content.getName());
        dto.setAuditTime(new Date());
        return dto;
    }

    public static SupplierChangeDTO from(String code, AdminLoginContent content) {
        SupplierChangeDTO dto = new SupplierChangeDTO();
        dto.setCode(code);
        dto.setGroupCode(content.getGroupCode());
        return dto;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getSupplierCode() {
        return supplierCode;
    }

    public void setSupplierCode(String supplierCode) {
        this.supplierCode = supplierCode;
    }

    public String getSupplierName() {
        return supplierName;
    }

    public void setSupplierName(String supplierName) {
        this.supplierName = supplierName;
    }

    public String getGroupCode() {
        return groupCode;
    }

    public void setGroupCode(String groupCode) {
        this.groupCode = groupCode;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Long getCreaterId() {
        return createrId;
    }

    public void setCreaterId(Long createrId) {
        this.createrId = createrId;
    }

    public String getCreaterName() {
        return createrName;
    }

    public void setCreaterName(String createrName) {
        this.createrName = createrName;
    }

    public Long getAuditorId() {
        return auditorId;
    }

    public void setAuditorId(Long auditorId) {
        this.auditorId = auditorId;
    }

    public String getAuditorName() {
        return auditorName;
    }

    public void setAuditorName(String auditorName) {
        this.auditorName = auditorName;
    }

    public Date getAuditTime() {
        return auditTime;
    }

    public void setAuditTime(Date auditTime) {
        this.auditTime = auditTime;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public List<SupplierStoreDTO> getSupplierStores() {
        return supplierStores;
    }

    public void setSupplierStores(List<SupplierStoreDTO> supplierStores) {
        this.supplierStores = supplierStores;
    }

    public List<SupplierItemDTO> getSupplierItems() {
        return supplierItems;
    }

    public void setSupplierItems(List<SupplierItemDTO> supplierItems) {
        this.supplierItems = supplierItems;
    }

    public PageBeans<SupplierStoreDTO> getStores() {
        return stores;
    }

    public void setStores(PageBeans<SupplierStoreDTO> stores) {
        this.stores = stores;
    }

    public PageBeans<SupplierItemDTO> getItems() {
        return items;
    }

    public void setItems(PageBeans<SupplierItemDTO> items) {
        this.items = items;
    }
}
