package com.morning.star.retail.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@ApiModel(value = "供应商")
@Data
public class SupplierDTO implements Serializable {
    private static final long serialVersionUID = 4505193978818395702L;

    private Long id;

    @ApiModelProperty(value = "供应商编码")
    private String supplierCode;

    @ApiModelProperty(value = "供应商名称")
    private String supplierName;

    @ApiModelProperty(value = "联系人姓名")
    private String linkman;

    @ApiModelProperty(value = "联系方式")
    private String contact;

    @ApiModelProperty(value = "经营品类id")
    private Long categoryId;

    @ApiModelProperty(value = "经营品类名称")
    private String categoryName;

    @ApiModelProperty(value = "所属省份id")
    private Long provinceId;

    @ApiModelProperty(value = "所属省份名称")
    private String provinceName;

    @ApiModelProperty(value = "所属城市id")
    private Long cityId;

    @ApiModelProperty(value = "所属城市编码")
    private String cityCode;

    @ApiModelProperty(value = "所属城市名称")
    private String cityName;

    @ApiModelProperty(value = "常驻城市id")
    private Long permanentCityId;

    @ApiModelProperty(value = "常驻城市名称")
    private String permanentCityName;

    @ApiModelProperty(value = "合同年份")
    private Integer contractYear;

    @ApiModelProperty(value = "营业执照")
    private String businessLicense;

    @ApiModelProperty(value = "授权证书")
    private String authority;

    @ApiModelProperty(value = "身份证正面")
    private String idcardFront;

    @ApiModelProperty(value = "身份证背面")
    private String idcardBack;

    @ApiModelProperty(value = "创建时间")
    private Date createTime;

    @ApiModelProperty(value = "状态")
    private Integer status;

    @ApiModelProperty(value = "备注")
    private String remark;

    @ApiModelProperty(value = "供应商类型（0：总部；1：分公司）")
    private Integer type;

    @ApiModelProperty(value = "集团编码")
    private String groupCode;
}
