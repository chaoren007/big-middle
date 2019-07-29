package com.morning.star.retail.stock.assembler;

import com.morning.star.retail.base.dto.GoodsDTO;
import com.morning.star.retail.stock.bo.ItemInBO;

/**
 * Assembler class for the ItemInBO.
 * 
 * @author Tim
 *
 */
public class ItemInBOAssembler {

    /**
     * 
     * @param goodsVo
     * @return a ItemInBO
     */
    public ItemInBO fromDTO(GoodsDTO goods) {
        ItemInBO itemInBO = new ItemInBO();
        itemInBO.setGoodsId(goods.getGoodsCode());
        itemInBO.setGoodsName(goods.getGoodsName());
        itemInBO.setGoodsUnit(goods.getPackSpecUnits());
//        itemInBO.setBarCode(goodsVo);
//        itemInBO.setInId(inId);
//        itemInBO.setProvider(provider);
//        itemInBO.setProviderName(providerName);
//        itemInBO.setPurchaseId(purchaseId);
//        itemInBO.setPurchasePrice(goodsVo.getGuidePrice());
//        itemInBO.setReplenishId(replenishId);
//        itemInBO.setSerialCode(serialCode);
//        itemInBO.setSerialId(serialId);
        return itemInBO;
    }

}
