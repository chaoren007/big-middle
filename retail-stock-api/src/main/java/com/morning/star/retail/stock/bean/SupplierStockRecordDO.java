package com.morning.star.retail.stock.bean;

import com.morning.star.retail.objectcopier.ObjectCopier;
import com.morning.star.retail.stock.enums.StockRecordTypeEnum;
import com.morning.star.retail.stock.po.SupplierStockPO;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;


/**
 * 供应商库存流水
 *
 * @author jiangyf
 */
public class SupplierStockRecordDO implements Serializable {
    private static final long serialVersionUID = 7325472769868093502L;

    /**
     * 库存流水
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
     * 库存流水单号(如：订单编号，补货编号等)
     */
    private String orderCode;

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
     * 货品数量
     */
    private BigDecimal num;

    /**
     * upc单位
     */
    private String units;

    /**
     * 待入数量（采购，补货）
     */
    private BigDecimal waitInStockNum;

    /**
     * 在库数量
     */
    private BigDecimal doneInStockNum;

    /**
     * 可售数量
     */
    private BigDecimal usedStockNum;

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
     * 类型(ONLINE_PRE：线上预占库存；ONLINE_FREE：线上释放库存；ONLINE_OUT：线上销售出库；OFFLINE_OUT：线下销售出库；MANUAL_OUT：人工手动出库；RETURN_IN：退货供应商出库；WASTE_OUT：货品折损出库；PURCHASE_IN：门店采购入库；REPLENISH_IN：总部补货入库；MANUAL_IN：人工手动入库；REJECT_IN：客户拒收入库；RETURN_IN：客户退货入库)
     */
    private String type;

    /**
     * 流水单状态，WAITPAY：待支付；PAYED：已支付；PICKING：拣货中；SHIPPED：已发货；SIGNED：已签收；CANCEL：已取消；OVERTIMECANCEL：超时取消；AFTERSERVICE：售后；
     */
    private String status;

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

    public static SupplierStockRecordDO from(SupplierStockPO supplierStockPO, String orderCode, BigDecimal num, StockRecordTypeEnum type, String status) {
        SupplierStockRecordDO stockRecordDO = ObjectCopier.copyObject(SupplierStockRecordDO.class, supplierStockPO);
        stockRecordDO.setId(null);
        stockRecordDO.setOrderCode(orderCode);
        stockRecordDO.setNum(num);
        stockRecordDO.setType(type.getCode());
        stockRecordDO.setStatus(status);
        return stockRecordDO;
    }

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

    public String getOrderCode() {
        return orderCode;
    }

    public void setOrderCode(String orderCode) {
        this.orderCode = orderCode;
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

    public BigDecimal getNum() {
        return num;
    }

    public void setNum(BigDecimal num) {
        this.num = num;
    }

    public String getUnits() {
        return units;
    }

    public void setUnits(String units) {
        this.units = units;
    }

    public BigDecimal getWaitInStockNum() {
        return waitInStockNum;
    }

    public void setWaitInStockNum(BigDecimal waitInStockNum) {
        this.waitInStockNum = waitInStockNum;
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

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
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
}