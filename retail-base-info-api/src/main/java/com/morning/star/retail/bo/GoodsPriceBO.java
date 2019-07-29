package com.morning.star.retail.bo;

import java.io.Serializable;
import java.util.List;

import com.morning.star.retail.bean.AdminLoginContent;

/**
 * 货品定价
 * 
 * @author jiangyf
 */
public class GoodsPriceBO implements Serializable {
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
	 * upc
	 */
	private String upcCode;

	/**
	 * 关键字
	 */
	private String keyWord;

	/**
	 * 货品编码
	 */
	private List<String> goodsCodes;

	/**
	 * 状态（0：待审核，1：审核成功，2：审核失败)
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

	public String getUpcCode() {
		return upcCode;
	}

	public void setUpcCode(String upcCode) {
		this.upcCode = upcCode;
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

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
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


    public GoodsPriceBO() {
	}

	public GoodsPriceBO(String companyCode, String storeCode, String goodsCode, String goodsName,
			String upcCode, String keyWord, List<String> goodsCodes, Integer status, Integer pageNo,
			Integer pageSize) {
		this.companyCode = companyCode;
		this.storeCode = storeCode;
		this.goodsCode = goodsCode;
		this.goodsName = goodsName;
		this.upcCode = upcCode;
		this.keyWord = keyWord;
		this.goodsCodes = goodsCodes;
		this.status = status;
		this.pageNo = pageNo;
		this.pageSize = pageSize;
	}

	public static GoodsPriceBO of(String companyCode, String storeCode, String goodsCode, String keyWord) {
		return new GoodsPriceBO(companyCode, storeCode, goodsCode, null, null, keyWord, null, null, null,
				null);
	}

	public static GoodsPriceBO of(String companyCode, String goodsCode, String goodsName, String upcCode,
			Integer status, Integer pageNo, Integer pageSize) {
		return new GoodsPriceBO(companyCode, null, goodsCode, goodsName, upcCode, null, null, status, pageNo,
				pageSize);
	}

	public static GoodsPriceBO from(String goodsCode, String goodsName, String upcCode, Integer status, Integer pageNo, Integer pageSize, AdminLoginContent content) {
		GoodsPriceBO goodsPriceBO = new GoodsPriceBO();
		goodsPriceBO.setGoodsCode(goodsCode);
		goodsPriceBO.setGoodsName(goodsName);
		goodsPriceBO.setUpcCode(upcCode);
		goodsPriceBO.setStatus(status);
		goodsPriceBO.setPageNo(pageNo);
		goodsPriceBO.setPageSize(pageSize);
		goodsPriceBO.setStoreCode(content.getStoreCode());
		goodsPriceBO.setGroupCode(content.getGroupCode());
		return goodsPriceBO;
	}

	public static GoodsPriceBO from(String goodsCode, AdminLoginContent content) {
		GoodsPriceBO goodsPriceBO = new GoodsPriceBO();
		goodsPriceBO.setGoodsCode(goodsCode);
		goodsPriceBO.setStoreCode(content.getStoreCode());
		goodsPriceBO.setGroupCode(content.getGroupCode());
		return goodsPriceBO;
	}
}