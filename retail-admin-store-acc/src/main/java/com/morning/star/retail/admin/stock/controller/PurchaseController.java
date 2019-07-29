package com.morning.star.retail.admin.stock.controller;

import com.morning.star.retail.admin.stock.controller.enums.PurchaseStatusEnum;
import com.morning.star.retail.admin.util.AdminController;
import com.morning.star.retail.admin.util.WebBean;
import com.morning.star.retail.bean.AdminLoginContent;
import com.morning.star.retail.dto.SupplierDTO;
import com.morning.star.retail.facade.PurchaseFacade;
import com.morning.star.retail.facade.SupplierFacade;
import com.morning.star.retail.facade.dto.purchase.*;
import com.morning.star.retail.utils.page.PageBean;
import com.morning.star.retail.validate.Validate;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.apache.commons.lang.StringUtils;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/purchase/")
@Api(tags = "采购单操作")
public class PurchaseController extends AdminController {
	@Autowired
	private PurchaseFacade purchaseFacade;
	@Autowired
	private SupplierFacade supplierFacade;

	@RequestMapping(value = "add", method = RequestMethod.POST)
	@ResponseBody
	@ApiOperation(value = "提交采购单")
	@Validate
	public WebBean<String> submitOrder(@RequestBody PurchaseSubmitDTO purchaseSubmitDTO) {
		AdminLoginContent login = getLoginAdmin();
		purchaseSubmitDTO.fillLoginUser(login);
		purchaseSubmitDTO.setIsDraft(0);
		purchaseSubmitDTO.setSubmitType(20);
		String result = purchaseFacade.submitOrder(purchaseSubmitDTO);
		if (StringUtils.isNotEmpty(result)) {
			return WebBean.ok(result);
		} else {
			return WebBean.fail(result);
		}
	}

	@RequestMapping(value = "add/prepare", method = RequestMethod.POST)
	@ApiOperation(value = "提交采购单草稿")
	@Validate
//	@RequiresPermissions(value = {"purchase:prepare_add"})
	public WebBean<String> prepareOrder(@RequestBody PurchaseSubmitDTO purchaseSubmitDTO) {
		AdminLoginContent login = getLoginAdmin();
		purchaseSubmitDTO.fillLoginUser(login);
		purchaseSubmitDTO.setIsDraft(1);
		purchaseSubmitDTO.setSubmitType(20);

		String result = purchaseFacade.submitOrder(purchaseSubmitDTO);
		return StringUtils.isNotEmpty(result) ? WebBean.ok(result) : WebBean.fail(result);
	}

	@RequestMapping(value = "update", method = RequestMethod.POST)
	@ApiOperation(value = "更新采购单")
	@Validate
//	@RequiresPermissions(value = {"purchase:update"})
	public WebBean<String> prepareOrder(@RequestBody PurchaseUpdateDTO purchaseUpdateDTO) {
		AdminLoginContent login = getLoginAdmin();
		purchaseUpdateDTO.setGroupCode(login.getGroupCode());
		purchaseUpdateDTO.setStoreCode(login.getStoreCode());

		String result = purchaseFacade.updateOrder(purchaseUpdateDTO);
		return StringUtils.isNotEmpty(result) ? WebBean.ok(result) : WebBean.fail(result);
	}

	@RequestMapping(value = "audit/fail", method = RequestMethod.POST)
	@ApiOperation(value = "采购单审核不通过")
	@Validate
//	@RequiresPermissions(value = {"purchase:audit_fail"})
	public WebBean<Integer> auditFail(@RequestBody PurchaseAuditDTO purchaseOrderDTO) {
		purchaseOrderDTO.setStatus(PurchaseStatusEnum.AUDIT_REJECT.getCode());

		Integer returnVale = purchaseFacade.auditPurchase(purchaseOrderDTO);

		return returnVale > 0 ? WebBean.ok(returnVale) : WebBean.fail();
	}

	@RequestMapping(value = "audit/success", method = RequestMethod.POST)
	@ApiOperation(value = "采购单审核通过")
	@Validate
//	@RequiresPermissions(value = {"purchase:audit_success"})
	public WebBean<Integer> auditSuccess(@RequestBody PurchaseAuditDTO purchaseOrderDTO) {
		purchaseOrderDTO.setStatus(PurchaseStatusEnum.AUDIT_SUCCESS.getCode());
		Integer returnVale = purchaseFacade.auditPurchase(purchaseOrderDTO);

		return returnVale > 0 ? WebBean.ok(returnVale) : WebBean.fail();
	}

	@RequestMapping(value = "delete", method = RequestMethod.POST)
	@ApiOperation(value = "采购单草稿删除")
	@Validate
//	@RequiresPermissions(value = {"purchase:delete"})
	public WebBean<Integer> delete(@RequestBody PurchaseDeleteDTO purchaseDeleteDTO) {
		Integer returnVale = purchaseFacade.deletePurchase(purchaseDeleteDTO);

		return returnVale > 0 ? WebBean.ok(returnVale) : WebBean.fail();
	}

	@RequestMapping(value = "query", method = RequestMethod.GET)
	@ApiOperation(value = "采购单查询")
//	@RequiresPermissions(value = {"purchase:list"})
	public WebBean<PageBean<PurchaseOrderSimpleDTO>> query(PurchaseQueryDTO searchDTO) {
		AdminLoginContent login = getLoginAdmin();
		searchDTO.setGroupCode(login.getGroupCode());
		searchDTO.setStoreCode(login.getStoreCode());

		return WebBean.ok(purchaseFacade.queryOrder(searchDTO));
	}

	@RequestMapping(value = "get/detail-code", method = RequestMethod.GET)
	@ApiOperation(value = "采购单详情")
	@Validate
//	@RequiresPermissions(value = {"purchase:detail"})
	public WebBean<PurchaseOrderDTO> getByCode(@ApiParam(value = "采购单号") PurchaseGetDTO purchaseGetDTO) {
		AdminLoginContent login = getLoginAdmin();

		purchaseGetDTO.setGroupCode(login.getGroupCode());
		purchaseGetDTO.setStoreCode(login.getStoreCode());
		PurchaseOrderDTO returnVale = purchaseFacade.getPurchaseByCode(purchaseGetDTO);
		/*SupplierDTO supplier = supplierFacade.get(returnVale.getSupplierCode(), login.getGroupCode());
		if (supplier != null) {
			String contract = supplier.getContact();
			returnVale.setSupplierContract(contract);
		}*/
		return WebBean.ok(returnVale);

	}
}
