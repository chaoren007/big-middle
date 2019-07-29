package com.morning.star.retail.facade.dto;

import io.swagger.annotations.ApiModelProperty;
import org.hibernate.validator.constraints.Range;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.util.List;

/**
 * WMS 入库单
 *
 * @author jiangyf
 */
public class WMSReceiptAddDTO {
    private static final long serialVersionUID = 1L;

    @ApiModelProperty(required = true, value = "入库编号")
    @NotNull(message = "入库编号不能为空")
    private String code;

    @ApiModelProperty(required = true, value = "关联单号")
    @NotNull(message = "关联单号不能为空")
    private String tcode;

    @ApiModelProperty(required = true, value = "仓库编号")
    @NotNull(message = "仓库编号不能为空")
    private String wcode;

    @ApiModelProperty(required = true, value = "供应商编号")
    private String scode;

    @ApiModelProperty(required = true, value = "备注")
    private String desc;

    @ApiModelProperty(required = true, value = "入库类型（1-采购入库，2-销售退货入库）")
    @NotNull(message = "入库类型不能为空")
    @Range(min=1, max=2)
    private Integer type;

    @Valid
    @NotNull(message = "入库详情detail不能为空")
    private List<WMSReceiptAddItemDTO> detail;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getTcode() {
        return tcode;
    }

    public void setTcode(String tcode) {
        this.tcode = tcode;
    }

    public String getWcode() {
        return wcode;
    }

    public void setWcode(String wcode) {
        this.wcode = wcode;
    }

    public String getScode() {
        return scode;
    }

    public void setScode(String scode) {
        this.scode = scode;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public List<WMSReceiptAddItemDTO> getDetail() {
        return detail;
    }

    public void setDetail(List<WMSReceiptAddItemDTO> detail) {
        this.detail = detail;
    }
}
