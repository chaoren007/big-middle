package com.morning.star.retail.shiro.bean;

import com.morning.star.retail.shiro.token.LoginType;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * 登录用户
 *
 * @author jiangyf
 * @date 2018年7月14日 上午9:51:31
 */
@ApiModel
@Data
public class LoginUser implements Serializable {
	private static final long serialVersionUID = 509576192116214625L;

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

	private LoginType loginType;

	@ApiModelProperty("头像")
	private String icon;

	public LoginUser() {
		super();
	}

	public static LoginUser of(String username, String password) {
		LoginUser user = new LoginUser();
		user.setUsername(username);
		user.setPassword(password);
		return user;
	}

	/**
	 * 用户敏感信息过滤
	 */
	public LoginUser filter() {
		if (this != null) {
			this.password = null;
			this.salt = null;
		}
		return this;
	}
}
