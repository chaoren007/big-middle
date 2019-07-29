package com.morning.star.retail.bean;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * pos/后台登录账户上下文 Created by liangguobin on 2017/5/17.
 */
@Data
@ApiModel
public class AdminLoginContent implements Serializable {
	private static final long serialVersionUID = 333920518067211346L;

	@ApiModelProperty("ID")
	private Long id;

	@ApiModelProperty("集团编码")
	private String groupCode;

	@ApiModelProperty("集团名称")
	private String groupName;

	@ApiModelProperty("门店编码")
	private String storeCode;

	@ApiModelProperty("门店名称")
	private String storeName;

	@ApiModelProperty("供应商编码")
	private String supplierCode;

	@ApiModelProperty("供应商名称")
	private String supplierName;

	@ApiModelProperty("账号")
	private String account;

	@ApiModelProperty("用户登录名")
	private String username;

	@ApiModelProperty("密码")
	private String password;

	@ApiModelProperty("盐值")
	private String salt;

	@ApiModelProperty("联系人姓名")
	private String name;

	@ApiModelProperty("联系人手机")
	private String mobile;

	@ApiModelProperty("联系人邮箱")
	private String email;

	@ApiModelProperty("账号等级")
	private String accountLevel;

	@ApiModelProperty("登录token")
	private String token;

	@ApiModelProperty("公司自定义域名后缀")
	private String domain;

	@ApiModelProperty("权限")
	private String accessIds;

	@ApiModelProperty("是否在线（0：离线；1：在线）")
	private Integer isOnline;

	@ApiModelProperty("状态（0：正常；1：冻结；2：作废）")
	private Integer status;

	@ApiModelProperty("登录次数")
	private Integer loginCount;

	@ApiModelProperty("上次登录时间")
	private Date lastLoginTime;

	@ApiModelProperty("头像")
	private String icon;
}
