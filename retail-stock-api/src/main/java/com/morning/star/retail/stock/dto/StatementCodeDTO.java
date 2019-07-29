package com.morning.star.retail.stock.dto;

import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

/**
 * 长短单编码
 *
 * @author jiangyf
 */
public class StatementCodeDTO implements Serializable {
    private static final long serialVersionUID = -5196228839756751315L;

    @ApiModelProperty(required = true, value = "长短单编码编码")
    private String statementCode;

    public String getStatementCode() {
        return statementCode;
    }

    public void setStatementCode(String statementCode) {
        this.statementCode = statementCode;
    }
}
