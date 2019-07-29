package com.morning.star.retail.facade.impl;

import com.alibaba.fastjson.JSON;
import com.morning.star.retail.dto.KingdeeTaxCategoryDTO;
import com.morning.star.retail.entity.enums.RequestTagEnum;
import com.morning.star.retail.facade.KingdeeAddGoodsFacade;
import com.morning.star.retail.facade.dto.supply.GoodsSupplyDTO;
import com.morning.star.retail.facade.dto.supply.GoodsSupplySpuDTO;
import com.morning.star.retail.helper.GoodsSupplyHelper;
import com.morning.star.retail.kingdee.service.KingdeeClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;

@Service
public class KingdeeAddGoodsFacadeImpl implements KingdeeAddGoodsFacade {
    @Autowired
    private KingdeeClient client;
    @Autowired
    private GoodsSupplyHelper goodsSupplyHelper;

    private static final String GOODS_FORMID = "BD_MATERIAL";


    @Override
    public void add(String code) {
        GoodsSupplyDTO detailBySupplyCode = goodsSupplyHelper.getDetailBySupplyCode(code);
        String goodsName = detailBySupplyCode.getGoodsName();
        List<GoodsSupplySpuDTO> spuDetailList = detailBySupplyCode.getSpuDetailList();
        String json = readJSON();
        if (spuDetailList!=null && spuDetailList.size()>0){
            for (GoodsSupplySpuDTO goodsSupplySpuDTO : spuDetailList) {
                String productCode = goodsSupplySpuDTO.getProductCode();
                String context = json.replace("这是要替换的名称", goodsName);
                context = context.replace("要替换的名字编码",productCode);
                client.add(GOODS_FORMID,context,"KingdeeAddGoodsFacade",RequestTagEnum.KINGDEE_CREATE_GOODS);
            }
        }

    }


    private String readJSON() {
        String pathname = "/data/code/liqun/retail-third-service/src/main/resources/JSON.txt";
        String json ="";
        try {
            FileReader reader = new FileReader(pathname);
            BufferedReader br = new BufferedReader(reader);
            String line;
            while ((line = br.readLine()) != null) {
                json = json + line;
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return json;
    }
}