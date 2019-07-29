package com.morning.star.retail.admin.god.group.controller;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.Validate;
import org.apache.commons.lang3.ObjectUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.morning.star.retail.admin.dto.ChangeRoleDTO;
import com.morning.star.retail.admin.enums.ChangeTypeEnum;
import com.morning.star.retail.admin.facade.AccountFacade;
import com.morning.star.retail.admin.facade.RoleFacade;
import com.morning.star.retail.admin.god.group.controller.command.QueryGroupCommand;
import com.morning.star.retail.admin.god.group.controller.command.QueryGroupListCommand;
import com.morning.star.retail.admin.god.group.controller.command.QueryGroupPageCommand;
import com.morning.star.retail.admin.util.AdminController;
import com.morning.star.retail.admin.util.BeanUtils;
import com.morning.star.retail.admin.util.WebBean;
import com.morning.star.retail.bean.AdminLoginContent;
import com.morning.star.retail.dto.group.GroupCreateDTO;
import com.morning.star.retail.dto.group.GroupDeleteDTO;
import com.morning.star.retail.dto.group.GroupInfoDTO;
import com.morning.star.retail.dto.group.GroupModifyDTO;
import com.morning.star.retail.dto.group.GroupQueryListDTO;
import com.morning.star.retail.dto.group.GroupQueryPageDTO;
import com.morning.star.retail.facade.GroupFacade;
import com.morning.star.retail.utils.page.PageBean;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

/**
 * Created by lenovo on 2017/10/12.
 */
@Api(tags = "集团接口")
@Controller
@RequestMapping("/api/god/group/")
public class GroupController extends AdminController {

	@Autowired
	private GroupFacade groupFacade;
	@Autowired
	private RoleFacade roleFacade;

	@Autowired
	private AccountFacade accountFacade;

	private static final String pre = "JT";

	@ApiOperation(value = "获取集团编码")
	@RequestMapping(value = "get-code", method = RequestMethod.GET)
	@ResponseBody
	public WebBean<GroupCreateDTO> getCode() {
		String code = this.groupFacade.getCode();
		if (StringUtils.isBlank(code)) {
			code = pre + "0";
		}
		String groupCode;
		groupCode = autoGenericCode(Integer.parseInt(code.split(pre)[1]), 8);
		GroupCreateDTO groupCreateDTO = new GroupCreateDTO();
		groupCreateDTO.setGroupCode(groupCode);
		return WebBean.ok(groupCreateDTO);
	}

	@ApiOperation(value = "新增集团信息")
	@RequestMapping(value = "add", method = RequestMethod.POST)
	@ResponseBody
	public WebBean<Void> add(@Validated @RequestBody GroupCreateDTO groupCreateDTO) {
		AdminLoginContent login = getLoginAdmin();
		groupCreateDTO.setCreator(login.getAccount());
		groupCreateDTO.setCreatorName(login.getName());
		if (groupCreateDTO.getProvinceId() != 810000 &&
			groupCreateDTO.getProvinceId() != 820000) {
			if (groupCreateDTO.getDistrictId() == null) {
				throw new IllegalArgumentException("区域ID不能为空");
			}
			if (StringUtils.isBlank(groupCreateDTO.getDistrict())) {
				throw new IllegalArgumentException("区域不能为空");
			}
		}
		this.groupFacade.addGroup(groupCreateDTO);

		return WebBean.ok();
	}

