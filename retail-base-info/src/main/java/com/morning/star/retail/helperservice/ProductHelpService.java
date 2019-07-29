package com.morning.star.retail.helperservice;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.Validate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.morning.star.retail.facade.ProductFacade;
import com.morning.star.retail.facade.dto.ProductDTO;
import com.morning.star.retail.facade.dto.ProductGetDTO;

/**
 * 货品-外部类
 *
 * @author jiangyf
 */
@Service
public class ProductHelpService {

    @Autowired
    private ProductFacade facade;

    public ProductDTO get(String productCode, String groupCode) {
        Validate.isTrue(StringUtils.isNoneBlank(productCode), "货品编码不能为空");
        ProductGetDTO getDTO = new ProductGetDTO();
        getDTO.setProductCode(productCode);
        getDTO.setGroupCode(groupCode);
        return facade.getDetail(getDTO);
    }

    public ProductDTO checkGet(String productCode, String groupCode) {
        ProductDTO dto = get(productCode, groupCode);
        Validate.isTrue(dto != null, String.format("未找到该货品【编码：%s】信息", productCode));
        return dto;
    }

    public ProductDTO checkGetBySAP(String sapProductCode, String groupCode) {
        ProductDTO dto = facade.getBySapCode(groupCode, sapProductCode);
        Validate.isTrue(dto != null, String.format("未找到该货品【SAP编码：%s】信息", sapProductCode));
        return dto;
    }

    public List<String> getSapCodeByUpc(String upcCode) {
        return facade.getSapCodeByUpc(upcCode);
    }
}
