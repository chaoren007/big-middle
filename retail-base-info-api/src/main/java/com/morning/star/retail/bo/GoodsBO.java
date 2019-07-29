package com.morning.star.retail.bo;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import com.morning.star.retail.bean.AdminLoginContent;
import com.morning.star.retail.consts.RetailDefaultConst;

/**
 * 货品定价
 *
 * @author jiangyf
 */
public class GoodsBO implements Serializable {
    private static final long serialVersionUID = -524682370200828118L;

    /**
     * 集团编码
     */
    private String groupCode;

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
     * 货品类型 SP-单品,PP-套装
     */
    private String goodsType;

    /**
     * 包装容量
     */
    private Integer packSpecNum;

    /**
     * 如果是单品为null，如果是套装，记录套装内对应单品的goods_code
     */
    private String unitGoodsCode;

    /**
     * 条形码
     */
    private String upcCode;
    private String goodsUpc;
    private List<String> upcCodes;

    /**
     * spu
     */
    private String spuCode;

    /**
     * 货品规格
     */
    private List<GoodsSpecBO> goodsSpecs;

    /**
     * 关键字
     */
    private String keyWord;

    /**
     * 货品编码
     */
    private List<String> goodsCodes;

    /**
     * 线上销售状态（0：下架；1：上架）
     */
    private Integer saleStatus;

    /**
     * 流通状态，1：退市 2：上市 3：禁售
     */
    private Integer status;

    /**
     * 页码
     */
    private Integer pageNo;

    /**
     * 记录数
     */
    private Integer pageSize;

    /**
     * 货品最后更新时间
     */
    private Date lastModifyTime;

    /**
     * 是否查询包装规格信息
     */
    private boolean queryGoodsSpec;

    /**
     * 是否查询商品标签
     */
    private boolean queryGoodsTag;

    /**
     * 分类id
     */
    private String[] categoryIds;
    /**
     * 一级分类id
     */
    private Long categoryId1;
    /**
     * 二级分类id
     */
    private Long categoryId2;
    /**
     * 三级分类id
     */
    private Long categoryId3;
    /**
     * 品牌名
     */
    private String[] brandNames;
    /**
     * 品牌id
     */
    private String[] brandIds;
    /**
     * 标准类型（0：非称重，1：称重）
     */
    private Integer standardType;
    /**
     * 计量单位ID
     */
    private Integer unitsId;
    /**
     * 品牌ID
     */
    private Integer brandId;

    /**
     * 产地
     */
    private String originPlace;

    public String getGroupCode() {
        return groupCode;
    }

