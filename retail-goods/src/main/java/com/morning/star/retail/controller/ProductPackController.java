package com.morning.star.retail.controller;

import com.morning.star.retail.facade.ProductPackFacade;
import com.morning.star.retail.facade.dto.ProductPackAddDTO;
import com.morning.star.retail.facade.dto.ProductPackDTO;
import com.morning.star.retail.facade.dto.ProductPackQueryDTO;
import com.morning.star.retail.utils.page.PageBean;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author ethan
 * @createTime 2018/7/12 15:01
 */
@RestController
@RequestMapping("/product-pack-api/v1")
public class ProductPackController {
	@Autowired
	private ProductPackFacade facade;

	@ApiOperation(value = "获取品牌信息")
	@RequestMapping(value = "/query", method = RequestMethod.GET)
	public PageBean<ProductPackDTO> queryByPage(ProductPackQueryDTO dto) {
		PageBean<ProductPackDTO> list = facade.query(dto);
		return list;
	}

	@ApiOperation(value = "修改品牌信息")
	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public void updateBrandInfo(@RequestBody ProductPackAddDTO dto) {
		facade.add(dto);
	}
}
