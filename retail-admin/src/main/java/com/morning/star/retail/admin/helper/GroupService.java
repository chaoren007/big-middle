package com.morning.star.retail.admin.helper;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.morning.star.retail.dto.group.GroupInfoDTO;
import com.morning.star.retail.dto.group.GroupQueryListDTO;
import com.morning.star.retail.facade.GroupFacade;


@Service
public class GroupService {

	@Autowired
	private GroupFacade groupFacade;

	public GroupInfoDTO get(String groupCode) {
		return groupFacade.getByCode(groupCode);
	}

	public List<GroupInfoDTO> query(GroupQueryListDTO groupQueryListDTO) {
		return groupFacade.listGroup(groupQueryListDTO).getRecord();
	}

}
