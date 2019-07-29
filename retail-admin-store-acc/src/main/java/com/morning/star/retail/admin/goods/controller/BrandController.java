package com.morning.star.retail.admin.goods.controller;

import java.util.List;

import org.apache.commons.lang.Validate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.morning.star.retail.admin.util.AdminController;
import com.morning.star.retail.admin.util.WebBean;
import com.morning.star.retail.facade.BrandFacade;
import com.morning.star.retail.facade.dto.BrandCountDTO;
import com.morning.star.retail.facade.dto.BrandCountReDTO;
import com.morning.star.retail.facade.dto.BrandDTO;
import com.morning.star.retail.facade.dto.BrandQueryDTO;
import com.morning.star.retail.utils.page.PageBean;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

/**
 * 品牌
 *
 * @author obama
 */
@Api(tags = {"门店品牌"})
@Controller
@RequestMapping("/api/brand/")
public class BrandController extends AdminController {
    @Autowired
    private BrandFacade brandFacade;

    @ApiOperation(value = "分页查询品牌")
    @RequestMapping(value = "page", method = RequestMethod.GET)
    @ResponseBody
    public WebBean<PageBean<BrandDTO>> queryPage(BrandQueryDTO brandQueryDTO) {
        Validate.notNull(brandQueryDTO.getPageNo(), "分页参数不能为空!");
        Validate.notNull(brandQueryDTO.getPageSize(), "分页参数不能为空!");
        return WebBean.ok(brandFacade.queryPage(brandQueryDTO));
    }

    @ApiOperation(value = "列表查询品牌")
    @RequestMapping(value = "list", method = RequestMethod.GET)
    @ResponseBody
    public WebBean<List<BrandDTO>> queryList(BrandQueryDTO dto) {
        Validate.notNull(dto.getCategoryId());
        return WebBean.ok(brandFacade.queryList(dto));
    }

    @ApiOperation(value = "获取品牌统计")
    @RequestMapping(value = "count", method = RequestMethod.GET)
    @ResponseBody
    public WebBean<PageBean<BrandCountReDTO>> getCategoryConut(BrandCountDTO dto) {
        dto.setGroupCode(getLoginAdmin().getGroupCode());
        dto.setStoreCode(getLoginAdmin().getStoreCode());
        return WebBean.ok(brandFacade.queryCountPage(dto));
    }

}
