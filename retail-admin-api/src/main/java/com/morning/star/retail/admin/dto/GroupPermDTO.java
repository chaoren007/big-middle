package com.morning.star.retail.admin.dto;

import com.morning.star.retail.validate.CreateGroup;
import com.morning.star.retail.validate.ModifyGroup;

import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.List;

/**
 * 分组
 *
 * @author jiangyf
 * @date 2017年10月17日 下午5:38:08
 */
public class GroupPermDTO implements Serializable {
	private static final long serialVersionUID = 4999826848578987787L;

	/**
	 * 权限id
	 */
	@NotNull(message = "不能为空", groups = { CreateGroup.class, ModifyGroup.class })
	private Long permId;

	/**
	 * 模块权限id集
	 */
    @NotNull(message = "不能为空", groups = { CreateGroup.class, ModifyGroup.class })
	private List<ModePermDTO> modePerms;

	public Long getPermId() {
		return permId;
	}

	public void setPermId(Long permId) {
		this.permId = permId;
	}

	public List<ModePermDTO> getModePerms() {
		return modePerms;
	}

	public void setModePerms(List<ModePermDTO> modePerms) {
		this.modePerms = modePerms;
	}

}
