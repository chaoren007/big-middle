package com.morning.star.retail.base.poi;

import java.io.Serializable;

/**
 * excel导入失败详情
 *
 * @author jiangyf
 * @date 2017年5月22日 下午3:10:20
 */
public class ImportDetailBean implements Serializable {
    private static final long serialVersionUID = -5973588763774695232L;

    /**
     * 位于Excel中第几行
     */
    private Integer row;
    /**
     * 位于Excel中第几列
     */
    private Integer column;
    /**
     * 失败原因
     */
    private String remark;

    public Integer getRow() {
        return row;
    }

    public void setRow(Integer row) {
        this.row = row;
    }

    public Integer getColumn() {
        return column;
    }

    public void setColumn(Integer column) {
        this.column = column;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public ImportDetailBean() {
    }

    public ImportDetailBean(Integer row, Integer column, String remark) {
        this.row = row;
        this.column = column;
        this.remark = remark;
    }

    /**
     * 获取实例
     *
     * @param row
     * @param column
     * @param remark
     * @return
     */
    public static ImportDetailBean getInstance(Integer row, Integer column,
                                               String remark) {
        return new ImportDetailBean(row, column, remark);
    }

}
