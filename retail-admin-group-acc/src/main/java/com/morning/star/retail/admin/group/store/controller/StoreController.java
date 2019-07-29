package com.morning.star.retail.admin.group.store.controller;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang3.ObjectUtils;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.morning.star.retail.admin.dto.ChangeRoleDTO;
import com.morning.star.retail.admin.enums.ChangeTypeEnum;
import com.morning.star.retail.admin.facade.AccountFacade;
import com.morning.star.retail.admin.facade.RoleFacade;
import com.morning.star.retail.admin.group.helper.StoreService;
import com.morning.star.retail.admin.group.store.controller.command.CreateStoreCommand;
import com.morning.star.retail.admin.group.store.controller.command.ModifyStoreCommand;
import com.morning.star.retail.admin.group.store.controller.command.QueryStoreCommand;
import com.morning.star.retail.admin.util.AdminController;
import com.morning.star.retail.admin.util.WebBean;
import com.morning.star.retail.bean.AdminLoginContent;
import com.morning.star.retail.dto.store.StoreCreateDTO;
import com.morning.star.retail.dto.store.StoreDTO;
import com.morning.star.retail.dto.store.StoreModifyDTO;
import com.morning.star.retail.dto.store.StoreQueryDTO;
import com.morning.star.retail.utils.page.PageBean;
import com.morning.star.retail.validate.Validate;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api(tags = "门店接口")
@RestController
@RequestMapping("/api/v1")
public class StoreController extends AdminController {

	@Autowired
	private StoreService storeService;
	@Autowired
	private RoleFacade roleFacade;
	@Autowired
	private AccountFacade accountFacade;


	@RequiresPermissions(value = "store:create")
	@ApiOperation(value = "获取门店编码")
	@RequestMapping(value = "/store/code", method = RequestMethod.POST)
	public WebBean<String> genStoreCode() {
		return WebBean.ok(storeService.genCode());
	}

	@RequiresPermissions(value = "store:create")
	@ApiOperation(value = "创建门店")
	@RequestMapping(value = "/store/create", method = RequestMethod.POST)
	@Validate
	public WebBean<Void> addStore(@RequestBody CreateStoreCommand command) {
		StoreCreateDTO dto = new StoreCreateDTO();
		BeanUtils.copyProperties(command, dto);
		dto.setGroupCode(getLoginAdmin().getGroupCode());
		storeService.addStore(dto);
		return WebBean.ok();
	}

	@RequiresPermissions(value = "store:edit")
	@ApiOperation(value = "编辑门店")
	@RequestMapping(value = "/store/edit", method = RequestMethod.POST)
	@Validate
	public WebBean<Void> modifyStore(@RequestBody ModifyStoreCommand command) {

		StoreDTO oldStore = storeService.getStore(command.getStoreCode());

		StoreModifyDTO dto = new StoreModifyDTO();
		BeanUtils.copyProperties(command, dto);
		storeService.modifyStore(dto);

		if (ObjectUtils.notEqual(oldStore.getAccessIds(), command.getAccessIds())) {
			AdminLoginContent login = getLoginAdmin();
			ChangeRoleDTO changeRoleDTO = new ChangeRoleDTO();
			changeRoleDTO.setGroupCode(login.getGroupCode());
			changeRoleDTO.setStoreCode(login.getStoreCode());
			changeRoleDTO.setChangeType(ChangeTypeEnum.GROUP_COMPANY_COMPANY);
			changeRoleDTO.setOldRoleIds(oldStore.getAccessIds());
			changeRoleDTO.setNewRoleIds(command.getAccessIds());
			roleFacade.changeRole(changeRoleDTO);

			accountFacade.changeStoreAdminAccessIds(command.getStoreCode(), command.getAccessIds());
		}

		return WebBean.ok();
	}

	@ApiOperation(value = "获取门店列表")
	@RequestMapping(value = "/store/query", method = RequestMethod.GET)
	public WebBean<PageBean<StoreDTO>> pageListStore(QueryStoreCommand command) {
		StoreQueryDTO dto = new StoreQueryDTO();
		BeanUtils.copyProperties(command, dto);
		dto.setGroupCode(getLoginAdmin().getGroupCode());
		return WebBean.ok(storeService.pageListStore(dto));
	}

	@ApiOperation(value = "获取门店详情")
	@RequestMapping(value = "/store/get", method = RequestMethod.GET)
	public WebBean<StoreDTO> getStoreInfo(String storeCode) {
		if (StringUtils.isBlank(storeCode)) {
			paramsError();
		}
		return WebBean.ok(storeService.getStore(storeCode));
	}

//	@ApiOperation(value = "冻结门店")
//	@RequestMapping(value = "/store/freeze", method = RequestMethod.POST)
//	public WebBean<Void> freezeStore(String storeCode) {
//		storeService.freezeStore(storeCode);
//		return WebBean.success();
//	}
//
//	@ApiOperation(value = "解冻门店")
//	@RequestMapping(value = "/store/unfreeze", method = RequestMethod.POST)
//	public WebBean<Void> unfreezeStore(String storeCode) {
//		storeService.unfreezeStore(storeCode);
//		return WebBean.success();
//	}

}
