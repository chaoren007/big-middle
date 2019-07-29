package com.morning.star.retail.facade;

import java.util.List;

import com.morning.star.retail.facade.dto.ImeiAddDTO;
import com.morning.star.retail.facade.dto.ImeiQueryDTO;
import com.morning.star.retail.facade.dto.ImeiUpdateDTO;
import com.morning.star.retail.utils.page.PageBean;
/**
 * @author Dell
 */
public interface ImeiFacade {
	
	void createList(List<ImeiAddDTO> list,String storeCode,String groupCode);
	
    void create(ImeiAddDTO dto);
    
    void edit(ImeiUpdateDTO dto);
    
    PageBean<ImeiAddDTO> queryPage(ImeiQueryDTO dto);
	
}
