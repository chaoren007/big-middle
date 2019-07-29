package com.morning.star.retail.facade;

import java.util.List;

import com.morning.star.retail.facade.dto.BrandAddDTO;
import com.morning.star.retail.facade.dto.BrandCountDTO;
import com.morning.star.retail.facade.dto.BrandCountReDTO;
import com.morning.star.retail.facade.dto.BrandDTO;
import com.morning.star.retail.facade.dto.BrandQueryDTO;
import com.morning.star.retail.facade.dto.BrandUpdateDTO;
import com.morning.star.retail.utils.page.PageBean;
/**
 * @author Dell
 */
public interface BrandFacade {
	/**
	 * 添加品牌
	 * @param dto
	 * @return
	 */
	Long create(BrandAddDTO dto);

	/**
	 * 删除品牌
	 * @param id
	 */
	void delete(Long id);
	/**
	 *编辑品牌
	 * @param dto
	 */
	void edit(BrandUpdateDTO dto);
	/**
	 *分页查询品牌
	 * @param brandQueryDTO
	 * @return
	 */
	PageBean<BrandDTO> queryPage(BrandQueryDTO brandQueryDTO);

	/**
	 * 列表查询品牌
	 * @param brandQueryDTO
	 * @return
	 */
	List<BrandDTO> queryList(BrandQueryDTO brandQueryDTO);


	PageBean<BrandCountReDTO> queryCountPage(BrandCountDTO dto);
	PageBean<BrandCountReDTO> queryCountGroupPage(BrandCountDTO dto);
	BrandDTO getByCode(Long id);
}
