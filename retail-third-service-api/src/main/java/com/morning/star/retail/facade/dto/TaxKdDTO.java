package com.morning.star.retail.facade.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 * 外部服务分类dto
 *
 * @author kimhuhg
 */
@ApiModel
public class TaxKdDTO implements Serializable {
    private static final long serialVersionUID = 735382006815547012L;
    @ApiModelProperty(required = true, value = "单位名称")
    @NotNull(message = "名称不能为空")
    private String taxName;
    @ApiModelProperty(required = true, value = "税率")
    @NotNull(message = "税率不能为空")
    private Integer fTaxRate;
    @ApiModelProperty(required = true, value = "单位名称")
    @NotNull(message = "开始时间")
    private String fEffectiveDate;
    @ApiModelProperty(required = true, value = "单位名称")
    @NotNull(message = "结束时间")
    private String fExpiryDate;
    @ApiModelProperty(required = true, value = "单位名称")
    @NotNull(message = "是否开增值税发票 1是")
    private String fMakeVatInvoice;

    /**
     *
     * @param taxName 税种名称
     * @param fEffectiveDate 生效时间
     * @param fExpiryDate 失效时间
     */
    public TaxKdDTO(String taxName, String fEffectiveDate, String fExpiryDate) {
        this.taxName = taxName;
        this.fEffectiveDate = fEffectiveDate;
        this.fExpiryDate = fExpiryDate;
    }

    /**
     *
     * @param taxName 税率名称
     * @param fTaxRate 税率
     * @param fEffectiveDate 生效时间
     * @param fExpiryDate 失效时间
     * @param fMakeVatInvoice 是否增值税 1为是
     */
    public TaxKdDTO(String taxName,Integer fTaxRate,String fEffectiveDate, String fExpiryDate, String fMakeVatInvoice) {
        this.taxName = taxName;
        this.fTaxRate = fTaxRate;
        this.fEffectiveDate = fEffectiveDate;
        this.fExpiryDate = fExpiryDate;
        this.fMakeVatInvoice = fMakeVatInvoice;
    }

    public TaxKdDTO() {
    }

    public Integer getfTaxRate() {
        return fTaxRate;
    }

    public void setfTaxRate(Integer fTaxRate) {
        this.fTaxRate = fTaxRate;
    }
    public String getTaxName() {
        return taxName;
    }

    public void setTaxName(String taxName) {
        this.taxName = taxName;
    }

    public String getfEffectiveDate() {
        return fEffectiveDate;
    }

    public void setfEffectiveDate(String fEffectiveDate) {
        this.fEffectiveDate = fEffectiveDate;
    }

    public String getfExpiryDate() {
        return fExpiryDate;
    }

    public void setfExpiryDate(String fExpiryDate) {
        this.fExpiryDate = fExpiryDate;
    }

    public String getfMakeVatInvoice() {
        return fMakeVatInvoice;
    }

    public void setfMakeVatInvoice(String fMakeVatInvoice) {
        this.fMakeVatInvoice = fMakeVatInvoice;
    }
}
