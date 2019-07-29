package com.morning.star.retail.facade.impl;

import com.github.pagehelper.Page;
import com.google.gson.Gson;
import com.morning.star.retail.application.GroupApplication;
import com.morning.star.retail.dao.GroupDAO;
import com.morning.star.retail.dto.group.*;
import com.morning.star.retail.entity.GroupEntity;
import com.morning.star.retail.entity.repository.GroupRepository;
import com.morning.star.retail.facade.GroupFacade;
import com.morning.star.retail.utils.entity.BeanUtils;
import com.morning.star.retail.utils.page.PageBean;
import com.morning.star.retail.utils.page.PageBeanAssembler;
import com.morning.star.retail.utils.page.RowBoundsBuilder;
import org.apache.commons.lang3.StringUtils;
import org.apache.ibatis.session.RowBounds;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

/**
 * Created by kimhuhg.
 */
@Service
public class GroupFacadeImpl implements GroupFacade {

	private static final Logger LOG = LoggerFactory.getLogger(GroupFacade.class);
	private static final Gson GSON = new Gson();

	@Value("${default.group.code}")
	private String defaultGroupCode;

	@Autowired
	private GroupApplication groupApplication;

	@Autowired
	private GroupRepository groupRepository;

	@Autowired
	private GroupDAO groupDAO;

	@Override
	public String getCode() {
		return this.groupDAO.getCode();
	}

	@Override
	public PageBean<GroupInfoDTO> pageList(GroupQueryPageDTO groupQueryPageDTO) {
		LOG.info("------------------pageListGroup-----------params:{}", GSON.toJson(groupQueryPageDTO));
		GroupQueryDTO groupQueryDTO = new GroupQueryDTO();
		BeanUtils.copy(groupQueryPageDTO, groupQueryDTO);
		RowBounds rowBounds = RowBoundsBuilder.build(groupQueryPageDTO.getPageNo(), groupQueryPageDTO.getPageSize());
		Page<GroupInfoDTO> list = groupDAO.selectAll(groupQueryDTO, rowBounds);
		return new PageBeanAssembler().toBean(list);
	}

	@Override
	public PageBean<GroupInfoDTO> listGroup(GroupQueryListDTO groupQueryListDTO) {
		RowBounds rowBounds = RowBoundsBuilder.build(1, Integer.MAX_VALUE);
		GroupQueryDTO groupQueryDTO = new GroupQueryDTO();
		BeanUtils.copy(groupQueryListDTO, groupQueryDTO);
		Page<GroupInfoDTO> list = groupDAO.selectAll(groupQueryDTO, rowBounds);
		return new PageBeanAssembler().toBean(list);
	}

	@Override
	public GroupInfoDTO getByCode(String groupCode) {
		GroupEntity groupEntity = groupRepository.getByGroupCode(groupCode);
		if (groupEntity == null) {
			return null;
		}
		GroupInfoDTO groupInfoDTO = new GroupInfoDTO();
		BeanUtils.copy(groupEntity, groupInfoDTO);
		return groupInfoDTO;
	}

	@Override
	public void addGroup(GroupCreateDTO groupCreateDTO) {
		this.groupApplication.add(groupCreateDTO);
	}

	@Override
	public void modify(GroupModifyDTO groupModifyDTO) {
		this.groupApplication.modify(groupModifyDTO);
	}

	@Override
	public void delete(String groupCode) {
		this.groupApplication.delete(groupCode);
	}

	@Override
	public GroupInfoDTO getDefault() {
		GroupEntity groupEntity = null;
		if (StringUtils.isNotBlank(defaultGroupCode)) {
			groupEntity = groupRepository.getByGroupCode(defaultGroupCode);
		}
		if (groupEntity == null) {
			groupEntity = groupRepository.getFirstByOrderByGroupCode();
		}
		if (groupEntity == null) {
			return null;
		}
		GroupInfoDTO groupInfoDTO = new GroupInfoDTO();
		BeanUtils.copy(groupEntity, groupInfoDTO);
		return groupInfoDTO;
	}
}
