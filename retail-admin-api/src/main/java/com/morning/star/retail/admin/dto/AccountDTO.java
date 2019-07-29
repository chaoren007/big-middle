package com.morning.star.retail.admin.dto;


import com.morning.star.retail.admin.enums.AccountLevelEnum;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@ApiModel
@Data
public class AccountDTO implements Serializable {

	private static final long serialVersionUID = 1111320370190733557L;

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

	@ApiModelProperty("账号等级名")
	private String accountLevelStr;

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

	@ApiModelProperty("折扣")
	private Integer discount;

	@ApiModelProperty("创建时间")
	private Date createTime;

	@ApiModelProperty("头像")
	private String icon;

	public String getAccountLevelStr() {
		return AccountLevelEnum.getByCode(this.accountLevel).getDesc();
	}
}
