package com.morning.star.retail.admin.dto;

import com.morning.star.retail.validate.CreateGroup;
import com.morning.star.retail.validate.ModifyGroup;

import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.List;

/**
 * 模块
 * 
 * @author jiangyf
 * @date 2017年10月17日 下午6:15:00
 */
public class ModePermDTO implements Serializable {
	private static final long serialVersionUID = -1283820326793052044L;

	/**
	 * 权限id
	 */
	@NotNull(message = "不能为空", groups = { CreateGroup.class, ModifyGroup.class })
	private Long permId;

	/**
	 * 子权限id
	 */
	@NotNull(message = "不能为空", groups = { CreateGroup.class, ModifyGroup.class })
	private List<Long> methodPerms;

	public Long getPermId() {
		return permId;
	}

	public void setPermId(Long permId) {
		this.permId = permId;
	}

	public List<Long> getMethodPerms() {
		return methodPerms;
	}

	public void setMethodPerms(List<Long> methodPerms) {
		this.methodPerms = methodPerms;
	}

}
