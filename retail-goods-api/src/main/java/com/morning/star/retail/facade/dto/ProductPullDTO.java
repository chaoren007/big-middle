package com.morning.star.retail.facade.dto;


import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.List;

@ApiModel
public class ProductPullDTO implements Serializable {
	private static final long serialVersionUID = 735382006815547012L;

	@NotNull(message = "SAP编码不能为空")
	@ApiModelProperty(value = "SAP货品编码集合")
	private List<String> sapProductCodes;

	@ApiModelProperty(value = "分类ID")
	private Long categoryId;

	@ApiModelProperty(value = "集团编码", hidden = true)
	private String groupCode;

	@NotNull(message = "生鲜类型不能为空：0,普通商品;1,称重管重量；2,称重不管重量;3,计件")
	@ApiModelProperty(value = "生鲜类型，0,普通商品;1,称重管重量；2,称重不管重量;3,计件")
	private Integer freshType;

	public List<String> getSapProductCodes() {
		return sapProductCodes;
	}

	public void setSapProductCodes(List<String> sapProductCodes) {
		this.sapProductCodes = sapProductCodes;
	}

	public Long getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(Long categoryId) {
		this.categoryId = categoryId;
	}

	public String getGroupCode() {
		return groupCode;
	}

	public void setGroupCode(String groupCode) {
		this.groupCode = groupCode;
	}

	public Integer getFreshType() {
		return freshType;
	}

	public void setFreshType(Integer freshType) {
		this.freshType = freshType;
	}
}
