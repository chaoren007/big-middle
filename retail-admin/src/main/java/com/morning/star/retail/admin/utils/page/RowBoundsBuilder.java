package com.morning.star.retail.admin.utils.page;

import org.apache.commons.lang3.ObjectUtils;
import org.apache.ibatis.session.RowBounds;

public class RowBoundsBuilder {
    
    public static RowBounds build(Integer pageNo, Integer pageSize) {
        pageNo = ObjectUtils.defaultIfNull(pageNo, 1);
        pageSize = ObjectUtils.defaultIfNull(pageSize, 20);
        return new RowBounds((pageNo - 1) * pageSize, pageSize);
    }
    
}
