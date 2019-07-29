package com.morning.star.retail.facade.dto;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import io.swagger.annotations.ApiModel;
@ApiModel
public class CategoryDTO implements Serializable, Comparable<CategoryDTO> {
    private static final long serialVersionUID = 179038923113779970L;
    private Long categoryId;
    private Integer clevel;
    private Long parentId;
    private String categoryName;
    private Integer weight;
    private String url;
    private Integer sort;
    private Date createTime;
    private Date modifyTime;
    private Long operatorId;
    private String operatorName;
    private List<CategoryPropertyDTO> properties;
    private BigDecimal maxCommission;
    private BigDecimal minCommission;
    List<CategoryDTO> childs;

    @Override
    public int compareTo(CategoryDTO o) {
        return (this.getSort() - o.getSort()) >= 0 ? 1 : 0;
    }


    public BigDecimal getMaxCommission() {
        return maxCommission;
    }

    public void setMaxCommission(BigDecimal maxCommission) {
        this.maxCommission = maxCommission;
    }

    public BigDecimal getMinCommission() {
        return minCommission;
    }

    public void setMinCommission(BigDecimal minCommission) {
        this.minCommission = minCommission;
    }

    public List<CategoryPropertyDTO> getProperties() {
        return properties;
    }

    public void setProperties(List<CategoryPropertyDTO> properties) {
        this.properties = properties;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Long getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Long categoryId) {
        this.categoryId = categoryId;
    }

    public Integer getClevel() {
		return clevel;
	}

	public void setClevel(Integer clevel) {
		this.clevel = clevel;
	}



	public void setParentId(Long parentId) {
		this.parentId = parentId;
	}

	public void setWeight(Integer weight) {
		this.weight = weight;
	}

	public void setSort(Integer sort) {
		this.sort = sort;
	}

	public void setOperatorId(Long operatorId) {
		this.operatorId = operatorId;
	}

	public Long getParentId() {
        return parentId;
    }

    public void setParentId(long parentId) {
        this.parentId = parentId;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public Integer getSort() {
        return sort;
    }

    public void setSort(int sort) {
        this.sort = sort;
    }

  

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getModifyTime() {
        return modifyTime;
    }

    public void setModifyTime(Date modifyTime) {
        this.modifyTime = modifyTime;
    }

    public String getOperatorName() {
        return operatorName;
    }

    public void setOperatorName(String operatorName) {
        this.operatorName = operatorName;
    }

    public Long getOperatorId() {
        return operatorId;
    }

    public void setOperatorId(long operatorId) {
        this.operatorId = operatorId;
    }

    public List<CategoryDTO> getChilds() {
        return childs;
    }

    public void setChilds(List<CategoryDTO> childs) {
        this.childs = childs;
    }

   

    public Integer getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }


}
