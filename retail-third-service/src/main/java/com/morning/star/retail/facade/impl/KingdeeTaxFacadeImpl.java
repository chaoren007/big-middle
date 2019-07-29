package com.morning.star.retail.facade.impl;

import com.alibaba.fastjson.JSON;
import com.morning.star.retail.dto.KingdeeTaxCategoryDTO;
import com.morning.star.retail.dto.KingdeeTaxRateDTO;
import com.morning.star.retail.entity.enums.RequestTagEnum;
import com.morning.star.retail.facade.KingdeeTaxFacade;
import com.morning.star.retail.facade.dto.TaxKdDTO;
import com.morning.star.retail.kingdee.service.KingdeeClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class KingdeeTaxFacadeImpl implements KingdeeTaxFacade {
    @Autowired
    private KingdeeClient client;

    private static final String TAXRATE_FORMID = "BD_TaxRate";
    private static final String TAXTYPE_FORMID = "BD_TAXTYPE";

    @Override
    public void addTaxRate(TaxKdDTO dto) {
        String context = JSON.toJSONString(new KingdeeTaxRateDTO(dto.getTaxName(),dto.getfTaxRate(),dto.getfEffectiveDate(), dto.getfExpiryDate(), dto.getfMakeVatInvoice()));
        client.add(TAXRATE_FORMID,context,"KingdeeTaxFacade",RequestTagEnum.KINGDEE_CREATE_TAXRATE);
    }

    @Override
    public void addTaxCategory(TaxKdDTO dto) {
        String context = JSON.toJSONString(new KingdeeTaxCategoryDTO(dto.getTaxName(), dto.getfEffectiveDate(), dto.getfExpiryDate()));
        client.add(TAXTYPE_FORMID,context,"KingdeeTaxFacade",RequestTagEnum.KINGDEE_CREATE_TAXTYPE);
    }
}
