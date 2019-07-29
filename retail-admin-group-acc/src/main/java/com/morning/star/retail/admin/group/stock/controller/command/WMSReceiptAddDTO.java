package com.morning.star.retail.admin.group.stock.controller.command;

import java.util.List;

/**
 * WMS 入库单
 *
 * @author jiangyf
 */
public class WMSReceiptAddDTO {
    private static final long serialVersionUID = 1L;

    /**
     * 入库编号
     */
    private String code;
    /**
     * 关联单号（采购入库单号）
     */
    private String tcode;
    /**
     * 仓库编号
     */
    private String wcode;
    /**
     * 供应商编号
     */
    private String scode;
    /**
     * 备注
     */
    private String desc;
    /**
     * 本次请求唯一标识，请求成功后返回值把会这个带回来
     */
    private String tagId;
    /**
     * 入库明细
     */
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

    public String getTagId() {
        return tagId;
    }

    public void setTagId(String tagId) {
        this.tagId = tagId;
    }

    public List<WMSReceiptAddItemDTO> getDetail() {
        return detail;
    }

    public void setDetail(List<WMSReceiptAddItemDTO> detail) {
        this.detail = detail;
    }
}
