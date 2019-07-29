package com.morning.star.retail.stock.dto;

import com.morning.star.retail.bean.AdminLoginContent;
import com.morning.star.retail.consts.RetailDefaultConst;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.List;

@ApiModel(value = "库存-查询")
public class StockQueryDTO implements Serializable {
    private static final long serialVersionUID = -92861951599221691L;

    @ApiModelProperty(value = "集团编码")
    private String groupCode;

    @ApiModelProperty(value = "门店编码")
    private String storeCode;

    @ApiModelProperty(value = "门店名称")
    private String storeName;

    @ApiModelProperty(value = "货品编码")
    private String productCode;

    @ApiModelProperty(value = "货品编码")
    private List<String> productCodes;

    @ApiModelProperty(value = "货品名称")
    private String productName;

    @ApiModelProperty(value = "货品编码/名称")
    private String keyWord;

    @ApiModelProperty(value = "商品编码")
    private String goodsCode;

    @ApiModelProperty(value = "商品名称")
    private String goodsName;

    @ApiModelProperty(value = "条形码")
    private String upcCode;

    @ApiModelProperty("仓库编码")
    private String warehouseCode;

    @ApiModelProperty("城市id")
    private Long cityId;

    @ApiModelProperty(value = "库存状态")
    private Integer stockStatus;

    @ApiModelProperty(value = "页码")
    private Integer pageNo;

    @ApiModelProperty(value = "记录数")
    private Integer pageSize;

    public StockQueryDTO() {
    }

    public static StockQueryDTO byProductCode(String productCode, String warehouseCode) {
        StockQueryDTO stockBO = new StockQueryDTO();
        stockBO.setProductCode(productCode);
        stockBO.setWarehouseCode(warehouseCode);
        return stockBO;
    }

    public static StockQueryDTO byGoodsCode(String goodsCode, String warehouseCode) {
        StockQueryDTO stockBO = new StockQueryDTO();
        stockBO.setGoodsCode(goodsCode);
        stockBO.setWarehouseCode(warehouseCode);
        return stockBO;
    }

    public static StockQueryDTO byUpcCode(String upcCode, String warehouseCode) {
        StockQueryDTO stockBO = new StockQueryDTO();
        stockBO.setUpcCode(upcCode);
        stockBO.setWarehouseCode(warehouseCode);
        return stockBO;
    }

    public static StockQueryDTO supply(StockQueryDTO queryDTO, AdminLoginContent content) {
        queryDTO.setGroupCode(content.getGroupCode());
        queryDTO.setStoreCode(content.getStoreCode());
        return queryDTO;
    }

    public static StockQueryDTO from(String productCode, String productName, String upcCode, Integer stockStatus,
                                     Integer pageNo, Integer pageSize, AdminLoginContent content) {
        StockQueryDTO queryDTO = new StockQueryDTO();
        queryDTO.setProductCode(productCode);
        queryDTO.setProductName(productName);
        queryDTO.setUpcCode(upcCode);
        queryDTO.setStockStatus(stockStatus);
        queryDTO.setPageNo(pageNo == null ? 1 : pageNo);
        queryDTO.setPageSize(pageSize == null ? Integer.MAX_VALUE : pageSize);
        queryDTO.setGroupCode(content.getGroupCode());
        queryDTO.setStoreCode(content.getStoreCode());
        return queryDTO;
    }

    public static StockQueryDTO supply(AdminLoginContent content) {
        StockQueryDTO queryDTO = new StockQueryDTO();
        queryDTO.setGroupCode(content.getGroupCode());
        queryDTO.setStoreCode(content.getStoreCode());
        return queryDTO;
    }

    public String getGroupCode() {
        return groupCode;
    }

    public void setGroupCode(String groupCode) {
        this.groupCode = groupCode;
    }

    public String getStoreCode() {
        return storeCode;
    }

    public void setStoreCode(String storeCode) {
        this.storeCode = storeCode;
    }

    public String getStoreName() {
        return storeName;
    }

    public void setStoreName(String storeName) {
        this.storeName = storeName;
    }

    public String getProductCode() {
        return productCode;
    }

    public void setProductCode(String productCode) {
        this.productCode = productCode;
    }

    public List<String> getProductCodes() {
        return productCodes;
    }

    public void setProductCodes(List<String> productCodes) {
        this.productCodes = productCodes;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getKeyWord() {
        return keyWord;
    }

    public void setKeyWord(String keyWord) {
        this.keyWord = keyWord;
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

    public String getUpcCode() {
        return upcCode;
    }

    public void setUpcCode(String upcCode) {
        this.upcCode = upcCode;
    }

    public String getWarehouseCode() {
        return warehouseCode;
    }

    public void setWarehouseCode(String warehouseCode) {
        this.warehouseCode = warehouseCode;
    }

    public Long getCityId() {
        return cityId;
    }

    public void setCityId(Long cityId) {
        this.cityId = cityId;
    }

    public Integer getStockStatus() {
        return stockStatus;
    }

    public void setStockStatus(Integer stockStatus) {
        this.stockStatus = stockStatus;
    }

    public Integer getPageNo() {
        if (pageNo == null) {
            return 1;
        }
        return pageNo;
    }

    public void setPageNo(Integer pageNo) {
        this.pageNo = pageNo;
    }

    public Integer getPageSize() {
        if (pageSize == null) {
            return RetailDefaultConst.ADMIN_PAGE_SIZE;
        }
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }
}
