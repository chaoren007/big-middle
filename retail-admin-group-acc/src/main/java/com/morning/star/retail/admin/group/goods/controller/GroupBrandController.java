package com.morning.star.retail.admin.group.goods.controller;

import com.morning.star.retail.admin.util.AdminController;
import com.morning.star.retail.admin.util.WebBean;
import com.morning.star.retail.facade.BrandFacade;
import com.morning.star.retail.facade.dto.*;
import com.morning.star.retail.utils.page.PageBean;
import com.morning.star.retail.validate.Validate;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Api(tags = {"集团品牌"})
@Controller
@RequestMapping("/api/brand")
public class GroupBrandController extends AdminController {
    @Autowired
    private BrandFacade brandFacade;

    @ApiOperation(value = "添加品牌")
    @RequestMapping(value = "/create", method = RequestMethod.POST)
    @ResponseBody
    @Validate
    public WebBean<Long> createBrand(@RequestBody BrandAddDTO dto) {
        return WebBean.ok(brandFacade.create(dto));
    }


    @ApiOperation(value = "获取品牌统计")
    @RequestMapping(value = "/count", method = RequestMethod.GET)
    @ResponseBody
    public WebBean<PageBean<BrandCountReDTO>> getCategoryConut(BrandCountDTO dto) {
        dto.setGroupCode(getLoginAdmin().getGroupCode());
        return WebBean.ok(brandFacade.queryCountGroupPage(dto));
    }

    @ApiOperation(value = "列表查询品牌")
    @RequestMapping(value = "list", method = RequestMethod.GET)
    @ResponseBody
    public WebBean<List<BrandDTO>> queryList(BrandQueryDTO dto) {
        org.apache.commons.lang.Validate.notNull(dto.getCategoryId());
        return WebBean.ok(brandFacade.queryList(dto));
    }

    @ApiOperation(value = "查询品牌")
    @RequestMapping(method = RequestMethod.GET)
    @ResponseBody
    public WebBean<PageBean<BrandDTO>> queryByPage(BrandQueryDTO brandQueryDTO) {
        org.apache.commons.lang.Validate.notNull(brandQueryDTO.getPageNo(),"分页参数不能为空!");
        org.apache.commons.lang.Validate.notNull(brandQueryDTO.getPageSize(),"分页参数不能为空!");
        return WebBean.ok(brandFacade.queryPage(brandQueryDTO));
    }

    @ApiOperation(value = "删除品牌")
    @RequestMapping(value = "/delete", method = RequestMethod.POST)
    @ResponseBody
    @Validate
    public WebBean<Void> deleteBrand(@RequestBody BrandDeleteDTO dto) {
        brandFacade.delete(dto.getId());
        return WebBean.ok();
    }

    @ApiOperation(value = "编辑品牌")
    @RequestMapping(value = "/edit", method = RequestMethod.POST)
    @ResponseBody
    @Validate
    public WebBean<Void> createBrand(@RequestBody BrandUpdateDTO dto) {
        brandFacade.edit(dto);
        return WebBean.ok();

    }


}
