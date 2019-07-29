package com.morning.star.retail.admin.supplier.controller;

import com.morning.star.retail.admin.util.AdminController;
import com.morning.star.retail.admin.util.WebBean;
import com.morning.star.retail.base.enums.SupplierAuthFailReasonEnum;
import com.morning.star.retail.base.enums.SupplierStatusEnum;
import com.morning.star.retail.base.enums.SupplierTypeEnum;
import com.morning.star.retail.base.page.PageBeans;
import com.morning.star.retail.bean.AdminLoginContent;
import com.morning.star.retail.dto.*;
import com.morning.star.retail.facade.SupplierFacade;
import com.morning.star.retail.facade.SupplierGoodsFacade;
import com.morning.star.retail.utils.page.PageBean;
import com.morning.star.retail.validate.SaveGroup;
import com.morning.star.retail.validate.Validate;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Map;

@Api(tags = "供应商")
@RestController
@RequestMapping("/api/supplier")
public class SupplierController extends AdminController {

    @Autowired
    private SupplierFacade facade;

    @Autowired
    private SupplierGoodsFacade supplierGoodsFacade;



    @ApiOperation(value = "供应商申请-列表")
    @RequestMapping(value = "/list-apply", method = RequestMethod.GET)
    public WebBean<PageBeans<SupplierApplyDTO>> listApply(SupplierQueryDTO queryDTO) {
        AdminLoginContent content = getLoginAdmin();
        queryDTO.setGroupCode(content.getGroupCode());
        queryDTO.setStoreCode(content.getStoreCode());
        return WebBean.ok(facade.listApply(queryDTO));
    }

    @ApiOperation(value = "供应商申请-详情")
    @RequestMapping(value = "/get-apply", method = RequestMethod.GET)
    public WebBean<SupplierApplyDTO> getApply(@RequestParam(required = true) Long id) {
        return WebBean.ok(facade.getApply(id));
    }

    @ApiOperation(value = "供应商申请-审核失败原因")
    @RequestMapping(value = "/auth-fail-reason", method = RequestMethod.GET)
    public WebBean<List<Map<String, Object>>> authFailReason() {
        return WebBean.ok(SupplierAuthFailReasonEnum.list());
    }

    @ApiOperation(value = "供应商申请-审核通过")
    @RequestMapping(value = "/auth-pass", method = RequestMethod.POST)
    public WebBean authPass(@RequestBody SupplierAuthPassDTO dto) {
        facade.authPass(dto);
        return WebBean.ok();
    }

    @ApiOperation(value = "供应商申请-审核失败")
    @RequestMapping(value = "/auth-fail", method = RequestMethod.POST)
    public WebBean authFail(@RequestBody SupplierAuthFailDTO dto) {
        facade.authFail(dto);
        return WebBean.ok();
    }

    @ApiOperation(value = "供应商-列表")
    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public WebBean<PageBeans<SupplierDTO>> list(SupplierQueryDTO queryDTO) {
        AdminLoginContent content = getLoginAdmin();
        queryDTO.setGroupCode(content.getGroupCode());
        queryDTO.setStoreCode(content.getStoreCode());
        return WebBean.ok(facade.list(queryDTO));
    }

    @ApiOperation(value = "供应商-详情")
    @RequestMapping(value = "/get", method = RequestMethod.GET)
    public WebBean<SupplierDTO> get(@RequestParam(required = true) Long id) {
        return WebBean.ok(facade.get(id));
    }

    @ApiOperation(value = "供应商-新增")
    @RequestMapping(value = "/create", method = RequestMethod.POST)
    @Validate(groups = SaveGroup.class)
    public WebBean create(@RequestBody SupplierCreateDTO dto) {
        AdminLoginContent content = getLoginAdmin();
        dto.setGroupCode(content.getGroupCode());
        dto.setStoreCode(content.getStoreCode());
        dto.setType(SupplierTypeEnum.BRANCH.getCode());
        facade.create(dto);
        return WebBean.ok();
    }