    public void setGroupCode(String groupCode) {
        this.groupCode = groupCode;
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

    public String getGoodsType() {
        return goodsType;
    }

    public void setGoodsType(String goodsType) {
        this.goodsType = goodsType;
    }

    public Integer getPackSpecNum() {
        return packSpecNum;
    }

    public void setPackSpecNum(Integer packSpecNum) {
        this.packSpecNum = packSpecNum;
    }

    public String getUnitGoodsCode() {
        return unitGoodsCode;
    }

    public void setUnitGoodsCode(String unitGoodsCode) {
        this.unitGoodsCode = unitGoodsCode;
    }

    public String getUpcCode() {
        return upcCode;
    }

    public void setUpcCode(String upcCode) {
        this.upcCode = upcCode;
    }

    public String getGoodsUpc() {
        return goodsUpc;
    }

    public void setGoodsUpc(String goodsUpc) {
        this.goodsUpc = goodsUpc;
    }

    public List<String> getUpcCodes() {
        return upcCodes;
    }

    public void setUpcCodes(List<String> upcCodes) {
        this.upcCodes = upcCodes;
    }

    public String getSpuCode() {
        return spuCode;
    }

    public void setSpuCode(String spuCode) {
        this.spuCode = spuCode;
    }

    public List<GoodsSpecBO> getGoodsSpecs() {
        return goodsSpecs;
    }

    public void setGoodsSpecs(List<GoodsSpecBO> goodsSpecs) {
        this.goodsSpecs = goodsSpecs;
    }

    public String getKeyWord() {
        return keyWord;
    }

    public void setKeyWord(String keyWord) {
        this.keyWord = keyWord;
    }

    public List<String> getGoodsCodes() {
        return goodsCodes;
    }

    public void setGoodsCodes(List<String> goodsCodes) {
        this.goodsCodes = goodsCodes;
    }

    public Integer getSaleStatus() {
        return saleStatus;
    }

    public void setSaleStatus(Integer saleStatus) {
        this.saleStatus = saleStatus;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
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

    public Date getLastModifyTime() {
        return lastModifyTime;
    }

    public void setLastModifyTime(Date lastModifyTime) {
        this.lastModifyTime = lastModifyTime;
    }

    public boolean getQueryGoodsSpec() {
        return queryGoodsSpec;
    }

    public void setQueryGoodsSpec(boolean queryGoodsSpec) {
        this.queryGoodsSpec = queryGoodsSpec;
    }

    public boolean getQueryGoodsTag() {
        return queryGoodsTag;
    }

    public void setQueryGoodsTag(boolean queryGoodsTag) {
        this.queryGoodsTag = queryGoodsTag;
    }

    public String[] getCategoryIds() {
        return categoryIds;
    }

    public void setCategoryIds(String[] categoryIds) {
        this.categoryIds = categoryIds;
    }

    public Long getCategoryId1() {
        return categoryId1;
    }

    public void setCategoryId1(Long categoryId1) {
        this.categoryId1 = categoryId1;
    }

    public Long getCategoryId2() {
        return categoryId2;
    }

    public void setCategoryId2(Long categoryId2) {
        this.categoryId2 = categoryId2;
    }

    public Long getCategoryId3() {
        return categoryId3;
    }

    public void setCategoryId3(Long categoryId3) {
        this.categoryId3 = categoryId3;
    }

    public String[] getBrandNames() {
        return brandNames;
    }

    public void setBrandNames(String[] brandNames) {
        this.brandNames = brandNames;
    }

    public String[] getBrandIds() {
        return brandIds;
    }

    public void setBrandIds(String[] brandIds) {
        this.brandIds = brandIds;
    }

    public Integer getStandardType() {
        return standardType;
    }

    public void setStandardType(Integer standardType) {
        this.standardType = standardType;
    }

    public Integer getUnitsId() {
        return unitsId;
    }

    public void setUnitsId(Integer unitsId) {
        this.unitsId = unitsId;
    }

    public Integer getBrandId() {
        return brandId;
    }

    public void setBrandId(Integer brandId) {
        this.brandId = brandId;
    }

    public String getOriginPlace() {
        return originPlace;
    }

    public void setOriginPlace(String originPlace) {
        this.originPlace = originPlace;
    }

    public GoodsBO() {
    }

    public GoodsBO(String companyCode, String storeCode, String goodsCode, String keyWord,
                   List<String> goodsCodes, Integer pageNo, Integer pageSize) {
        this.companyCode = companyCode;
        this.storeCode = storeCode;
        this.goodsCode = goodsCode;
        this.keyWord = keyWord;
        this.goodsCodes = goodsCodes;
        this.pageNo = pageNo;
        this.pageSize = pageSize;
    }

    public static GoodsBO getInstance(String companyCode, String storeCode, String goodsCode,
                                      String keyWord) {
        return new GoodsBO(companyCode, storeCode, goodsCode, keyWord, null, null, null);
    }

    public static GoodsBO getInstance(String companyCode, String goodsCode, String keyWord, Integer pageNo,
                                      Integer pageSize) {
        return new GoodsBO(companyCode, null, goodsCode, keyWord, null, pageNo, pageSize);
    }

    public static GoodsBO getInstance(String companyCode, List<String> goodsCodes, Integer pageNo,
                                      Integer pageSize) {
        return new GoodsBO(companyCode, null, null, null, goodsCodes, pageNo, pageSize);
    }

    public static GoodsBO of(String unitGoodsCode) {
        GoodsBO goodsBO = new GoodsBO();
        goodsBO.setUnitGoodsCode(unitGoodsCode);
        return goodsBO;
    }

    public static GoodsBO of(String goodsCode, String upcCode, String spuCode, String companyCode) {
        GoodsBO goodsBO = new GoodsBO();
        goodsBO.setGoodsCode(goodsCode);
        goodsBO.setUpcCode(upcCode);
        goodsBO.setSpuCode(spuCode);
        goodsBO.setCompanyCode(companyCode);
        return goodsBO;
    }

    public static GoodsBO of(String companyCode, Date lastModifyTime) {
        GoodsBO goodsBO = new GoodsBO();
        goodsBO.setLastModifyTime(lastModifyTime);
        goodsBO.setCompanyCode(companyCode);
        return goodsBO;
    }

    public static GoodsBO of(String companyCode, Integer status) {
        GoodsBO goodsBO = new GoodsBO();
        goodsBO.setCompanyCode(companyCode);
        goodsBO.setStatus(status);
        return goodsBO;
    }

    public static GoodsBO of(String companyCode, String goodsName) {
        GoodsBO goodsBO = new GoodsBO();
        goodsBO.setCompanyCode(companyCode);
        goodsBO.setGoodsName(goodsName);
        return goodsBO;
    }

    public static GoodsBO from(String goodsCode, AdminLoginContent content) {
        GoodsBO goodsBO = new GoodsBO();
        goodsBO.setGoodsCode(goodsCode);
        goodsBO.setStoreCode(content.getStoreCode());
        goodsBO.setGroupCode(content.getGroupCode());
        return goodsBO;
    }

    /**
     * 根据goodsCode查询
     */
    public static GoodsBO byGoodsCode(String goodsCode, String storeCode, String companyCode, String groupCode) {
        GoodsBO goodsBO = new GoodsBO();
        goodsBO.setGoodsCode(goodsCode);
        goodsBO.setStoreCode(storeCode);
        goodsBO.setCompanyCode(companyCode);
        goodsBO.setGroupCode(groupCode);
        return goodsBO;
    }

    /**
     * 根据goodsCode查询
     */
    public static GoodsBO byGoodsCode(String goodsCode, AdminLoginContent content) {
        GoodsBO goodsBO = new GoodsBO();
        goodsBO.setGoodsCode(goodsCode);
        return supply(goodsBO, content);
    }

    /**
     * 根据goodsName查询
     */
    public static GoodsBO byGoodsName(String goodsName, String storeCode, String companyCode, String groupCode) {
        GoodsBO goodsBO = new GoodsBO();
        goodsBO.setGoodsName(goodsName);
        goodsBO.setStoreCode(storeCode);
        goodsBO.setCompanyCode(companyCode);
        goodsBO.setGroupCode(groupCode);
        return goodsBO;
    }

    /**
     * 根据goodsName查询
     */
    public static GoodsBO byGoodsName(String goodsName, AdminLoginContent content) {
        GoodsBO goodsBO = new GoodsBO();
        goodsBO.setGoodsName(goodsName);
        return supply(goodsBO, content);
    }

    /**
     * 根据upc查询
     */
    public static GoodsBO byUpcCode(String upcCode, String storeCode, String companyCode, String groupCode) {
        GoodsBO goodsBO = new GoodsBO();
        goodsBO.setUpcCode(upcCode);
        goodsBO.setStoreCode(storeCode);
        goodsBO.setCompanyCode(companyCode);
        goodsBO.setGroupCode(groupCode);
        return goodsBO;
    }

    /**
     * 根据upc查询
     */
    public static GoodsBO byUpcCode(String upcCode, AdminLoginContent content) {
        GoodsBO goodsBO = new GoodsBO();
        goodsBO.setUpcCode(upcCode);
        return supply(goodsBO, content);
    }

    /**
     * 根据upc查询
     */
    public static GoodsBO byUpcCodes(List<String> upcCodes, AdminLoginContent content) {
        GoodsBO goodsBO = new GoodsBO();
        goodsBO.setUpcCodes(upcCodes);
        return supply(goodsBO, content);
    }

    /**
     * 补充storeCode, companyCode, groupCode
     *
     * @param goodsBO
     * @param content
     * @return
     */
    public static GoodsBO supply(GoodsBO goodsBO, AdminLoginContent content) {
        goodsBO.setStoreCode(content.getStoreCode());
        goodsBO.setGroupCode(content.getGroupCode());
        return goodsBO;
    }

    public static GoodsBO from(String keyWord, String goodsName, String goodsCode, String goodsUpc,
                               Integer saleStatus, Long categoryId1, Long categoryId2, Long categoryId3, Integer status,
                               String originPlace,Integer pageNo, Integer pageSize, AdminLoginContent content) {
        GoodsBO bo = new GoodsBO();
        bo.setKeyWord(keyWord);
        bo.setGoodsName(goodsName);
        bo.setGoodsCode(goodsCode);
        bo.setGoodsUpc(goodsUpc);
        bo.setSaleStatus(saleStatus);
        bo.setCategoryId1(categoryId1);
        bo.setCategoryId2(categoryId2);
        bo.setCategoryId3(categoryId3);
        bo.setStatus(status);
        bo.setPageNo(pageNo);
        bo.setPageSize(pageSize);
        bo.setOriginPlace(originPlace);
        return supply(bo, content);
    }

}