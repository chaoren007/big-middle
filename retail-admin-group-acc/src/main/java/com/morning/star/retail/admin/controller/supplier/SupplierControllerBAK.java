package com.morning.star.retail.admin.controller.supplier;

import com.morning.star.retail.admin.util.AdminController;
import com.morning.star.retail.admin.util.WebBean;
import com.morning.star.retail.base.enums.SupplierStatusEnum;
import com.morning.star.retail.base.page.PageBeans;
import com.morning.star.retail.base.poi.ExcelUtil;
import com.morning.star.retail.dto.*;
import com.morning.star.retail.enums.BusinessMethodEnum;
import com.morning.star.retail.enums.OriginalType;
import com.morning.star.retail.enums.SettlementMethodEnum;
import com.morning.star.retail.facade.SupplierFacade;
import com.morning.star.retail.validate.CreateGroup;
import com.morning.star.retail.validate.ModifyGroup;
import com.morning.star.retail.validate.SaveGroup;
import com.morning.star.retail.validate.Validate;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.Map;

/**
 * 供应商管理（供应商，供货门店，供应货品）
 *
 * @author jiangyf
 */
@Api(tags = "供应商管理（供应商，供货门店，供应货品）")
@RestController
@RequestMapping("/api-v2")
public class SupplierControllerBAK extends AdminController {

    @Autowired
    private SupplierFacade facade;

    @ApiOperation(value = "供应商-新增")
    @RequestMapping(value = "/supplier/create", method = RequestMethod.POST)
    @RequiresPermissions(value = "supplier:submit")
    @Validate(groups = SaveGroup.class)
    public WebBean create(@RequestBody SupplierCreateDTO dto) {
        facade.create(dto);
        return WebBean.ok();
    }

    @ApiOperation(value = "供应商-经营方式")
    @RequestMapping(value = "/supplier/business-method", method = RequestMethod.GET)
    public WebBean<List<Map<String, Object>>> businessMethod() {
        return WebBean.ok(BusinessMethodEnum.list());
    }

    @ApiOperation(value = "供应商-结算方式")
    @RequestMapping(value = "/supplier/settlement-method", method = RequestMethod.GET)
    public WebBean<List<Map<String, Object>>> settlementMethod() {
        return WebBean.ok(SettlementMethodEnum.list());
    }

    @ApiOperation(value = "供应商-修改")
    @RequestMapping(value = "/supplier/modify", method = RequestMethod.POST)
    @RequiresPermissions(value = "supplier:submit")
    @Validate(groups = SaveGroup.class)
    public WebBean modify(@RequestBody SupplierDTO dto) {
        facade.modify(dto);
        return WebBean.ok();
    }

    @ApiOperation(value = "供应商-删除")
    @RequestMapping(value = "/supplier/delete", method = RequestMethod.POST)
    @RequiresPermissions(value = "supplier:delete")
    public WebBean delete(@RequestBody SupplierDTO dto) {
        facade.delete(dto.getSupplierCode(), getLoginAdmin().getGroupCode());
        return WebBean.ok();
    }

    @ApiOperation(value = "供应商-列表")
    @RequestMapping(value = "/supplier/list", method = RequestMethod.GET)
    @RequiresPermissions(value = "supplier:list")
    public WebBean<PageBeans<SupplierDTO>> list(SupplierQueryDTO queryDTO) {
        queryDTO.setGroupCode(getLoginAdmin().getGroupCode());
        return WebBean.ok(facade.list(queryDTO));
    }

    @ApiOperation(value = "供应商-条件查询")
    @RequestMapping(value = "/supplier/query", method = RequestMethod.GET)
    public WebBean<List<SupplierDTO>> query(SupplierQueryDTO queryDTO) {
        queryDTO.setGroupCode(getLoginAdmin().getGroupCode());
        queryDTO.setStatus(SupplierStatusEnum.ENABLE.getCode());
        queryDTO.setPageSize(Integer.MAX_VALUE);
        return WebBean.ok(facade.list(queryDTO).getRecord());
    }

    @ApiOperation(value = "供应商-联营-列表")
    @RequestMapping(value = "/supplier/list-joint", method = RequestMethod.GET)
    @RequiresPermissions(value = "supplier:list-joint")
    public WebBean<PageBeans<SupplierDTO>> listJoint(SupplierQueryDTO queryDTO) {
        queryDTO.setGroupCode(getLoginAdmin().getGroupCode());
        // queryDTO.setBusinessMethod(BusinessMethodEnum.JOINT_SALE.getCode());
        return WebBean.ok(facade.list(queryDTO));
    }

    @ApiOperation(value = "供应商-详情")
    @RequestMapping(value = "/supplier/get", method = RequestMethod.GET)
    @RequiresPermissions(value = "supplier:get")
    public WebBean<SupplierDTO> get(@RequestParam(required = true) String supplierCode) {
        return WebBean.ok(facade.get(supplierCode, getLoginAdmin().getGroupCode()));
    }

    @ApiOperation(value = "供应商-根据upc查询")
    @RequestMapping(value = "/supplier/queryByUpc", method = RequestMethod.GET)
    public WebBean<List<SupplierDTO>> queryByUpc(SupplierQueryDTO queryDTO) {
        return WebBean.ok(facade.queryByUpc(queryDTO));
    }

