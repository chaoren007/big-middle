package com.morning.star.retail.admin.group.helper;

import org.springframework.stereotype.Service;

import com.morning.star.retail.bean.AdminLoginContent;
import com.morning.star.retail.bean.GoodsPriceDO;
import com.morning.star.retail.bo.GoodsPriceBO;
import com.morning.star.retail.util.MultipartFileWrapper;
import com.morning.star.retail.utils.page.PageBean;
import com.morning.star.retail.vo.GoodsInfoVO;
import com.morning.star.retail.vo.GoodsPriceInfoVO;
import com.morning.star.retail.vo.GoodsPriceVO;

/**
 * 货品定价
 * 
 * @author jiangyf
 * @date 2017年5月31日 下午8:15:29
 */
@Service
public class GoodsPriceService {

	/**
	 * 获取要定价的货品信息
	 * 
	 * @param goodsPriceBO
	 * @return
	 */
	public GoodsInfoVO getGoodsInfo(GoodsPriceBO goodsPriceBO) {
	    return null;
	}

	/**
	 * 货品定价信息
	 * 
	 * @param goodsPriceBO
	 * @return
	 */
	public GoodsPriceInfoVO getGoodsPriceInfo(GoodsPriceBO goodsPriceBO) {
        return null;
    }

	/**
	 * 修改价格
	 * 
	 * @param goodsPriceDO
	 * @return
	 */
	public boolean modifyGoodsPrice(GoodsPriceDO goodsPriceDO) {
        return false;
    }

	/**
	 * 分页查询货品定价记录
	 * 
	 * @param goodsPriceBO
	 * @return
	 */
	public PageBean<GoodsPriceVO> pageListGoodsPrice(GoodsPriceBO goodsPriceBO) {
        return null;
    }

	/**
	 * 导入货品定价
	 * 
	 * @param importFile
	 * @param userInfo
	 */
	public void importGoodsPrice(MultipartFileWrapper importFile, AdminLoginContent userInfo) {
    }

}
