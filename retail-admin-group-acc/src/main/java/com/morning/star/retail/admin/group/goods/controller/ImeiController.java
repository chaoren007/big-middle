package com.morning.star.retail.admin.group.goods.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.morning.star.retail.admin.util.AdminController;
import com.morning.star.retail.admin.util.WebBean;
import com.morning.star.retail.facade.ImeiFacade;
import com.morning.star.retail.facade.dto.ImeiAddDTO;
import com.morning.star.retail.facade.dto.ImeiQueryDTO;
import com.morning.star.retail.facade.dto.ImeiUpdateDTO;
import com.morning.star.retail.utils.page.PageBean;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api(tags = {"集团商品串码"})
@Controller
@RequestMapping("/api/imei/")
public class ImeiController extends AdminController {
    @Autowired
    private ImeiFacade imeiFacade;

    @ApiOperation(value = "商品串码-导入")
    @RequestMapping(value = "/create", method = RequestMethod.POST)
    @ResponseBody
    public WebBean<Void> importSupplierItem(@RequestBody List<ImeiAddDTO> list) {

        imeiFacade.createList(list,getLoginAdmin().getStoreCode(),getLoginAdmin().getGroupCode());
        return WebBean.ok();
    }

    @ApiOperation(value = "修改串码")
    @RequestMapping(value = "/edit", method = RequestMethod.POST)
    @ResponseBody
    public WebBean<Void> edit(@RequestBody ImeiUpdateDTO imeiUpdateDTO) {

        imeiFacade.edit(imeiUpdateDTO);

        return WebBean.ok();
    }

    @ApiOperation(value = "查询串码")
    @RequestMapping(value = "/queryPage", method = RequestMethod.GET)
    @ResponseBody
    public WebBean<PageBean<ImeiAddDTO>> queryPage(ImeiQueryDTO dto) {
        dto.setStoreCode(getLoginAdmin().getStoreCode());
        dto.setGroupCode(getLoginAdmin().getGroupCode());
        return WebBean.ok(imeiFacade.queryPage(dto));
    }
}
