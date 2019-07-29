package com.morning.star.retail.admin.dto;

import com.morning.star.retail.bean.AdminLoginContent;

import java.io.Serializable;
import java.util.List;

/**
 * 资源
 *
 * @author jiangyf
 * @date 2017年10月16日 下午6:17:15
 */
public class ResourceQueryDTO implements Serializable {
    private static final long serialVersionUID = -4651685797189927075L;

    /**
     * 资源id
     */
    private Long id;

    /**
     * 资源名称
     */
    private String name;

    /**
     * 资源类型（menu：菜单；button：按钮）
     */
    private String type;

    /**
     * 级别（group：分组；mode：模块；method：方法）
     */
    private String resourceLevel;

    /**
     * 上级资源id
     */
    private Long parentId;

    /**
     * 状态（0：正常，1：删除；2：锁定）
     */
    private Integer status;

    /**
     * 资源id集合
     */
    private List<Long> resourceIds;

    /**
     * 登录账号
     */
    private String account;

    /**
     * 登录账号级别
     */
    private String accountLevel;

    /**
     * 集团编码
     */
    private String groupCode;

    /**
     * 门店编码
     */
    private String StoreCode;

    /**
     * 分类
     */
    private String classify;

    public ResourceQueryDTO() {
    }

    public ResourceQueryDTO(Long id, String name, Long parentId, Integer status) {
        this.id = id;
        this.name = name;
        this.parentId = parentId;
        this.status = status;
    }

    public ResourceQueryDTO(Long id, String name, String type, String resourceLevel, Long parentId, Integer status,
                            List<Long> resourceIds, String account, String groupCode, String StoreCode, String classify) {
        this.id = id;
        this.name = name;
        this.type = type;
        this.resourceLevel = resourceLevel;
        this.parentId = parentId;
        this.status = status;
        this.resourceIds = resourceIds;
        this.account = account;
        this.groupCode = groupCode;
        this.StoreCode = StoreCode;
        this.classify = classify;
    }

    public static ResourceQueryDTO from(String classify, AdminLoginContent login) {
        ResourceQueryDTO queryDTO = ResourceQueryDTO.from(login);
        queryDTO.setClassify(classify);
        return queryDTO;
    }

    public static ResourceQueryDTO from(AdminLoginContent login) {
        ResourceQueryDTO queryDTO = new ResourceQueryDTO();
        queryDTO.setAccount(login.getAccount());
        queryDTO.setAccountLevel(login.getAccountLevel());
        queryDTO.setGroupCode(login.getGroupCode());
        queryDTO.setStoreCode(login.getStoreCode());
        return queryDTO;
    }

    public static ResourceQueryDTO of(Long id) {
        return new ResourceQueryDTO(id, null, null, null);
    }

    public static ResourceQueryDTO of(Long id, Long parentId) {
        return new ResourceQueryDTO(id, null, parentId, null);
    }

    public static ResourceQueryDTO of(String name, Long parentId, String classify) {
        ResourceQueryDTO queryDTO = new ResourceQueryDTO();
        queryDTO.setName(name);
        queryDTO.setParentId(parentId);
        queryDTO.setClassify(classify);
        return queryDTO;
    }

    public static ResourceQueryDTO of(Long parentId, Integer status) {
        return new ResourceQueryDTO(null, null, parentId, status);
    }

    public static ResourceQueryDTO of(Long parentId, List<Long> resourceIds, Integer status, String classify) {
        return new ResourceQueryDTO(null, null, null, null, parentId, status, resourceIds, null, null, null, classify);
    }

    public static ResourceQueryDTO of(List<Long> resourceIds) {
        ResourceQueryDTO queryDTO = new ResourceQueryDTO();
        queryDTO.setResourceIds(resourceIds);
        return queryDTO;
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

    public Long getParentId() {
        return parentId;
    }

    public void setParentId(Long parentId) {
        this.parentId = parentId;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public List<Long> getResourceIds() {
        return resourceIds;
    }

    public void setResourceIds(List<Long> resourceIds) {
        this.resourceIds = resourceIds;
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

    public String getStoreCode() {
        return StoreCode;
    }

    public void setStoreCode(String StoreCode) {
        this.StoreCode = StoreCode;
    }

    public String getClassify() {
        return classify;
    }

    public void setClassify(String classify) {
        this.classify = classify;
    }
}
