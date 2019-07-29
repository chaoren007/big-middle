package com.morning.star.retail.admin.group.stock.controller;

import com.morning.star.retail.admin.util.AdminController;
import com.morning.star.retail.admin.util.WebBean;
import com.morning.star.retail.bean.AdminLoginContent;
import com.morning.star.retail.dto.SupplierDTO;
import com.morning.star.retail.facade.PurchaseInFacade;
import com.morning.star.retail.facade.SupplierFacade;
import com.morning.star.retail.facade.dto.purchasein.*;
import com.morning.star.retail.utils.page.PageBean;
import com.morning.star.retail.validate.Validate;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/group/purchase-in/")
@Api(tags = "采购入库单操作")
public class GroupPurchaseInController extends AdminController {

	@Autowired
	private PurchaseInFacade purchaseInFacade;

	@Autowired
	private SupplierFacade supplierFacade;

	@RequestMapping(value = "query", method = RequestMethod.GET)
	@ApiOperation(value = "采购入库单查询")
	public WebBean<PageBean<PurchaseInOrderSimpleDTO>> queryOrder(PurchaseInQueryDTO searchDTO) {
		AdminLoginContent login = getLoginAdmin();
		searchDTO.setGroupCode(login.getGroupCode());

		return WebBean.ok(purchaseInFacade.queryOrder(searchDTO));
	}

	@RequestMapping(value = "get/detail-code", method = RequestMethod.GET)
	@ApiOperation(value = "采购单详情")
	@Validate
	public WebBean<PurchaseInOrderDTO> getByCode(@ApiParam(value = "采购入库单号") PurchaseInGetDTO purchaseInGetDTO) {
		AdminLoginContent login = getLoginAdmin();

		purchaseInGetDTO.setGroupCode(login.getGroupCode());
		PurchaseInOrderDTO returnVale = purchaseInFacade.getByCode(purchaseInGetDTO);
		SupplierDTO supplier = supplierFacade.get(returnVale.getSupplierCode(), login.getGroupCode());
		if (supplier != null) {
			String contract = supplier.getContact();
			returnVale.setSupplierContract(contract);
		}
		return WebBean.ok(returnVale);

	}

	@RequestMapping(value = "update/pre-receipt-time", method = RequestMethod.POST)
	@ApiOperation(value = "更新预计入库时间")
	@Validate
//	@RequiresPermissions(value = {"purchasein:update_pre_receipt_time"})
	public WebBean<Void> updatePreReceiptTime(@RequestBody PurchaseInUpdateDTO purchaseInUpdateDTO) {
		purchaseInFacade.updatePreReceiptTime(purchaseInUpdateDTO);
		return WebBean.ok();

	}

	@RequestMapping(value = "update/pre-receipt-qty", method = RequestMethod.POST)
	@ApiOperation(value = "更新预计入库数量")
	@Validate
//	@RequiresPermissions(value = {"purchasein:update_pre_receipt_qty"})
	public WebBean<Void> updateReceiptQty(@RequestBody PurchaseInUpdateDTO purchaseInUpdateDTO) {
		purchaseInFacade.updateReceiptQty(purchaseInUpdateDTO);
		return WebBean.ok();

	}

	@RequestMapping(value = "audit/close", method = RequestMethod.POST)
	@ApiOperation(value = "关闭订单")
	@Validate
//	@RequiresPermissions(value = {"purchasein:audit_close"})
	public WebBean<Void> auditClose(@RequestBody PurchaseInAuditDTO purchaseInAuditDTO) {
		purchaseInFacade.auditClose(purchaseInAuditDTO);
		return WebBean.ok();

	}

	@RequestMapping(value = "push", method = RequestMethod.GET)
	@ApiOperation(value = "推送采购入库单")
	@Validate
	public WebBean<Void> push(@RequestParam String code) {
		purchaseInFacade.pushThird(code);
		return WebBean.ok();

	}
}
