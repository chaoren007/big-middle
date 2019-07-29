package com.morning.star.retail.admin.dto;

import com.morning.star.retail.bean.AdminLoginContent;
import com.morning.star.retail.validate.CreateGroup;
import com.morning.star.retail.validate.DeleteGroup;
import com.morning.star.retail.validate.ModifyGroup;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.apache.commons.lang3.StringUtils;

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
public class RoleFormDTO implements Serializable {
    private static final long serialVersionUID = 1077875715273878755L;

    @ApiModelProperty(value = "角色id")
    @NotNull(message = "角色id", groups = {ModifyGroup.class, DeleteGroup.class})
    private Long roleId;

    @ApiModelProperty(value = "角色名称")
    @NotNull(message = "角色名称", groups = CreateGroup.class)
    private String roleName;

    @ApiModelProperty(value = "角色权限")
    @NotNull(message = "角色权限", groups = {CreateGroup.class, ModifyGroup.class})
    List<GroupPermDTO> groupPerms;

    @ApiModelProperty(value = "集团编码")
    private String groupCode;

    @ApiModelProperty(value = "门店编码")
    private String StoreCode;

    @ApiModelProperty(value = "操作人id")
    private String operatorId;

    @ApiModelProperty(value = "操作人名称")
    private String operatorName;

    @ApiModelProperty(value = "分类")
    @NotNull(message = "角色类型不能为空", groups = {CreateGroup.class})
    private String classify;

    @ApiModelProperty(value = "登录用户等级")
    private String accountLevel;

    public static RoleFormDTO from(RoleFormDTO formDTO, AdminLoginContent login) {
        formDTO.setGroupCode(login.getGroupCode());
        formDTO.setStoreCode(StringUtils.isBlank(login.getStoreCode()) ? "" : login.getStoreCode());
        formDTO.setOperatorId(String.valueOf(login.getId()));
        formDTO.setOperatorName(login.getName());
        formDTO.setAccountLevel(login.getAccountLevel());
        return formDTO;
    }

    public RoleFormDTO() {
    }

    public Long getRoleId() {
        return roleId;
    }

    public void setRoleId(Long roleId) {
        this.roleId = roleId;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public List<GroupPermDTO> getGroupPerms() {
        return groupPerms;
    }

    public void setGroupPerms(List<GroupPermDTO> groupPerms) {
        this.groupPerms = groupPerms;
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

    public String getClassify() {
        return classify;
    }

    public void setClassify(String classify) {
        this.classify = classify;
    }

    public String getAccountLevel() {
        return accountLevel;
    }

    public void setAccountLevel(String accountLevel) {
        this.accountLevel = accountLevel;
    }
}
