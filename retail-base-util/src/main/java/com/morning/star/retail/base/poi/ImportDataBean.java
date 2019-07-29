package com.morning.star.retail.base.poi;

import java.io.Serializable;

import org.springframework.web.multipart.MultipartFile;

/**
 * excel导入数据
 *
 * @author jiangyf
 * @date 2017年5月22日 下午3:33:34
 */
public class ImportDataBean implements Serializable {
    private static final long serialVersionUID = 8723128122377609523L;

    /**
     * 公司编码
     */
    private String companyCode;
    /**
     * 门店编码
     */
    private String storeCode;
    /**
     * 导入文件
     */
    private MultipartFile importFile;
    /**
     * 操作人ID
     */
    private Integer operatorId;
    /**
     * 操作人名称
     */
    private String operatorName;

    public String getCompanyCode() {
        return companyCode;
    }

    public void setCompanyCode(String companyCode) {
        this.companyCode = companyCode;
    }

    public String getStoreCode() {
        return storeCode;
    }

    public void setStoreCode(String storeCode) {
        this.storeCode = storeCode;
    }

    public MultipartFile getImportFile() {
        return importFile;
    }

    public void setImportFile(MultipartFile importFile) {
        this.importFile = importFile;
    }

    public Integer getOperatorId() {
        return operatorId;
    }

    public void setOperatorId(Integer operatorId) {
        this.operatorId = operatorId;
    }

    public String getOperatorName() {
        return operatorName;
    }

    public void setOperatorName(String operatorName) {
        this.operatorName = operatorName;
    }

    public ImportDataBean() {
    }

    public ImportDataBean(String companyCode, String storeCode,
                          MultipartFile importFile, Integer operatorId, String operatorName) {
        super();
        this.companyCode = companyCode;
        this.storeCode = storeCode;
        this.importFile = importFile;
        this.operatorId = operatorId;
        this.operatorName = operatorName;
    }

    /**
     * 获取实例
     *
     * @param companyCode
     * @param storeCode
     * @param importFile
     * @param operatorId
     * @param operatorName
     * @return
     */
    public static ImportDataBean getInstance(String companyCode,
                                             String storeCode, MultipartFile importFile, Integer operatorId,
                                             String operatorName) {
        return new ImportDataBean(companyCode, storeCode, importFile,
                operatorId, operatorName);
    }

}
