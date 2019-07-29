package com.morning.star.retail.facade.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 * 外部服务分类dto
 * @author kimhuhg
 */
@ApiModel
public class CategoryWmsDTO implements Serializable {
    private static final long serialVersionUID = 735382006815547012L;
    @ApiModelProperty(required = true, value = "分类id")
    @NotNull(message = "分类id分类不能为空")
    private Long categoryId;

    @ApiModelProperty(required = true, value = "分类名称")
    @NotNull(message = "分类名称不能为空")
    private String categoryName;

    public Long getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Long categoryId) {
        this.categoryId = categoryId;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }
}
