package com.morning.star.retail.admin.group.stock.controller;

import com.morning.star.retail.admin.util.AdminController;
import com.morning.star.retail.admin.util.WebBean;
import com.morning.star.retail.bean.AdminLoginContent;
import com.morning.star.retail.bean.WebJsonBean;
import com.morning.star.retail.facade.OutStockFacade;
import com.morning.star.retail.facade.dto.out.OutStockDTO;
import com.morning.star.retail.facade.dto.out.OutStockGetDTO;
import com.morning.star.retail.facade.dto.out.OutStockQueryDTO;
import io.swagger.annotations.Api;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 出库
 *
 * @author jiangyf
 * @date 2018/3/13
 */
@Api(tags = "出库操作")
@Controller
@RequestMapping("/api/group/outstock/")
public class GroupOutStockController extends AdminController {

	@Autowired
	private OutStockFacade outStockFacade;

	/**
	 * 分页查询
	 */
	@RequiresPermissions(value = {"group:outstock:page"})
	@RequestMapping(value = "page", method = RequestMethod.GET)
	@ResponseBody
	public WebJsonBean page(OutStockQueryDTO queryDTO) {
		queryDTO.setGroupCode(getLoginAdmin().getGroupCode());
		return success(outStockFacade.pageQuery(queryDTO));
	}

	/**
	 * 详情
	 */
	@RequiresPermissions(value = {"group:outstock:detail"})
	@RequestMapping(value = "detail", method = RequestMethod.GET)
	@ResponseBody
	public WebBean<OutStockDTO> detail(@RequestParam(required = true) String code) {
		AdminLoginContent login = getLoginAdmin();
		OutStockGetDTO command = new OutStockGetDTO();
		command.setGroupCode(login.getGroupCode());
		command.setOutStockCode(code);
		return WebBean.ok(outStockFacade.detail(command));
	}

}
