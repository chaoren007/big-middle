package com.morning.star.retail.stock.bean;

import java.math.BigDecimal;
import java.util.Date;

import org.apache.commons.lang3.StringUtils;

import com.morning.star.retail.stock.bo.ItemInBO;
import com.morning.star.retail.stock.bo.ItemOutBO;
import com.morning.star.retail.stock.bo.OperatorBO;
import com.morning.star.retail.stock.bo.WarehouseBO;
import com.morning.star.retail.stock.enums.StockDetailStatus;
import com.morning.star.retail.util.UniqueNoUtils;

/**
 * 库存明细
 * 
 * @author Tim
 *
 */
public class StockDetailDO {

    private Integer findex;
    private String id;                  // 明细编号
    private int status;   // 明细状态
    private String companyCode;         // 总部编号
    private String goodsName;           // 货品名称
    private String goodsId;             // 货品编号
    private String goodsUnit;           // 货品计量单位
    private String goodsSpec;           // 货品规格
    private String serialId;            // 序列号
    private String barCode;             // 条形码
    private String purchaseId;          // 采购单号
    private String replenishId;         // 补货单号
    private BigDecimal purchasePrice;   // 采购价格
    private String inId;                // 入库单号
    private int inType;     // 入库类型
    private String inOperator;          // 入库人
    private String inOperatorName;      // 入库人名称
    private Date inTime;                // 入库时间
    private String orderId;             // 订单号
    private String logisticsId;         // 物流单号
    private BigDecimal sellingPrice;    // 出库价格
    private BigDecimal salesPrice;      // 销售指导价
    private int outType;   // 出库类型
    private String outOperator;         // 出库人
    private String outOperatorName;     // 出库人名称
    private Date outTime;               // 出库时间
    private String provider;            // 供应商
    private String providerName;        // 供应商名称
    private String warehouseId;         // 门店编号
    private String operator;            // 操作人
    private String operatorName;        // 操作人名称
    private Date createTime;            // 创建时间
    private Date modifyTime;            // 修改时间
    
    /**
     * 创建明细
     * @param warehouseBO
     * @param itemInBO
     * @param operatorBO
     * @param inType
     * @return
     */
    public static StockDetailDO create(String companyCode, WarehouseBO warehouseBO, ItemInBO itemInBO, OperatorBO operatorBO, int inType) {
        Date now = new Date();
        
        StockDetailDO stockDetailDO = new StockDetailDO();
        stockDetailDO.setId(UniqueNoUtils.next());
        stockDetailDO.setCompanyCode(companyCode);
        stockDetailDO.setBarCode(itemInBO.getBarCode());
        stockDetailDO.setGoodsId(itemInBO.getGoodsId());
        stockDetailDO.setGoodsName(itemInBO.getGoodsName());
        stockDetailDO.setGoodsSpec(itemInBO.getGoodsSpec());
        stockDetailDO.setGoodsUnit(itemInBO.getGoodsUnit());
        stockDetailDO.setProvider(itemInBO.getProvider());
        stockDetailDO.setProviderName(itemInBO.getProviderName());
        stockDetailDO.setPurchaseId(itemInBO.getPurchaseId());
        stockDetailDO.setPurchasePrice(itemInBO.getPurchasePrice());
        stockDetailDO.setReplenishId(itemInBO.getReplenishId());
        stockDetailDO.setSerialId(StringUtils.isNotBlank(itemInBO.getSerialId()) ? itemInBO.getSerialId() : UniqueNoUtils.next());
        stockDetailDO.setInId(itemInBO.getInId());
        stockDetailDO.setInOperator(operatorBO.getId());
        stockDetailDO.setInOperatorName(operatorBO.getName());
        stockDetailDO.setInTime(now);
        stockDetailDO.setInType(inType);
        
        stockDetailDO.setCreateTime(now);
        stockDetailDO.setModifyTime(now);
        stockDetailDO.setOperator(operatorBO.getId());
        stockDetailDO.setOperatorName(operatorBO.getName());
        stockDetailDO.setStatus(StockDetailStatus.IN);
        stockDetailDO.setWarehouseId(warehouseBO.getId());
        return stockDetailDO;
    }
    
    /**
     * 更新入库信息
     * @param itemInBO
     * @param operatorBO
     * @param inType
     * @return
     */
    public StockDetailDO update(ItemInBO itemInBO, OperatorBO operatorBO, int inType) {
        Date now = new Date();
        
        this.setBarCode(itemInBO.getBarCode());
        this.setPurchaseId(itemInBO.getPurchaseId());
        this.setPurchasePrice(itemInBO.getPurchasePrice());
        this.setReplenishId(itemInBO.getReplenishId());
        this.setInId(itemInBO.getInId());
        this.setInOperator(operatorBO.getId());
        this.setInOperatorName(operatorBO.getName());
        this.setInTime(now);
        this.setInType(inType);
        
        this.setModifyTime(now);
        this.setOperator(operatorBO.getId());
        this.setOperatorName(operatorBO.getName());
        this.setStatus(StockDetailStatus.IN);
//        this.setProvider(itemInBO.getProvider());
//        this.setProviderName(itemInBO.getProviderName());
//        this.setSerialId(itemInBO.getSerialId());
        return this;
    }
    
