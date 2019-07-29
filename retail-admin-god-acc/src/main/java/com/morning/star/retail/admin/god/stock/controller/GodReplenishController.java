package com.morning.star.retail.admin.god.stock.controller;

import com.morning.star.retail.admin.util.AdminController;
import com.morning.star.retail.bean.WebJsonBean;
import com.morning.star.retail.consts.RetailDefaultConst;
import com.morning.star.retail.exception.CODE;
import com.morning.star.retail.facade.ReplenishFacade;
import com.morning.star.retail.facade.dto.replenish.ReplenishItemQueryDTO;
import com.morning.star.retail.facade.dto.replenish.ReplenishQueryDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/api/god/replenish/")
public class GodReplenishController extends AdminController {
    @Autowired
    private ReplenishFacade replenishFacade;

    @RequestMapping(value = "list", method = RequestMethod.POST)
    @ResponseBody
    public WebJsonBean list(@RequestBody ReplenishQueryDTO replenishQueryDTO) {
        return new WebJsonBean(CODE.SUCCESS, replenishFacade.list(replenishQueryDTO));
    }

    @RequestMapping(value = "getReplenishDetail", method = RequestMethod.POST)
    @ResponseBody
    public WebJsonBean replenishDetail(@RequestBody ReplenishItemQueryDTO replenishSerachDTO) {
        Integer page = replenishSerachDTO.getPage();
        Integer pageSize = replenishSerachDTO.getPageSize();
        replenishSerachDTO.setPage(page == null ? 1 : page);
        replenishSerachDTO.setPageSize(pageSize == null
                ? RetailDefaultConst.ADMIN_PAGE_SIZE : pageSize);
        return new WebJsonBean(CODE.SUCCESS, replenishFacade.replenishDetail(replenishSerachDTO));
    }
}
