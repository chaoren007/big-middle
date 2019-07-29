package com.morning.star.retail.admin.group.goods.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import javax.servlet.http.HttpServletResponse;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.morning.star.retail.admin.group.goods.controller.vo.ProductPackExportVO;
import com.morning.star.retail.admin.group.goods.controller.vo.ProductPackImportVO;
import com.morning.star.retail.admin.util.AdminController;
import com.morning.star.retail.admin.util.WebBean;
import com.morning.star.retail.base.poi.ExcelUtil;
import com.morning.star.retail.bean.AdminLoginContent;
import com.morning.star.retail.enums.OriginalType;
import com.morning.star.retail.facade.ProductPackFacade;
import com.morning.star.retail.facade.dto.ProductPackAddDTO;
import com.morning.star.retail.facade.dto.ProductPackDTO;
import com.morning.star.retail.facade.dto.ProductPackQueryDTO;
import com.morning.star.retail.utils.page.PageBean;
import com.morning.star.retail.validate.Validate;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api(tags = {"货品大小包装"})
@RestController
@RequestMapping("/api/pack")
public class GroupProductPackController extends AdminController {

	@Autowired
	private ProductPackFacade productPackFacade;

	@ApiOperation(value = "查询大小包装信息")
	@RequestMapping(value = "/query", method = RequestMethod.GET)
	@RequiresPermissions(value = {"pack:list"})
	public WebBean<PageBean<ProductPackDTO>> queryByPage(ProductPackQueryDTO dto) {
		AdminLoginContent login = getLoginAdmin();
		dto.setGroupCode(login.getGroupCode());
		PageBean<ProductPackDTO> list = productPackFacade.query(dto);
		return WebBean.ok(list);
	}

	@ApiOperation(value = "添加大小包装信息")
	@RequestMapping(value = "/add", method = RequestMethod.POST)
	@Validate
	@RequiresPermissions(value = {"pack:add"})
	public WebBean updateBrandInfo(@RequestBody ProductPackAddDTO dto) {
		AdminLoginContent login = getLoginAdmin();
		dto.setGroupCode(login.getGroupCode());
		productPackFacade.add(dto);
		return WebBean.ok();
	}

	@ApiOperation(value = "导出包装信息")
	@RequestMapping(value = "/export", method = RequestMethod.GET)
	@RequiresPermissions(value = {"pack:export"})
	public void exportGoods(ProductPackQueryDTO dto, HttpServletResponse response) {
		AdminLoginContent login = getLoginAdmin();
		dto.setGroupCode(login.getGroupCode());
		dto.setPageNo(1);
		dto.setPageSize(Integer.MAX_VALUE);

		PageBean<ProductPackDTO> pageData = productPackFacade.query(dto);

		List<ProductPackExportVO> list = new ArrayList<>(pageData.getRecord().size());
		pageData.getRecord().forEach(e -> {
			ProductPackExportVO exportVO = new ProductPackExportVO();
			BeanUtils.copyProperties(e, exportVO);
			list.add(exportVO);
		});
		try {
			new ExcelUtil<>(ProductPackExportVO.class).writeToHttpResponse(list, "导出包装.xlsx", "包装", response);
		} catch (Exception e) {
			throw new RuntimeException("导出包装错误", e);
		}
	}

	@ApiOperation(value = "导入包装信息")
	@RequestMapping(value = "/import", method = RequestMethod.POST)
	@RequiresPermissions(value = {"pack:import"})
	public WebBean<Void> importGoods(MultipartFile importFile) {
		AdminLoginContent login = getLoginAdmin();
		List<ProductPackImportVO> importVOS = new ExcelUtil<>(ProductPackImportVO.class).readXLSData(importFile, OriginalType.XLSX);

		List<ProductPackAddDTO> productPackAddDTOS = importVOS.stream().map(e -> {
			ProductPackAddDTO productPackAddDTO = new ProductPackAddDTO();
			BeanUtils.copyProperties(e, productPackAddDTO);
			productPackAddDTO.setGroupCode(login.getGroupCode());
			return productPackAddDTO;
		}).collect(Collectors.toList());

		productPackFacade.batchImport(productPackAddDTOS);
		return WebBean.ok();
	}
}
