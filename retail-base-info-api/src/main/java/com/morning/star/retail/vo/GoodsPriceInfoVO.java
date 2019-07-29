package com.morning.star.retail.vo;

import java.io.Serializable;
import java.util.List;

/**
 * 货品定价详情
 * 
 * @author jiangyf
 * @date 2017年5月31日 下午8:28:41
 */
public class GoodsPriceInfoVO implements Serializable {
	private static final long serialVersionUID = 8978930178552267816L;

	private GoodsInfoVO goodsInfo;
	private List<PriceVO> priceList;

	public GoodsInfoVO getGoodsInfo() {
		return goodsInfo;
	}

	public void setGoodsInfo(GoodsInfoVO goodsInfo) {
		this.goodsInfo = goodsInfo;
	}

	public List<PriceVO> getPriceList() {
		return priceList;
	}

	public void setPriceList(List<PriceVO> priceList) {
		this.priceList = priceList;
	}

}
