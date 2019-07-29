package com.morning.star.retail.application.impl;

import org.apache.commons.lang.Validate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.morning.star.retail.admin.facade.AccountFacade;
import com.morning.star.retail.application.GroupApplication;
import com.morning.star.retail.dto.group.GroupCreateDTO;
import com.morning.star.retail.dto.group.GroupModifyDTO;
import com.morning.star.retail.entity.GroupEntity;
import com.morning.star.retail.entity.GroupWaterEntity;
import com.morning.star.retail.entity.repository.GroupRepository;
import com.morning.star.retail.entity.repository.GroupWaterRepository;
import com.morning.star.retail.utils.entity.BeanUtils;

/**
 * Created by kimhuhg.
 */
@Service
public class GroupApplicationImpl implements GroupApplication {

	@Autowired
	private GroupRepository groupRepository;

	@Autowired
	private GroupWaterRepository groupWaterRepository;

	@Autowired
	private AccountFacade accountFacade;

	@Transactional
	@Override
	public void add(GroupCreateDTO groupCreateDTO) {
		String groupCode = groupCreateDTO.getGroupCode();
		String groupName = groupCreateDTO.getGroupName();
		Validate.isTrue(!groupRepository.exists(groupCode),
			"集团编码已存在：" + groupCode);
		Validate.isTrue(!groupRepository.existsByGroupName(groupName),
			"集团名称已存在：" + groupName);
		GroupEntity groupEntity = new GroupEntity();
		BeanUtils.copy(groupCreateDTO, groupEntity);
		this.groupRepository.save(groupEntity);

		GroupWaterEntity groupWaterEntity = new GroupWaterEntity();
		BeanUtils.copy(groupCreateDTO, groupWaterEntity);
		groupWaterEntity.setOperateType(groupWaterEntity.OPERATOR_ADD);
		this.groupWaterRepository.save(groupWaterEntity);
	}

	@Transactional
	@Override
	public void modify(GroupModifyDTO groupModifyDTO) {
		GroupEntity one = this.groupRepository.getByGroupCode(groupModifyDTO.getGroupCode());
		Validate.isTrue(one != null, "修改集团不存在");
		BeanUtils.copy(groupModifyDTO, one);
		this.groupRepository.save(one);

		GroupWaterEntity groupWaterEntity = new GroupWaterEntity();
		BeanUtils.copy(groupModifyDTO, groupWaterEntity);
		groupWaterEntity.setOperateType(groupWaterEntity.OPERATOR_MODIFY);
		this.groupWaterRepository.save(groupWaterEntity);
	}

	@Transactional
	@Override
	public void delete(String groupCode) {
		Validate.isTrue(!accountFacade.existGroupAccount(groupCode), "集团下面存在账号，不能删除");

		GroupEntity one = this.groupRepository.getByGroupCode(groupCode);
		Validate.isTrue(one != null, "删除集团不存在");
		one.setDeleteFlag(1);
		this.groupRepository.save(one);

		GroupWaterEntity groupWaterEntity = new GroupWaterEntity();
		BeanUtils.copy(one, groupWaterEntity);
		groupWaterEntity.setOperateType(groupWaterEntity.OPERATOR_DELETE);
		this.groupWaterRepository.save(groupWaterEntity);
	}
}
