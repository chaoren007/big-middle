package com.morning.star.retail.admin.dto;

import java.io.Serializable;

/**
 * 登录账号等级
 * 
 * @author jiangyf
 * @date 2017年7月21日 下午2:58:19
 */
public class LevelDTO implements Serializable {
	private static final long serialVersionUID = -7896672240142648986L;

	private String level;
	private String desc;

	public String getLevel() {
		return level;
	}

	public void setLevel(String level) {
		this.level = level;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	public LevelDTO() {
	}

	public LevelDTO(String level, String desc) {
		this.level = level;
		this.desc = desc;
	}

	public static LevelDTO of(String level, String desc) {
		return new LevelDTO(level, desc);
	}

}
