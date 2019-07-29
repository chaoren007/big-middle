package com.morning.star.retail.admin.controller.supplier;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.morning.star.retail.admin.util.AdminController;
import com.morning.star.retail.bean.WebJsonBean;
import com.morning.star.retail.dto.SupplierChangeDTO;
import com.morning.star.retail.dto.SupplierQueryDTO;
import com.morning.star.retail.enums.SupplierChangeStatusEnum;
import com.morning.star.retail.facade.SupplierChangeFacade;
import com.morning.star.retail.util.UniqueNoUtils;
import com.morning.star.retail.validate.SaveGroup;
import com.morning.star.retail.validate.Validate;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

/**
 * 供应商变更
 *
 * @author jiangyf
 */
@Api(tags = "供应商变更")
@RestController
@RequestMapping("/api")
public class SupplierChangeController extends AdminController {

    @Autowired
    private SupplierChangeFacade facade;

    @ApiOperation(value = "供应商变更-生成单号")
    @RequestMapping(value = "/supplier-change/code", method = RequestMethod.POST)
    public WebJsonBean code() {
        return success(UniqueNoUtils.next(UniqueNoUtils.UniqueNoType.SCC));
    }

    @ApiOperation(value = "供应商变更-保存草稿")
    @RequestMapping(value = "/supplier-change/draft", method = RequestMethod.POST)
    @RequiresPermissions(value = "supplier-change:draft")
    @Validate(groups = SaveGroup.class)
    public WebJsonBean draft(@RequestBody SupplierChangeDTO dto) {
        facade.save(SupplierChangeDTO.forSave(dto, getLoginAdmin(), SupplierChangeStatusEnum.DRAFT));
        return success();
    }

    @ApiOperation(value = "供应商变更-提交审核")
    @RequestMapping(value = "/supplier-change/submit", method = RequestMethod.POST)
    @RequiresPermissions(value = "supplier-change:submit")
    @Validate(groups = SaveGroup.class)
    public WebJsonBean submit(@RequestBody SupplierChangeDTO dto) {
        facade.save(SupplierChangeDTO.forSave(dto, getLoginAdmin(), SupplierChangeStatusEnum.WAIT_AUDIT));
        return success();
    }

    @ApiOperation(value = "供应商变更-审核通过")
    @RequestMapping(value = "/supplier-change/audit-success", method = RequestMethod.POST)
    @RequiresPermissions(value = "supplier-change:audit-success")
    @Validate
    public WebJsonBean auditSuccess(@RequestBody SupplierChangeDTO dto) {
        facade.audit(SupplierChangeDTO.forAudit(dto, getLoginAdmin(), SupplierChangeStatusEnum.AUDIT_SUCCESS));
        return success();
    }

    @ApiOperation(value = "供应商变更-审核失败")
    @RequestMapping(value = "/supplier-change/audit-fail", method = RequestMethod.POST)
    @RequiresPermissions(value = "supplier-change:audit-fail")
    @Validate
    public WebJsonBean auditFail(@RequestBody SupplierChangeDTO dto) {
        facade.audit(SupplierChangeDTO.forAudit(dto, getLoginAdmin(), SupplierChangeStatusEnum.AUDIT_FAIL));
        return success();
    }

    @ApiOperation(value = "供应商变更-删除")
    @RequestMapping(value = "/supplier-change/delete", method = RequestMethod.POST)
    @RequiresPermissions(value = "supplier-change:delete")
    @Validate
    public WebJsonBean delete(@RequestBody SupplierChangeDTO dto) {
        facade.delete(SupplierChangeDTO.from(dto.getCode(), getLoginAdmin()));
        return success();
    }

    @ApiOperation(value = "供应商变更-列表")
    @RequestMapping(value = "/supplier-change/list", method = RequestMethod.GET)
    @RequiresPermissions(value = "supplier-change:list")
    public WebJsonBean list(SupplierQueryDTO queryDTO) {
        return success(facade.list(queryDTO));
    }

    @ApiOperation(value = "供应商变更-详情")
    @RequestMapping(value = "/supplier-change/get", method = RequestMethod.GET)
    @RequiresPermissions(value = "supplier-change:get")
    public WebJsonBean get(@RequestParam(required = true) String code) {
        return success(facade.get(code, getLoginAdmin().getGroupCode()));
    }

    @ApiOperation(value = "供应商变更-门店-列表")
    @RequestMapping(value = "/supplier-change-store/list", method = RequestMethod.GET)
    @RequiresPermissions(value = "supplier-change-store:list")
    public WebJsonBean listStore(SupplierQueryDTO queryDTO) {
        return success(facade.listStore(queryDTO));
    }

    @ApiOperation(value = "供应商变更-供应货品-列表")
    @RequestMapping(value = "/supplier-change-item/list", method = RequestMethod.GET)
    @RequiresPermissions(value = "supplier-change-item:list")
    public WebJsonBean listItem(SupplierQueryDTO queryDTO) {
        return success(facade.listItem(queryDTO));
    }

}
