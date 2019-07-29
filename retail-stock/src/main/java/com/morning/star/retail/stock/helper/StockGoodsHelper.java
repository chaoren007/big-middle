package com.morning.star.retail.stock.helper;

import com.morning.star.retail.facade.GoodsAdminFacade;
import com.morning.star.retail.facade.dto.GoodsDTO;
import com.morning.star.retail.stock.helper.vo.GoodsInfo;
import com.morning.star.retail.utils.entity.BeanUtils;
import org.apache.commons.lang3.Validate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StockGoodsHelper {

    @Autowired
    private GoodsAdminFacade goodsAdminFacade;

    GoodsInfo form(GoodsDTO dto) {
        if (dto == null) {
            return null;
        }
        GoodsInfo info = new GoodsInfo();
        BeanUtils.copy(dto, info);

        return info;
    }

    public GoodsInfo getGoods(String goodsCode) {
        GoodsDTO dto = goodsAdminFacade.getGoods(goodsCode);
        return form(dto);
    }

    public GoodsInfo checkGetGoods(String goodsCode) {
        GoodsDTO dto = goodsAdminFacade.getGoods(goodsCode);
        Validate.notNull(dto, String.format("未找到该商品【编码：%s】信息", goodsCode));
        return form(dto);
    }

    public GoodsInfo getGoods(String storeCode, String productCode) {
        try {
            GoodsDTO dto = goodsAdminFacade.getGoodsByCode(storeCode, productCode);
            return form(dto);
        } catch (Exception e) {
            throw new RuntimeException("调用商品查询接口失败！" + e);
        }
    }

    public GoodsInfo checkGetGoods(String storeCode, String productCode) {
        GoodsInfo goods = getGoods(storeCode, productCode);
        Validate.notNull(goods, String.format("未找到该商品【货品编码：%s】信息", productCode));
        return goods;
    }

    public GoodsInfo getGoods(String upcCode, String storeCode, String groupCode) {
        GoodsDTO dto = goodsAdminFacade.getGoodsByUpc(storeCode, upcCode).get(0);
        return form(dto);
    }

    public GoodsInfo getBySapProductCode(String sapProductCode, String storeCode) {
        GoodsDTO dto = goodsAdminFacade.getBySapCode(storeCode, sapProductCode);
        return form(dto);
    }

}
