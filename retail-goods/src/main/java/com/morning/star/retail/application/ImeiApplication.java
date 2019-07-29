package com.morning.star.retail.application;

import com.morning.star.retail.facade.dto.ImeiAddDTO;
import com.morning.star.retail.facade.dto.ImeiQueryDTO;
import com.morning.star.retail.facade.dto.ImeiUpdateDTO;
import com.morning.star.retail.utils.page.PageBean;

public interface ImeiApplication {
	
    void create(ImeiAddDTO dto);
    
    void edit(ImeiUpdateDTO dto);
    
    PageBean<ImeiAddDTO> queryPage(ImeiQueryDTO dto);

}