    @ApiOperation(value = "供应商-启用")
    @RequestMapping(value = "/enable", method = RequestMethod.POST)
    public WebBean enable(@RequestBody SupplierModifyDTO dto) {
        dto.setStatus(SupplierStatusEnum.ENABLE.getCode());
        facade.modifyStatus(dto);
        return WebBean.ok();
    }

    @ApiOperation(value = "供应商-禁用")
    @RequestMapping(value = "/disable", method = RequestMethod.POST)
    public WebBean disable(@RequestBody SupplierModifyDTO dto) {
        dto.setStatus(SupplierStatusEnum.DISABLE.getCode());
        facade.modifyStatus(dto);
        return WebBean.ok();
    }

    @ApiOperation(value = "查询启用状态的供应商")
    @RequestMapping(value = "/query", method = RequestMethod.GET)
    public WebBean<List<SupplierDTO>> query(SupplierQueryDTO queryDTO) {
        AdminLoginContent content = getLoginAdmin();
        queryDTO.setGroupCode(content.getGroupCode());
        queryDTO.setStoreCode(content.getStoreCode());
        queryDTO.setStatus(SupplierStatusEnum.ENABLE.getCode());
        queryDTO.setPageSize(Integer.MAX_VALUE);
        return WebBean.ok(facade.list(queryDTO).getRecord());
    }

    @ApiOperation(value = "运营端供货列表")
    @RequestMapping(value = "/bus-supply-list", method = RequestMethod.GET)
    public WebBean<PageBean<BusSupplyGoodsDTO>> getSupplyGoods(BusSupplyGoodsQueryDTO queryDTO) {
        org.apache.commons.lang3.Validate.notNull(queryDTO.getPageNo(),"分页参数不能为空");
        org.apache.commons.lang.Validate.notNull(queryDTO.getPageSize(),"分页参数不能为空");

        PageBean<BusSupplyGoodsDTO> supplyGoods = supplierGoodsFacade.getSupplyGoods(queryDTO);
        return WebBean.ok(supplyGoods);
    }

    @ApiOperation(value = "运营端送货单列表")
    @RequestMapping(value = "/bus-ship-list", method = RequestMethod.GET)
    public WebBean<PageBean<BusShipGoodsDTO>> getSupplyGoods(BusShipGoodsQueryDTO queryDTO) {
        org.apache.commons.lang3.Validate.notNull(queryDTO.getPageNo(),"分页参数不能为空");
        org.apache.commons.lang.Validate.notNull(queryDTO.getPageSize(),"分页参数不能为空");
        PageBean<BusShipGoodsDTO> supplyGoods = supplierGoodsFacade.getShipGoods(queryDTO);
        return WebBean.ok(supplyGoods);
    }
    @ApiOperation(value = "运营端发货单详情")
    @RequestMapping(value = "/bus-supply-detail", method = RequestMethod.GET)
    public WebBean<BusSupplyGoodsDetailDTO> getSupplyGoodsDetail(String supplyCode) {
        BusSupplyGoodsDetailDTO dto = supplierGoodsFacade.getSupplyGoodsDetail(supplyCode);
        return WebBean.ok(dto);
    }

    @ApiOperation(value = "运营端送货单详情列表")
    @RequestMapping(value = "/bus-ship-detail", method = RequestMethod.GET)
    public WebBean<BusShipGoodsDetailDTO> getShipGoodsDetail(String shipCode) {
        BusShipGoodsDetailDTO dto = supplierGoodsFacade.getShipGoodsDetail(shipCode);
        return WebBean.ok(dto);
    }

    @ApiOperation(value = "手动任务（生成供应商供货订单）")
    @RequestMapping(value = "/task", method = RequestMethod.GET)
    public WebBean<BusShipGoodsDetailDTO> getShipGoodsDetail() {
        supplierGoodsFacade.insertSupBusItem();
        return WebBean.ok();
    }


}