    /**
     * 更新出库信息
     * @param itemOutBO
     * @param operatorBO
     * @param outType
     * @return
     */
    public StockDetailDO update(ItemOutBO itemOutBO, OperatorBO operatorBO, int outType) {
        Date now = new Date();
        
        this.setBarCode(itemOutBO.getBarCode());
        this.setSalesPrice(itemOutBO.getSalesPrice());
        this.setSellingPrice(itemOutBO.getSellingPrice());
        this.setLogisticsId(itemOutBO.getLogisticsId());
        this.setOrderId(itemOutBO.getOrderId());
        this.setOutOperator(operatorBO.getId());
        this.setOutOperatorName(operatorBO.getName());
        this.setOutTime(now);
        this.setOutType(outType);
        
        this.setModifyTime(now);
        this.setOperator(operatorBO.getId());
        this.setOperatorName(operatorBO.getName());
        this.setStatus(StockDetailStatus.OUT);
        return this;
    }

    public Integer getFindex() {
        return findex;
    }

    public void setFindex(Integer findex) {
        this.findex = findex;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getGoodsName() {
        return goodsName;
    }

    public void setGoodsName(String goodsName) {
        this.goodsName = goodsName;
    }

    public String getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(String goodsId) {
        this.goodsId = goodsId;
    }

    public String getGoodsUnit() {
        return goodsUnit;
    }

    public void setGoodsUnit(String goodsUnit) {
        this.goodsUnit = goodsUnit;
    }

    public String getGoodsSpec() {
        return goodsSpec;
    }

    public void setGoodsSpec(String goodsSpec) {
        this.goodsSpec = goodsSpec;
    }

    public String getSerialId() {
        return serialId;
    }

    public void setSerialId(String serialId) {
        this.serialId = serialId;
    }

    public String getBarCode() {
        return barCode;
    }

    public void setBarCode(String barCode) {
        this.barCode = barCode;
    }

    public String getPurchaseId() {
        return purchaseId;
    }

    public void setPurchaseId(String purchaseId) {
        this.purchaseId = purchaseId;
    }

    public String getReplenishId() {
        return replenishId;
    }

    public void setReplenishId(String replenishId) {
        this.replenishId = replenishId;
    }

    public BigDecimal getPurchasePrice() {
        return purchasePrice;
    }

    public void setPurchasePrice(BigDecimal purchasePrice) {
        this.purchasePrice = purchasePrice;
    }

    public String getInId() {
        return inId;
    }

    public void setInId(String inId) {
        this.inId = inId;
    }

    public int getInType() {
        return inType;
    }

    public void setInType(int inType) {
        this.inType = inType;
    }

    public String getInOperator() {
        return inOperator;
    }

    public void setInOperator(String inOperator) {
        this.inOperator = inOperator;
    }

    public String getInOperatorName() {
        return inOperatorName;
    }

    public void setInOperatorName(String inOperatorName) {
        this.inOperatorName = inOperatorName;
    }

    public Date getInTime() {
        return inTime;
    }

    public void setInTime(Date inTime) {
        this.inTime = inTime;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public String getLogisticsId() {
        return logisticsId;
    }

    public void setLogisticsId(String logisticsId) {
        this.logisticsId = logisticsId;
    }

    public BigDecimal getSellingPrice() {
        return sellingPrice;
    }

    public void setSellingPrice(BigDecimal sellingPrice) {
        this.sellingPrice = sellingPrice;
    }

    public BigDecimal getSalesPrice() {
        return salesPrice;
    }

    public void setSalesPrice(BigDecimal salesPrice) {
        this.salesPrice = salesPrice;
    }

    public int getOutType() {
        return outType;
    }

    public void setOutType(int outType) {
        this.outType = outType;
    }

    public String getOutOperator() {
        return outOperator;
    }

    public void setOutOperator(String outOperator) {
        this.outOperator = outOperator;
    }

    public String getOutOperatorName() {
        return outOperatorName;
    }

    public void setOutOperatorName(String outOperatorName) {
        this.outOperatorName = outOperatorName;
    }

    public Date getOutTime() {
        return outTime;
    }

    public void setOutTime(Date outTime) {
        this.outTime = outTime;
    }

    public String getProvider() {
        return provider;
    }

    public void setProvider(String provider) {
        this.provider = provider;
    }

    public String getProviderName() {
        return providerName;
    }

    public void setProviderName(String providerName) {
        this.providerName = providerName;
    }

    public String getWarehouseId() {
        return warehouseId;
    }

    public void setWarehouseId(String warehouseId) {
        this.warehouseId = warehouseId;
    }

    public String getOperator() {
        return operator;
    }

    public void setOperator(String operator) {
        this.operator = operator;
    }

    public String getOperatorName() {
        return operatorName;
    }

    public void setOperatorName(String operatorName) {
        this.operatorName = operatorName;
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

    public String getCompanyCode() {
        return companyCode;
    }

    public void setCompanyCode(String companyCode) {
        this.companyCode = companyCode;
    }

    @Override
    public String toString() {
        return "StockDetailDO [findex=" + findex + ", id=" + id + ", status=" + status + ", goodsName=" + goodsName
                + ", goodsId=" + goodsId + ", goodsUnit=" + goodsUnit + ", goodsSpec=" + goodsSpec + ", serialId="
                + serialId + ", barCode=" + barCode + ", purchaseId=" + purchaseId + ", replenishId=" + replenishId
                + ", purchasePrice=" + purchasePrice + ", inId=" + inId + ", inType=" + inType + ", inOperator="
                + inOperator + ", inOperatorName=" + inOperatorName + ", inTime=" + inTime + ", orderId=" + orderId
                + ", logisticsId=" + logisticsId + ", sellingPrice=" + sellingPrice + ", salesPrice=" + salesPrice
                + ", outType=" + outType + ", outOperator=" + outOperator + ", outOperatorName=" + outOperatorName
                + ", outTime=" + outTime + ", provider=" + provider + ", providerName=" + providerName
                + ", warehouseId=" + warehouseId + ", operator=" + operator + ", operatorName=" + operatorName
                + ", createTime=" + createTime + ", modifyTime=" + modifyTime + "]";
    }

}
