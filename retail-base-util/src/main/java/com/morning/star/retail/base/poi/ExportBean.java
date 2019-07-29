package com.morning.star.retail.base.poi;

import java.io.Serializable;

/**
 * 导出参数
 *
 * @author jiangyf
 * @date 2017年6月10日 上午11:16:03
 */
public class ExportBean implements Serializable {
    private static final long serialVersionUID = -8626537222810407905L;

    /**
     * 公司编码
     */
    private String companyCode;
    /**
     * 记录ID（逗号隔开）
     */
    private String recordIds;
    /**
     * 第几页
     */
    private Integer pageNo;
    /**
     * 每页记录数
     */
    private Integer pageSize;

    public String getCompanyCode() {
        return companyCode;
    }

    public void setCompanyCode(String companyCode) {
        this.companyCode = companyCode;
    }

    public String getRecordIds() {
        return recordIds;
    }

    public void setRecordIds(String recordIds) {
        this.recordIds = recordIds;
    }

    public Integer getPageNo() {
        return pageNo;
    }

    public void setPageNo(Integer pageNo) {
        this.pageNo = pageNo;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public ExportBean() {
    }

    public ExportBean(String companyCode, String recordIds, Integer pageNo,
                      Integer pageSize) {
        this.companyCode = companyCode;
        this.recordIds = recordIds;
        this.pageNo = pageNo;
        this.pageSize = pageSize;
    }

    public static ExportBean getInstance(String companyCode, String recordIds,
                                         Integer pageNo, Integer pageSize) {
        return new ExportBean(companyCode, recordIds, pageNo, pageSize);
    }
}
