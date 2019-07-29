package com.morning.star.retail.helper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.morning.star.retail.dto.group.GroupInfoDTO;
import com.morning.star.retail.facade.GroupFacade;

@Service
public class GroupService {
    
    @Autowired
    private GroupFacade groupFacade;

    public GroupInfoDTO getGroupInfo(String groupCode) {
        return groupFacade.getByCode(groupCode);
    }

}
