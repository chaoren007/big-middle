package com.morning.star.retail.facade;

import com.morning.star.retail.dto.group.*;
import com.morning.star.retail.utils.page.PageBean;

/**
 * Created by kimhuhg.
 */
public interface GroupFacade {

	String getCode();

	PageBean<GroupInfoDTO> pageList(GroupQueryPageDTO groupQueryPageDTO);

	PageBean<GroupInfoDTO> listGroup(GroupQueryListDTO groupQueryListDTO);

//    GroupInfoDTO getGroupInfo(GroupQueryDTO queryGroupDTO);

	GroupInfoDTO getByCode(String groupCode);

	void addGroup(GroupCreateDTO groupCreateDTO);

	void modify(GroupModifyDTO groupModifyDTO);

	void delete(String groupCode);

	GroupInfoDTO getDefault();

}
