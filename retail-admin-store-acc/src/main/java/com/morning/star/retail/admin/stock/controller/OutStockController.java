package com.morning.star.retail.admin.stock.controller;

import com.morning.star.retail.admin.util.AdminController;
import com.morning.star.retail.admin.util.WebBean;
import com.morning.star.retail.bean.AdminLoginContent;
import com.morning.star.retail.facade.OutStockFacade;
import com.morning.star.retail.facade.dto.out.*;
import com.morning.star.retail.stock.dto.OutstockOrderDTO;
import com.morning.star.retail.util.UniqueNoUtils;
import com.morning.star.retail.utils.page.PageBean;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@Api(tags = "出库操作")
@RestController
@RequestMapping("/api/out-stock/")
public class OutStockController extends AdminController {

	@Autowired
	private OutStockFacade outStockFacade;

	@RequestMapping(value = "generate-code", method = RequestMethod.GET)
	@ApiOperation(value = "获取出库单号")
	@RequiresPermissions(value = {"outstock:create"})
	public WebBean<OutstockOrderDTO> generateCode() {
		AdminLoginContent content = getLoginAdmin();
		OutstockOrderDTO orderDTO = new OutstockOrderDTO();
		orderDTO.setOutstockCode(UniqueNoUtils.nextInc(UniqueNoUtils.UniqueNoType.OSC, 5));
		orderDTO.setSenderCode(content.getStoreCode());
		orderDTO.setSenderName(content.getStoreName());
		return WebBean.ok(orderDTO);
	}

	/**
	 * 保存草稿
	 */
	@RequiresPermissions(value = {"outstock:create"})
	@RequestMapping(value = "submit/draft", method = RequestMethod.POST)
	@ApiOperation(value = "保存草稿")
	public WebBean<Void> saveDraft(@RequestBody OutStockSubmitDTO submitDTO) {
		submitDTO.setGroupCode(getLoginAdmin().getGroupCode());
		submitDTO.setGroupName(getLoginAdmin().getGroupName());
		submitDTO.setOutStoreCode(getLoginAdmin().getStoreCode());
		submitDTO.setIsDraft(1);
		outStockFacade.save(submitDTO);
		return WebBean.ok();
	}

	/**
	 * 提交审核
	 */
	@RequiresPermissions(value = {"outstock:create"})
	@RequestMapping(value = "submit", method = RequestMethod.POST)
	@ApiOperation(value = "提交审核")
	public WebBean<Void> submit(@RequestBody OutStockSubmitDTO submitDTO) {
		submitDTO.setGroupCode(getLoginAdmin().getGroupCode());
		submitDTO.setOutStoreCode(getLoginAdmin().getStoreCode());
		submitDTO.setIsDraft(0);
		outStockFacade.save(submitDTO);
		return WebBean.ok();
	}

	/**
	 * 分页查询
	 */
	@RequiresPermissions(value = {"outstock:page"})
	@RequestMapping(value = "page", method = RequestMethod.GET)
	@ApiOperation(value = "分页查询出库单")
	public WebBean<PageBean<OutStockDTO>> page(OutStockQueryDTO command) {
		AdminLoginContent login = getLoginAdmin();
		command.setGroupCode(login.getGroupCode());
		command.setStoreCode(login.getStoreCode());

		return WebBean.ok(outStockFacade.pageQuery(command));
	}

	/**
	 * 查看详情
	 */
	@RequiresPermissions(value = {"outstock:detail"})
	@RequestMapping(value = "detail", method = RequestMethod.GET)
	@ApiOperation(value = "出库单详情")
	public WebBean<OutStockDTO> detail(@RequestParam(required = true) String code) {
		AdminLoginContent login = getLoginAdmin();
		OutStockGetDTO command = new OutStockGetDTO();
		command.setGroupCode(login.getGroupCode());
		command.setStoreCode(login.getStoreCode());
		command.setOutStockCode(code);
		return WebBean.ok(outStockFacade.detail(command));
	}

	/**
	 * 删除出库单
	 */
	@RequiresPermissions(value = {"outstock:delete"})
	@RequestMapping(value = "delete", method = RequestMethod.POST)
	@ApiOperation(value = "删除出库单")
	public WebBean<Void> delete(@RequestBody OutStockAuditDTO auditDTO) {
		outStockFacade.delete(auditDTO.getOutStockCode());

		return WebBean.ok();
	}

	/**
	 * 审核成功
	 */
	@RequiresPermissions(value = {"outstock:audit"})
	@RequestMapping(value = "audit/success", method = RequestMethod.POST)
	@ApiOperation(value = "审核成功")
	public WebBean<Void> auditSuccess(@RequestBody OutStockAuditDTO auditDTO) {
		auditDTO.setStatus(20);
		outStockFacade.audit(auditDTO);
		return WebBean.ok();
	}

	/**
	 * 审核驳回
	 */
	@RequiresPermissions(value = {"outstock:audit"})
	@RequestMapping(value = "audit/reject", method = RequestMethod.POST)
	@ApiOperation(value = "审核驳回")
	public WebBean<Void> auditReject(@RequestBody OutStockAuditDTO auditDTO) {
		auditDTO.setStatus(30);
		outStockFacade.audit(auditDTO);
		return WebBean.ok();

	}

	@RequiresPermissions(value = {"outstock:outstock"})
	@RequestMapping(value = "audit/out", method = RequestMethod.POST)
	@ApiOperation(value = "确认出库")
	public WebBean<Void> auditOut(@RequestBody OutStockOutDTO outStockOutDTO) {
		outStockFacade.auditOut(outStockOutDTO);
		return WebBean.ok();
	}
}