    @ApiOperation(value = "供应商门店-新增")
    @RequestMapping(value = "/supplier-store/create", method = RequestMethod.POST)
    @RequiresPermissions(value = "supplier-store:create")
    @Validate(groups = CreateGroup.class)
    public WebBean createStore(@RequestBody SupplierStoreDTO dto) {
        dto.setGroupCode(getLoginAdmin().getGroupCode());
        facade.createStore(dto);
        return WebBean.ok();
    }

    @ApiOperation(value = "供应商门店-删除")
    @RequestMapping(value = "/supplier-store/delete", method = RequestMethod.POST)
    @RequiresPermissions(value = "supplier-store:delete")
    @Validate
    public WebBean deleteStore(@RequestBody SupplierStoreDTO dto) {
        dto.setGroupCode(getLoginAdmin().getGroupCode());
        facade.deleteStore(dto);
        return WebBean.ok();
    }

    @ApiOperation(value = "供应商门店-列表")
    @RequestMapping(value = "/supplier-store/list", method = RequestMethod.GET)
    @RequiresPermissions(value = "supplier-store:list")
    public WebBean<PageBeans<SupplierStoreDTO>> listStore(SupplierQueryDTO queryDTO) {
        return WebBean.ok(facade.listStore(queryDTO));
    }

    @ApiOperation(value = "供应货品-新增")
    @RequestMapping(value = "/supplier-item/create", method = RequestMethod.POST)
    @RequiresPermissions(value = "supplier-item:create")
    @Validate(groups = CreateGroup.class)
    public WebBean createItem(@RequestBody SupplierItemFormDTO formDTO) {
        formDTO.setGroupCode(getLoginAdmin().getGroupCode());
        facade.createItem(formDTO);
        return WebBean.ok();
    }

    @ApiOperation(value = "供应货品-修改")
    @RequestMapping(value = "/supplier-item/modify", method = RequestMethod.POST)
    @RequiresPermissions(value = "supplier-item:modify")
    @Validate(groups = ModifyGroup.class)
    public WebBean modifyItem(@RequestBody SupplierItemFormDTO formDTO) {
        formDTO.setGroupCode(getLoginAdmin().getGroupCode());
        facade.modifyItem(formDTO);
        return WebBean.ok();
    }

    @ApiOperation(value = "供应货品-删除")
    @RequestMapping(value = "/supplier-item/delete", method = RequestMethod.POST)
    @RequiresPermissions(value = "supplier-item:delete")
    @Validate
    public WebBean deleteItem(@RequestBody SupplierItemDeleteDTO dto) {
        facade.deleteItem(dto);
        return WebBean.ok();
    }

    @ApiOperation(value = "供应货品-列表")
    @RequestMapping(value = "/supplier-item/list", method = RequestMethod.GET)
    @RequiresPermissions(value = "supplier-item:list")
    public WebBean<PageBeans<SupplierItemDTO>> listItem(SupplierQueryDTO queryDTO) {
        return WebBean.ok(facade.listItem(queryDTO));
    }

    @ApiOperation(value = "供应货品-详情")
    @RequestMapping(value = "/supplier-item/get", method = RequestMethod.GET)
    @RequiresPermissions(value = "supplier-item:get")
    public WebBean<SupplierItemDTO> getItem(SupplierQueryDTO queryDTO) {
        return WebBean.ok(facade.getItem(queryDTO));
    }

    @ApiOperation(value = "供应货品-根据upc查询")
    @RequestMapping(value = "/supplier-item/queryByUpc", method = RequestMethod.GET)
    public WebBean<List<SupplierItemDTO>> queryItemByUpc(SupplierQueryDTO queryDTO) {
        return WebBean.ok(facade.queryItem(queryDTO));
    }

    @ApiOperation(value = "供应货品-导入")
    @RequestMapping(value = "/supplier-item/import", method = RequestMethod.POST)
    @RequiresPermissions(value = "supplier-item:import")
    public WebBean importSupplierItem(@RequestParam MultipartFile importFile, @RequestParam(required = true) String supplierCode) {
        List<SupplierItemSaveDTO> items = new ExcelUtil<>(SupplierItemSaveDTO.class).readXLSData(importFile, OriginalType.XLSX);
        SupplierItemFormDTO formDTO = new SupplierItemFormDTO();
        formDTO.setSupplierCode(supplierCode);
        formDTO.setCreateItems(items);
        formDTO.setGroupCode(getLoginAdmin().getGroupCode());
        facade.createItem(formDTO);
        return WebBean.ok();
    }

    @ApiOperation(value = "供应货品-导出")
    @RequestMapping(value = "/supplier-item/export", method = RequestMethod.GET)
    @RequiresPermissions(value = "supplier-item:export")
    public void exportItem(@RequestParam(required = true) String supplierCode, HttpServletResponse response) {
        try {
            List<ExportSuppilerItemDTO> list = facade.queryExportItem(supplierCode);
            new ExcelUtil<>(ExportSuppilerItemDTO.class).writeToHttpResponse(list, "导出供货商品.xls", "供货商品", response);
        } catch (Exception e) {
            throw new RuntimeException("导出货品错误", e);
        }
    }
}
