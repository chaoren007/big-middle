package com.morning.star.retail.base.poi;

import java.io.Serializable;
import java.util.List;

/**
 * excel导入结果统计
 *
 * @author jiangyf
 * @date 2017年5月22日 下午3:08:38
 */
public class ImportResultBean implements Serializable {
    private static final long serialVersionUID = 4701112200317150242L;

    /**
     * 总数量
     */
    private Integer totalNum;
    /**
     * 成功数量
     */
    private Integer successNum;
    /**
     * 失败数量
     */
    private Integer failNum;
    /**
     * 失败详情
     */
    private List<ImportDetailBean> detail;

    public Integer getTotalNum() {
        return totalNum;
    }

    public void setTotalNum(Integer totalNum) {
        this.totalNum = totalNum;
    }

    public Integer getSuccessNum() {
        return successNum;
    }

    public void setSuccessNum(Integer successNum) {
        this.successNum = successNum;
    }

    public Integer getFailNum() {
        return failNum;
    }

    public void setFailNum(Integer failNum) {
        this.failNum = failNum;
    }

    public List<ImportDetailBean> getDetail() {
        return detail;
    }

    public void setDetail(List<ImportDetailBean> detail) {
        this.detail = detail;
    }

    public ImportResultBean() {
    }

    public ImportResultBean(Integer totalNum, Integer successNum,
                            Integer failNum, List<ImportDetailBean> detail) {
        this.totalNum = totalNum;
        this.successNum = successNum;
        this.failNum = failNum;
        this.detail = detail;
    }

    /**
     * 获取实例
     *
     * @param totalNum
     * @param successNum
     * @param failNum
     * @param detail
     * @return
     */
    public static ImportResultBean getInstance(Integer totalNum,
                                               Integer successNum, Integer failNum,
                                               List<ImportDetailBean> detail) {
        return new ImportResultBean(totalNum, successNum, failNum, detail);
    }

}