	@ApiOperation(value = "编辑集团信息")
	@RequestMapping(value = "edit", method = RequestMethod.POST)
	@ResponseBody
	public WebBean<Void> edit(@Validated @RequestBody GroupModifyDTO groupModifyDTO) {
		if (groupModifyDTO.getProvinceId() != 810000 &&
			groupModifyDTO.getProvinceId() != 820000) {
			if (groupModifyDTO.getDistrictId() == null) {
				throw new IllegalArgumentException("区域ID不能为空");
			}
			if (StringUtils.isBlank(groupModifyDTO.getDistrict())) {
				throw new IllegalArgumentException("区域不能为空");
			}
		}

		GroupInfoDTO group = this.groupFacade.getByCode(groupModifyDTO.getGroupCode());
		Validate.isTrue(group != null, "根据集团编号查询的集团信息不存在");
		String oldGroupAccessIds = group.getAccessIds();
		String oldRoleIds = group.getRoleIds();

		this.groupFacade.modify(groupModifyDTO);
		GroupCreateDTO groupCreateDTO = new GroupCreateDTO();
		BeanUtils.copy(groupModifyDTO, groupCreateDTO);
		changRole(groupCreateDTO, groupModifyDTO.getAccessIds(), oldGroupAccessIds, ChangeTypeEnum.ROOT_GROUP_GROUP);
		changRole(groupCreateDTO, groupModifyDTO.getRoleIds(), oldRoleIds, ChangeTypeEnum.ROOT_GROUP_COMPANY);

		if (ObjectUtils.notEqual(groupModifyDTO.getAccessIds(), oldGroupAccessIds)) {
			accountFacade.changeGroupAdminAccessIds(groupModifyDTO.getGroupCode(), groupModifyDTO.getAccessIds());
		}
		return WebBean.ok();
	}

	@ApiOperation(value = "删除集团信息")
	@RequestMapping(value = "delete", method = RequestMethod.POST)
	@ResponseBody
	public WebBean<Void> delete(@ApiParam(value = "集团编码", required = true) @RequestBody GroupDeleteDTO groupDeleteDTO) {
		this.groupFacade.delete(groupDeleteDTO.getGroupCode());
		return WebBean.ok();
	}

	@ApiOperation(value = "获取集团分页信息")
	@RequestMapping(value = "query", method = RequestMethod.POST)
	@ResponseBody
	public WebBean<PageBean<GroupInfoDTO>> query(@RequestBody QueryGroupPageCommand queryGroupPageCommand) {
		GroupQueryPageDTO groupQueryPageDTO = new GroupQueryPageDTO();
		BeanUtils.copy(queryGroupPageCommand, groupQueryPageDTO);
		PageBean<GroupInfoDTO> page = this.groupFacade.pageList(groupQueryPageDTO);
		return WebBean.ok(page);
	}

	@ApiOperation(value = "获取集团信息列表")
	@RequestMapping(value = "list", method = RequestMethod.POST)
	@ResponseBody
	public WebBean<PageBean<GroupInfoDTO>> list(@RequestBody QueryGroupListCommand queryGroupListCommand) {
		GroupQueryListDTO groupQueryListDTO = new GroupQueryListDTO();
		BeanUtils.copy(queryGroupListCommand, groupQueryListDTO);
		PageBean<GroupInfoDTO> list = this.groupFacade.listGroup(groupQueryListDTO);
		return WebBean.ok(list);
	}

	@ApiOperation(value = "根据条件获取集团信息")
	@RequestMapping(value = "get-info", method = RequestMethod.POST)
	@ResponseBody
	public WebBean<GroupInfoDTO> getInfo(@RequestBody QueryGroupCommand queryGroupCommand) {
		Validate.isTrue(StringUtils.isNotBlank(queryGroupCommand.getGroupCode()), "集团编码不能为空");
		GroupInfoDTO info = this.groupFacade.getByCode(queryGroupCommand.getGroupCode());
		Validate.isTrue(info != null, "该集团不存在");

		return WebBean.ok(info);
	}

	private static String autoGenericCode(int code, int num) {
		String result = "";
		// 保留num的位数
		// 0 代表前面补充0
		// d 代表参数为正数型
		result = String.format(pre + "%0" + num + "d", code + 1);
		return result;
	}


	private void changRole(GroupCreateDTO groupCreateDTO, String newRoles, String oldRoles, ChangeTypeEnum changeTypeEnum) {
		ChangeRoleDTO roleDTO = new ChangeRoleDTO();
		roleDTO.setGroupCode(groupCreateDTO.getGroupCode());
		roleDTO.setChangeType(changeTypeEnum);
		roleDTO.setOldRoleIds(oldRoles);
		roleDTO.setNewRoleIds(newRoles);
		this.roleFacade.changeRole(roleDTO);
	}
}
