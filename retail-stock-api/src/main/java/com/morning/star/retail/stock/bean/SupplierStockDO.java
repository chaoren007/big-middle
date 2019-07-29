package com.morning.star.retail.stock.bean;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * 供应商库存
 *
 * @author jiangyf
 */
public class SupplierStockDO implements Serializable {
    private static final long serialVersionUID = 6350017873635373132L;

    /**
     * 记录ID
     */
    private Integer id;

    /**
     * 公司编码
     */
    private String companyCode;

    /**
     * 门店编码
     */
    private String storeCode;

    /**
     * 货品编码
     */
    private String goodsCode;

    /**
     * 货品名称
     */
    private String goodsName;

    /**
     * 供应商编码
     */
    private String supplierCode;

    /**
     * 供应商名称
     */
    private String supplierName;

    /**
     * 条形码
     */
    private String upcCode;

    /**
     * 销售类型（0：自营；1：代销）
     */
    private Integer salesType;

    /**
     * 在库数量
     */
    private BigDecimal doneInStockNum;

    /**
     * 可售数量
     */
    private BigDecimal usedStockNum;

    /**
     * 待入数量（采购，补货）
     */
    private BigDecimal waitInStockNum;

    /**
     * 占用数量（订单）
     */
    private BigDecimal preStockNum;

    /**
     * 待出数量（订单）
     */
    private BigDecimal waitOutStockNum;

    /**
     * 已出数量（订单）
     */
    private BigDecimal doneOutStockNum;

    /**
     * 计量单位（如：个）
     */
    private String units;

    /**
     * 货品类型 SP-单品,PP-套装
     */
    private String goodsType;

    /**
     * 包装容量
     */
    private Integer specNum;

    /**
     * 包装容量单位（如：箱）
     */
    private String specUnits;

    /**
     * 删除标记，0：正常；1：删除
     */
    private Integer deleteFlag;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 修改时间
     */
    private Date modifyTime;

    /**
     * 操作人ID
     */
    private Integer operatorId;

    /**
     * 操作人姓名
     */
    private String operatorName;

    /**
     * 详情备注
     */
    private String remark;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

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

    public String getGoodsCode() {
        return goodsCode;
    }

    public void setGoodsCode(String goodsCode) {
        this.goodsCode = goodsCode;
    }

    public String getGoodsName() {
        return goodsName;
    }

    public void setGoodsName(String goodsName) {
        this.goodsName = goodsName;
    }

    public String getSupplierCode() {
        return supplierCode;
    }

    public void setSupplierCode(String supplierCode) {
        this.supplierCode = supplierCode;
    }

    public String getSupplierName() {
        return supplierName;
    }

    public void setSupplierName(String supplierName) {
        this.supplierName = supplierName;
    }

    public String getUpcCode() {
        return upcCode;
    }

    public void setUpcCode(String upcCode) {
        this.upcCode = upcCode;
    }

    public Integer getSalesType() {
        return salesType;
    }

    public void setSalesType(Integer salesType) {
        this.salesType = salesType;
    }

    public BigDecimal getDoneInStockNum() {
        return doneInStockNum;
    }

    public void setDoneInStockNum(BigDecimal doneInStockNum) {
        this.doneInStockNum = doneInStockNum;
    }

    public BigDecimal getUsedStockNum() {
        return usedStockNum;
    }

    public void setUsedStockNum(BigDecimal usedStockNum) {
        this.usedStockNum = usedStockNum;
    }

    public BigDecimal getWaitInStockNum() {
        return waitInStockNum;
    }

    public void setWaitInStockNum(BigDecimal waitInStockNum) {
        this.waitInStockNum = waitInStockNum;
    }

    public BigDecimal getPreStockNum() {
        return preStockNum;
    }

    public void setPreStockNum(BigDecimal preStockNum) {
        this.preStockNum = preStockNum;
    }

    public BigDecimal getWaitOutStockNum() {
        return waitOutStockNum;
    }

    public void setWaitOutStockNum(BigDecimal waitOutStockNum) {
        this.waitOutStockNum = waitOutStockNum;
    }

    public BigDecimal getDoneOutStockNum() {
        return doneOutStockNum;
    }

    public void setDoneOutStockNum(BigDecimal doneOutStockNum) {
        this.doneOutStockNum = doneOutStockNum;
    }

    public String getUnits() {
        return units;
    }

    public void setUnits(String units) {
        this.units = units;
    }

    public String getGoodsType() {
        return goodsType;
    }

    public void setGoodsType(String goodsType) {
        this.goodsType = goodsType;
    }

    public Integer getSpecNum() {
        return specNum;
    }

    public void setSpecNum(Integer specNum) {
        this.specNum = specNum;
    }

    public String getSpecUnits() {
        return specUnits;
    }

    public void setSpecUnits(String specUnits) {
        this.specUnits = specUnits;
    }

    public Integer getDeleteFlag() {
        return deleteFlag;
    }

    public void setDeleteFlag(Integer deleteFlag) {
        this.deleteFlag = deleteFlag;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getModifyTime() {
        return modifyTime;
    }

    public void setModifyTime(Date modifyTime) {
        this.modifyTime = modifyTime;
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

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }
}