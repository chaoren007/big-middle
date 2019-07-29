package com.morning.star.retail.stock.controller;

import com.google.gson.Gson;
import com.morning.star.retail.bean.AdminLoginContent;
import com.morning.star.retail.bean.WebJsonBean;
import com.morning.star.retail.facade.PurchaseFacade;
import com.morning.star.retail.facade.dto.purchase.*;
import com.morning.star.retail.stock.enums.PurchaseStatusEnum;
import io.swagger.annotations.ApiOperation;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by lenovo on 2017/10/25.
 */
@Controller
@RequestMapping("/api/v1/")
public class PurchaseController extends BaseController {
	private static final Logger LOGGER = LoggerFactory
		.getLogger(PurchaseController.class);
	private static final Gson GSON = new Gson();

	@Autowired
	private PurchaseFacade purchaseFacade;

	public AdminLoginContent getLoginAdmin() {
		AdminLoginContent login = new AdminLoginContent();
		login.setId(0L);
		login.setName("watermelon");
		login.setGroupCode("JT00000005");
		login.setStoreCode("GS00000016");
		return login;
	}

	@ApiOperation(value = "获取采购单详情")
	@RequestMapping(value = "purchase/{purchaseCode}/detail", method = RequestMethod.GET)
	@ResponseBody
	public WebJsonBean getPurchaseByCode(@PathVariable String purchaseCode) {
		AdminLoginContent login = getLoginAdmin();

		PurchaseOrderDTO returnVale = purchaseFacade.getPurchaseByCode(new PurchaseGetDTO(purchaseCode, login.getGroupCode()));

		return success(returnVale);

	}

	@ApiOperation(value = "提交采购单")
	@RequestMapping(value = "purchase", method = RequestMethod.POST)
	@ResponseBody
	public WebJsonBean submitOrder(@RequestBody PurchaseSubmitDTO purchaseSubmitDTO) {
		AdminLoginContent login = getLoginAdmin();

		purchaseSubmitDTO.setStoreCode(login.getStoreCode());
		purchaseSubmitDTO.setGroupCode(login.getGroupCode());

		String result = purchaseFacade.submitOrder(purchaseSubmitDTO);

		if (StringUtils.isNotEmpty(result)) {
			return success(result);
		} else {
			return fail(result);
		}
	}

	@ApiOperation(value = "提交采购单草稿")
	@RequestMapping(value = "purchase/prepare", method = RequestMethod.POST)
	@ResponseBody
	public WebJsonBean prepareOrder(@RequestBody PurchaseUpdateDTO purchaseUpdateDTO) {
		AdminLoginContent login = getLoginAdmin();

		purchaseUpdateDTO.setStoreCode(login.getStoreCode());
		purchaseUpdateDTO.setGroupCode(login.getGroupCode());

		String result = purchaseFacade.updateOrder(purchaseUpdateDTO);
		if (StringUtils.isNotEmpty(result)) {
			return success(result);
		} else {
			return fail(result);
		}
	}

	@ApiOperation(value = "采购单审核失败")
	@RequestMapping(value = "purchase/{purchaseOrderCode}/audit_fail/", method = RequestMethod.POST)
	@ResponseBody
	public WebJsonBean auditFail(@PathVariable String purchaseOrderCode) {
		AdminLoginContent login = getLoginAdmin();

		PurchaseAuditDTO purchaseOrderDTO = new PurchaseAuditDTO();
		purchaseOrderDTO.setPurchaseCode(purchaseOrderCode);
		purchaseOrderDTO.setStatus(PurchaseStatusEnum.AUDIT_REJECT.getCode());
		LOGGER.info("--auditFail-------PurchaseOrderDTO:{}", GSON.toJson(purchaseOrderDTO));
		int returnVale = purchaseFacade.auditPurchase(purchaseOrderDTO);

		if (returnVale > 0) {
			return success(returnVale);
		} else {
			return fail(returnVale);
		}
	}

	@ApiOperation(value = "采购单审核成功")
	@RequestMapping(value = "purchase/{purchaseOrderCode}/audit_success/", method = RequestMethod.POST)
	@ResponseBody
	public WebJsonBean auditSuccess(@PathVariable String purchaseOrderCode) {
		AdminLoginContent login = getLoginAdmin();

		PurchaseAuditDTO purchaseOrderDTO = new PurchaseAuditDTO();
		purchaseOrderDTO.setPurchaseCode(purchaseOrderCode);
		purchaseOrderDTO.setStatus(PurchaseStatusEnum.AUDIT_SUCCESS.getCode());
		LOGGER.info("--auditSuccess-------PurchaseOrderDTO:{}", GSON.toJson(purchaseOrderDTO));
		int returnVale = purchaseFacade.auditPurchase(purchaseOrderDTO);

		if (returnVale > 0) {
			return success(returnVale);
		} else {
			return fail(returnVale);
		}
	}

	@ApiOperation(value = "采购单删除")
	@RequestMapping(value = "purchase/{purchaseOrderCode}/", method = RequestMethod.DELETE)
	@ResponseBody
	public WebJsonBean deletePurchase(@PathVariable String purchaseOrderCode) {
		AdminLoginContent login = getLoginAdmin();

		PurchaseDeleteDTO dto = new PurchaseDeleteDTO();
		dto.setPurchaseCode(purchaseOrderCode);

		Integer returnVale = purchaseFacade.deletePurchase(dto);

		if (returnVale > 0) {
			return success(returnVale);
		} else {
			return fail(returnVale);
		}
	}

	@ApiOperation(value = "采购单分页查询")
	@RequestMapping(value = "purchase", method = RequestMethod.GET)
	@ResponseBody
	public WebJsonBean queryOrder(PurchaseQueryDTO searchDTO) {
		AdminLoginContent login = getLoginAdmin();
		searchDTO.setGroupCode(login.getGroupCode());
		searchDTO.setStoreCode(login.getStoreCode());

		Object returnVale = purchaseFacade.queryOrder(searchDTO);

		return success(returnVale);

	}

	@ApiOperation(value = "校验供应商")
	@RequestMapping(value = "supplier/verify/", method = RequestMethod.POST)
	@ResponseBody
	public WebJsonBean verifySupplierItem(@RequestBody PurchaseOrderDTO purchaseOrderDTO) {
		List<String> list = purchaseFacade.checkSupplierRelationship(purchaseOrderDTO);
		if (list == null || list.size() <= 0) {
			return success();
		} else {
			return fail(list);
		}
	}
}
