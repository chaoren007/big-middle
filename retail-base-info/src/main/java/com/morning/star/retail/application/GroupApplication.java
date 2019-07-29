package com.morning.star.retail.application;

import com.morning.star.retail.dto.group.GroupCreateDTO;
import com.morning.star.retail.dto.group.GroupModifyDTO;

/**
 * Created by kimhuhg.
 */
public interface GroupApplication {

    void add(GroupCreateDTO groupCreateDTO);

    void modify(GroupModifyDTO groupModifyDTO);

    void delete(String groupCode);
}
