package com.morning.star.retail.admin.dto;

import com.morning.star.retail.bean.AdminLoginContent;
import com.morning.star.retail.validate.DetailGroup;
import com.morning.star.retail.validate.PageGroup;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.List;

/**
 * 角色
 *
 * @author jiangyf
 * @date 2017年10月16日 下午6:17:15
 */
@ApiModel(value = "角色")
public class RoleQueryDTO implements Serializable {
    private static final long serialVersionUID = -7169150856610938996L;

    @NotNull(message = "权限id", groups = DetailGroup.class)
    @ApiModelProperty(value = "权限id")
    private Long id;

    @ApiModelProperty(value = "权限id")
    private List<Long> ids;

    @ApiModelProperty(value = "权限名称")
    private String name;

    @ApiModelProperty(value = "状态（0：正常，1：删除；2：锁定）")
    private Integer status;

    @ApiModelProperty(value = "登录账号")
    private String account;

    @ApiModelProperty(value = "登录账号级别")
    private String accountLevel;

    @ApiModelProperty(value = "集团编码")
    private String groupCode;

    @ApiModelProperty(value = "集团编码")
    private List<String> groupCodes;

    @ApiModelProperty(value = "门店编码")
    private String StoreCode;

    @ApiModelProperty(value = "门店编码")
    private List<String> StoreCodes;

    @ApiModelProperty(value = "分类")
    private String classify;

    @ApiModelProperty(value = "分类")
    private String notClassify;

    @ApiModelProperty(value = "页码")
    @NotNull(message = "页码", groups = PageGroup.class)
    private Integer pageNo;

    @ApiModelProperty(value = "记录数")
    @NotNull(message = "记录数", groups = PageGroup.class)
    private Integer pageSize;

    public static RoleQueryDTO from(RoleFormDTO formDTO) {
        RoleQueryDTO queryDTO = new RoleQueryDTO();
        queryDTO.setId(formDTO.getRoleId());
        queryDTO.setName(formDTO.getRoleName());
        queryDTO.setGroupCode(formDTO.getGroupCode());
        queryDTO.setStoreCode(formDTO.getStoreCode());
        queryDTO.setClassify(formDTO.getClassify());
        return queryDTO;
    }

    public static RoleQueryDTO of(Long id, Integer status) {
        RoleQueryDTO queryDTO = new RoleQueryDTO();
        queryDTO.setId(id);
        queryDTO.setStatus(status);
        return queryDTO;
    }

    public static RoleQueryDTO from(String classify, AdminLoginContent login) {
        RoleQueryDTO queryDTO = from(new RoleQueryDTO(), login);
        queryDTO.setClassify(classify);
        return queryDTO;
    }

    public static RoleQueryDTO from(AdminLoginContent login) {
        return from(new RoleQueryDTO(), login);
    }

    public static RoleQueryDTO from(RoleQueryDTO queryDTO, AdminLoginContent login) {
        queryDTO.setAccount(login.getAccount());
        queryDTO.setAccountLevel(login.getAccountLevel());
        queryDTO.setGroupCode(login.getGroupCode());
        queryDTO.setStoreCode(login.getStoreCode());
        return queryDTO;
    }

    public static RoleQueryDTO of(String classify, String notClassify, List<String> groupCodes) {
        RoleQueryDTO queryDTO = new RoleQueryDTO();
        queryDTO.setClassify(classify);
        queryDTO.setNotClassify(notClassify);
        queryDTO.setGroupCodes(groupCodes);
        return queryDTO;
    }

    public static RoleQueryDTO of(String classify, String notClassify, String groupCode) {
        RoleQueryDTO queryDTO = new RoleQueryDTO();
        queryDTO.setClassify(classify);
        queryDTO.setNotClassify(notClassify);
        queryDTO.setGroupCode(groupCode);
        return queryDTO;
    }

    public static RoleQueryDTO of(List<String> StoreCodes, String groupCode) {
        RoleQueryDTO queryDTO = new RoleQueryDTO();
        queryDTO.setStoreCodes(StoreCodes);
        queryDTO.setGroupCode(groupCode);
        return queryDTO;
    }

    public static RoleQueryDTO of(String StoreCode, String groupCode) {
        RoleQueryDTO queryDTO = new RoleQueryDTO();
        queryDTO.setStoreCode(StoreCode);
        queryDTO.setGroupCode(groupCode);
        return queryDTO;
    }

    public RoleQueryDTO() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<Long> getIds() {
        return ids;
    }

    public void setIds(List<Long> ids) {
        this.ids = ids;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getAccountLevel() {
        return accountLevel;
    }

    public void setAccountLevel(String accountLevel) {
        this.accountLevel = accountLevel;
    }

    public String getGroupCode() {
        return groupCode;
    }

    public void setGroupCode(String groupCode) {
        this.groupCode = groupCode;
    }

    public List<String> getGroupCodes() {
        return groupCodes;
    }

    public void setGroupCodes(List<String> groupCodes) {
        this.groupCodes = groupCodes;
    }

    public String getStoreCode() {
        return StoreCode;
    }

    public void setStoreCode(String StoreCode) {
        this.StoreCode = StoreCode;
    }

    public List<String> getStoreCodes() {
        return StoreCodes;
    }

    public void setStoreCodes(List<String> StoreCodes) {
        this.StoreCodes = StoreCodes;
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

    public String getClassify() {
        return classify;
    }

    public void setClassify(String classify) {
        this.classify = classify;
    }

    public String getNotClassify() {
        return notClassify;
    }

    public void setNotClassify(String notClassify) {
        this.notClassify = notClassify;
    }
}
