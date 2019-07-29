package com.morning.star.retail.order.facade.dto;

import java.io.Serializable;

/**
 * 快递信息
 * @author Tim
 *
 */
public class ExpressDTO implements Serializable {

    private static final long serialVersionUID = 1L;
    
    private String code;
    private String companyCode;
    private String companyName;
    
    public ExpressDTO() {
    }

    public ExpressDTO(String code, String companyCode, String companyName) {
        this.code = code;
        this.companyCode = companyCode;
        this.companyName = companyName;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getCompanyCode() {
        return companyCode;
    }

    public void setCompanyCode(String companyCode) {
        this.companyCode = companyCode;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    
}
